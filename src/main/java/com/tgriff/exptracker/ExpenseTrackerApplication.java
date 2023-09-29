package com.tgriff.exptracker;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//import com.tgriff.exptracker.entity.Expense;
//import com.tgriff.exptracker.repository.ExpenseRepository;

@SpringBootApplication
public class ExpenseTrackerApplication{

	public static void main(String[] args) {
		SpringApplication.run(ExpenseTrackerApplication.class, args);
	}

	/* 
	@Autowired
	private ExpenseRepository expenseRepository;
	@Override
	public void run(String... args) throws Exception {
		Expense expense1 = new Expense("Groceries", "Walmart", 50.00);
		expenseRepository.save(expense1);

		Expense expense2 = new Expense("Bills", "Water Bill", 200);
		expenseRepository.save(expense2);

		Expense expense3 = new Expense("Bills", "Electric Bill", 100);
		expenseRepository.save(expense3);
	}
	*/
	

}
