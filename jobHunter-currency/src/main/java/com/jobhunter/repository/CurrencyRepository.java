package com.jobhunter.repository;

import com.jobhunter.model.Currency;
import com.jobhunter.model.CurrencyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CurrencyRepository extends JpaRepository<CurrencyEntity, Integer> {

    Optional<CurrencyEntity> findByCurrency(Currency currency);

}
