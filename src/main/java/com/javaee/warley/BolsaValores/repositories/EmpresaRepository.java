package com.javaee.warley.BolsaValores.repositories;

import java.util.Set;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.javaee.warley.BolsaValores.domain.Empresa;

@Repository
public interface EmpresaRepository extends MongoRepository<Empresa, String> {
	Set<Empresa> findByEmpresa(String empresa);
}
