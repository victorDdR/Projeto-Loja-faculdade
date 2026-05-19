package com.trabalho.faculdade.impacta.sale.presentation;

import com.trabalho.faculdade.impacta.sale.app.SaleRegisterUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/sales")
public class SaleController {

    private final SaleRegisterUseCase saleRegisterUseCase;

    @Autowired
    SaleController(SaleRegisterUseCase saleRegisterUseCase) {
        this.saleRegisterUseCase = saleRegisterUseCase;
    }

    @PostMapping(consumes = "application/json; charset=utf-8", path = "/register")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void sell(@RequestBody SaleRequest saleRequest) {
        saleRegisterUseCase.register(saleRequest);
    }

}
