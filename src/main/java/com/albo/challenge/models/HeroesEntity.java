package com.albo.challenge.models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "heroes")
public class HeroesEntity {
    @Id
    @Column(name = "short_name")
    private String shortName;
    private String name;
    @Column(name = "last_sync")
    private LocalDateTime lastSync;
}
