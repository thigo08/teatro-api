package com.brasilia.teatro.api.repository.favorito;

import java.util.List;

import com.brasilia.teatro.api.model.Evento;
import com.brasilia.teatro.api.model.Favorito;

public interface FavoritoRepositoryQuery {

	public List<Evento> buscarEventosFavoritoPorUsuario(String codigoUsuario);
	
	public Favorito buscarFavorito(Favorito favorito);

	public void deletar(Favorito favorito);

}
