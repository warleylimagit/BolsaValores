package com.javaee.warley.BolsaValores.services;

import java.util.Set;

import com.javaee.warley.BolsaValores.domain.Acao;

public interface AcaoService {
	
	Set<Acao> getAll();
	
	Acao getAcaoById(String id);

	Acao createNewAcao(Acao acao);

	Acao saveAcao(String id, Acao acao);
}
