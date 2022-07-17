package com.harley.mysales.controllers;

import com.harley.mysales.entities.Sale;
import com.harley.mysales.service.SaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/sales")
@RequiredArgsConstructor
public class SaleController {

    private final SaleService saleService;

    @GetMapping
    public List<Sale> findSales() {
       return saleService.findSales();
    }
}
