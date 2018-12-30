package com.javaee.warley.BolsaValores.repositories;

import java.util.Set;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.javaee.warley.BolsaValores.domain.Acao;

@Repository
public interface AcaoRepository extends MongoRepository<Acao, String> {
	Set<Acao> findByAcao(String acao);
}
