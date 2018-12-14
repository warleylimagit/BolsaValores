package com.javaee.warley.BolsaValores.services;

import java.util.Set;

import com.javaee.warley.BolsaValores.domain.Acionista;

public interface AcionistaService {
	
	Set<Acionista> getAll();
	
	Acionista getGarageById(String id);

	Acionista createNewGarage(Acionista garage);

	Acionista saveGarage(String id, Acionista garage);
}
