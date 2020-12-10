package com.example.shop;

import com.example.shop.JDBC.SalesPeriodJdbcDemo;
import com.example.shop.JDBC.SalesProductJdbcRepository;
import com.example.shop.JPA.Sales;
import com.example.shop.JPA.repos.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.util.List;
import java.util.Map;

@Controller
public class SalesController {
    @Autowired
    private SalesRepository salesRepository;

    @GetMapping
    public String main(Map<String, Object> model){
        Iterable<Sales> saleses = salesRepository.findAll();

        model.put("saleses", saleses);
        return "main"; //возрат пользователю??
    }

    @PostMapping //Обработка button добавить
    public String add(@RequestParam Date dateFrom, @RequestParam Date dateTo, Map<String, Object> model){
        Sales sales = new Sales(dateFrom, dateTo, 1L, 1);
        salesRepository.save(sales);

        //Вычитываем добавленные записи
        Iterable<Sales> saleses = salesRepository.findAll();
        model.put("saleses", saleses);
        return "main";
    }

    @PostMapping("filter") //поиск по дате
    public String filter(@RequestParam Date dateTo, Map<String, Object> model){
        List<Sales> salesList = salesRepository.findByDateFrom(dateTo);
        model.put("saleses", salesList);
        for(Sales sales: salesList){
            System.out.println(sales.toString());
        }

        return "main";
    }

    @PostMapping("countJPA")
    public String count(Map<String, Object> model){
        List<Sales> iterable = (List<Sales>) salesRepository.findAll();
        model.put("count", iterable.size());
        System.out.println(iterable.size());

        return "main";
    }

    @PostMapping("countJDBC")
    public String jdbc(Map<String, Object> model){

        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        dataSource.setDriverClass(com.mysql.jdbc.Driver.class);
        dataSource.setUrl("jdbc:mysql://localhost/sales_db?useUnicode=true&serverTimezone=UTC"); //jdbc:mysql://localhost:3306/sales_db?useSSL=false&useUnicode=true&characterEncoding=UTF-8
        dataSource.setUsername("root");
        dataSource.setPassword("qwe234");

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        SalesProductJdbcRepository repository = new SalesProductJdbcRepository(jdbcTemplate);
        System.out.println(repository.count());

        model.put("count", repository.count());

        for (SalesPeriodJdbcDemo sales:repository.selectSales()){
            System.out.println(sales);
        }
        //model.put("saleses", repository.selectSales());


        return "main";
    }

    @PostMapping("whereIdJDBC")
    public String whereIdJDBC(Map<String, Object> model){
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        dataSource.setDriverClass(com.mysql.jdbc.Driver.class);
        dataSource.setUrl("jdbc:mysql://localhost/sales_db?useUnicode=true&serverTimezone=UTC"); //jdbc:mysql://localhost:3306/sales_db?useSSL=false&useUnicode=true&characterEncoding=UTF-8
        dataSource.setUsername("root");
        dataSource.setPassword("qwe234");

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        SalesProductJdbcRepository repository = new SalesProductJdbcRepository(jdbcTemplate);
        System.out.println(repository.count());

        for (SalesPeriodJdbcDemo sales:repository.selectWhereId(1)){
            System.out.println(sales);
        }

        //model.put("count", iterable.size());
        //System.out.println(iterable.size());

        return "main";
    }

}
