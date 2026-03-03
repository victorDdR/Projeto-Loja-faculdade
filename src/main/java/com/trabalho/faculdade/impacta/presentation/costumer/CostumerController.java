package com.trabalho.faculdade.impacta.presentation.costumer;

import com.trabalho.faculdade.impacta.domain.costumer.CostumerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/costumer")
public class CostumerController {

    private final CostumerService costumerService;

    @Autowired
    CostumerController(CostumerService costumerService) {
        this.costumerService = costumerService;
    }

    @PostMapping(produces = "application/json; charset=utf-8")
    @ResponseStatus(HttpStatus.CREATED)
    public void createCostumer(@RequestBody @Valid CostumerDTO costumerDTO){
        costumerService.save(costumerDTO);
    }
}
