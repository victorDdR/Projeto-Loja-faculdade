package com.trabalho.faculdade.impacta.sale.infra;

import com.trabalho.faculdade.impacta.sale.domain.SaleItem;
import com.trabalho.faculdade.impacta.sale.domain.SaleItems;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
class SaleItemsImpl implements SaleItems {

    private final SaleItemRepository saleItemRepository;

    @Autowired
    SaleItemsImpl(SaleItemRepository saleItemRepository) {
        this.saleItemRepository = saleItemRepository;
    }

    @Override
    public SaleItem save(SaleItem saleItem) {
        return saleItemRepository.save(saleItem);
    }
}
