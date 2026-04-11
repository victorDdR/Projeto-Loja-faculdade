package com.trabalho.faculdade.impacta.infra.repository;

import com.trabalho.faculdade.impacta.domain.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    List<Category> findByDeletedFalse();
}
