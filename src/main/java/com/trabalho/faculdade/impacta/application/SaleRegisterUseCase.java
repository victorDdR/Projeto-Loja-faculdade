package com.trabalho.faculdade.impacta.application;

import com.trabalho.faculdade.impacta.domain.model.Product;
import com.trabalho.faculdade.impacta.domain.model.Sale;
import com.trabalho.faculdade.impacta.domain.model.SaleItem;
import com.trabalho.faculdade.impacta.domain.service.ProductService;
import com.trabalho.faculdade.impacta.domain.service.SaleItemService;
import com.trabalho.faculdade.impacta.domain.service.SaleService;
import com.trabalho.faculdade.impacta.presentation.dtos.ProductDTO;
import com.trabalho.faculdade.impacta.presentation.dtos.SaleItemDTO;
import com.trabalho.faculdade.impacta.presentation.dtos.SaleRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class SaleRegisterUseCase {

    private final SaleService saleService;
    private final SaleItemService saleItemService;
    private final ProductService productService;

    @Autowired
    SaleRegisterUseCase(SaleService saleService, SaleItemService saleItemService, ProductService productService) {
        this.saleService = saleService;
        this.saleItemService = saleItemService;
        this.productService = productService;
    }

    public void register(SaleRequest saleRequest) {
        BigDecimal saleTotal = totalPrice(saleRequest.items());
        Sale sale = saleService.save(new Sale(saleTotal, LocalDateTime.now()));
        saleRequest.items().forEach(saleItemDTO -> registerSellItem(saleItemDTO, sale));
    }

    private void registerSellItem(SaleItemDTO saleItemDTO, Sale sale) {
        ProductDTO productDTO = saleItemDTO.productDTO();
        Product product = productService.findById(productDTO.id());
        sellProduct(product, saleItemDTO.quantity());
        saleItemService.save(
                new SaleItem(saleItemDTO.quantity(), productDTO.price(), saleItemDTO.getTotalPrice(), sale, product)
        );
    }

    private void sellProduct(Product product, int quantity) {
        product.sell(quantity);
        productService.save(product);
    }

    private BigDecimal totalPrice(List<SaleItemDTO> items) {
        return items.stream().map(SaleItemDTO::getTotalPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
    }
    
}
