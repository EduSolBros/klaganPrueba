package com.tecnico.test.service.rate;

import com.tecnico.test.model.Price;
import com.tecnico.test.model.dto.PriceResponseDTO;
import com.tecnico.test.operations.DateOperations;
import com.tecnico.test.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Comparator;
import java.util.List;

@Service
public class PriceServiceImpl implements PriceService {

    private PriceRepository priceRepository;

    private DateOperations dateOperations;
    @Autowired
    public PriceServiceImpl(PriceRepository priceRepository){
        this.priceRepository = priceRepository;
        dateOperations = new DateOperations();
    }

    @Override
    public PriceResponseDTO checkPrice(String consultationDate, Long productId, Long brandId) throws ParseException {


        var priceList = priceRepository.findPricesByDateAndProductIdAndBrandId(dateOperations.convertToTimestamp(consultationDate),productId,brandId);
        var resultPrice = getBestPrice(priceList);
        if(resultPrice !=null) {
            return new PriceResponseDTO(resultPrice.getProductId(), resultPrice.getBrandId(), resultPrice.getPriceList(), consultationDate, resultPrice.getPrice());
        }else{
            return null;
        }
    }

    @Override
    public Price getBestPrice(List<Price> priceList) {
        var bestRate = priceList.stream()
                .max(Comparator.comparingDouble( element -> element.getPriority() ))
                .orElse(null);
        return bestRate;
    }


}
