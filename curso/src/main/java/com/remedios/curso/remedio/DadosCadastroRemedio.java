package com.remedios.curso.remedio;

import java.time.LocalDate;

import jakarta.persistence.Enumerated;
import jakarta.persistence.MapKeyEnumerated;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroRemedio(

		@NotBlank
		String nome,
		@NotNull
		Via via,
		@NotBlank
		String lote,

		int quantidade,

		@Future
		LocalDate validade,
		@NotNull
		Laboratorio laboratorio
) {

//	public String Getnome() {
//		return nome;
//	}




}