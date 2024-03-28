package com.example.expenseTrackerApi.model;

import com.example.expenseTrackerApi.model.base.AbstractIdentifiable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Account_transactions")
@Getter
@Setter
@RequiredArgsConstructor
public class AccountTransaction extends AbstractIdentifiable {

    @Column(name="account_number")
    private Integer acountNumber;

    @Column(name="custom_id")
    private Integer customerId;

    @Column(name="transaction_dt")
    private String transactionDt;

    @Column(name="transaction_summary")
    private String transactionSummary;

    @Column(name="transaction_type")
    private String transactionType;

    @Column(name="transaction_amt")
    private Integer transactionAmt;



}
