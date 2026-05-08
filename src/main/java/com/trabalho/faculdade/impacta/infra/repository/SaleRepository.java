package com.trabalho.faculdade.impacta.infra.repository;

import com.trabalho.faculdade.impacta.domain.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale, Long> {
}
