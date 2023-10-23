package com.njcoder.springbootmongodb.config;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import com.njcoder.springbootmongodb.model.Expense;
import com.njcoder.springbootmongodb.model.ExpenseCategory;
import com.njcoder.springbootmongodb.repository.ExpenseRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static com.njcoder.springbootmongodb.model.ExpenseCategory.*;

@ChangeLog
public class DatabaseChangeLog {

    @ChangeSet(order = "001", id = "seedDatabase", author = "Neeraj Sharma")
    public void seedDatabase(ExpenseRepository expenseRepository){
        List<Expense> expenseList = new ArrayList<>();
        expenseList.add(createExpense("Mall", ENTERTAINMENT, BigDecimal.valueOf(324)));
        expenseList.add(createExpense("Mall", ENTERTAINMENT, BigDecimal.valueOf(233)));
        expenseList.add(createExpense("Mall", RESTAURENT, BigDecimal.valueOf(32423)));
        expenseList.add(createExpense("Mall", RESTAURENT, BigDecimal.valueOf(232)));
        expenseList.add(createExpense("Mall", GROCERIES, BigDecimal.valueOf(3232)));
        expenseList.add(createExpense("Mall", GROCERIES, BigDecimal.valueOf(67)));
        expenseRepository.insert(expenseList);
    }
    public Expense createExpense(String expenseName, ExpenseCategory expenseCategory, BigDecimal expenseAmount){
        Expense expense = new Expense();
        expense.setExpenseName(expenseName);
        expense.setExpenseCategory(expenseCategory);
        expense.setExpenseAmount(expenseAmount);
        return expense;
    }
}
