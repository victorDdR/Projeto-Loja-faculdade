package com.trabalho.faculdade.impacta.domain.costumer;

interface Costumers {

    Costumer findById(Long id);
    Costumer findByEmail(String email);
    void save(Costumer costumer);
}
