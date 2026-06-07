package com.trabalho.faculdade.impacta.product.app;

import com.trabalho.faculdade.impacta.product.domain.CategoryDomainService;
import com.trabalho.faculdade.impacta.product.presentation.dtos.CategoryDTO;
import com.trabalho.faculdade.impacta.util.PageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    private final CategoryDomainService categoryDomainService;

    @Autowired
    CategoryService(CategoryDomainService categoryDomainService) {
        this.categoryDomainService = categoryDomainService;
    }

    public PageResponse<CategoryDTO> findAll(Pageable pageable) {
        Page<CategoryDTO> page = categoryDomainService.findAll(pageable).map(CategoryDTO::new);
        return new PageResponse<>(page);
    }

}
