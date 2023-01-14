package com.tgodard.mybudget.models.entities;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(
                name = "UniqueTransactionDateForEstimated",
                columnNames = {"date", "estimated_transaction_id"}
        )
})
public class Transaction {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(columnDefinition = "TIMESTAMP(0)", nullable = false)
    private LocalDate date;
    @Column(nullable = false)
    private double amount;

    @ManyToOne
    private Category category;

    @ManyToOne
    @JoinColumn(name = "estimated_transaction_id")
    private EstimatedTransaction estimatedTransaction;
}
