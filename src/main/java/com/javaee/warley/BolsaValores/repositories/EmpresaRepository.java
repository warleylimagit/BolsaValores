package com.javaee.warley.BolsaValores.repositories;

import java.util.Set;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.javaee.warley.BolsaValores.domain.Empresa;

public interface EmpresaRepository extends MongoRepository<Empresa, String> {
	Set<Empresa> findByEmpresa(String empresa);
}
