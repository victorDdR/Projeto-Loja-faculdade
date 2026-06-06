package com.trabalho.faculdade.impacta.product.presentation.controllers;

import com.trabalho.faculdade.impacta.product.app.CategoryService;
import com.trabalho.faculdade.impacta.product.presentation.dtos.CategoryDTO;
import com.trabalho.faculdade.impacta.util.PageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public PageResponse<CategoryDTO> findAll(Pageable pageable) {
        return categoryService.findAll(pageable);
    }

}
