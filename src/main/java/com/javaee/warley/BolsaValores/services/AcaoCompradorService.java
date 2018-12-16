package com.javaee.warley.BolsaValores.services;

import com.javaee.warley.BolsaValores.domain.Acao_Comprador;

public interface AcaoCompradorService {
	
	Acao_Comprador getAcaoCompradorById(String id);

	Acao_Comprador createNewAcaoComprador(Acao_Comprador acaoComprador);

	Acao_Comprador saveAcaoComprador(String id, Acao_Comprador acaoComprador);
}
