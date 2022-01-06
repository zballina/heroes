package com.albo.challenge.services.impl;

import com.albo.challenge.dto.response.InvolvedResponse;
import com.albo.challenge.enums.CreatorRoles;
import com.albo.challenge.models.HeroesEntity;
import com.albo.challenge.repositories.CollaboratorsRepository;
import com.albo.challenge.repositories.HeroesRepository;
import com.albo.challenge.services.CollaboratorsService;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.NotFoundException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


@ApplicationScoped
public class CollaboratorsServiceImpl implements CollaboratorsService {

    @Inject
    HeroesRepository heroesRepository;
    @Inject
    CollaboratorsRepository collaboratorsRepository;
    @ConfigProperty(name = "sync.message")
    String message;

    /**
     * Get the list of creators involved in the comics
     *
     * @param shortName
     */
    @Override
    public InvolvedResponse involved(String shortName) {
        HeroesEntity hero = heroesRepository.findById(shortName);
        if (hero == null) {
            throw new NotFoundException();
        }
        List<String> editors = new ArrayList<>();
        List<String> writers = new ArrayList<>();
        List<String> colorists = new ArrayList<>();
        collaboratorsRepository.findAll().list()
                .forEach(
                        collaborator -> {
                            if (collaborator.getRole().compareTo(CreatorRoles.colorist) == 0) {
                                colorists.add(collaborator.getName());
                            }
                            if (collaborator.getRole().compareTo(CreatorRoles.editor) == 0) {
                                editors.add(collaborator.getName());
                            }
                            if (collaborator.getRole().compareTo(CreatorRoles.writer) == 0) {
                                writers.add(collaborator.getName());
                            }
                        }
                );
        return InvolvedResponse.builder()
                .last_sync(message + ": " + hero.getLastSync().format(DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss")))
                .colorists(colorists)
                .editors(editors)
                .writers(writers)
                .build();
    }
}
