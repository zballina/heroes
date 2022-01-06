package com.albo.challenge.services.impl;

import com.albo.challenge.dto.response.external.CharactersResponse;
import com.albo.challenge.dto.response.external.ComicsResponse;
import com.albo.challenge.providers.MarvelProvider;
import com.albo.challenge.services.MarvelService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.time.LocalDateTime;


@ApplicationScoped
public class MarvelServiceImpl implements MarvelService {
    @Inject
    MarvelProvider marvelProvider;

    @Override
    public CharactersResponse getCharactersByName(String name, LocalDateTime modifiedSince) {
        return marvelProvider.getCharactersByName(name, modifiedSince);
    }

    @Override
    public ComicsResponse getComicsByCharacter(Long characterId, LocalDateTime modifiedSince) {
        return marvelProvider.getComicsByCharacter(characterId, modifiedSince);
    }

    @Override
    public CharactersResponse getCharactersByComic(Long comicId, LocalDateTime modifiedSince) {
        return marvelProvider.getCharactersByComic(comicId, modifiedSince);
    }
}
