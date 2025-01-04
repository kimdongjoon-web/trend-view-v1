package com.example.trendviewv1.production.domain.exchangerate;

import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter
public class ExchangeRate {
    private final LocalDate date;
    private final BigDecimal rate;

    private ExchangeRate(LocalDate date, BigDecimal rate) {
        this.date = date;
        this.rate = rate;
    }

    public static ExchangeRate from(ExchangeRateData data) {
        return new ExchangeRate(
                LocalDate.parse(data.getTime(), DateTimeFormatter.ofPattern("yyyyMMdd")),
                new BigDecimal(data.getDataValue())
        );
    }
}