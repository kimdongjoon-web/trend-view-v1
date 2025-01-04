package com.example.trendviewv1.production.domain.exchangerate;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class ExchangeRateData {
    @JsonProperty("TIME")
    private String time;

    @JsonProperty("DATA_VALUE")
    private String dataValue;
}