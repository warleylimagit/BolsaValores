package com.javaee.warley.BolsaValores.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.javaee.warley.BolsaValores.domain.Acionista;

public interface AcionistaRepository extends MongoRepository<Acionista, String> {

}
