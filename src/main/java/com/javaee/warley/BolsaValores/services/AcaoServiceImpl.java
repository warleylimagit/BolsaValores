package com.javaee.warley.BolsaValores.services;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.javaee.warley.BolsaValores.domain.Acao;
import com.javaee.warley.BolsaValores.repositories.AcaoRepository;

@Service
public class AcaoServiceImpl implements AcaoService {
	private AcaoRepository acaoRepository;
	
	public AcaoServiceImpl(AcaoRepository acaoRepository) {
		this.acaoRepository = acaoRepository;
	}
	
	@Override
	public Set<Acao> getAll() {
		Set<Acao> acoes = new HashSet<>();
		this.acaoRepository.findAll().iterator().forEachRemaining(acoes::add);
		return acoes;
	}
	
	private Acao GetById(String id) {
		Optional<Acao> optionalAcao = acaoRepository.findById(id);
		
		if (!optionalAcao.isPresent()) {
            throw new IllegalArgumentException("Nenhum item foi encontrado!");
        }
        return optionalAcao.get();
	}

	@Override
	public Acao getAcaoById(String id) {
		// TODO Auto-generated method stub
		return GetById(id);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public Acao createNewAcao(Acao acao) {
		if(acaoRepository.findByAcao(acao.getAcao()).isEmpty()) {			
			return acaoRepository.save(acao);
		}
		
		throw new IllegalArgumentException("Ja existe uma acao com este nome!");
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public Acao saveAcao(String id, Acao acao) {
		acao.setId(id);
		return acaoRepository.save(acao);
	}

}
