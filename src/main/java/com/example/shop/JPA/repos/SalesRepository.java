package com.example.shop.JPA.repos;

import com.example.shop.JPA.Sales;
import org.springframework.data.repository.CrudRepository;

import java.sql.Date;
import java.util.List;

public interface SalesRepository  extends CrudRepository<Sales, Long> {
    List<Sales> findByDateFrom(Date date);
}
