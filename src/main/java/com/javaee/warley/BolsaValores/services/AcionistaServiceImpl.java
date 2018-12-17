package com.javaee.warley.BolsaValores.services;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.javaee.warley.BolsaValores.domain.Acionista;
import com.javaee.warley.BolsaValores.repositories.AcionistaRepository;

public class AcionistaServiceImpl implements AcionistaService {
	private AcionistaRepository acionistaRepository;
	
	public AcionistaServiceImpl(AcionistaRepository acionistaRepository) {
		this.acionistaRepository = acionistaRepository;
	}
	
	@Override
	public Set<Acionista> getAll() {
		Set<Acionista> acionistas = new HashSet<>();
		this.acionistaRepository.findAll().iterator().forEachRemaining(acionistas::add);
		return acionistas;
	}
	
	private Acionista GetById(String id) {
		Optional<Acionista> optionalAcionista = acionistaRepository.findById(id);
		
		if (!optionalAcionista.isPresent()) {
            throw new IllegalArgumentException("Nenhum item foi encontrado!");
        }
        return optionalAcionista.get();
	}

	@Override
	public Acionista getAcionistaById(String id) {
		// TODO Auto-generated method stub
		return GetById(id);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public Acionista createNewAcionista(Acionista acionista) {
		if(acionistaRepository.findByAcionista(acionista.getNome()).isEmpty()) {			
			return acionistaRepository.save(acionista);
		}
		
		throw new IllegalArgumentException("Ja existe um acionista com este nome!");
	}

	@Override
	public Acionista saveAcionista(String id, Acionista acionista) {
		acionista.setId(id);
		return acionistaRepository.save(acionista);
	}

}
