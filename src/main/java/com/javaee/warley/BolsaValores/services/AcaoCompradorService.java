package com.javaee.warley.BolsaValores.services;

import com.javaee.warley.BolsaValores.domain.Acao_Comprador;

public interface AcaoCompradorService {
	
	Acao_Comprador getGarageById(String id);

	Acao_Comprador createNewGarage(Acao_Comprador garage);

	Acao_Comprador saveGarage(String id, Acao_Comprador garage);
}
