package com.tecnico.test.repository;


import com.tecnico.test.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {

    @Query("SELECT r FROM Price r WHERE :consultationDate >= r.startDate  AND :consultationDate <= r.endDate AND r.productId = :productId AND r.brandId = :brandId")
    List<Price> findPricesByDateAndProductIdAndBrandId(Timestamp consultationDate, Long productId, Long brandId);
}