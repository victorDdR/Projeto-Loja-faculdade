package com.trabalho.faculdade.impacta.product.presentation;

import com.trabalho.faculdade.impacta.product.domain.CategoryDomainService;
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

    private final CategoryDomainService categoryDomainService;

    @Autowired
    CategoryController(CategoryDomainService categoryDomainService) {
        this.categoryDomainService = categoryDomainService;
    }

    @GetMapping(produces = "application/json; charset=utf-8")
    @ResponseStatus(code = HttpStatus.OK)
    public List<CategoryDTO> findAll() {
        return categoryDomainService.findAll();
    }

}
