package com.albo.challenge.models;


import com.albo.challenge.enums.CreatorRoles;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "collaborators")
public class CollaboratorsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "comic_id")
    private Long comicId;
    private String name;
    @Enumerated(EnumType.STRING)
    private CreatorRoles role;
}
