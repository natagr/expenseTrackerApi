package com.example.expenseTrackerApi.controller;

import com.example.expenseTrackerApi.model.Account;
import com.example.expenseTrackerApi.repository.AccountRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AccountController {


    private final AccountRepository accountsRepository;

    @GetMapping("/myAccount")
    public Account getAccountDetails(@RequestParam Integer id) {
        Account account = accountsRepository.findByCustomerId(id);
        if (account != null ) {
            return account;
        }else {
            return null;
        }
    }

}