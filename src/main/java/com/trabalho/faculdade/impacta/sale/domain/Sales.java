package com.trabalho.faculdade.impacta.sale.domain;

import java.util.List;

public interface Sales {

    Sale save(Sale sale);
    List<Sale> findAll();
    Sale findById(Long id);
}
