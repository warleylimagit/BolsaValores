package com.javaee.warley.BolsaValores.services;

import java.util.Set;

import com.javaee.warley.BolsaValores.domain.Empresa;

public interface EmpresaService {

	Set<Empresa> getAll();
	
	Empresa getEmpresaById(String id);

	Empresa createNewEmpresa(Empresa empresa);

	Empresa saveEmpresa(String id, Empresa empresa);
}
