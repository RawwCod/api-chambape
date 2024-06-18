package com.ucsm.proyecto.chambape.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ucsm.proyecto.chambape.model.Pago;
import com.ucsm.proyecto.chambape.model.SolicitudServicio;

@Repository
public interface PagoRepository extends JpaRepository<Pago, Integer>{
    Pago findBySolicitudServicio(SolicitudServicio solicitudServicio);
    
}