package com.ucsm.proyecto.chambape.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ucsm.proyecto.chambape.dto.DepartamentoDto;
import com.ucsm.proyecto.chambape.model.DepartamentoCober;
import com.ucsm.proyecto.chambape.service.DepartamentoService;

@RestController
@RequestMapping(path = "departamento")
public class DepartamentoController {
    
    @Autowired
    private DepartamentoService departamentoService;

    @PostMapping
    public void addDepartamento(@RequestBody DepartamentoDto departamentoDto){
        departamentoService.saveDepartamento(departamentoDto);
    }

    @GetMapping
    public ArrayList<DepartamentoCober> getAllDepartamento(){
        return departamentoService.getAllDepartamento();
    }

    @GetMapping(path = "{id}")
    public DepartamentoCober getDepartamento(Integer id){
        return departamentoService.getDepartamento(id);
    }
}
