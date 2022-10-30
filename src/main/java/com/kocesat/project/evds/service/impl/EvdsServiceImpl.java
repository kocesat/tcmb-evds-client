package com.kocesat.project.evds.service.impl;

import com.kocesat.project.evds.model.EvdsItem;
import com.kocesat.project.evds.model.EvdsResponseDocument;
import com.kocesat.project.evds.service.EvdsService;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class EvdsServiceImpl implements EvdsService {

    private static final String API_ANAHTAR = "vtXDLYTlxd";
    private final WebClient evdsWebClient;

    public EvdsServiceImpl(WebClient evdsWebClient) {
        this.evdsWebClient = evdsWebClient;
    }

    private final static String USD_CODE = "TP.DK.USD.A";
    private final static String EUR_CODE = "TP.DK.EUR.A";
    private final static String API_DATE_FORMAT = "dd-MM-yyyy";

    @Override
    public List<EvdsItem> getUsdRateFor(LocalDate start, LocalDate end) {
        final EvdsResponseDocument evdsResponseDocument = getRateFor(USD_CODE, start, end);
        return evdsResponseDocument.getItems();
    }

    private EvdsResponseDocument getRateFor(String code, LocalDate start, LocalDate end) {
        String uri = String.format("/series=%s&startDate=%s&endDate=%s&type=xml&key=%s", code, format(start), format(end), API_ANAHTAR);
        return evdsWebClient
                .get()
                .uri(uri)
                .retrieve()
                .bodyToMono(EvdsResponseDocument.class)
                .block();
    }

    private String format(LocalDate date) {
        return date.format(DateTimeFormatter.ofPattern(API_DATE_FORMAT));
    }
}
