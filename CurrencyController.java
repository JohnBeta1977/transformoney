package com.transfor.money.controller;

import com.transfor.money.model.ConversionHistory;
import com.transfor.money.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CurrencyController {

    @Autowired
    private CurrencyService currencyService;

    @GetMapping("/convert")
    public double convertCurrency(@RequestParam String from, 
                                  @RequestParam String to, 
                                  @RequestParam double amount) throws IOException {
        return currencyService.convertCurrency(from, to, amount);
    }

    @GetMapping("/history")
    public List<ConversionHistory> getHistory() {
        return currencyService.getHistory();
    }
}