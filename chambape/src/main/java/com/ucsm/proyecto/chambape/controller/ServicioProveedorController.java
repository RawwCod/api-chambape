package com.ucsm.proyecto.chambape.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ucsm.proyecto.chambape.dto.UsuarioServicioDto;
import com.ucsm.proyecto.chambape.model.UsuarioServicio;
import com.ucsm.proyecto.chambape.service.UsuarioServicioService;

@RestController
@RequestMapping(path = "servicioproveedor")
public class ServicioProveedorController {
    
    @Autowired
    private UsuarioServicioService usuarioServicioService;

    @PostMapping
    public void addServicioProveedor(@RequestBody UsuarioServicioDto usuarioServicioDto){
        usuarioServicioService.saveUsuarioServicio(usuarioServicioDto);
    }
}
