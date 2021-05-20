package com.mk.trading.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mk.trading.domain.Tax;

public interface TaxRepository extends JpaRepository<Tax, Long> {

}
