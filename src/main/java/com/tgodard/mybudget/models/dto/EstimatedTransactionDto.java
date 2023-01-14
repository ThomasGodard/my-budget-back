package com.tgodard.mybudget.models.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDate;

@Getter
@Setter
@RequiredArgsConstructor
public class EstimatedTransactionDto {

    private Long id;

    private String name;

    private LocalDate startDate;

    private LocalDate endDate;

    private Instant creationDate;

    private double amount;

    private CategoryDto category;
}
