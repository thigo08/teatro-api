package com.brasilia.teatro.api.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.brasilia.teatro.api.event.RecursoCriadoEvent;
import com.brasilia.teatro.api.model.Local;
import com.brasilia.teatro.api.repository.LocalRepository;

@RestController
@RequestMapping("/locais")
public class LocalResource {

	@Autowired
	private LocalRepository localRepository;

	@Autowired
	private ApplicationEventPublisher publisher;

	@GetMapping
	public List<Local> listar() {
		return localRepository.findAll();
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<Local> buscarPeloCodigo(@PathVariable Long codigo) {
		Local local = localRepository.findOne(codigo);
		return local != null ? ResponseEntity.ok(local) : ResponseEntity.notFound().build();
	}

	@PostMapping
	public ResponseEntity<Local> criar(@RequestBody Local local, HttpServletResponse response) {
		Local localSalvo = localRepository.save(local);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, localSalvo.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(localSalvo);
	}

	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		localRepository.delete(codigo);
	}

}
