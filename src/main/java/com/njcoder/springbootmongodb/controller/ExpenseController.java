package com.njcoder.springbootmongodb.controller;

import com.njcoder.springbootmongodb.model.Expense;
import com.njcoder.springbootmongodb.model.ExpenseCategory;
import com.njcoder.springbootmongodb.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expense")
public class ExpenseController {

    private ExpenseService expenseService;

    @Autowired
    public ExpenseController(ExpenseService expenseService){
        this.expenseService = expenseService;
    }

    @PostMapping("/add")
    public ResponseEntity<Expense> addExpense(@RequestBody Expense expense) {
        System.out.println("Entered the conrtroller method for creating the expense !!! ");
        expenseService.addExpense(expense);
        return ResponseEntity.status(HttpStatus.CREATED).body(expense);
    }

    @PutMapping("/update")
    public ResponseEntity<Expense> updateExpense(@RequestBody Expense expense){
        System.out.println("Entered the conrtroller method for updating the expense !!! ");
        expenseService.updateExpense(expense);
        return ResponseEntity.status(HttpStatus.OK).body(expense);
    }
    @GetMapping("/getall")
    public ResponseEntity<List<Expense>> getAllExpense(){
        List<Expense> expenseList = expenseService.getAllExpense();
        return ResponseEntity.status(HttpStatus.OK).body(expenseList);
    }

    @GetMapping("/getexpensebyname/{expenseName}")
    public ResponseEntity<List<Expense>>  getExpenseByName(@PathVariable String expenseName){
        List<Expense> expenseList = expenseService.getExpenseByName(expenseName);
        return ResponseEntity.status(HttpStatus.OK).body(expenseList);
    }

    @DeleteMapping("/deleteexpensebyname")
    public String deleteExpense(@RequestBody Expense expense){
        expenseService.deleteExpense(expense);
        return "Deleted Successfully";
    }
}
