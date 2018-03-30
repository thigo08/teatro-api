package com.brasilia.teatro.api.repository.usuario;

import com.brasilia.teatro.api.model.Usuario;
import com.brasilia.teatro.api.repository.filter.UsuarioFilter;

public interface UsuarioRepositoryQuery {

	public Usuario filtrar(UsuarioFilter usuarioFilter);

}
