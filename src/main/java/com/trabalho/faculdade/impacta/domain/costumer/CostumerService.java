package com.trabalho.faculdade.impacta.domain.costumer;

import com.trabalho.faculdade.impacta.presentation.costumer.CostumerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CostumerService {

    private final Costumers costumers;

    @Autowired
    CostumerService(Costumers costumers) {
        this.costumers = costumers;
    }

    public void save(CostumerDTO costumerDTO) {
        Costumer costumer = new Costumer(costumerDTO.name(), costumerDTO.email());
        costumers.save(costumer);
    }
}
