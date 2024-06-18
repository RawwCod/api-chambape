package com.ucsm.proyecto.chambape.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ucsm.proyecto.chambape.dto.DistritoDto;
import com.ucsm.proyecto.chambape.model.Distrito;
import com.ucsm.proyecto.chambape.service.DistritoService;

@RestController
@RequestMapping(path = "distrito")
public class DistritoController {
    
    @Autowired
    private DistritoService distritoService;

    @PostMapping
    public void addDistrito(@RequestBody DistritoDto distritoDto){
        distritoService.saveDistrito(distritoDto);
    }

    @GetMapping
    public ArrayList<Distrito> getAllDistrito(){
        return distritoService.getAllDistrito();
    }

    @GetMapping(path = "{id}")
    public Distrito getDistrito(@PathVariable Integer id){
        return distritoService.getDistrito(id);
    }
}
