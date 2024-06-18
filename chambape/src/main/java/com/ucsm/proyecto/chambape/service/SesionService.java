package com.ucsm.proyecto.chambape.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ucsm.proyecto.chambape.dto.PasswordChangueDto;
import com.ucsm.proyecto.chambape.dto.SesionRequestDto;
import com.ucsm.proyecto.chambape.dto.SesionResponseDto;
import com.ucsm.proyecto.chambape.model.DetalleSesion;
import com.ucsm.proyecto.chambape.model.Tipo;
import com.ucsm.proyecto.chambape.model.Usuario;
import com.ucsm.proyecto.chambape.repository.DetalleSesionRepository;
import com.ucsm.proyecto.chambape.repository.UsuarioRepository;

@Service
public class SesionService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private DetalleSesionRepository detalleSesionRepository;
    
    public SesionResponseDto getUsuario(SesionRequestDto sesionRequestDto){
        String correo=sesionRequestDto.correo();
        String contraseña=sesionRequestDto.contrasena();
        if(correo=="ADMIN" && contraseña=="ADMIN"){
            SesionResponseDto sesionResponseDto=new SesionResponseDto(0, Tipo.Administrador);
            return sesionResponseDto;
        }
        DetalleSesion detalleSesion=detalleSesionRepository.findByNombreUsuarioAndContrasena(sesionRequestDto.correo(), sesionRequestDto.contrasena());
        if(detalleSesion==null){
            return null;
        }
        Usuario usuario=detalleSesion.getUsuario();
        SesionResponseDto sesionResponseDto=new SesionResponseDto(usuario.getId(), usuario.getTipo());
        return sesionResponseDto;
        //Usuario usuario= usuarioRepository
    }
    
    public void saveUsuario(String correo, String contraseña, Integer idUsuario){
        DetalleSesion detalleSesion=new DetalleSesion();
        Usuario usuario=usuarioRepository.findById(idUsuario).get();
        detalleSesion.setNombreUsuario(correo);
        detalleSesion.setContrasena(contraseña);
        detalleSesion.setUsuario(usuario);
        detalleSesionRepository.save(detalleSesion);
    }

    public boolean updatePassword(PasswordChangueDto passwordChangueDto){
        DetalleSesion detalleSesion=detalleSesionRepository.findByNombreUsuarioAndContrasena(passwordChangueDto.correo(), passwordChangueDto.password_old());
        if(detalleSesion==null){
            return false;
        }
        detalleSesion.setContrasena(passwordChangueDto.password_new());
        detalleSesionRepository.save(detalleSesion);
        return true;
    }
}
