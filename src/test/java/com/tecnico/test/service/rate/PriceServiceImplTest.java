package com.tecnico.test.service.rate;

import com.tecnico.test.operations.DateOperations;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestClass;

import java.sql.Date;
import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PriceServiceImplTest {


    private PriceService priceService;
    private DateOperations dateOperations;

    @BeforeEach
    public void setup() {

    }
    @Autowired
    public PriceServiceImplTest(PriceService priceService){
        this.dateOperations = new DateOperations();
        this.priceService = priceService;
    }

    @Test
    void testCheckPriceWithDate1() throws ParseException {
        //arrange
        String dateInString = "2020-06-14-10.00.00";
        var date = dateOperations.convertToTimestamp(dateInString);
        var productId = 35455L;
        var brandId = 1L;
        var priceExpected = 35.5;
        //act
        var result = priceService.checkPrice(dateInString,productId,brandId);
        //assert
        assertEquals(priceExpected,result.getPrice());

    }

    @Test
    void testCheckPriceWithDate2() throws ParseException {
        //arrange
        String dateInString = "2020-06-14-16.00.00";
        var date = dateOperations.convertToTimestamp(dateInString);
        var productId = 35455L;
        var brandId = 1L;
        var priceExpected = 25.45;
        //act
        var result = priceService.checkPrice(dateInString,productId,brandId);
        //assert
        assertEquals(priceExpected,result.getPrice());

    }

    @Test
    void testCheckPriceWithDate3() throws ParseException {
        //arrange
        String dateInString = "2020-06-14-21.00.00";
        var date = dateOperations.convertToTimestamp(dateInString);
        var productId = 35455L;
        var brandId = 1L;
        var priceExpected = 35.5;
        //act
        var result = priceService.checkPrice(dateInString,productId,brandId);
        //assert
        assertEquals(priceExpected,result.getPrice());

    }

    @Test
    void testCheckPriceWithDate4() throws ParseException {
        //arrange
        String dateInString = "2020-06-15-10.00.00";
        var date = dateOperations.convertToTimestamp(dateInString);
        var productId = 35455L;
        var brandId = 1L;
        var priceExpected = 30.5;
        //act
        var result = priceService.checkPrice(dateInString,productId,brandId);
        //assert
        assertEquals(priceExpected,result.getPrice());

    }

    @Test
    void testCheckPriceWithDate5() throws ParseException {
        //arrange
        String dateInString = "2020-06-16-21.00.00";
        var date = dateOperations.convertToTimestamp(dateInString);
        var productId = 35455L;
        var brandId = 1L;
        var priceExpected = 38.95;
        //act
        var result = priceService.checkPrice(dateInString,productId,brandId);
        //assert
        assertEquals(priceExpected,result.getPrice());

    }

}