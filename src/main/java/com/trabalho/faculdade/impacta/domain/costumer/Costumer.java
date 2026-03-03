package com.trabalho.faculdade.impacta.domain.costumer;

import jakarta.persistence.*;

@Entity(name = "usuario")
@Table(name = "usuarios")
public class Costumer {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long id;

    @Column(nullable = false, name = "nome")
    private String name;

    @Column(nullable = false, name = "email")
    private String email;

    @Deprecated
    Costumer(){};

    Costumer(String name, String email){
        this.name = name;
        this.email = email;
    }
}
