package com.njcoder.springbootmongodb.service;

import com.njcoder.springbootmongodb.model.Expense;
import com.njcoder.springbootmongodb.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {

    private ExpenseRepository expenseRepository;

    @Autowired
    public ExpenseService(ExpenseRepository expenseRepository){
        this.expenseRepository = expenseRepository;
    }
    public void addExpense(Expense expense) {
        expenseRepository.save(expense);
    }
    public void updateExpense(Expense expense){
        expenseRepository.save(expense);
    }
    public List<Expense> getAllExpense(){
        return expenseRepository.findAll();
    }

    public List<Expense> getExpenseByName(String expenseName){
        return expenseRepository.findByFieldName(expenseName);
    }
    public void deleteExpense(Expense expense){
        expenseRepository.delete(expense);
    }
}
