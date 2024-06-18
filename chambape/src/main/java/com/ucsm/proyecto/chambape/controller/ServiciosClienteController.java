package com.ucsm.proyecto.chambape.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ucsm.proyecto.chambape.model.UsuarioServicio;
import com.ucsm.proyecto.chambape.service.UsuarioServicioService;

@RestController
@RequestMapping(path = "servicioscliente")
public class ServiciosClienteController {

    @Autowired
    private UsuarioServicioService usuarioServicioService;
    
    @GetMapping
    public ArrayList<UsuarioServicio> getServiciosForCliente(){
        return usuarioServicioService.getAllUsuarioServicio();
    }

}
