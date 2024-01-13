package com.example.expenseTrackerApi.service.interfaces;

import com.example.expenseTrackerApi.domain.entity.dto.ExpenseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;

import java.util.List;

public interface ExpenseService {

    Page<ExpenseDto> getAllExpenses(Pageable page);

    ExpenseDto getExpenseById(Long id);

    void deleteExpenseById(Long id);

    ExpenseDto createExpense(ExpenseDto expenseDto);

    ExpenseDto updateExpense(Long id, ExpenseDto expenseDto);

    List<ExpenseDto> readByCategory(String category, Pageable page);

    List<ExpenseDto> readByName(String keyword, Pageable page);

    List<ExpenseDto> readByDate(LocalDate startDate, LocalDate endDate, Pageable page);

}
