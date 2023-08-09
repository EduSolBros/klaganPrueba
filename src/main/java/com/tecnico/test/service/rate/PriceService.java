package com.tecnico.test.service.rate;

import com.tecnico.test.model.Price;
import com.tecnico.test.model.dto.PriceResponseDTO;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.List;

public interface PriceService {

    PriceResponseDTO checkPrice(String consultationDate, Long productId, Long brandId) throws ParseException;

    Price getBestPrice(List<Price> priceList);
}
