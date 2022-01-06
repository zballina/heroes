package com.albo.challenge.dto.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class InteractionsResponse {
    private String last_sync;
    private List<Character> characters;

    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    public static class Character {
        private String character;
        private List<String> comics;
    }
}
