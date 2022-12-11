package com.tgodard.mybudget.models.entities;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.Instant;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class EstimatedTransaction  {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(columnDefinition = "TIMESTAMP(0)", nullable = false)
    private Instant startDate;

    @Column(columnDefinition = "TIMESTAMP(0)")
    private Instant endDate;

    @Column(nullable = false)
    private double amount;

    @ManyToOne
    private Category category;

    @OneToOne(cascade = CascadeType.ALL)
    private Transaction transaction;
}
