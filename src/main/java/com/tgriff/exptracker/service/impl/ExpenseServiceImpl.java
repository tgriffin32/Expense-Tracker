package com.tgriff.exptracker.service.impl;

import com.tgriff.exptracker.entity.Expense;
import com.tgriff.exptracker.repository.ExpenseRepository;
import com.tgriff.exptracker.service.ExpenseService;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    private ExpenseRepository expenseRepository;

    

    public ExpenseServiceImpl(ExpenseRepository expenseRepository) {
        super();
        this.expenseRepository = expenseRepository;
    }


    // List all expenses
    @Override
    public List<Expense> getAllExpenses() {
        
        return expenseRepository.findAll();
    }

    @Override
    public Expense saveExpense(Expense expense){
        return expenseRepository.save(expense);
    }


    @Override
    public Expense updateExpense(Expense expense) {
        return expenseRepository.save(expense);
    }


    @Override
    public Expense getExpenseById(Long id) {
        return expenseRepository.findById(id).get();
    }


    @Override
    public void deleteExpenseById(Long id) {
        expenseRepository.deleteById(id);
    }
    
}