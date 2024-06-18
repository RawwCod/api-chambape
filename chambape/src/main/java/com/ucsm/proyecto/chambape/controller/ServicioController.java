package com.ucsm.proyecto.chambape.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ucsm.proyecto.chambape.dto.ServicioDto;
import com.ucsm.proyecto.chambape.model.Servicio;
import com.ucsm.proyecto.chambape.service.ServicioService;

@RestController
@RequestMapping(path = "servicio")
public class ServicioController {
    
    @Autowired
    private ServicioService servicioService;

    @GetMapping
    public ArrayList<Servicio> getAllServicios(){
        return servicioService.getAllServicio();
    }

    @GetMapping(path = "{id}")
    public Servicio getServiciosProveedor(@PathVariable Integer id){
        return servicioService.getServicio(id);
    }

    @PostMapping
    public void addServicio(@RequestBody ServicioDto servicioDto){
        servicioService.saveServicio(servicioDto);
    }

}
