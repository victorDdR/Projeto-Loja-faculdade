package com.trabalho.faculdade.impacta.product.infra;

import com.trabalho.faculdade.impacta.product.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    List<Category> findByDeletedFalse();
}
