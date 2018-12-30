package com.javaee.warley.BolsaValores.repositories;

import java.util.Set;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.javaee.warley.BolsaValores.domain.Acao_Comprador;

@Repository
public interface AcaoCompradorRepository extends MongoRepository<Acao_Comprador, String> {
	Set<Acao_Comprador> findByAcao(String acao);
}
