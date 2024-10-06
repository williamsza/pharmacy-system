package com.remedios.curso.remedio;

import java.time.LocalDate;

import jakarta.persistence.Enumerated;
import jakarta.persistence.MapKeyEnumerated;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.web.bind.annotation.PutMapping;

public record DadosListagemRemedio(Long id, String nome, Laboratorio laboratorio, Via via , int quantidade) {
	
	public DadosListagemRemedio(Remedio remedio) {
		this(remedio.getId(),remedio.getNome(), remedio.getLaboratorio(), remedio.getVia(), remedio.getQuantidade());
	}



}