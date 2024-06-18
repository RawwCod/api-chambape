package com.ucsm.proyecto.chambape.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ucsm.proyecto.chambape.model.UsuarioServicio;

@Repository
public interface UsuarioServicioRepository extends JpaRepository<UsuarioServicio, Integer>{

    ArrayList<UsuarioServicio> findByUsuarioId(Integer idUsuario);

    ArrayList<UsuarioServicio> findByServicioId(Integer idServicio);
    
}
