package com.trabalho.faculdade.impacta.product.presentation;

import com.trabalho.faculdade.impacta.product.app.CreateProductUseCase;
import com.trabalho.faculdade.impacta.product.domain.ProductDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/products")
public class ProductController {

    private final ProductDomainService productDomainService;
    private final CreateProductUseCase createProductUseCase;

    @Autowired
    ProductController(ProductDomainService productDomainService, CreateProductUseCase createProductUseCase) {
        this.productDomainService = productDomainService;
        this.createProductUseCase = createProductUseCase;
    }

    @GetMapping(produces = "application/json; charset=utf-8")
    @ResponseStatus(code = HttpStatus.OK)
    public List<ProductDTO> findAll() {
        return productDomainService.findAll();
    }

    @PostMapping(consumes = "application/json; charset=utf-8", path = "/new")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductDTO productDTO) {
        createProductUseCase.createProduct(productDTO);
    }

    @DeleteMapping(path = "/{productId}/delete")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable Long productId) {
        productDomainService.deleteById(productId);
    }

    @GetMapping(produces = "application/json; charset=utf-8", path = "/available")
    @ResponseStatus(code = HttpStatus.OK)
    public List<ProductDTO> findAllAvailable() {
        return productDomainService.findAllAvailable();
    }

}
