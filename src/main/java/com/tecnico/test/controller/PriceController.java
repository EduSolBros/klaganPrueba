package com.tecnico.test.controller;


import com.tecnico.test.model.dto.PriceResponseDTO;
import com.tecnico.test.service.rate.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;

@RestController
@RequestMapping("/price")
public class PriceController {

    private final PriceService priceService;

    @Autowired
    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }

    @GetMapping
    public ResponseEntity<PriceResponseDTO> checkPrice(@RequestParam("consultationDate") String consultationDate, @RequestParam("productId") Long roomId, @RequestParam("brandId") Long brandId) {

        PriceResponseDTO priceQueryResponseDto = null;
        try {
            priceQueryResponseDto = priceService.checkPrice(consultationDate, roomId, brandId);

        if (priceQueryResponseDto != null ){
            return new ResponseEntity<>(priceQueryResponseDto, HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
        } catch (ParseException e) {
            return ResponseEntity.badRequest().build();
        }
    }


}