package com.albo.challenge.services.impl;

import com.albo.challenge.dto.response.external.CharactersResponse;
import com.albo.challenge.dto.response.external.ComicsResponse;
import com.albo.challenge.enums.CreatorRoles;
import com.albo.challenge.models.*;
import com.albo.challenge.repositories.*;
import com.albo.challenge.services.MarvelService;
import com.albo.challenge.services.SyncService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.time.LocalDateTime;


@ApplicationScoped
public class SyncServiceImpl implements SyncService {

    @Inject
    MarvelService marvelService;
    @Inject
    HeroesRepository heroesRepository;
    @Inject
    CharactersRepository charactersRepository;
    @Inject
    ComicsRepository comicsRepository;
    @Inject
    CollaboratorsRepository collaboratorsRepository;
    @Inject
    ComicsCharactersRepository comicsCharactersRepository;


    @Override
    public void syncAll() {
        heroesRepository.findAll().stream().forEach(this::sync);
    }

    /**
     * Synchronize changes with marvel by one hero
     *
     * @param hero
     */
    private void sync(HeroesEntity hero) {
        marvelService.getCharactersByName(hero.getName(), hero.getLastSync())
                .getData().getResults().forEach(
                        character -> marvelService.getComicsByCharacter(character.getId(), hero.getLastSync())
                                .getData().getResults().forEach(
                                        comic -> {
                                            this.persistComics(comic);
                                            this.persistCreators(comic);
                                            marvelService.getCharactersByComic(comic.getId(), hero.getLastSync())
                                                    .getData().getResults().forEach(
                                                            characterByComic -> {
                                                                this.persistCharacter(characterByComic);
                                                                this.persistComicsCharacters(characterByComic, comic);
                                                            }
                                                    );
                                        }
                                )
                );
        hero.setLastSync(LocalDateTime.now());
        heroesRepository.update("lastSync = ?1", LocalDateTime.now());
    }

    /**
     * A new character persists
     *
     * @param character
     */
    private void persistCharacter(CharactersResponse.Results character) {
        if (charactersRepository.findByIdOptional(character.getId()).isEmpty()) {
            charactersRepository.persist(CharactersEntity.builder()
                    .id(character.getId())
                    .name(character.getName())
                    .description(character.getDescription())
                    .build());
        }
    }

    /**
     * A new character-comic relationship persists
     *
     * @param character
     * @param comic
     */
    private void persistComicsCharacters(CharactersResponse.Results character, ComicsResponse.Results comic) {
        boolean exist = comicsCharactersRepository.find("comicId = ?1 and characterId = ?2", comic.getId(), character.getId()).stream().findAny().isPresent();
        if (!exist) {
            comicsCharactersRepository.persist(ComicsCharactersEntity.builder()
                    .comicId(comic.getId())
                    .characterId(character.getId())
                    .build());
        }
        if (comicsRepository.findByIdOptional(comic.getId()).isEmpty()) {
            comicsRepository.persist(ComicsEntity.builder()
                    .id(comic.getId())
                    .digitalId(comic.getDigitalId())
                    .title(comic.getTitle())
                    .description(comic.getDescription())
                    .build());
        }
    }

    /**
     * A new comic persists
     *
     * @param comic
     */
    private void persistComics(ComicsResponse.Results comic) {
        if (comicsRepository.findByIdOptional(comic.getId()).isEmpty()) {
            comicsRepository.persist(ComicsEntity.builder()
                    .id(comic.getId())
                    .digitalId(comic.getDigitalId())
                    .title(comic.getTitle())
                    .description(comic.getDescription())
                    .build());
        }
    }

    /**
     * A new colorist, editor or writer persists
     *
     * @param comic
     */
    private void persistCreators(ComicsResponse.Results comic) {
        comic.getCreators().getItems()
                .stream().filter(creator ->
                        creator.getRole().compareToIgnoreCase(CreatorRoles.colorist.name()) == 0 ||
                                creator.getRole().compareToIgnoreCase(CreatorRoles.editor.name()) == 0 ||
                                creator.getRole().compareToIgnoreCase(CreatorRoles.writer.name()) == 0)
                .forEach(
                        creator -> {
                            if (collaboratorsRepository.find("comicId = ?1 and name = ?2", comic.getId(), creator.getName()).stream()
                                    .findAny().isEmpty()) {
                                collaboratorsRepository.persist(
                                        CollaboratorsEntity.builder()
                                                .comicId(comic.getId())
                                                .name(creator.getName())
                                                .role(CreatorRoles.valueOf(creator.getRole()))
                                                .build()
                                );
                            }
                        }
                );
    }
}
