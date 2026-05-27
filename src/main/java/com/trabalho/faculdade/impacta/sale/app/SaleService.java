package com.trabalho.faculdade.impacta.sale.app;

import com.trabalho.faculdade.impacta.product.domain.Product;
import com.trabalho.faculdade.impacta.product.domain.ProductDomainService;
import com.trabalho.faculdade.impacta.sale.domain.Sale;
import com.trabalho.faculdade.impacta.sale.domain.SaleItem;
import com.trabalho.faculdade.impacta.sale.domain.SaleItemServiceDomain;
import com.trabalho.faculdade.impacta.sale.domain.SaleServiceDomain;
import com.trabalho.faculdade.impacta.sale.presentation.SaleItemRequest;
import com.trabalho.faculdade.impacta.sale.presentation.SaleRequest;
import com.trabalho.faculdade.impacta.sale.presentation.SaleResponse;
import com.trabalho.faculdade.impacta.util.PageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class SaleService {

    private final SaleServiceDomain saleServiceDomain;
    private final SaleItemServiceDomain saleItemServiceDomain;
    private final ProductDomainService productDomainService;

    @Autowired
    SaleService(SaleServiceDomain saleServiceDomain, SaleItemServiceDomain saleItemServiceDomain,
                ProductDomainService productDomainService) {
        this.saleServiceDomain = saleServiceDomain;
        this.saleItemServiceDomain = saleItemServiceDomain;
        this.productDomainService = productDomainService;
    }

    public PageResponse<SaleResponse> findAll(Pageable pageable) {
        Page<SaleResponse> page = saleServiceDomain.findAll(pageable).map(SaleResponse::new);
        return new PageResponse<>(page);
    }

    public void register(SaleRequest saleRequest) {
        BigDecimal saleTotal = totalPrice(saleRequest.items());
        Sale sale = saleServiceDomain.save(new Sale(saleTotal, LocalDateTime.now()));
        saleRequest.items().forEach(saleItemRequest -> registerSellItem(saleItemRequest, sale));
    }

    private void registerSellItem(SaleItemRequest saleItemRequest, Sale sale) {
        Product product = productDomainService.findById(saleItemRequest.productId());
        saleItemServiceDomain.save(
                new SaleItem(saleItemRequest.quantity(), saleItemRequest.productPrice(), saleItemRequest.getTotalPrice(), sale, product)
        );
        sellProduct(product, saleItemRequest.quantity());
    }

    private void sellProduct(Product product, int quantity) {
        product.sell(quantity);
        productDomainService.save(product);
    }

    private BigDecimal totalPrice(List<SaleItemRequest> items) {
        return items.stream().map(SaleItemRequest::getTotalPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
    }
    
}
