package com.javaee.warley.BolsaValores.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.javaee.warley.BolsaValores.domain.Acao_Comprador;
import com.javaee.warley.BolsaValores.services.AcaoCompradorService;

@RestController
@RequestMapping(AcaoCompradorController.BASE_URL)
public class AcaoCompradorController {

	public static final String BASE_URL = "/api/v1/acaoComprador";

    private final AcaoCompradorService acaoCompradorService;
    
    public AcaoCompradorController(AcaoCompradorService acaoCompradorService) {
    	this.acaoCompradorService = acaoCompradorService;
    }
    
    @GetMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public Acao_Comprador getById(@PathVariable String id){
        return acaoCompradorService.getAcaoCompradorById(id);
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Acao_Comprador create(@RequestBody Acao_Comprador acaoComprador){
        return acaoCompradorService.createNewAcaoComprador(acaoComprador);
    }
    
    @PutMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public Acao_Comprador update(@PathVariable String id, @RequestBody Acao_Comprador acaoComprador){
        return acaoCompradorService.saveAcaoComprador(id, acaoComprador);
    }
}
