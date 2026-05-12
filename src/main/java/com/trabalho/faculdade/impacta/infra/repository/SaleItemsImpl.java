package com.trabalho.faculdade.impacta.infra.repository;

import com.trabalho.faculdade.impacta.domain.model.SaleItem;
import com.trabalho.faculdade.impacta.domain.repository.SaleItems;
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
