package com.brasilia.teatro.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brasilia.teatro.api.model.Usuario;
import com.brasilia.teatro.api.repository.usuario.UsuarioRepositoryQuery;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>, UsuarioRepositoryQuery {

}