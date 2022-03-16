package com.tgodard.mybudget.models.entities;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.Instant;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class Transaction {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String label;

    @Column(columnDefinition = "TIMESTAMP(0)", nullable = false)
    private Instant levyDate;

    @Column(nullable = false)
    private double amount;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Transaction transaction = (Transaction) o;
        return id != null && Objects.equals(id, transaction.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
