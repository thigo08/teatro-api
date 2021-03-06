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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brasilia.teatro.api.event.RecursoCriadoEvent;
import com.brasilia.teatro.api.model.Usuario;
import com.brasilia.teatro.api.repository.UsuarioRepository;
import com.brasilia.teatro.api.repository.filter.UsuarioFilter;
import com.brasilia.teatro.api.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioResource {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private ApplicationEventPublisher publisher;

	@GetMapping
	public List<Usuario> listar() {
		return usuarioRepository.findAll();
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<Usuario> buscarPeloCodigo(@PathVariable Long codigo) {
		Usuario usuario = usuarioRepository.findOne(codigo);
		return usuario != null ? ResponseEntity.ok(usuario) : ResponseEntity.notFound().build();
	}

	@GetMapping(params = "filtrar")
	public Usuario usuarioFiltro(UsuarioFilter usuarioFilter) {
		return usuarioRepository.filtrar(usuarioFilter);
	}

	@PostMapping
	public ResponseEntity<Usuario> criar(@RequestBody Usuario usuario, HttpServletResponse response) {
		Usuario usuarioSalvo = usuarioRepository.save(usuario);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, usuarioSalvo.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioSalvo);
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<Usuario> atualizar(@PathVariable Long codigo, @RequestBody Usuario usuario) {
		Usuario usuarioSalvo = usuarioService.atualizar(codigo, usuario);
		return ResponseEntity.ok(usuarioSalvo);
	}

}
