package com.ucsm.proyecto.chambape.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ucsm.proyecto.chambape.dto.NewUsuarioDto;
import com.ucsm.proyecto.chambape.model.DetalleSesion;
import com.ucsm.proyecto.chambape.model.Estado;
import com.ucsm.proyecto.chambape.model.Usuario;
import com.ucsm.proyecto.chambape.repository.DetalleSesionRepository;
import com.ucsm.proyecto.chambape.repository.UsuarioRepository;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private SesionService sesionService;

    public ArrayList<Usuario> getAllUsuario(){
        ArrayList<Usuario> usuarios=new ArrayList<Usuario>(usuarioRepository.findAll());
        return usuarios;
    }

    public Optional<Usuario> getUsuario(Integer id){
        return usuarioRepository.findById(id);
    }

    public void saveUsuario(NewUsuarioDto newusuario){
        Usuario usuario=new Usuario();
        usuario.setNombre(newusuario.nombre());
        usuario.setApellido(newusuario.apellido());
        usuario.setCorreo(newusuario.correo());
        usuario.setTelefono(newusuario.telefono());
        usuario.setTipo(newusuario.tipo());
        usuario.setDireccion(newusuario.direccion());
        usuario.setEstado(Estado.Activo);
        usuario=usuarioRepository.save(usuario);
        System.out.println("usuario: "+usuario);
        sesionService.saveUsuario(newusuario.correo(), newusuario.contrasena(), usuario.getId());
    }
}
