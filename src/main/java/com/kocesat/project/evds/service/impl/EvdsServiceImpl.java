package com.kocesat.project.evds.service.impl;

import com.kocesat.project.evds.model.Todo;
import com.kocesat.project.evds.service.EvdsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class EvdsServiceImpl implements EvdsService {
    @Qualifier("todoWebClient")
    @Autowired
    private WebClient todoWebClient;

    private final static String USD_CODE = "TP.DK.USD.A";
    private final static String EUR_CODE = "TP.DK.EUR.A";
    private final static String API_DATE_FORMAT = "dd-MM-YYYY";

    @Override
    public List<Todo> getUsdRateFor(LocalDate date) {
        return getRateFor(USD_CODE, date);
    }

    private List<Todo> getRateFor(String code, LocalDate date) {
        String formattedDate = date.format(DateTimeFormatter.ofPattern(API_DATE_FORMAT));
        String uri = "/todos";
        return todoWebClient
                .get()
                .uri(uri)
                .retrieve()
                .bodyToFlux(Todo.class)
                .collectList()
                .block();
    }
}
