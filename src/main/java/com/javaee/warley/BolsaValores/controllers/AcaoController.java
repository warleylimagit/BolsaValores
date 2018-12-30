package com.javaee.warley.BolsaValores.controllers;

import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.javaee.warley.BolsaValores.domain.Acao;
import com.javaee.warley.BolsaValores.services.AcaoService;

@RestController
@RequestMapping(AcaoController.BASE_URL)
public class AcaoController {
	public static final String BASE_URL = "/api/v1/acao";
	
	private final AcaoService acaoService;
    
    public AcaoController(AcaoService acaoService) {
    	this.acaoService = acaoService;
    }
    
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Set<Acao> getAll(){
        return acaoService.getAll();
    }
    
    @GetMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public Acao getById(@PathVariable String id){
        return acaoService.getAcaoById(id);
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Acao create(@RequestBody Acao acao){
        return acaoService.createNewAcao(acao);
    }
    
    @PutMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public Acao update(@PathVariable String id, @RequestBody Acao acao){
        return acaoService.saveAcao(id, acao);
    }
}
