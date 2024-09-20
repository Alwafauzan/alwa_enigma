package com.example.jwt_student.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DTOReqTeacher {
    @NotBlank(message = "nip is diperlukan")
    @Size(min = 5, max = 5, message = "nip harus 5 karakter")
    private String nip;
    @NotBlank(message = "name is diperlukan")
    private String name;
    @NotBlank(message = "email is diperlukan")
    private String email;
    @NotBlank(message = "password is diperlukan")
    private String password;
}
