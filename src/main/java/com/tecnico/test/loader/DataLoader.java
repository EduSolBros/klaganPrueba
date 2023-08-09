package com.tecnico.test.loader;

import com.tecnico.test.model.Price;
import com.tecnico.test.operations.DateOperations;
import com.tecnico.test.repository.PriceRepository;
import jakarta.persistence.Column;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.text.ParseException;

@Component
public class DataLoader implements CommandLineRunner {

    private final PriceRepository priceRepository;
    private DateOperations dateOperations;

    @Autowired
    public DataLoader(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
        this.dateOperations = new DateOperations();
    }

    @Override
    public void run(String... args) throws ParseException {

        Price price1 = new Price(1L, dateOperations.convertToTimestamp("2020-06-14-00.00.00"),dateOperations.convertToTimestamp("2020-12-31-23.59.59"), 1,35455,0,35.50,"EUR");
        Price price2 = new Price(1l, dateOperations.convertToTimestamp("2020-06-14-15.00.00"),dateOperations.convertToTimestamp("2020-06-14-18.30.00"),2,35455,1,25.45,"EUR");
        Price price3 = new Price(1L,dateOperations.convertToTimestamp("2020-06-15-00.00.00"),dateOperations.convertToTimestamp("2020-06-15-11.00.00"),3 ,35455 ,1 , 30.50,"EUR");
        Price price4 = new Price(1L,dateOperations.convertToTimestamp("2020-06-15-16.00.00") , dateOperations.convertToTimestamp("2020-12-31-23.59.59"),4,35455 ,1,38.95,"EUR");

        priceRepository.save(price1);
        priceRepository.save(price2);
        priceRepository.save(price3);
        priceRepository.save(price4);
    }
}