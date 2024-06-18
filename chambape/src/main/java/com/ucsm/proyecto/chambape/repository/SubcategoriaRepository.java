package com.ucsm.proyecto.chambape.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ucsm.proyecto.chambape.model.Categoria;
import com.ucsm.proyecto.chambape.model.Subcategoria;

@Repository
public interface SubcategoriaRepository extends JpaRepository<Subcategoria, Integer> {

    Collection<? extends Subcategoria> findByCategoria(Categoria categoria);
    
}
