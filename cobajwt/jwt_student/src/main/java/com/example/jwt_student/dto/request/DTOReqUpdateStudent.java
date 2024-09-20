package com.example.jwt_student.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DTOReqUpdateStudent {
    private String id;
    private String nim;
    private String name;
    private String email;
    private String password;

}
