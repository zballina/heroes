package com.albo.challenge.commons;


public final class ExternalRoutes {
    public static final String BASE_MARVEL_ROUTE = "/v1/public";
    public static final String MARVEL_CHARACTERS_BY_NAME = "/characters";
    public static final String MARVEL_COMICS_BY_CHARACTER = "/characters/{characterId}/comics";
    public static final String MARVEL_CHARACTER_BY_COMIC = "/comics/{comicId}/characters";
}
