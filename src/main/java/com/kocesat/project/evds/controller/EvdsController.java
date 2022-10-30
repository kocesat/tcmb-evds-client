package com.kocesat.project.evds.controller;

import com.kocesat.project.evds.service.EvdsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/evds")
public class EvdsController {
    @Autowired
    private EvdsService evdsService;

    @GetMapping
    public ResponseEntity getAll() {
        return ResponseEntity.ok(evdsService.getUsdRateFor(LocalDate.now()));
    }
}
