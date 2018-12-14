package com.javaee.warley.BolsaValores.services;

import java.util.Set;

import com.javaee.warley.BolsaValores.domain.Empresa;

public interface EmpresaService {

	Set<Empresa> getAll();
	
	Empresa getGarageById(String id);

	Empresa createNewGarage(Empresa garage);

	Empresa saveGarage(String id, Empresa garage);
}
