package com.javaee.warley.BolsaValores.services;

import com.javaee.warley.BolsaValores.domain.Acao_Empresa;
import com.javaee.warley.BolsaValores.domain.Empresa;

public interface AcaoEmpresaService {
	
	Acao_Empresa getAcaoEmpresaById(String id);

	Acao_Empresa createNewAcaoEmpresa(Acao_Empresa acaoEmpresa);

	Acao_Empresa saveAcaoEmpresa(String id, Acao_Empresa acaoEmpresa);

	Acao_Empresa getAcaoEmpresaByIdEmpresa(Empresa empresa);
}
