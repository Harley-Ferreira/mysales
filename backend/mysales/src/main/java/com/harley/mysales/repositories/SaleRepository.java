package com.harley.mysales.repositories;

import com.harley.mysales.entities.Sale;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;


@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {

    @Query("select s from Sale s where s.date between :min and :max order by s.amount")
    Page<Sale> findSales(LocalDate min, LocalDate max, Pageable pageable);
}
