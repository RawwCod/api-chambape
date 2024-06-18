package com.ucsm.proyecto.chambape.repository;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ucsm.proyecto.chambape.model.SolicitudServicio;

@Repository
public interface SolicitudServicioRepository extends JpaRepository<SolicitudServicio, Integer> {

    ArrayList<SolicitudServicio> findByClienteId(Integer idCliente);

    Collection<? extends SolicitudServicio> findByUsuarioServicioId(Integer id);
    
}
