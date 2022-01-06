package com.albo.challenge.models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "comics")
public class ComicsEntity {
    @Id
    private Long id;
    @Column(name = "digital_id")
    private Long digitalId;
    private String title;
    private String description;
}
