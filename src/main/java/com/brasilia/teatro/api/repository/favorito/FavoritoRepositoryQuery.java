package com.brasilia.teatro.api.repository.favorito;

import java.util.List;

import com.brasilia.teatro.api.model.Evento;

public interface FavoritoRepositoryQuery {

	public List<Evento> buscarEventosFavoritoPorUsuario(String codigoUsuario);

}
