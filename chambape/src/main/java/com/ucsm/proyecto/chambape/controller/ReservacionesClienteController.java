package com.ucsm.proyecto.chambape.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ucsm.proyecto.chambape.model.SolicitudServicio;
import com.ucsm.proyecto.chambape.model.UsuarioServicio;
import com.ucsm.proyecto.chambape.service.SolicitudServicioService;
import com.ucsm.proyecto.chambape.service.UsuarioServicioService;

@RestController
@RequestMapping(path = "reservacionescliente")
public class ReservacionesClienteController {
    
    @Autowired
    private SolicitudServicioService solicitudServicioService;

    @Autowired
    private UsuarioServicioService usuarioServicioService;

    @GetMapping(path="{id}")
    public ArrayList<SolicitudServicio> getReservacionesCliente(@PathVariable Integer id){
        return solicitudServicioService.getSolicitudServicioByCliente(id);
    }

    @GetMapping
    public ArrayList<UsuarioServicio> getAllUsuarioServicio(){
        return usuarioServicioService.getAllUsuarioServicio();
    }
}
