package com.example.trendviewv1.production.domain.exchangerate;

import com.example.trendviewv1.production.EcosOpenApiClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ExchangeController {
    private final EcosOpenApiClient ecosClient;

    public ExchangeController(EcosOpenApiClient ecosClient) {
        this.ecosClient = ecosClient;
    }

    @GetMapping("/exchange-rates/recent")
    public List<ExchangeRate> getRecentExchangeRates() {
        return ecosClient.getRecentExchangeRate()
                .getExchangeRates();
    }
}