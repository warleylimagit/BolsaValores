package com.javaee.warley.BolsaValores.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.javaee.warley.BolsaValores.domain.Acao_Comprador;

public interface AcaoCompradorRepository extends MongoRepository<Acao_Comprador, String> {

}
