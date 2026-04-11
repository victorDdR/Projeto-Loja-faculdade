package com.trabalho.faculdade.impacta.presentation.controllers;

import com.trabalho.faculdade.impacta.domain.service.CategoryService;
import com.trabalho.faculdade.impacta.presentation.dtos.CategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping(produces = "application/json; charset=utf-8")
    @ResponseStatus(code = HttpStatus.OK)
    public List<CategoryDTO> findAll() {
        return categoryService.getCategories();
    }

}
