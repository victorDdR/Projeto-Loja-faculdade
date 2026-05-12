package com.trabalho.faculdade.impacta.domain.repository;

import com.trabalho.faculdade.impacta.domain.model.Sale;

import java.util.List;

public interface Sales {

    Sale save(Sale sale);
    List<Sale> findAll();
    Sale findById(Long id);
}
