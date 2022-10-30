package com.kocesat.project.evds.service;

import com.kocesat.project.evds.model.EvdsItem;

import java.time.LocalDate;
import java.util.List;

public interface EvdsService {
    List<EvdsItem> getUsdRateFor(LocalDate start, LocalDate end);
}
