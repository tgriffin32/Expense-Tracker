package com.tgriff.exptracker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.tgriff.exptracker.entity.Expense;
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

    @GetMapping("/expenses/new")
    public String createExpenseForm(Model model){

        // create expense obj to hold new expense form data
        Expense expense = new Expense();
        model.addAttribute("expense", expense);
        return "create_expense";
    }

    @PostMapping("/expenses")
    public String saveExpense(@ModelAttribute("expense") Expense expense){
        expenseService.saveExpense(expense);
        return "redirect:/expenses";
    }

    
}