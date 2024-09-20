package com.uhukuhuk.MyStore.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
public class RegisterDTO {
    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;
    @NotEmpty
    @Email
    private String email;
    private String phone;
    private String address;
    @Size(min = 6, message = "Password must be at least 6 characters long")
    private String password;
    private String confirmPassword;

    public RegisterDTO(String firstName, String lastName, String email, String phone, String address, String password,
            String confirmPassword) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

}
