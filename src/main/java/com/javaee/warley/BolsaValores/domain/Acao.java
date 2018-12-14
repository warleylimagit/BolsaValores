package com.javaee.warley.BolsaValores.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document
public class Acao {
	@Id
    private String id;
    private Empresa empresa;
    private String acao;
    private Double valor_inicial;
    private Double valor_atual;
}
