package com.trabalho.faculdade.impacta.domain.model;

import jakarta.persistence.*;

@Entity
@Table(name = "categories")
public class Category {

    @Id @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long id;

    @Column(nullable = false, name = "category_name")
    private String name;

    @Column(nullable = false, name = "deleted")
    private boolean deleted;

    @Deprecated
    public Category(){}

    public Category(Long id, String name, boolean deleted) {
        this.id = id;
        this.name = name;
        this.deleted = deleted;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isDeleted() {
        return deleted;
    }

}
