package com.example.expenseTrackerApi.service;

import com.example.expenseTrackerApi.domain.entity.Expense;
import com.example.expenseTrackerApi.domain.entity.dto.ExpenseDto;

import com.example.expenseTrackerApi.domain.mapper.ExpenseMapper;
import com.example.expenseTrackerApi.repository.ExpenseRepository;
import com.example.expenseTrackerApi.service.interfaces.ExpenseService;
import com.example.expenseTrackerApi.service.interfaces.UserService;
import jakarta.persistence.EntityExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseRepository expenseRepo;
    private final UserService userService;
    private final ExpenseMapper expenseMapper;

    @Transactional(readOnly = true)
    @Override
    public Page<ExpenseDto> getAllExpenses(Pageable page) {
        return expenseRepo.findByUserId(userService.getLoggedInUser().getId(), page).map(expenseMapper::toDto);
    }

    @Transactional(readOnly = true)
    @Override
    public ExpenseDto getExpenseById(Long id) {
        Optional<ExpenseDto> expense=expenseRepo.findByUserIdAndId(userService.getLoggedInUser().getId(), id).map(expenseMapper::toDto);
        if(expense.isPresent()){
            return expense.get();
        }
        throw new EntityExistsException("Expense is not found for the id "+id);
    }

    @Transactional
    @Override
    public void deleteExpenseById(Long id) {
       Expense expense= expenseMapper.toEntity(getExpenseById(id));
        expenseRepo.delete(expense);
    }

    @Transactional
    @Override
    public ExpenseDto createExpense(ExpenseDto expenseDto) {
        Expense expense = new Expense();
        expense.setName(expenseDto.getName());
        expense.setDescription(expenseDto.getDescription());
        expense.setCategory(expenseDto.getCategory());
        expense.setAmount(expenseDto.getAmount());
        expense.setDate(expenseDto.getDate());
        expense.setUser(userService.getLoggedInUser());
        return expenseDto;
    }

    @Transactional
    @Override
    public ExpenseDto updateExpense(Long id, ExpenseDto expenseDto) {
        Expense existingExpense = expenseMapper.toEntity(getExpenseById(id));
        expenseMapper.updateExpense(expenseDto, existingExpense);
       return expenseDto;
    }

    @Transactional(readOnly = true)
    @Override
    public List<ExpenseDto> readByCategory(String category, Pageable page) {
        return expenseRepo.findByUserIdAndCategory(userService.getLoggedInUser().getId(), category, page).map(expenseMapper::toDto).toList();
    }

    @Transactional(readOnly = true)
    @Override
    public List<ExpenseDto> readByName(String keyword, Pageable page) {
        return expenseRepo.findByUserIdAndNameContaining(userService.getLoggedInUser().getId(), keyword, page).map(expenseMapper::toDto).toList();
    }

    @Transactional(readOnly = true)
    @Override
    public List<ExpenseDto> readByDate(LocalDate startDate, LocalDate endDate, Pageable page) {
        if(startDate==null) startDate=LocalDate.of(2000, 1, 1);
        if(endDate==null) endDate=LocalDate.now();
        return expenseRepo.findByUserIdAndDateBetween(userService.getLoggedInUser().getId(), startDate, endDate, page).map(expenseMapper::toDto).toList();
    }

}
