package com.brasilia.teatro.api.repository.evento;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.brasilia.teatro.api.model.Evento;
import com.brasilia.teatro.api.repository.filter.EventoFilter;

public interface EventoRepositoryQuery {

	public Page<Evento> findAllPaged(Pageable pageable);

	public List<Evento> buscarPaginado(Pageable pageable);

	// TODO Implementar filtro
	public List<Evento> filtrar(EventoFilter eventoFilter);

	public List<Evento> listarEventos(String uid);

}
