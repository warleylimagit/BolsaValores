package com.javaee.warley.BolsaValores.services;

import java.util.Optional;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.javaee.warley.BolsaValores.domain.Acao_Comprador;
import com.javaee.warley.BolsaValores.repositories.AcaoCompradorRepository;

public class AcaoCompradorServiceImpl implements AcaoCompradorService {
	private AcaoCompradorRepository acaoCompradorRepository;
	
	public AcaoCompradorServiceImpl(AcaoCompradorRepository acaoCompradorRepository) {
		this.acaoCompradorRepository = acaoCompradorRepository;
	}
	
	private Acao_Comprador GetById(String id) {
		Optional<Acao_Comprador> optionalAcao = acaoCompradorRepository.findById(id);
		
		if (!optionalAcao.isPresent()) {
            throw new IllegalArgumentException("Nenhum item foi encontrado!");
        }
        return optionalAcao.get();
	}
	
	@Override
	public Acao_Comprador getAcaoCompradorById(String id) {
		return GetById(id);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public Acao_Comprador createNewAcaoComprador(Acao_Comprador acaoComprador) {
		if(acaoCompradorRepository.findByAcao(acaoComprador.getAcao().getAcao()).isEmpty()) {
			return acaoCompradorRepository.save(acaoComprador);
		}
		
		throw new IllegalArgumentException("Esta acao ja foi comprada por outro acionista!");
	}

	@Override
	public Acao_Comprador saveAcaoComprador(String id, Acao_Comprador acaoComprador) {
		acaoComprador.setId(id);
		return acaoCompradorRepository.save(acaoComprador);
	}

}
