package com.javaee.warley.BolsaValores.repositories;

import java.util.Set;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.javaee.warley.BolsaValores.domain.Acao_Empresa;

public interface AcaoEmpresaRepository extends MongoRepository<Acao_Empresa, String> {
	Set<Acao_Empresa> fingByEmpresa(String empresa);
}
