package com.albo.challenge.services.impl;

import com.albo.challenge.dto.response.InteractionsResponse;
import com.albo.challenge.models.ComicsEntity;
import com.albo.challenge.models.HeroesEntity;
import com.albo.challenge.repositories.CharactersRepository;
import com.albo.challenge.repositories.ComicsCharactersRepository;
import com.albo.challenge.repositories.ComicsRepository;
import com.albo.challenge.repositories.HeroesRepository;
import com.albo.challenge.services.CharactersService;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.NotFoundException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


@ApplicationScoped
public class CharactersServiceImpl implements CharactersService {

    @Inject
    HeroesRepository heroesRepository;
    @Inject
    CharactersRepository charactersRepository;
    @Inject
    ComicsCharactersRepository comicsCharactersRepository;
    @Inject
    ComicsRepository comicsRepository;
    @ConfigProperty(name = "sync.message")
    String message;


    /**
     * Get the interactions of a hero
     *
     * @param shortName
     */
    @Override
    public InteractionsResponse interactions(String shortName) {
        HeroesEntity hero = heroesRepository.findById(shortName);
        if (hero == null) {
            throw new NotFoundException();
        }
        List<InteractionsResponse.Character> characters = new ArrayList<>();
        charactersRepository.findAll().list().forEach(
                charactersEntity -> {
                    List<String> comics = new ArrayList<>();
                    comicsCharactersRepository.find("characterId", charactersEntity.getId()).list()
                            .forEach(
                                    comicsCharactersEntity -> {
                                        ComicsEntity comicsEntity = comicsRepository.findById(comicsCharactersEntity.getComicId());
                                        if (comicsEntity != null) {
                                            comics.add(comicsEntity.getTitle());
                                        }
                                    }
                            );
                    characters.add(
                            InteractionsResponse.Character.builder()
                                    .character(charactersEntity.getName())
                                    .comics(comics)
                                    .build());
                }
        );

        return InteractionsResponse.builder()
                .last_sync(message + ": " + hero.getLastSync().format(DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss")))
                .characters(characters)
                .build();
    }
}
