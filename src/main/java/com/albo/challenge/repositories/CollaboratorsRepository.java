package com.albo.challenge.repositories;

import com.albo.challenge.models.CollaboratorsEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CollaboratorsRepository implements PanacheRepository<CollaboratorsEntity> {
}