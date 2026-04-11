package com.trabalho.faculdade.impacta.infra.repository;

import com.trabalho.faculdade.impacta.domain.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByDeletedFalse();
}
