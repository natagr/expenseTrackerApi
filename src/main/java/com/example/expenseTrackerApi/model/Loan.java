package com.example.expenseTrackerApi.model;

import com.example.expenseTrackerApi.model.base.AbstractIdentifiable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Loan extends AbstractIdentifiable {

    @Column(name="custom_id")
    private Integer customerId;

    @Column(name="start_dt")
    private Date startDt;

    @Column(name="loan_type")
    private String loanType;

    @Column(name="total_loan")
    private Integer totalLoan;

    @Column(name="amount_paid")
    private Integer amountPaid;

    @Column(name = "outstanding_amount")
    private Integer outstandingAmount;

    @Column(name = "create_dt")
    private String createDt;

}
