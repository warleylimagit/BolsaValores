package com.javaee.warley.BolsaValores.services;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.javaee.warley.BolsaValores.domain.Acao_Empresa;
import com.javaee.warley.BolsaValores.domain.Empresa;
import com.javaee.warley.BolsaValores.repositories.AcaoEmpresaRepository;
import com.javaee.warley.BolsaValores.repositories.EmpresaRepository;

@Service
public class EmpresaServiceImpl implements EmpresaService {
	private EmpresaRepository empresaRepository;
	private AcaoEmpresaRepository acaoEmpresaRepository;
	
	public EmpresaServiceImpl(EmpresaRepository empresaRepository) {
		this.empresaRepository = empresaRepository;
	}
	
	@Override
	public Set<Empresa> getAll() {
		Set<Empresa> empresas = new HashSet<>();
		this.empresaRepository.findAll().iterator().forEachRemaining(empresas::add);
		return empresas;
	}

	private Empresa GetById(String id) {
		Optional<Empresa> optionalEmpresa = empresaRepository.findById(id);
		
		if (!optionalEmpresa.isPresent()) {
            throw new IllegalArgumentException("Nenhum item foi encontrado!");
        }
        return optionalEmpresa.get();
	}
	
	@Override
	public Empresa getEmpresaById(String id) {
		// TODO Auto-generated method stub
		return GetById(id);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public Empresa createNewEmpresa(Empresa empresa) {
		if(!empresaRepository.findByEmpresa(empresa.getEmpresa()).isEmpty())
			throw new IllegalArgumentException("Ja existe uma empresa com este nome!");
		
		Optional<Acao_Empresa> empresaBanco = acaoEmpresaRepository.findByEmpresa(empresa.getEmpresa());
		if(empresaBanco.get().getQuantidade_atual_acoes() == empresaBanco.get().getLimite_acoes())
			throw new IllegalArgumentException("A empresa ja atingiu o limite maximo de acoes!");
		
		empresaBanco.get().setQuantidade_atual_acoes(empresaBanco.get().getQuantidade_atual_acoes() + 1);
		acaoEmpresaRepository.save(empresaBanco.get());
		
		return empresaRepository.save(empresa);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public Empresa saveEmpresa(String id, Empresa empresa) {
		empresa.setId(id);
		return empresaRepository.save(empresa);
	}

}
