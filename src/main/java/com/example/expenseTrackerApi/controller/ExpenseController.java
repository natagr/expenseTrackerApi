package com.example.expenseTrackerApi.controller;


import com.example.expenseTrackerApi.domain.entity.dto.ExpenseDto;
import com.example.expenseTrackerApi.service.interfaces.ExpenseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ExpenseController {

    private final ExpenseService expenseService;

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping("/expenses")
    public ExpenseDto createExpense(@Valid @RequestBody ExpenseDto expenseDto) {
        return expenseService.createExpense(expenseDto);
    }

    @GetMapping("/expenses")
    @ResponseStatus(HttpStatus.OK)
    public Page<ExpenseDto> getAllExpenses(Pageable page) {
        return expenseService.getAllExpenses(page);
    }

    @GetMapping("/expenses/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ExpenseDto getExpenseById(@PathVariable Long id){
        return expenseService.getExpenseById(id);
    }

    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @DeleteMapping("/expenses")
    public void deleteExpenseById(@RequestParam Long id) {
        expenseService.deleteExpenseById(id);
    }


    @PutMapping("/expenses/{id}")
    public ExpenseDto updateExpenseDetails(@RequestBody ExpenseDto expenseDto, @PathVariable Long id){
        return expenseService.updateExpense(id, expenseDto);
    }

    @GetMapping("/expenses/category")
    public List<ExpenseDto> getExpensesByCategory(@RequestParam String category, Pageable page) {
        return expenseService.readByCategory(category, page);
    }

    @GetMapping("/expenses/name")
    public List<ExpenseDto> getExpensesByName(@RequestParam String keyword, Pageable page) {
        return expenseService.readByName(keyword, page);
    }

    @GetMapping("/expenses/date")
    public List<ExpenseDto> getExpensesByDates(@RequestParam(required = false) LocalDate startDate,
                                            @RequestParam(required = false) LocalDate endDate,
                                            Pageable page) {
        return expenseService.readByDate(startDate, endDate, page);
    }
}


