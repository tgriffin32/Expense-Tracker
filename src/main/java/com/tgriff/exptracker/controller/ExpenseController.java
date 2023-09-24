package com.tgriff.exptracker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.tgriff.exptracker.service.ExpenseService;

@Controller
public class ExpenseController {
    
    private ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        super();
        this.expenseService = expenseService;
    }

    //handler method to handle list students and return model and view
    @GetMapping("/expenses")
    public String listExpenses(Model model){
        model.addAttribute("expenses", expenseService.getAllExpenses());
        return "expenses";
    }

    
}