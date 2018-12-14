package com.javaee.warley.BolsaValores.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.javaee.warley.BolsaValores.domain.Acao_Empresa;

public interface AcaoEmpresaRepository extends MongoRepository<Acao_Empresa, String> {

}
