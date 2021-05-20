package com.mk.trading.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mk.trading.common.domain.Stock;

@Repository
public interface TradingRepository extends JpaRepository<Stock, Long> {

}
