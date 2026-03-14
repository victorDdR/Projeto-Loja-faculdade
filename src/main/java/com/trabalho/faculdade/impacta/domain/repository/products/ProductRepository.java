package com.trabalho.faculdade.impacta.domain.repository.products;

import com.trabalho.faculdade.impacta.domain.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

interface ProductRepository extends JpaRepository<Product, Long> {
}
