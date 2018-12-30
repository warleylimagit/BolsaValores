package com.javaee.warley.BolsaValores.controllers;

import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.javaee.warley.BolsaValores.domain.Acionista;
import com.javaee.warley.BolsaValores.services.AcionistaService;

@RestController
@RequestMapping(AcionistaController.BASE_URL)
public class AcionistaController {

	public static final String BASE_URL = "/api/v1/acionista";
	
	private final AcionistaService acionistaService;
    
    public AcionistaController(AcionistaService acionistaService) {
    	this.acionistaService = acionistaService;
    }
    
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Set<Acionista> getAll(){
        return acionistaService.getAll();
    }
    
    @GetMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public Acionista getById(@PathVariable String id){
        return acionistaService.getAcionistaById(id);
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Acionista create(@RequestBody Acionista _acionista){
        return acionistaService.createNewAcionista(_acionista);
    }
}
