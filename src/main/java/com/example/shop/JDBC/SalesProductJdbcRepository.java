package com.example.shop.JDBC;

import com.example.shop.JPA.Sales;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class SalesProductJdbcRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public SalesProductJdbcRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<SalesPeriodJdbcDemo> selectSales(){
        List<Map<String, Object>> rows = jdbcTemplate.queryForList("select * from sales");
        List<SalesPeriodJdbcDemo> saleses = new ArrayList<>();

        for(Map row: rows){
            SalesPeriodJdbcDemo sales = new SalesPeriodJdbcDemo();
            sales.setId((Long) row.get("Id"));
            sales.setPrice((Long) row.get("price"));
            sales.setProduct(Integer.parseInt(row.get("product").toString()));
            sales.setDateFrom((Date) row.get("dateFrom"));
            sales.setDateTo((Date) row.get("dateTo"));
            saleses.add(sales);
        }
        return saleses;
    }

    public List<SalesPeriodJdbcDemo> selectSalesId(String id){
        List<SalesPeriodJdbcDemo> results = new ArrayList<SalesPeriodJdbcDemo>();
        List<Map<String, Object>> rows = jdbcTemplate.queryForList("select * from sales where Id =" + id);


        for(Map row: rows){
            SalesPeriodJdbcDemo sakes = new SalesPeriodJdbcDemo(
                    (Long)row.get("Id"),
                    (Long)row.get("price"),
                    //(Date)row.get("timeFrom"),
                    //(Date)row.get("timeTo"),
                    (Integer)row.get("product")
            );
            results.add(sakes);
        }

        return results;
    }

    public int count(){ //!!
        return jdbcTemplate.queryForObject("select count(*) from sales", Integer.class);
    }


}
