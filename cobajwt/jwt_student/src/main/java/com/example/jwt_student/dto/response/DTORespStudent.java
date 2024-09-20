package com.example.jwt_student.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DTORespStudent {

    private String studentId;
    private String nim;
    private String name;
    private String email;
    private String password;

}
