package com.brasilia.teatro.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brasilia.teatro.api.model.Evento;
import com.brasilia.teatro.api.repository.evento.EventoRepositoryQuery;

public interface EventoRepository extends JpaRepository<Evento, Long>, EventoRepositoryQuery{

}
