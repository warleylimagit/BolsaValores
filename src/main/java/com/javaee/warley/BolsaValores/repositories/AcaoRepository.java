package com.javaee.warley.BolsaValores.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.javaee.warley.BolsaValores.domain.Acao;

public interface AcaoRepository extends MongoRepository<Acao, String> {

}
