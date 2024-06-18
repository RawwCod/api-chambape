package com.ucsm.proyecto.chambape.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ucsm.proyecto.chambape.dto.NewUsuarioDto;
import com.ucsm.proyecto.chambape.model.Usuario;
import com.ucsm.proyecto.chambape.service.UsuarioService;

@RestController
@RequestMapping(path = "usuario")
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ArrayList<Usuario> getAllUsuarios(){
        return usuarioService.getAllUsuario();
    }

    @GetMapping(path = "{id}")
    public Optional<Usuario> getUsuario(@PathVariable Integer id){
        System.out.println("id: "+id);
        return usuarioService.getUsuario(id);
    }

    @PostMapping
    public void saveUsuario(@RequestBody NewUsuarioDto usuario){
        System.out.println("usuario: "+usuario);
        usuarioService.saveUsuario(usuario);
    }
}
