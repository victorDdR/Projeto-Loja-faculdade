package com.trabalho.faculdade.impacta.presentation.controllers;

import com.trabalho.faculdade.impacta.application.CreateProductUseCase;
import com.trabalho.faculdade.impacta.domain.service.ProductService;
import com.trabalho.faculdade.impacta.presentation.dtos.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/products")
public class ProductController {

    private final ProductService productService;
    private final CreateProductUseCase createProductUseCase;

    @Autowired
    ProductController(ProductService productService, CreateProductUseCase createProductUseCase) {
        this.productService = productService;
        this.createProductUseCase = createProductUseCase;
    }

    @GetMapping(produces = "application/json; charset=utf-8")
    @ResponseStatus(code = HttpStatus.OK)
    public List<ProductDTO> findAll() {
        return productService.findAll();
    }

    @PostMapping(consumes = "application/json; charset=utf-8", path = "/new")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductDTO productDTO) {
        createProductUseCase.createProduct(productDTO);
    }
    
}
