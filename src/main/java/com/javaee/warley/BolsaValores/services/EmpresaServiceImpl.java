package com.javaee.warley.BolsaValores.services;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.javaee.warley.BolsaValores.domain.Empresa;
import com.javaee.warley.BolsaValores.repositories.EmpresaRepository;

public class EmpresaServiceImpl implements EmpresaService {
	private EmpresaRepository empresaRepository;
	
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
		if(empresaRepository.findByEmpresa(empresa.getEmpresa()).isEmpty()) {			
			return empresaRepository.save(empresa);
		}
		
		throw new IllegalArgumentException("Ja existe uma empresa com este nome!");
	}

	@Override
	public Empresa saveEmpresa(String id, Empresa empresa) {
		empresa.setId(id);
		return empresaRepository.save(empresa);
	}

}
