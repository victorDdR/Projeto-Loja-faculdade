package com.trabalho.faculdade.impacta.domain.costumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
class CostumersImpl implements Costumers {

    private final CostumerRepository costumerRepository;

    @Autowired
    CostumersImpl(CostumerRepository costumerRepository) {
        this.costumerRepository = costumerRepository;
    }

    @Override
    public Costumer findById(Long id) {
        Optional<Costumer> optionalCostumer = costumerRepository.findById(id);
        if (optionalCostumer.isEmpty()) {
            throw new RuntimeException();
        }

        return optionalCostumer.get();
    }

    @Override
    public Costumer findByEmail(String email) {
        Optional<Costumer> optionalCostumer = costumerRepository.findByEmail(email);
        if (optionalCostumer.isEmpty()) {
            throw new RuntimeException();
        }

        return optionalCostumer.get();
    }

    @Override
    public void save(Costumer costumer) {
        costumerRepository.save(costumer);
    }
}
