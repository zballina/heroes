package com.albo.challenge.repositories;

import com.albo.challenge.models.ComicsEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ComicsRepository implements PanacheRepository<ComicsEntity> {
}