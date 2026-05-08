package com.trabalho.faculdade.impacta.domain.service;

import com.trabalho.faculdade.impacta.domain.model.Sale;
import com.trabalho.faculdade.impacta.domain.repository.Sales;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleService {

    private final Sales sales;

    @Autowired
    SaleService(Sales sales) {
        this.sales = sales;
    }

    public void save(Sale sale) {
        sales.save(sale);
    }

}
