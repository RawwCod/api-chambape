package com.ucsm.proyecto.chambape.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ucsm.proyecto.chambape.dto.InformacionPagoDto;
import com.ucsm.proyecto.chambape.dto.MetodoCobroDto;
import com.ucsm.proyecto.chambape.dto.ResponsePagoDto;
import com.ucsm.proyecto.chambape.model.MetodoCobro;
import com.ucsm.proyecto.chambape.model.Usuario;
import com.ucsm.proyecto.chambape.repository.UsuarioRepository;
import com.ucsm.proyecto.chambape.service.MetodoCobroService;
import com.ucsm.proyecto.chambape.service.PagoService;
import com.ucsm.proyecto.chambape.service.UsuarioService;

@RestController
@RequestMapping(path = "/api/pagos")
public class PagosController {
    @Autowired
    private PagoService pagoService;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private MetodoCobroService metodoCobroService;
    
    @GetMapping(path = "{id}")
    public ArrayList<ResponsePagoDto> getPagosByUsuario(@PathVariable Integer id){
        return pagoService.getPagosByUsuario(id);
    }

    @PostMapping
    public boolean updatePago(@RequestBody InformacionPagoDto informacionPagoDto){
        Usuario usuario=usuarioRepository.findById(informacionPagoDto.idUsuario()).get();
        usuario.setNumCuenta(informacionPagoDto.numCuenta());
        return usuarioRepository.save(usuario)!=null;
    }

    @PostMapping(path = "/metodoCobro")
    public void addMetodoCobro(@RequestBody MetodoCobroDto metodoCobroDto){
        metodoCobroService.saveMetodoCobro(metodoCobroDto);
    }

    @GetMapping(path = "/metodoCobro")
    public ArrayList<MetodoCobro> getAllMetodoCobro(){
        return metodoCobroService.getAllMetodoCobro();
    }
}
