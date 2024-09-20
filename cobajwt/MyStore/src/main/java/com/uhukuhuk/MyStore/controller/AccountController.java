package com.uhukuhuk.MyStore.controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.uhukuhuk.MyStore.model.AppUser;
import com.uhukuhuk.MyStore.model.RegisterDTO;
import com.uhukuhuk.MyStore.repository.AppUserRepository;

import jakarta.validation.Valid;

@Controller
public class AccountController {
    @Autowired
    private AppUserRepository appUserRepository;

    @GetMapping("/register")
    public String register(Model model) {
        RegisterDTO registerDTO = new RegisterDTO();
        model.addAttribute("registerDTO", registerDTO);
        model.addAttribute("success", false);
        return "register";
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(Model model, @Valid @ModelAttribute RegisterDTO registerDTO,
            BindingResult result) {
        if (!registerDTO.getPassword().equals(registerDTO.getConfirmPassword())) {
            result.addError(
                    new FieldError("registerDTO", "confirmPassword", "Passwords do not match"));

        }

        AppUser appUser = appUserRepository.findByEmail(registerDTO.getEmail());
        if (appUser != null) {
            result.addError(new FieldError("registerDTO", "email", "already exists"));
        }

        if (result.hasErrors()) {
            return ResponseEntity.status(HttpStatus.FOUND).body("register");
        }

        try {
            var bcrypt = new BCryptPasswordEncoder();
            AppUser newUswer = new AppUser();
            newUswer.setFirstName(registerDTO.getFirstName());
            newUswer.setLastName(registerDTO.getLastName());
            newUswer.setEmail(registerDTO.getEmail());
            newUswer.setPhone(registerDTO.getPhone());
            newUswer.setAddress(registerDTO.getAddress());
            newUswer.setRole("client");
            newUswer.setCreatedAt(new Date(0));
            newUswer.setPassword(bcrypt.encode(registerDTO.getPassword()));

            appUserRepository.save(newUswer);

            model.addAttribute("registerDTO", new RegisterDTO());
            model.addAttribute("success", true);

        } catch (Exception e) {
            result.addError(new FieldError("registerDTO", "firstname", e.getMessage()));
        }
        return ResponseEntity.status(HttpStatus.FOUND).body("redirect:/login");
    }

}
