package com.kocesat.project.evds.service;

import com.kocesat.project.evds.model.Todo;

import java.time.LocalDate;
import java.util.List;

public interface EvdsService {
    List<Todo> getUsdRateFor(LocalDate date);
}
