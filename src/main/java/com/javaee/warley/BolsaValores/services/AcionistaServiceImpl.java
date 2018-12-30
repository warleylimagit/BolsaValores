package com.javaee.warley.BolsaValores.services;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.javaee.warley.BolsaValores.domain.Acionista;
import com.javaee.warley.BolsaValores.repositories.AcionistaRepository;

@Service
public class AcionistaServiceImpl implements AcionistaService {
	@Autowired
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
	public Acionista createNewAcionista(Acionista _acionista) {
		if(acionistaRepository.findByAcionista(_acionista.getNome()).isEmpty()) {			
			return acionistaRepository.save(_acionista);
		}
		
		throw new IllegalArgumentException("Ja existe um acionista com este nome!");
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public Acionista saveAcionista(String id, Acionista _acionista) {
		_acionista.setId(id);
		return acionistaRepository.save(_acionista);
	}

}
