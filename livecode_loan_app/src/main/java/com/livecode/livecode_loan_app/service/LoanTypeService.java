package com.livecode.livecode_loan_app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.livecode.livecode_loan_app.model.LoanType;
import com.livecode.livecode_loan_app.repository.LoanTypeRepository;

@Service
public class LoanTypeService {

    private final LoanTypeRepository loanRepository;

    @Autowired
    public LoanTypeService(LoanTypeRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    // create
    public LoanType saveLoanType(LoanType loan) {
        return loanRepository.save(loan);
    }

    // read
    public List<LoanType> getAllLoanType() {
        return loanRepository.findAll();

    }

    // read by id
    public Optional<LoanType> getLoanTypeByid(String id) {
        return loanRepository.findByid(id);
    }

    // update
    public LoanType updateLoanTypeByid(String id, LoanType loanDetails) {
        LoanType loan = loanRepository.findByid(id)
                .orElseThrow(() -> new RuntimeException("LoanType with id " + id + " not found"));

        loan.setType(loanDetails.getType());
        loan.setMaxLoan(loanDetails.getMaxLoan());

        return loanRepository.save(loan);
    }

    // delete
    public void deleteLoanTypeByid(String id) {
        Optional<LoanType> loan = loanRepository.findByid(id);
        if (loan.isPresent()) {
            loanRepository.delete(loan.get());
        } else {
            throw new RuntimeException("LoanType with id " + id + " not found");
        }
    }

}