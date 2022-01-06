package com.albo.challenge.dto.response.external;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CharactersResponse {
    private Integer code;
    private String status;
    private String copyright;
    private String etag;
    private Data data;

    @Getter
    @Setter
    public static class Data {
        private Long offset;
        private Integer limit;
        private Integer total;
        private Integer count;
        private List<Results> results;
    }

    @Getter
    @Setter
    public static class Results {
        private Long id;
        private String name;
        private String description;
        private String modified;
    }

}
