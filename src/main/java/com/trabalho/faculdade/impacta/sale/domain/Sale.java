package com.trabalho.faculdade.impacta.sale.domain;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "sales")
public class Sale {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long id;

    @Column(nullable = false, name = "sale_date")
    private LocalDateTime saleDate;

    @Column(nullable = false, name = "total")
    private BigDecimal total;

    @OneToMany(mappedBy = "sale", fetch = FetchType.LAZY)
    private List<SaleItem> items;

    @Deprecated
    Sale(){}

    public Sale(BigDecimal total, LocalDateTime saleDate) {
        this.total = total;
        this.saleDate = saleDate;
    }

    public Long getId() {
        return id;
    }

}
