package com.livecode.livecode_loan_app.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/manager")
public class ManagerController {

    @PostMapping("/post")
    public ResponseEntity<String> managerPost() {
        return ResponseEntity.ok("Manager:: POST");
    }

    @PutMapping("/put")
    public ResponseEntity<String> managerPut() {
        return ResponseEntity.ok("Manager:: PUT");
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> managerDelete() {
        return ResponseEntity.ok("Manager:: DELETE");
    }

    @GetMapping("/get")
    public ResponseEntity<String> managerGet() {
        return ResponseEntity.ok("Manager:: GET");
    }
}
