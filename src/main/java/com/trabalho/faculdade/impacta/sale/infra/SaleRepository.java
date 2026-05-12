package com.trabalho.faculdade.impacta.sale.infra;

import com.trabalho.faculdade.impacta.sale.domain.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale, Long> {
}
