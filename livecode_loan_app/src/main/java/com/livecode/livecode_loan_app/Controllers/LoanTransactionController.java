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

import com.livecode.livecode_loan_app.model.LoanTransaction;
import com.livecode.livecode_loan_app.service.LoanTransactionService;

// ini buat inisialisasi bikin api nya
@RestController
@RequestMapping("/api/transactions")
public class LoanTransactionController {

    @Autowired
    private LoanTransactionService loanTransactionService;

    // create
    @PostMapping(path = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public LoanTransaction saveLoanTransaction(@RequestBody LoanTransaction loanTransaction) {
        return loanTransactionService.saveLoanTransaction(loanTransaction);
    }

    // read
    @GetMapping("/")
    public List<LoanTransaction> getAllLoanTransaction() {
        return loanTransactionService.getAllLoanTransaction();
    }

    // read by id
    @GetMapping("/{id}")
    public ResponseEntity<Optional<LoanTransaction>> getLoanTransactionByid(@PathVariable String id) {
        try {
            Optional<LoanTransaction> loanTransaction = loanTransactionService.getLoanTransactionByid(id);
            return ResponseEntity.ok(loanTransaction);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // update
    @PutMapping("/{id}")
    public ResponseEntity<LoanTransaction> updateLoanTransactionByid(@PathVariable(value = "id") String id,
            @RequestBody LoanTransaction loanTransactionDetails) {
        try {
            LoanTransaction updatedLoanTransaction = loanTransactionService.updateLoanTransactionByid(id,
                    loanTransactionDetails);
            return ResponseEntity.ok(updatedLoanTransaction);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // delete
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLoanTransactionByid(@PathVariable String id) {
        try {
            loanTransactionService.deleteLoanTransactionByid(id);
            return ResponseEntity.ok("LoanTransaction with id " + id + " deleted");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}