package com.ucsm.proyecto.chambape.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ucsm.proyecto.chambape.model.DetalleSesion;

@Repository
public interface DetalleSesionRepository extends JpaRepository<DetalleSesion, Integer>{
    DetalleSesion findByNombreUsuarioAndContrasena(String nombreUsuario, String contrasena);
}
