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
public class EstimatedTransaction  {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String label;

    @Column(columnDefinition = "TIMESTAMP(0)", nullable = false)
    private Instant StartDate;

    @Column(columnDefinition = "TIMESTAMP(0)")
    private Instant EndDate;
    
    @Column(nullable = false)
    private double amount;

    @Override

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        EstimatedTransaction that = (EstimatedTransaction) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
