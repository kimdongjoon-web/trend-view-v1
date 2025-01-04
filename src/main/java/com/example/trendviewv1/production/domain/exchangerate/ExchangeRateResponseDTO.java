package com.example.trendviewv1.production.domain.exchangerate;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class ExchangeRateResponseDTO {
    @JsonProperty("StatisticSearch")
    private StatisticSearch data;

    public List<ExchangeRate> getExchangeRates() {
        return data.getRow().stream()
                .map(ExchangeRate::from) // API에서 받은 원본 데이터는 날짜와 환율이 문자열 형식이므로 각각 LocalDateTime / BigDecimal 변환
                .collect(Collectors.toList());
    }

    @Getter
    public static class StatisticSearch {
        @JsonProperty("list_total_count")
        private int listTotalCount;
        private List<ExchangeRateData> row;
    }
}