package com.albo.challenge.models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "characters")
public class CharactersEntity {
    @Id
    private Long id;
    private String name;
    private String description;
}
