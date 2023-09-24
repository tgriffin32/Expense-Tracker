package com.tgriff.exptracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tgriff.exptracker.entity.Expense;

// JpaRepository provides CRUD methods
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    
}