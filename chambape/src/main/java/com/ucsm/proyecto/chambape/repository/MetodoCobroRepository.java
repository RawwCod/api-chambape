package com.ucsm.proyecto.chambape.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ucsm.proyecto.chambape.model.MetodoCobro;

@Repository
public interface MetodoCobroRepository extends JpaRepository<MetodoCobro, Integer>{
    
}
