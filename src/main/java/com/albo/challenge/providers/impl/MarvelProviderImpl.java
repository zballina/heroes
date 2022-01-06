package com.albo.challenge.providers.impl;

import com.albo.challenge.clients.MarvelClient;
import com.albo.challenge.dto.response.external.CharactersResponse;
import com.albo.challenge.dto.response.external.ComicsResponse;
import com.albo.challenge.providers.MarvelProvider;
import org.apache.commons.codec.digest.DigestUtils;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@ApplicationScoped
public class MarvelProviderImpl implements MarvelProvider {

    @Inject
    @RestClient
    MarvelClient marvelClient;

    @ConfigProperty(name = "marvel-client.public-key")
    String publicKey;

    @ConfigProperty(name = "marvel-client.private-key")
    String privateKey;


    @Override
    public CharactersResponse getCharactersByName(String name, LocalDateTime lastSync) {
        Long timestamp = Instant.now().getEpochSecond();
        String hash = DigestUtils.md5Hex(String.format("%s%s%s", timestamp, privateKey, publicKey));

        String modifiedSince = lastSync != null ? lastSync.format(DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss")) : null;
        return marvelClient.getCharactersByName(
                publicKey,
                hash,
                timestamp.toString(),
                modifiedSince,
                name);
    }

    @Override
    public ComicsResponse getComicsByCharacter(Long characterId, LocalDateTime lastSync) {
        Long timestamp = Instant.now().getEpochSecond();
        String hash = DigestUtils.md5Hex(String.format("%s%s%s", timestamp, privateKey, publicKey));

        String modifiedSince = lastSync != null ? lastSync.format(DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss")) : null;
        return marvelClient.getComicsByCharacter(
                publicKey,
                hash,
                timestamp.toString(),
                modifiedSince,
                characterId);
    }

    @Override
    public CharactersResponse getCharactersByComic(Long comicId, LocalDateTime lastSync) {
        Long timestamp = Instant.now().getEpochSecond();
        String hash = DigestUtils.md5Hex(String.format("%s%s%s", timestamp, privateKey, publicKey));

        String modifiedSince = lastSync != null ? lastSync.format(DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss")) : null;
        return marvelClient.getCharacterByComic(
                publicKey,
                hash,
                timestamp.toString(),
                modifiedSince,
                comicId);
    }
}
