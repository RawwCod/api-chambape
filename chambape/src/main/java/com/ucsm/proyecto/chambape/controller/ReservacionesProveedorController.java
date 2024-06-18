package com.ucsm.proyecto.chambape.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ucsm.proyecto.chambape.model.SolicitudServicio;
import com.ucsm.proyecto.chambape.service.SolicitudServicioService;

@RestController
@RequestMapping(path = "reservacionesproveedor")
public class ReservacionesProveedorController {
    
    @Autowired
    private SolicitudServicioService solicitudServicioService;
    
    @GetMapping(path="{id}")
    public ArrayList<SolicitudServicio> getReservacionesProveedor(@PathVariable Integer id){
        return solicitudServicioService.getSolicitudServicioByUsuario(id);
    }
}
