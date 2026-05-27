package com.trabalho.faculdade.impacta.sale.infra;

import com.trabalho.faculdade.impacta.sale.domain.Sale;
import com.trabalho.faculdade.impacta.sale.domain.Sales;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
class SalesImpl implements Sales {

    private final SaleRepository saleRepository;

    @Autowired
    SalesImpl(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    @Override
    public Sale save(Sale sale) {
        return saleRepository.save(sale);
    }

    @Override
    public Page<Sale> findAll(Pageable pageable) {
        return saleRepository.findAll(pageable);
    }

    @Override
    public Sale findById(Long id) {
        return saleRepository.findById(id).orElse(null);
    }

}
