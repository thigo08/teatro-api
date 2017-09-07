package com.brasilia.teatro.api.repository.evento;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.brasilia.teatro.api.model.Evento;

public interface EventoRepositoryQuery {

	public Page<Evento> findAllPaged(Pageable pageable);

	public List<Evento> buscarPaginado(Pageable pageable);

}
