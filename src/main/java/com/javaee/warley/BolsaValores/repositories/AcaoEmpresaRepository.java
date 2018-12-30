package com.javaee.warley.BolsaValores.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.javaee.warley.BolsaValores.domain.Acao_Empresa;

@Repository
public interface AcaoEmpresaRepository extends MongoRepository<Acao_Empresa, String> {
	Optional<Acao_Empresa> findByEmpresa(String empresa);
}
