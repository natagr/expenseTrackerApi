package com.example.expenseTrackerApi.repository;

import com.example.expenseTrackerApi.model.AccountTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AccountTransactionRepository extends JpaRepository<AccountTransaction, Integer> {

    List<AccountTransaction> findByCustomerIdOrderByTransactionDtDesc(int customerId);

}
