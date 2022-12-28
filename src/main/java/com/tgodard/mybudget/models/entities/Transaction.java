package com.tgodard.mybudget.models.entities;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.Instant;
import java.util.Objects;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
public class Transaction {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(columnDefinition = "TIMESTAMP(0)", nullable = false)
    private Instant date;

    @Column(nullable = false)
    private double amount;

    @ManyToOne
    private Category category;

    @ManyToOne
    private EstimatedTransaction estimatedTransaction;
}
