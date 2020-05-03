package com.brajesh.myApp.services;

import com.brajesh.myApp.exception.RecordNotFoundException;
import com.brajesh.myApp.model.Expense;
import com.brajesh.myApp.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {
    @Autowired
    ExpenseRepository expenseRepository;

    public Expense getExpenseById(long id) throws RecordNotFoundException {
        Optional<Expense> result =  expenseRepository.findById(id);
        if(result.isPresent()) {
            return result.get();
        } else {
            throw new RecordNotFoundException("No student record exist for given id",id);
        }
    }

    public List<Expense> findAll() {
        return expenseRepository.findAll();
    }


    public Expense save(Expense expense) {
        return expenseRepository.save(expense);
    }

    public  List<Expense> findByItem(String item) {
        return expenseRepository.listItemsWithName(item);
    }

    public List<Expense> listItemsWithPriceOver(float amount) {
        return expenseRepository.listItemsWithPriceOver(amount);
    }
}
