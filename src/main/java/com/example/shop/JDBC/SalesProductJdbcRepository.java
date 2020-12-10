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
        return jdbcTemplate.query("select * from sales", (rs, rowNum)->
                new SalesPeriodJdbcDemo(
                        rs.getLong("Id"),
                        rs.getLong("price"),
                        rs.getDate("date_from"),
                        rs.getDate("date_to"),
                        rs.getInt("product")));
    }

    public List<SalesPeriodJdbcDemo> selectWhereId(Integer id){
        return jdbcTemplate.query("select * from sales where Id =" + id, (rs, rowNum)->
                new SalesPeriodJdbcDemo(
                        rs.getLong("Id"),
                        rs.getLong("price"),
                        rs.getDate("date_from"),
                        rs.getDate("date_to"),
                        rs.getInt("product")));
    }



    public int count(){ //!!
        return jdbcTemplate.queryForObject("select count(*) from sales", Integer.class);
    }


}
