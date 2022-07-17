package com.harley.mysales.service;

import com.harley.mysales.entities.Sale;
import com.harley.mysales.repositories.SaleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SaleService {
    private final SaleRepository saleRepository;

    public List<Sale> findSales() {
        return saleRepository.findAll();
    }
}
