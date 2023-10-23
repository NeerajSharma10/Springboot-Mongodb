package com.njcoder.springbootmongodb.repository;

import com.njcoder.springbootmongodb.model.Expense;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseRepository extends MongoRepository<Expense, String> {
    @Query("{ 'fieldName' : ?0 }")
    List<Expense> findByFieldName(String fieldName);
}
