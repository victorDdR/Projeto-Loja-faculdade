package com.trabalho.faculdade.impacta.sale.domain;

import org.springframework.beans.factory.annotation.Autowired;
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

}
