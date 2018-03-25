package com.brasilia.teatro.api.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
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
import com.brasilia.teatro.api.model.Favorito;
import com.brasilia.teatro.api.repository.FavoritoRepository;

@RestController
@RequestMapping("/favorito")
public class FavoritoResource {

	@Autowired
	private FavoritoRepository favoritoRepository;

	@Autowired
	private ApplicationEventPublisher publisher;

	@GetMapping
	public List<Favorito> listar() {
		return favoritoRepository.findAll();
	}

	@GetMapping("/{codigo}")
	public List<Evento> buscarEventosFavoritoPorUsuario(@PathVariable Long codigo) {
		return favoritoRepository.buscarEventosFavoritoPorUsuario(codigo);
	}

	@PostMapping
	public ResponseEntity<Favorito> criar(@RequestBody Favorito favorito, HttpServletResponse response) {
		Favorito favoritoSalvo = favoritoRepository.save(favorito);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, favoritoSalvo.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(favoritoSalvo);
	}

}
