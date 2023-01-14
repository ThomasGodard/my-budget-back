package com.tgodard.mybudget.models.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@RequiredArgsConstructor
public class TransactionDto {

    private String name;

    private LocalDate date;
    private double amount;
    private CategoryDto category;
    private EstimatedTransactionDto estimatedTransaction;
}
