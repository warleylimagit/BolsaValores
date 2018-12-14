package com.javaee.warley.BolsaValores.services;

import java.util.Set;

import com.javaee.warley.BolsaValores.domain.Acao;

public interface AcaoService {
	
	Set<Acao> getAll();
	
	Acao getGarageById(String id);

	Acao createNewGarage(Acao garage);

	Acao saveGarage(String id, Acao garage);
}
