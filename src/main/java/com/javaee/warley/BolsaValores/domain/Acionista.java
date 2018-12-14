package com.javaee.warley.BolsaValores.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document
public class Acionista {
	@Id
    private String id;
    private String nome;
    private String cpf;
    private String email;
}
