package com.trabalho.faculdade.impacta.domain.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "products")
public class Product {

    @Id @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    @Column(nullable = false, name = "productName")
    private String name;

    @Column(nullable = false, name = "price")
    private BigDecimal price;

    @Column(nullable = false, name = "stock")
    private int stock;

    @Column(nullable = false, name = "deleted")
    private boolean deleted;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @Deprecated
    Product(){}

    public Product(String name, BigDecimal price, int stock, Category category) {
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.category = category;
    }


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

    public Category getCategory() {
        return category;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void delete() {
        this.deleted = true;
        this.stock = 0;
    }

}
