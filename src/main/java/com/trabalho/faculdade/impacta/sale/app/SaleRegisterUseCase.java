package com.trabalho.faculdade.impacta.sale.app;

import com.trabalho.faculdade.impacta.product.domain.Product;
import com.trabalho.faculdade.impacta.sale.domain.Sale;
import com.trabalho.faculdade.impacta.sale.domain.SaleItem;
import com.trabalho.faculdade.impacta.product.domain.ProductDomainService;
import com.trabalho.faculdade.impacta.sale.domain.SaleItemService;
import com.trabalho.faculdade.impacta.sale.domain.SaleService;
import com.trabalho.faculdade.impacta.product.presentation.dtos.ProductDTO;
import com.trabalho.faculdade.impacta.sale.presentation.SaleItemDTO;
import com.trabalho.faculdade.impacta.sale.presentation.SaleRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class SaleRegisterUseCase {

    private final SaleService saleService;
    private final SaleItemService saleItemService;
    private final ProductDomainService productDomainService;

    @Autowired
    SaleRegisterUseCase(SaleService saleService, SaleItemService saleItemService, ProductDomainService productDomainService) {
        this.saleService = saleService;
        this.saleItemService = saleItemService;
        this.productDomainService = productDomainService;
    }

    public void register(SaleRequest saleRequest) {
        BigDecimal saleTotal = totalPrice(saleRequest.items());
        Sale sale = saleService.save(new Sale(saleTotal, LocalDateTime.now()));
        saleRequest.items().forEach(saleItemDTO -> registerSellItem(saleItemDTO, sale));
    }

    private void registerSellItem(SaleItemDTO saleItemDTO, Sale sale) {
        ProductDTO productDTO = saleItemDTO.productDTO();
        Product product = productDomainService.findById(productDTO.id());
        sellProduct(product, saleItemDTO.quantity());
        saleItemService.save(
                new SaleItem(saleItemDTO.quantity(), productDTO.price(), saleItemDTO.getTotalPrice(), sale, product)
        );
    }

    private void sellProduct(Product product, int quantity) {
        product.sell(quantity);
        productDomainService.save(product);
    }

    private BigDecimal totalPrice(List<SaleItemDTO> items) {
        return items.stream().map(SaleItemDTO::getTotalPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
    }
    
}
