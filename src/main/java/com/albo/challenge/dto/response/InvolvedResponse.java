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
public class InvolvedResponse {
    private String last_sync;
    private List<String> editors;
    private List<String> writers;
    private List<String> colorists;
}
