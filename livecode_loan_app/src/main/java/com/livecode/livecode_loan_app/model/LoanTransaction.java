package com.livecode.livecode_loan_app.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class LoanTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @OneToOne
    private LoanType loanType;

    @OneToOne
    private InstalmentType instalmentType;

    @OneToOne
    private Customer customer;

    @Column
    private Double nominal;
    
    @Column
    private Long approvedAt;
    
    @Column
    private String approvedBy;
    
    @Enumerated(EnumType.STRING)
    private ApprovalStatus approvalStatus;
    
    @OneToMany
    private List<LoanTransactionDetail> loanTransactionDetails;
    
    @Column
    private Long createdAt;
    
    @Column
    private Long updatedAt;
}

enum ApprovalStatus {
    APPROVED,
    REJECTED
}
