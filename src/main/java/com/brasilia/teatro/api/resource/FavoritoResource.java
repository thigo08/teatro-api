package com.brasilia.teatro.api.resource;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.brasilia.teatro.api.event.RecursoCriadoEvent;
import com.brasilia.teatro.api.exceptionhandler.TeatroExceptionHandler.Erro;
import com.brasilia.teatro.api.model.Favorito;
import com.brasilia.teatro.api.repository.FavoritoRepository;
import com.brasilia.teatro.api.service.FavoritoService;
import com.brasilia.teatro.api.service.exception.FavoritoJaExisteException;

@RestController
@RequestMapping("/favorito")
public class FavoritoResource {

	@Autowired
	private FavoritoRepository favoritoRepository;
	
	@Autowired
	private FavoritoService favoritoService;

	@Autowired
	private ApplicationEventPublisher publisher;
	
	@Autowired
	private MessageSource messageSource;

	@GetMapping
	public List<Favorito> listar() {
		return favoritoRepository.findAll();
	}

	@PostMapping
	public ResponseEntity<Favorito> criar(@RequestBody Favorito favorito, HttpServletResponse response) {
		Favorito favoritoSalvo = favoritoService.salvar(favorito);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, favoritoSalvo.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(favoritoSalvo);
	}

	@DeleteMapping
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@RequestBody Favorito favorito) {
		Favorito favoritoSalvo = favoritoRepository.buscarFavorito(favorito);
		favoritoRepository.delete(favoritoSalvo);
	}
	
	@ExceptionHandler({ FavoritoJaExisteException.class })
	public ResponseEntity<Object> handlePessoaInexistenteOuInativaException(FavoritoJaExisteException ex) {
		String mensagemUsuario = messageSource.getMessage("favorito.ja-exite", null, LocaleContextHolder.getLocale());
		String mensagemDesenvolvedor = ex.toString();
		List<Erro> erros = Arrays.asList(new Erro(mensagemUsuario, mensagemDesenvolvedor));
		return ResponseEntity.badRequest().body(erros);
	}

}
