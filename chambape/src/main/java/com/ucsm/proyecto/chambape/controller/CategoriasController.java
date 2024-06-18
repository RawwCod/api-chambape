package com.ucsm.proyecto.chambape.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ucsm.proyecto.chambape.dto.CategoriaDto;
import com.ucsm.proyecto.chambape.model.Categoria;
import com.ucsm.proyecto.chambape.service.CategoriaService;

@RestController
@RequestMapping(path = "categoria")
public class CategoriasController {
    
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public ArrayList<Categoria> getAllCategorias(){
        return categoriaService.getAllCategoria();
    }

    @PostMapping
    public void addCategoria(@RequestBody CategoriaDto categoriaDto){
        categoriaService.saveCategoria(categoriaDto);
    }

    @GetMapping(path = "{id}")
    public Categoria getCategoriaById(@PathVariable Integer id){
        return categoriaService.getCategoria(id);
    }
}
