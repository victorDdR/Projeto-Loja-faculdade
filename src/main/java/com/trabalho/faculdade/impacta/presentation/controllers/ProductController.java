package com.trabalho.faculdade.impacta.presentation.controllers;

import com.trabalho.faculdade.impacta.domain.service.ProductService;
import com.trabalho.faculdade.impacta.presentation.dtos.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(produces = "application/json; charset=utf-8")
    @ResponseStatus(code = HttpStatus.OK)
    public List<ProductDTO> findAll() {
        return productService.findAll();
    }

}
