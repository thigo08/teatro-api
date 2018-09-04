package com.brasilia.teatro.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brasilia.teatro.api.model.Favorito;
import com.brasilia.teatro.api.repository.FavoritoRepository;
import com.brasilia.teatro.api.service.exception.FavoritoJaExisteException;

@Service
public class FavoritoService {

	@Autowired
	private FavoritoRepository favoritoRepository;

	public Favorito salvar(Favorito favorito) {
		Favorito retornoFavorito = favoritoRepository.buscarFavorito(favorito);
		if (retornoFavorito != null) {
			throw new FavoritoJaExisteException();
		}

		Favorito favoritoSalvo = favoritoRepository.save(favorito);
		return favoritoSalvo;
	}

}
