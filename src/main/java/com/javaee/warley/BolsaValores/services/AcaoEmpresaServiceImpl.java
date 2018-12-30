package com.javaee.warley.BolsaValores.services;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.javaee.warley.BolsaValores.domain.Acao_Empresa;
import com.javaee.warley.BolsaValores.domain.Empresa;
import com.javaee.warley.BolsaValores.repositories.AcaoEmpresaRepository;

@Service
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
	public Acao_Empresa getAcaoEmpresaByIdEmpresa(Empresa empresa) {
		Optional<Acao_Empresa> acaoEmpresa = acaoEmpresaRepository.findByEmpresa(empresa.getEmpresa());
		
		if(!acaoEmpresa.isPresent())
			throw new IllegalArgumentException("Nenhum item foi encontrado!");
		
		return acaoEmpresa.get();
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public Acao_Empresa createNewAcaoEmpresa(Acao_Empresa acaoEmpresa) {
		return acaoEmpresaRepository.save(acaoEmpresa);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public Acao_Empresa saveAcaoEmpresa(String id, Acao_Empresa acaoEmpresa) {
		acaoEmpresa.setId(id);
		return acaoEmpresaRepository.save(acaoEmpresa);
	}

}
