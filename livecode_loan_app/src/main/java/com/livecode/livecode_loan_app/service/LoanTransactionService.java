package com.livecode.livecode_loan_app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.livecode.livecode_loan_app.model.LoanTransaction;
import com.livecode.livecode_loan_app.repository.LoanTransactionRepository;

@Service
public class LoanTransactionService {

    private final LoanTransactionRepository loanRepository;

    @Autowired
    public LoanTransactionService(LoanTransactionRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    // create
    public LoanTransaction saveLoanTransaction(LoanTransaction loan) {
        return loanRepository.save(loan);
    }

    // read
    public List<LoanTransaction> getAllLoanTransaction() {
        return loanRepository.findAll();

    }

    // read by id
    public Optional<LoanTransaction> getLoanTransactionByid(String id) {
        return loanRepository.findByid(id);
    }

    // update
    public LoanTransaction updateLoanTransactionByid(String id, LoanTransaction loanDetails) {
        LoanTransaction loan = loanRepository.findByid(id)
                .orElseThrow(() -> new RuntimeException("LoanTransaction with id " + id + " not found"));

        loan.setLoanType(loanDetails.getLoanType());
        loan.setInstalmentType(loanDetails.getInstalmentType());
        loan.setCustomer(loanDetails.getCustomer());
        loan.setNominal(loanDetails.getNominal());

        return loanRepository.save(loan);
    }

    // delete
    public void deleteLoanTransactionByid(String id) {
        Optional<LoanTransaction> loan = loanRepository.findByid(id);
        if (loan.isPresent()) {
            loanRepository.delete(loan.get());
        } else {
            throw new RuntimeException("LoanTransaction with id " + id + " not found");
        }
    }

}