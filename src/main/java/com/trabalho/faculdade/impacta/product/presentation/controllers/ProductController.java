package com.trabalho.faculdade.impacta.product.presentation.controllers;

import com.trabalho.faculdade.impacta.product.app.ProductService;
import com.trabalho.faculdade.impacta.product.presentation.dtos.ProductDTO;
import com.trabalho.faculdade.impacta.util.PageResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public PageResponse<ProductDTO> findAll(Pageable pageable) {
        return productService.findAll(pageable);
    }

    @GetMapping( path = "/available")
    public PageResponse<ProductDTO>findAllAvailable(Pageable pageable) {
        return productService.findAllAvailable(pageable);
    }

    @PostMapping(consumes = "application/json; charset=utf-8", path = "/new")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void create(@RequestBody @Valid ProductDTO productDTO) {
        productService.create(productDTO);
    }

    @DeleteMapping(path = "/{productId}/delete")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long productId) {
        productService.deleteById(productId);
    }

}
