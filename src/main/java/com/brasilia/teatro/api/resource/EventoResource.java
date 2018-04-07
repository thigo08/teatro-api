package com.brasilia.teatro.api.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brasilia.teatro.api.event.RecursoCriadoEvent;
import com.brasilia.teatro.api.model.Evento;
import com.brasilia.teatro.api.repository.EventoRepository;
import com.brasilia.teatro.api.repository.filter.EventoFilter;

@RestController
@RequestMapping("/eventos")
public class EventoResource {

	@Autowired
	private EventoRepository eventoRepository;

	@Autowired
	private ApplicationEventPublisher publisher;

	@GetMapping
	public List<Evento> listar() {
		return eventoRepository.findAll();
	}
	
	@GetMapping("/listar/{uid}")
	public List<Evento> listarEventos(@PathVariable String uid){
		return eventoRepository.listarEventos(uid);
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<Evento> buscarPeloCodigo(@PathVariable Long codigo) {
		Evento evento = eventoRepository.findOne(codigo);
		return evento != null ? ResponseEntity.ok(evento) : ResponseEntity.notFound().build();
	}

	@GetMapping(params = "filtrar")
	public List<Evento> listarEventoFiltro(EventoFilter eventoFilter) {
		return eventoRepository.filtrar(eventoFilter);
	}

	@GetMapping(params = "peagle")
	public Page<Evento> listarPageable(Pageable pageable) {
		return eventoRepository.findAllPaged(pageable);
	}

	@GetMapping(params = "paginado")
	public List<Evento> listarPaginado(Pageable pageable) {
		return eventoRepository.buscarPaginado(pageable);
	}

	@PostMapping
	public ResponseEntity<Evento> criar(@RequestBody Evento evento, HttpServletResponse response) {
		// TODO Persistir com a lista Agenda
		Evento eventoSalvo = eventoRepository.save(evento);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, eventoSalvo.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(eventoSalvo);
	}

}
