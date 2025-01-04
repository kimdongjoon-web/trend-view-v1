package com.example.trendviewv1.production;

import com.example.trendviewv1.production.domain.exchangerate.ExchangeRateResponseDTO;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class EcosOpenApiClient {

    @Value("${ecos.api.base-url}")
    private String baseUrl;

    @Value("${ecos.api.base-url.api-key}")
    private String apiKey;

    private final RestTemplate restTemplate;
    private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");

    public EcosOpenApiClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ExchangeRateResponseDTO getRecentExchangeRate() {
        LocalDate endDate = LocalDate.now();
        LocalDate startDate = endDate.minusDays(10);
        URI uri = UriComponentsBuilder.fromHttpUrl(baseUrl)
                .pathSegment(apiKey, "json", "kr", "1", "10", "731Y003", "D", startDate.format(dateFormatter), endDate.format(dateFormatter), "0000002")
                .build()
                .toUri();

        System.out.println(uri);

        return restTemplate.getForObject(uri, ExchangeRateResponseDTO.class);
    }
}