package com.harley.mysales.controllers;

import com.harley.mysales.entities.Sale;
import com.harley.mysales.service.SaleService;
import com.harley.mysales.service.SmsService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/sales")
@RequiredArgsConstructor
public class SaleController {

    private final SaleService saleService;
    private final SmsService smsService;

    @GetMapping
    public Page<Sale> findSales(@RequestParam(value = "minDate", defaultValue = "") String minDate,
                                @RequestParam(value = "maxDate", defaultValue = "") String maxDate,
                                Pageable pageable) {
       return saleService.findSales(minDate, maxDate, pageable);
    }
    @GetMapping("/{id}/notification")
    public void notifySms(@PathVariable Long id) {
        smsService.sendSms(id);
    }
}
