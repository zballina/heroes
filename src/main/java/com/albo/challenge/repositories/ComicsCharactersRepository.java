package com.albo.challenge.repositories;

import com.albo.challenge.models.ComicsCharactersEntity;
import com.albo.challenge.models.pk.ComicsCharactersPK;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ComicsCharactersRepository implements PanacheRepositoryBase<ComicsCharactersEntity, ComicsCharactersPK> {
}