package com.ucsm.proyecto.chambape.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ucsm.proyecto.chambape.dto.UsuarioServicioDto;
import com.ucsm.proyecto.chambape.model.Servicio;
import com.ucsm.proyecto.chambape.model.Usuario;
import com.ucsm.proyecto.chambape.model.UsuarioServicio;
import com.ucsm.proyecto.chambape.repository.ServicioRepository;
import com.ucsm.proyecto.chambape.repository.UsuarioRepository;
import com.ucsm.proyecto.chambape.repository.UsuarioServicioRepository;

@Service
public class UsuarioServicioService {
    
    @Autowired
    private UsuarioServicioRepository usuarioServicioRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private ServicioRepository servicioRepository;

    public void saveUsuarioServicio(UsuarioServicioDto usuarioServicioDto){
        Usuario usuario=usuarioRepository.findById(usuarioServicioDto.idUsuario()).get();
        System.out.println(usuario);
        Servicio servicio=servicioRepository.findById(usuarioServicioDto.idServicio()).get();
        System.out.println(servicio);
        UsuarioServicio usuarioServicio=new UsuarioServicio();
        usuarioServicio.setUsuario(usuario);
        usuarioServicio.setServicio(servicio);
        usuarioServicioRepository.save(usuarioServicio);
    }

    public UsuarioServicio getUsuarioServicio(Integer id){
        UsuarioServicio usuarioServicio=usuarioServicioRepository.findById(id).get();
        if(usuarioServicio==null){
            return null;
        }
        return usuarioServicio;
    }

    public void deleteUsuarioServicio(Integer id){
        UsuarioServicio usuarioServicio=usuarioServicioRepository.findById(id).get();
        usuarioServicioRepository.delete(usuarioServicio);
    }

    public ArrayList<Servicio> getServicioByUsuario(Integer idUsuario){
        //falta validar que el metodo se genere correctamete
        ArrayList<UsuarioServicio> usuarioServicios=usuarioServicioRepository.findByUsuarioId(idUsuario);
        ArrayList<Servicio> servicios=new ArrayList<Servicio>();
        for(UsuarioServicio usuarioServicio:usuarioServicios){
            servicios.add(usuarioServicio.getServicio());
        }
        return servicios;
    }
    
    public ArrayList<Usuario> getUsuarioByServicio(Integer idServicio){
        //falta validar que el metodo se genere correctamete
        ArrayList<UsuarioServicio> usuarioServicios=usuarioServicioRepository.findByServicioId(idServicio);
        ArrayList<Usuario> usuarios=new ArrayList<Usuario>();
        for(UsuarioServicio usuarioServicio:usuarioServicios){
            usuarios.add(usuarioServicio.getUsuario());
        }
        return usuarios;
    }

    public ArrayList<UsuarioServicio> getUsuarioServicioByUsuario(Integer idUsuario){
        //falta validar que el metodo se genere correctamete
        ArrayList<UsuarioServicio> usuarioServicios=usuarioServicioRepository.findByUsuarioId(idUsuario);
        return usuarioServicios;
    }

    public ArrayList<UsuarioServicio> getAllUsuarioServicio(){
        ArrayList<UsuarioServicio> usuarioServicios=new ArrayList<UsuarioServicio>(usuarioServicioRepository.findAll());
        return usuarioServicios;
    }

    public ArrayList<Integer> getIdsServiciosByUsuario(Integer id){
        ArrayList<UsuarioServicio> usuarioServicios=usuarioServicioRepository.findByUsuarioId(id);
        ArrayList<Integer> ids=new ArrayList<Integer>();
        for(UsuarioServicio usuarioServicio:usuarioServicios){
            ids.add(usuarioServicio.getServicio().getId());
        }
        return ids;
    }
}
