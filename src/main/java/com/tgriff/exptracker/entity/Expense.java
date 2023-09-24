package com.tgriff.exptracker.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "expensetracker")
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "expense_category", nullable = true)
    private String category;

    @Column(name = "expense_description", nullable = false)
    public String description;

    @Column(name = "expense_cost", nullable = false)
    private double dollarAmount;

    //dynamic constructor to create objects dynimically
    public Expense(){

    }

    public Expense(String category, String description, double dollarAmount) {
        super();
        this.category = category;
        this.description = description;
        this.dollarAmount = dollarAmount;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public String getDesciption() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public double getDollarAmount() {
        return dollarAmount;
    }
    public void setDollarAamount(double dollarAmount) {
        this.dollarAmount = dollarAmount;
    }

    
}