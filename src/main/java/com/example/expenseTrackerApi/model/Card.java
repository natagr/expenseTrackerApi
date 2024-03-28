package com.example.expenseTrackerApi.model;

import com.example.expenseTrackerApi.model.base.AbstractIdentifiable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Card extends AbstractIdentifiable {

    @Column(name = "customer_id")
    private Integer customerId;

    @Column(name="card_number")
    private String cardNumber;

    @Column(name="card_type")
    private String cardType;

    @Column(name="custom_id")
    private Integer totalLimit;

    @Column(name="amount_used")
    private Integer amountUsed;

}
