package com.albo.challenge.models;


import com.albo.challenge.models.pk.ComicsCharactersPK;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "comics_characters")
@IdClass(ComicsCharactersPK.class)
public class ComicsCharactersEntity {

    @Id
    @Column(name = "comic_id")
    private Long comicId;

    @Id
    @Column(name = "character_id")
    private Long characterId;
}
