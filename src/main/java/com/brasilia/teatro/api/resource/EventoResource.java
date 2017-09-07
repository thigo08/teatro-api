package com.brasilia.teatro.api.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brasilia.teatro.api.model.Evento;
import com.brasilia.teatro.api.repository.EventoRepository;

@RestController
@RequestMapping("/eventos")
public class EventoResource {

	@Autowired
	private EventoRepository eventoRepository;

	@GetMapping
	public List<Evento> listar() {
		return eventoRepository.findAll();
	}

	@GetMapping(params = "peagle")
	public Page<Evento> listarPageable(Pageable pageable) {
		return eventoRepository.findAllPaged(pageable);
	}

	@GetMapping(params = "paginado")
	public List<Evento> listarPaginado(Pageable pageable) {
		return eventoRepository.buscarPaginado(pageable);
	}

}
