package com.javaee.warley.BolsaValores.services;

import com.javaee.warley.BolsaValores.domain.Acao_Empresa;

public interface AcaoEmpresaService {
	
	Acao_Empresa getGarageById(String id);

	Acao_Empresa createNewGarage(Acao_Empresa garage);

	Acao_Empresa saveGarage(String id, Acao_Empresa garage);
}
