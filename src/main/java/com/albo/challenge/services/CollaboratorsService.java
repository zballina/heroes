package com.albo.challenge.services;

import com.albo.challenge.dto.response.InvolvedResponse;


public interface CollaboratorsService {

    InvolvedResponse involved(String shortName);
}
