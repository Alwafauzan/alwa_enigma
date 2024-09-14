package com.example.coba_customer.model.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class CustomerMejatDTO {

    private String id;
    private String name;
    private String phoneNumber;
    private Boolean isMember;
    private List<MejaDTO> mejaConnections;

    @Setter
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MejaDTO {
        private Long id;
        private String mejaName;

    }
}
