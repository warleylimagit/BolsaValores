package com.javaee.warley.BolsaValores.services;

import com.javaee.warley.BolsaValores.domain.Acao_Empresa;

public interface AcaoEmpresaService {
	
	Acao_Empresa getAcaoEmpresaById(String id);

	Acao_Empresa createNewAcaoEmpresa(Acao_Empresa garage);

	Acao_Empresa saveAcaoEmpresa(String id, Acao_Empresa garage);
}
