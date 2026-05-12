package com.trabalho.faculdade.impacta.product.infra;

import com.trabalho.faculdade.impacta.product.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByDeletedFalse();
    @Query("SELECT p FROM Product p WHERE p.deleted = false AND p.quantity > 0")
    List<Product> findAvailableProducts();
}
