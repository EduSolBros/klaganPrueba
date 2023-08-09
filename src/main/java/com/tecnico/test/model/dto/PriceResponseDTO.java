package com.tecnico.test.model.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Date;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
public class PriceResponseDTO {


    private Integer productId;
    private Long brandId;
    private Integer priceList;
    private String consultationDate;
    private Double price;



}
