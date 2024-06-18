package com.ucsm.proyecto.chambape.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ucsm.proyecto.chambape.dto.SubCategoriaDto;
import com.ucsm.proyecto.chambape.model.Subcategoria;
import com.ucsm.proyecto.chambape.service.SubCategoriaService;

@RestController
@RequestMapping(path = "subcategoria")
public class SubCategoriaController {
    
    @Autowired
    private SubCategoriaService subCategoriaService;

    @GetMapping
    public ArrayList<Subcategoria> getAllSubcategoria(){
        return subCategoriaService.getAllSubCategoria();
    }

    @GetMapping(path = "categoria/{id}")
    public ArrayList<Subcategoria> getSubcategoriaByCategoria(@PathVariable Integer id){
        return subCategoriaService.getSubCategoriaByCategoria(id);
    }

    @GetMapping(path = "{id}")
    public Subcategoria getSubcategoriaById(@PathVariable Integer id){
        return subCategoriaService.getSubCategoria(id);
    }

    @PostMapping
    public void saveSubcategoria(@RequestBody SubCategoriaDto subcategoraDto){
        subCategoriaService.saveSubCategoria(subcategoraDto);
    }
}
