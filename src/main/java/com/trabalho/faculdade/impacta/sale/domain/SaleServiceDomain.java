package com.trabalho.faculdade.impacta.sale.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SaleServiceDomain {

    private final Sales sales;

    @Autowired
    SaleServiceDomain(Sales sales) {
        this.sales = sales;
    }

    public Sale save(Sale sale) {
        return sales.save(sale);
    }

    public Page<Sale> findAll(Pageable pageable) {
        return sales.findAll(pageable);
    }

}
