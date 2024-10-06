package com.remedios.curso.remedio;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RemedioRepository extends JpaRepository<Remedio, Long> {

   // List<Optional<DadosListagemRemedio>>  findAllByAtivoTrue();
    List<Remedio> findAllByAtivoTrue();
}
