package com.ucsm.proyecto.chambape.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ucsm.proyecto.chambape.dto.PasswordChangueDto;
import com.ucsm.proyecto.chambape.dto.SesionRequestDto;
import com.ucsm.proyecto.chambape.dto.SesionResponseDto;
import com.ucsm.proyecto.chambape.service.SesionService;

@RestController
@RequestMapping(path = "sesion")
public class SesionController {

    @Autowired
    private SesionService sesionService;

    @PostMapping
    public SesionResponseDto getUsuario(@RequestBody SesionRequestDto sesionRequestDto){
        return sesionService.getUsuario(sesionRequestDto);
    }

    @PutMapping
    public boolean updatePassword(@RequestBody PasswordChangueDto sesionRequestDto){
        return sesionService.updatePassword(sesionRequestDto);
    }
}
