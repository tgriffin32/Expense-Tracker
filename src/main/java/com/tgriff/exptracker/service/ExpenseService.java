package com.tgriff.exptracker.service;

import java.util.List;

import com.tgriff.exptracker.entity.Expense;

public interface ExpenseService {
    List<Expense> getAllExpenses();

    Expense saveExpense(Expense expense);

    Expense updateExpense(Expense expense);
    Expense getExpenseById(Long id);

    void deleteExpenseById(Long id);

    
}