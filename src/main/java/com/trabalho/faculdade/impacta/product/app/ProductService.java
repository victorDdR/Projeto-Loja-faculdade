package com.trabalho.faculdade.impacta.product.app;

import com.trabalho.faculdade.impacta.product.domain.Category;
import com.trabalho.faculdade.impacta.product.domain.CategoryDomainService;
import com.trabalho.faculdade.impacta.product.domain.Product;
import com.trabalho.faculdade.impacta.product.domain.ProductDomainService;
import com.trabalho.faculdade.impacta.product.presentation.dtos.CategoryDTO;
import com.trabalho.faculdade.impacta.product.presentation.dtos.ProductDTO;
import com.trabalho.faculdade.impacta.util.PageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductDomainService productDomainService;
    private final CategoryDomainService categoryDomainService;

    @Autowired
    ProductService(ProductDomainService productDomainService, CategoryDomainService categoryDomainService) {
        this.productDomainService = productDomainService;
        this.categoryDomainService = categoryDomainService;
    }

    public PageResponse<ProductDTO> findAll(Pageable pageable) {
        Page<ProductDTO> page = productDomainService.findAll(pageable).map(ProductDTO::new);
        return new PageResponse<>(page);
    }

    public PageResponse<ProductDTO> findAllAvailable(Pageable pageable) {
        Page<ProductDTO> page = productDomainService.findAllAvailable(pageable).map(ProductDTO::new);
        return new PageResponse<>(page);
    }

    public void create(ProductDTO productDTO) {
        Category category = getCategory(productDTO.category());
        productDomainService.save(new Product(productDTO.productName(), productDTO.price(), productDTO.stock(), category));
    }

    public void deleteById(Long productId) {
        productDomainService.deleteById(productId);
    }

    private Category getCategory(CategoryDTO categoryDTO) {
        if (categoryDTO.id() == null) {
            return categoryDomainService.save(new Category(categoryDTO.name()));
        }

        return categoryDomainService.findById(categoryDTO.id());
    }

}
