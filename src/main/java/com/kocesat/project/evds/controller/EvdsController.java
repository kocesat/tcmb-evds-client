package com.kocesat.project.evds.controller;

import com.kocesat.project.base.BaseResponse;
import com.kocesat.project.evds.model.EvdsItem;
import com.kocesat.project.evds.service.EvdsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = "/evds")
public class EvdsController {
    @Autowired
    private EvdsService evdsService;

    @GetMapping
    public ResponseEntity<BaseResponse> getAll(@RequestParam LocalDate start, @RequestParam LocalDate end) {
        List<EvdsItem> document = evdsService.getUsdRateFor(start, end);
        return ResponseEntity.ok(BaseResponse.success(document));
    }
}
