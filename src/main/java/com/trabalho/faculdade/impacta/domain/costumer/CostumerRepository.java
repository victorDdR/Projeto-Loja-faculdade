package com.trabalho.faculdade.impacta.domain.costumer;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

interface CostumerRepository extends JpaRepository<Costumer, Long> {

    Optional<Costumer> findByEmail(String email);
}
