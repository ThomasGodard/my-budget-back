package com.tgodard.mybudget.models.entities;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
public class EstimatedTransaction  {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(columnDefinition = "TIMESTAMP(0)", nullable = false)
    @Temporal(TemporalType.DATE)
    private LocalDate startDate;

    @Column(columnDefinition = "TIMESTAMP(0)")
    @Temporal(TemporalType.DATE)
    private LocalDate endDate;

    @Column(columnDefinition = "TIMESTAMP(0)")
    private Instant creationDate;

    @Column(nullable = false)
    private double amount;

    @ManyToOne
    private Category category;

    @OneToMany(mappedBy = "estimatedTransaction", cascade = {CascadeType.PERSIST})
    private Set<Transaction> transaction;
}
