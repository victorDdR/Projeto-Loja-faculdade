package com.trabalho.faculdade.impacta.product.app;

import com.trabalho.faculdade.impacta.product.domain.Category;
import com.trabalho.faculdade.impacta.product.domain.CategoryDomainService;
import com.trabalho.faculdade.impacta.product.domain.Product;
import com.trabalho.faculdade.impacta.product.domain.ProductDomainService;
import com.trabalho.faculdade.impacta.product.presentation.dtos.CategoryDTO;
import com.trabalho.faculdade.impacta.product.presentation.dtos.ProductResponse;
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

    public PageResponse<ProductResponse> findAll(Pageable pageable) {
        Page<ProductResponse> page = productDomainService.findAll(pageable).map(this::toDTO);
        return new PageResponse<>(page.getContent(), page.getNumber(), page.getSize(), page.getTotalElements(),
                page.getTotalPages(), page.isLast(), page.isFirst());
    }

    public PageResponse<ProductResponse> findAllAvailable(Pageable pageable) {
        Page<ProductResponse> page = productDomainService.findAllAvailable(pageable).map(this::toDTO);
        return new PageResponse<>(page.getContent(), page.getNumber(), page.getSize(), page.getTotalElements(),
                page.getTotalPages(), page.isLast(), page.isFirst());
    }

    public void createProduct(ProductResponse productResponse) {
        Category category = getCategory(productResponse.category());
        productDomainService.save(new Product(productResponse.productName(), productResponse.price(), productResponse.stock(), category));
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

    private ProductResponse toDTO(Product product) {
        Category category = product.getCategory();
        return new ProductResponse(product.getId(), product.getName(), product.getPrice(), product.getQuantity(),
                new CategoryDTO(category.getId(), category.getName()));
    }

}
