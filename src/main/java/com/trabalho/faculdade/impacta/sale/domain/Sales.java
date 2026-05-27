package com.trabalho.faculdade.impacta.sale.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface Sales {

    Sale save(Sale sale);
    Page<Sale> findAll(Pageable pageable);
    Sale findById(Long id);
}
