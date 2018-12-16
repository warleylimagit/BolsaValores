package com.javaee.warley.BolsaValores.repositories;

import java.util.Set;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.javaee.warley.BolsaValores.domain.Acao_Comprador;

public interface AcaoCompradorRepository extends MongoRepository<Acao_Comprador, String> {
	Set<Acao_Comprador> findByAcao(String acao);
}
