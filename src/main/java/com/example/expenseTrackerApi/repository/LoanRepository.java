package com.example.expenseTrackerApi.repository;

import com.example.expenseTrackerApi.model.Customer;
import com.example.expenseTrackerApi.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface LoanRepository extends JpaRepository<Loan, Integer> {

    List<Loan> findByCustomerIdOrderByStartDtDesc(int customerId);

}
