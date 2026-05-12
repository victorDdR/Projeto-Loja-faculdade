package com.trabalho.faculdade.impacta.domain.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "sale_items")
public class SaleItem {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long id;

    @Column(nullable = false, name = "quantity")
    private int quantity;

    @Column(nullable = false, name = "unit_price")
    private BigDecimal unitPrice;

    @Column(nullable = false, name = "total_price")
    private BigDecimal totalPrice;

    @ManyToOne
    @JoinColumn(name = "sale_id", nullable = false)
    private Sale sale;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Deprecated
    SaleItem(){}

    public SaleItem(int quantity, BigDecimal unitPrice, BigDecimal totalPrice, Sale sale, Product product) {
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.totalPrice = totalPrice;
        this.sale = sale;
        this.product = product;
    }

}
