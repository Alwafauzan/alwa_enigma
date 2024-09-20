package com.livecode.livecode_loan_app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class InstalmentType {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Enumerated(EnumType.STRING)
    private EInstalmentType instalmentType;
}

enum EInstalmentType {
    ONE_MONTH,
    THREE_MONTHS,
    SIXTH_MONTHS,
    NINE_MONTHS,
    TWELVE_MONTHS
}
