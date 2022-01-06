package com.albo.challenge.providers;

import com.albo.challenge.dto.response.external.CharactersResponse;
import com.albo.challenge.dto.response.external.ComicsResponse;

import java.time.LocalDateTime;

public interface MarvelProvider {
    CharactersResponse getCharactersByName(String name, LocalDateTime modifiedSince);

    ComicsResponse getComicsByCharacter(Long characterId, LocalDateTime modifiedSince);

    CharactersResponse getCharactersByComic(Long comicId, LocalDateTime lastSync);
}
