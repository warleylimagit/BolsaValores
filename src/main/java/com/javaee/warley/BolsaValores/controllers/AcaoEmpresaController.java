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

import com.javaee.warley.BolsaValores.domain.Acao_Empresa;
import com.javaee.warley.BolsaValores.domain.Empresa;
import com.javaee.warley.BolsaValores.services.AcaoEmpresaService;
import com.javaee.warley.BolsaValores.services.EmpresaService;

@RestController
@RequestMapping(AcaoCompradorController.BASE_URL)
public class AcaoEmpresaController {

	public static final String BASE_URL = "/api/v1/acaoEmpresa";

    private final AcaoEmpresaService acaoEmpresaService;
    private final EmpresaService empresaService;
    
    public AcaoEmpresaController(AcaoEmpresaService acaoEmpresaService, EmpresaService empresaService) {
    	this.acaoEmpresaService = acaoEmpresaService;
    	this.empresaService = empresaService;
    }
    
    @GetMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public Acao_Empresa getById(@PathVariable String id){
        return acaoEmpresaService.getAcaoEmpresaById(id);
    }
    
    @GetMapping({"/{id}/empresa"})
    @ResponseStatus(HttpStatus.OK)
    public Acao_Empresa getByIdEmpresa(@PathVariable String id){
    	Empresa empresa = empresaService.getEmpresaById(id);
        return acaoEmpresaService.getAcaoEmpresaByIdEmpresa(empresa);
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Acao_Empresa create(@RequestBody Acao_Empresa acaoEmpresa){
        return acaoEmpresaService.createNewAcaoEmpresa(acaoEmpresa);
    }
    
    @PutMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public Acao_Empresa update(@PathVariable String id, @RequestBody Acao_Empresa acaoEmpresa){
        return acaoEmpresaService.saveAcaoEmpresa(id, acaoEmpresa);
    }
}
