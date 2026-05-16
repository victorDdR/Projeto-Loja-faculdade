package com.trabalho.faculdade.impacta.product.infra;

import com.trabalho.faculdade.impacta.product.domain.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

interface ProductRepository extends JpaRepository<Product, Long> {

    Page<Product> findByDeletedFalse(Pageable pageable);

    @Query("SELECT p FROM Product p WHERE p.deleted = false AND p.quantity > 0")
    Page<Product> findAvailableProducts(Pageable pageable);

}
