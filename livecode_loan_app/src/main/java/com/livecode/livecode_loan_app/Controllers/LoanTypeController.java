package com.livecode.livecode_loan_app.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.livecode.livecode_loan_app.model.LoanType;
import com.livecode.livecode_loan_app.service.LoanTypeService;

// ini buat inisialisasi bikin api nya
@RestController
@RequestMapping("/api/loan-type")
public class LoanTypeController {

    @Autowired
    private LoanTypeService loanTypeService;

    // create
    @PostMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public LoanType saveLoanType(@RequestBody LoanType loanType) {
        return loanTypeService.saveLoanType(loanType);
    }

    // read
    @GetMapping("/")
    public List<LoanType> getAllLoanType() {
        return loanTypeService.getAllLoanType();
    }

    // read by id
    @GetMapping("/{id}")
    public ResponseEntity<Optional<LoanType>> getLoanTypeByid(@PathVariable String id) {
        try {
            Optional<LoanType> loanType = loanTypeService.getLoanTypeByid(id);
            return ResponseEntity.ok(loanType);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // update
    @PutMapping("/{id}")
    public ResponseEntity<LoanType> updateLoanTypeByid(@PathVariable(value = "id") String id,
            @RequestBody LoanType loanTypeDetails) {
        try {
            LoanType updatedLoanType = loanTypeService.updateLoanTypeByid(id,
                    loanTypeDetails);
            return ResponseEntity.ok(updatedLoanType);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // delete
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLoanTypeByid(@PathVariable String id) {
        try {
            loanTypeService.deleteLoanTypeByid(id);
            return ResponseEntity.ok("LoanType with id " + id + " deleted");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}