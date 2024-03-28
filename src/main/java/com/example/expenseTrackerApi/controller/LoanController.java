package com.example.expenseTrackerApi.controller;

import com.example.expenseTrackerApi.model.Loan;
import com.example.expenseTrackerApi.repository.LoanRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class LoanController {

    private final LoanRepository loanRepository;

    @GetMapping("/myLoans")
    public List<Loan> getLoanDetails(@RequestParam Integer id) {
        List<Loan> loans = loanRepository.findByCustomerIdOrderByStartDtDesc(id);
        if (loans != null ) {
            return loans;
        }else {
            return null;
        }
    }

}