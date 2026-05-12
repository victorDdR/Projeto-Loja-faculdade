package com.trabalho.faculdade.impacta.sale.infra;

import com.trabalho.faculdade.impacta.sale.domain.SaleItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleItemRepository extends JpaRepository<SaleItem, Long> {
}
