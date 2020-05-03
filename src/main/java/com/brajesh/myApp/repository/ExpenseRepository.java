package com.brajesh.myApp.repository;
import com.brajesh.myApp.model.Expense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    public List<Expense> findByItem(String item);

    public Expense findById(String item);

    public  List<Expense> findAll();

    @Query("SELECT e FROM Expense e WHERE e.amount >= :amount")
    public List<Expense> listItemsWithPriceOver(@Param("amount") float amount);


    @Query("SELECT e FROM Expense e WHERE e.item like %:item%")
    public List<Expense> listItemsWithName(@Param("item") String item);
}
