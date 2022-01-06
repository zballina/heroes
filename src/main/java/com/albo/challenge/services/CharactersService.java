package com.albo.challenge.services;

import com.albo.challenge.dto.response.InteractionsResponse;


public interface CharactersService {
    InteractionsResponse interactions(String hero);
}
