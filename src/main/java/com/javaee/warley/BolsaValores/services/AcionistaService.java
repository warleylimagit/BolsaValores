package com.javaee.warley.BolsaValores.services;

import java.util.Set;

import com.javaee.warley.BolsaValores.domain.Acionista;

public interface AcionistaService {
	
	Set<Acionista> getAll();
	
	Acionista getAcionistaById(String id);

	Acionista createNewAcionista(Acionista garage);

	Acionista saveAcionista(String id, Acionista garage);
}
