package com.trabalho.faculdade.impacta.application;

import com.trabalho.faculdade.impacta.domain.model.Product;
import com.trabalho.faculdade.impacta.domain.model.Sale;
import com.trabalho.faculdade.impacta.domain.model.SaleItem;
import com.trabalho.faculdade.impacta.domain.service.ProductService;
import com.trabalho.faculdade.impacta.domain.service.SaleItemService;
import com.trabalho.faculdade.impacta.domain.service.SaleService;
import com.trabalho.faculdade.impacta.presentation.dtos.SaleItemDTO;
import com.trabalho.faculdade.impacta.presentation.dtos.SaleRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseRecordUseCase {

    private final SaleService saleService;
    private final SaleItemService saleItemService;
    private final ProductService productService;

    @Autowired
    PurchaseRecordUseCase(SaleService saleService, SaleItemService saleItemService, ProductService productService) {
        this.saleService = saleService;
        this.saleItemService = saleItemService;
        this.productService = productService;
    }

    public void purchase(SaleRequest saleRequest) {
        Sale sale = saleService.save(new Sale(saleRequest.total()));

        List<SaleItemDTO> items = saleRequest.items();
        items.forEach(item -> {
            Product product = productService.findById(item.productDTO().id());
            sellProduct(product, item.quantity());
            saleItemService.save(new SaleItem(item.quantity(), item.unitPrice(), item.totalPrice(), sale, product));
        });
    }

    private void sellProduct(Product product, int quantity) {
        product.sell(quantity);
        productService.save(product);
    }
    
}
