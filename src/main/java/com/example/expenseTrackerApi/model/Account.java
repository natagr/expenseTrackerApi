package com.example.expenseTrackerApi.model;

import com.example.expenseTrackerApi.model.base.AbstractIdentifiable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Account extends AbstractIdentifiable {

    @Column(name="custom_id")
    private Integer customerId;

    @Column(name="account_type")
    private String accountType;

    @Column(name="branch_address")
    private String branchAddress;

    @Column(name="create_dt")
    private String createDt;





}
