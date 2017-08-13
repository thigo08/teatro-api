package com.brasilia.teatro.api.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

}
