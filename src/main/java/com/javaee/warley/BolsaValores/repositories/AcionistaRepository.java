package com.javaee.warley.BolsaValores.repositories;

import java.util.Set;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.javaee.warley.BolsaValores.domain.Acionista;

@Repository
public interface AcionistaRepository extends MongoRepository<Acionista, String> {
	Set<Acionista> findByAcionista(String nome);
}
