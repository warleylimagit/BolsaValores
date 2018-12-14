package com.javaee.warley.BolsaValores.domain;

import java.sql.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document
public class Acao_Comprador {
	@Id
    private String id;
	private Acionista acionista;
	private Acao acao;
	private Date data_compra;
}
