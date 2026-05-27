package com.trabalho.faculdade.impacta.sale.presentation;

import com.trabalho.faculdade.impacta.sale.app.SaleService;
import com.trabalho.faculdade.impacta.util.PageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/sales")
public class SaleController {

    private final SaleService saleService;

    @Autowired
    SaleController(SaleService saleService) {
        this.saleService = saleService;
    }

    @PostMapping(consumes = "application/json; charset=utf-8", path = "/register")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void sell(@RequestBody SaleRequest saleRequest) {
        saleService.register(saleRequest);
    }

    @GetMapping
    public PageResponse<SaleResponse> findAll(Pageable pageable) {
        return saleService.findAll(pageable);
    }

}
