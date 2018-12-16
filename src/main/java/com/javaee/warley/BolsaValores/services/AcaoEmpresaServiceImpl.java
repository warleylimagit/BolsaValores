package com.javaee.warley.BolsaValores.services;

import java.util.Optional;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.javaee.warley.BolsaValores.domain.Acao_Empresa;
import com.javaee.warley.BolsaValores.repositories.AcaoEmpresaRepository;

public class AcaoEmpresaServiceImpl implements AcaoEmpresaService {
	private AcaoEmpresaRepository acaoEmpresaRepository;
	
	public AcaoEmpresaServiceImpl(AcaoEmpresaRepository acaoEmpresaRepository) {
		this.acaoEmpresaRepository = acaoEmpresaRepository;
	}
	
	private Acao_Empresa GetById(String id) {
		Optional<Acao_Empresa> optionalAcao = acaoEmpresaRepository.findById(id);
		
		if (!optionalAcao.isPresent()) {
            throw new IllegalArgumentException("Nenhum item foi encontrado!");
        }
        return optionalAcao.get();
	}
	
	@Override
	public Acao_Empresa getAcaoEmpresaById(String id) {
		// TODO Auto-generated method stub
		return GetById(id);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public Acao_Empresa createNewAcaoEmpresa(Acao_Empresa acaoEmpresa) {
		return acaoEmpresaRepository.save(acaoEmpresa);
	}

	@Override
	public Acao_Empresa saveAcaoEmpresa(String id, Acao_Empresa acaoEmpresa) {
		acaoEmpresa.setId(id);
		return acaoEmpresaRepository.save(acaoEmpresa);
	}

}
