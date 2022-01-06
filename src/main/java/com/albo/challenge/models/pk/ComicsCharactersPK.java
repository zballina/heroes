package com.albo.challenge.models.pk;

import lombok.Data;

import java.io.Serializable;

@Data
public class ComicsCharactersPK implements Serializable {
    private Long comicId;
    private Long characterId;
}
