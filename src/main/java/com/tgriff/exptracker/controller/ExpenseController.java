package com.tgriff.exptracker.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
        double totalAmount = expenseService.getAllExpenses().stream().mapToDouble(Expense::getDollarAmount).sum();

        String formattedTotalAmount = String.format("%.2f", totalAmount);

        model.addAttribute("expenses", expenseService.getAllExpenses());
        model.addAttribute("totalAmount", formattedTotalAmount);
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

    //Handler method to handle update requests
    //PathVariable binds id variable to view path
    @GetMapping("/expenses/edit/{id}")
    public String editExpenseFrom(@PathVariable Long id, Model model){
        model.addAttribute("expense", expenseService.getExpenseById(id));
        return "edit_expense";
    }

    //Handler method to handle update form requests
    @PostMapping("/expenses/{id}")
    public String updateExpense(@PathVariable Long id, @ModelAttribute("expense") Expense expense, Model model){
        
        //get student from database by id
        Expense existingExpense = expenseService.getExpenseById(id);
        existingExpense.setId(id);
        existingExpense.setCategory(expense.getCategory());
        existingExpense.setDescription(expense.getDescription());
        existingExpense.setDollarAmount(expense.getDollarAmount());

        //save updated expense object
        expenseService.updateExpense(existingExpense);
        return "redirect:/expenses";
    }

    //Handler method to handle delete expense requests
    @GetMapping("/expenses/{id}")
    public String deleteExpense(@PathVariable Long id){
        expenseService.deleteExpenseById(id);
        return "redirect:/expenses";
    }

    /* 
    // Handler to calculate total expenses
    @GetMapping("/expenses")
    public String calculateTotalExpenses(Model model){
        List<Expense> expenses = expenseService.getAllExpenses();

        //Calculate total amount
        double totalAmount = expenses.stream().mapToDouble(Expense::getDollarAmount).sum();
        //model.addAttribute("expenses", expenses);
        model.addAttribute("totalAmount", totalAmount);

        return "expenses";
    }
    */

    
}