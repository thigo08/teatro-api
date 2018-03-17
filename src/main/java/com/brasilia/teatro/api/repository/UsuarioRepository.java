package com.brasilia.teatro.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brasilia.teatro.api.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}