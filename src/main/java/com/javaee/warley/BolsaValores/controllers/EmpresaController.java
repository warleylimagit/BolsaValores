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

import com.javaee.warley.BolsaValores.domain.Empresa;
import com.javaee.warley.BolsaValores.services.EmpresaService;

@RestController
@RequestMapping(EmpresaController.BASE_URL)
public class EmpresaController {

	public static final String BASE_URL = "/api/v1/empresa";
	
	private final EmpresaService empresaService;
    
    public EmpresaController(EmpresaService empresaService) {
    	this.empresaService = empresaService;
    }
    
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Set<Empresa> getAll(){
        return empresaService.getAll();
    }
    
    @GetMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public Empresa getById(@PathVariable String id){
        return empresaService.getEmpresaById(id);
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Empresa create(@RequestBody Empresa empresa){
        return empresaService.createNewEmpresa(empresa);
    }
    
    @PutMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public Empresa update(@PathVariable String id, @RequestBody Empresa empresa){
        return empresaService.saveEmpresa(id, empresa);
    }
}
