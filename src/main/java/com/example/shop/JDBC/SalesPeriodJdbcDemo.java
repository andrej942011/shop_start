package com.example.shop.JDBC;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class SalesPeriodJdbcDemo {
    private Long id;
    private Long price;
    private Date dateFrom;

    private Date dateTo;
    private Integer product;

    public SalesPeriodJdbcDemo(){

    }

    public SalesPeriodJdbcDemo(Long id, Long price, Integer product){ //Date dateFrom, Date dateTo
        this.id = id;
        this.price = price;
        //this.dateFrom = dateFrom;
        //this.dateTo = dateTo;
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Integer getProduct() {
        return product;
    }

    public void setProduct(Integer product) {
        this.product = product;
    }

    @Override
    public String toString(){
        return String.format(
               "Sales[ id=%d, price=%s, product=%s ]",
               id, price, product//, dateFrom
        );
    }
}
