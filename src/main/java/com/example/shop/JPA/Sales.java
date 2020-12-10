package com.example.shop.JPA;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Sales {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name="price")
    private long price;

    @Column(name="dateFrom")
    private Date dateFrom;

    @Column(name="dateTo")
    private Date dateTo;

    @Column(name = "product")
    private Integer product;

    @Override
    public String toString() {
        return "SalesPeriodJpaDemo{" +
                "id=" + id +
                ", price=" + price +
                ", dateFrom=" + dateFrom +
                ", dateTo=" + dateTo +
                ", product=" + product +
                '}';
    }

    public Sales() { } //обязательный конструктор для @Entity

    public Sales(Date dateFrom, Date dateTo, Long price, Integer product) {
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.price = price;
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public Date getDateFrom(Date dateFrom) {
        return this.dateFrom;
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

    public Integer getProduct(Integer product) {
        return this.product;
    }

    public void setProduct(Integer product) {
        this.product = product;
    }
}
