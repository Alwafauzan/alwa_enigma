package com.livecode.livecode_loan_app.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {

    @PostMapping("/home")
    public ResponseEntity<String> adminPost() {
        return ResponseEntity.ok("Admin:: POST");
    }

    @PutMapping("/put")
    public ResponseEntity<String> adminPut() {
        return ResponseEntity.ok("Admin:: PUT");
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> adminDelete() {
        return ResponseEntity.ok("Admin:: DELETE");
    }

    @GetMapping("/get")
    public ResponseEntity<String> adminGet() {
        return ResponseEntity.ok("Admin:: GET");
    }
}
