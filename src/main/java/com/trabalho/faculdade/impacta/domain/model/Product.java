package com.trabalho.faculdade.impacta.domain.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity(name = "product")
@Table(name = "products")
public class Product {

    @Id @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    @Column(nullable = false, name = "product_name")
    private String name;

    @Column(nullable = false, name = "price")
    private BigDecimal price;

    @Column(nullable = false, name = "stock")
    private int stock;

    @Column(nullable = false, name = "deleted")
    private boolean deleted;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }
}
