package com.brasilia.teatro.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brasilia.teatro.api.model.Evento;

public interface EventoRepository extends JpaRepository<Evento, Long> {

}
