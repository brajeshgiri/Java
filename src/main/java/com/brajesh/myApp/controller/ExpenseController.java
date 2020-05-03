package com.brajesh.myApp.controller;

import com.brajesh.myApp.exception.RecordNotFoundException;
import com.brajesh.myApp.model.Expense;
import com.brajesh.myApp.services.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path = "/expense")
public class ExpenseController {
    @Autowired
    ExpenseService expenseService;

    @GetMapping(path="/{id}")
    public ResponseEntity<Expense> getExpenseById(@PathVariable("id") long id) {
        Expense expense =  expenseService.getExpenseById(id);
        return new ResponseEntity<Expense>(expense, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping(path="/list")
    public ResponseEntity< List<Expense>> getAllExpense() {
        List<Expense> list = expenseService.findAll();
        return new ResponseEntity<List<Expense>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping(path="/item/{amount}")
    public ResponseEntity<List<Expense>> listItemsWithPriceOver(@PathVariable("amount") Float amount) {
        List<Expense> list = expenseService.listItemsWithPriceOver(amount);
        if(list.isEmpty()) {
            throw new RecordNotFoundException("Records not found for item:", amount.toString() );
        } else {
            return new ResponseEntity<List<Expense>>(list, new HttpHeaders(), HttpStatus.OK);
        }
    }

    @GetMapping(path="/item/{item}")
    public ResponseEntity<List<Expense>> listItemWithItem(@PathVariable("item") String item) {
        List<Expense> list = expenseService.findByItem(item);
        if(list.isEmpty()) {
            throw new RecordNotFoundException("Records not found for item:",item );
        } else {
            return new ResponseEntity<List<Expense>>(list, new HttpHeaders(), HttpStatus.OK);
        }
    }

    @PostMapping(path="/save")
    public Expense save(@RequestBody Expense expense)  throws Exception  {
        return expenseService.save(expense);
    }

}
