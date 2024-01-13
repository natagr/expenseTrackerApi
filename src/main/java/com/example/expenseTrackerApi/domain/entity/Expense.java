package com.example.expenseTrackerApi.domain.entity;

import com.example.expenseTrackerApi.domain.base.AbstractVersionalIdentifiable;
import com.example.expenseTrackerApi.domain.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.math.BigDecimal;
import java.time.LocalDate;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_expenses")

public class Expense extends AbstractVersionalIdentifiable {

    @Column(name="expense_name")
    @NotBlank(message="expense name must not be null")
    @Size(min = 3, message = "expense name must be at least 3 characters")
    private String name;

    private String description;

    @Column(name="expense_amount")
    @NotNull(message = "expense amount must not be null")
    private BigDecimal amount;

    @NotBlank(message="expense category must not be null")
    private String category;

    @NotNull(message = "expense date must not be null")
    private LocalDate date;

    @ManyToOne(fetch=FetchType.LAZY, optional = false)
    @JoinColumn(name="user_id", nullable=false)
    @OnDelete(action= OnDeleteAction.CASCADE)
    @JsonIgnore
    private User user;

}