package com.javaee.warley.BolsaValores.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document
public class Acao_Empresa {
	@Id
    private String id;
	private Empresa empresa;
    private Integer limite_acoes;
    private Integer quantidade_atual_acoes;
}
