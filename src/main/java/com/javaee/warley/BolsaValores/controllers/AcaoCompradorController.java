package com.javaee.warley.BolsaValores.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaee.warley.BolsaValores.services.AcaoCompradorService;

@RestController
@RequestMapping(AcaoCompradorController.BASE_URL)
public class AcaoCompradorController {

	public static final String BASE_URL = "/api/v1/acaoComprador";

    private final AcaoCompradorService acaoCompradorService;
    
    public AcaoCompradorController(AcaoCompradorService acaoCompradorService) {
    	this.acaoCompradorService = acaoCompradorService;
    }
}
