package com.brasilia.teatro.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brasilia.teatro.api.model.Favorito;
import com.brasilia.teatro.api.repository.favorito.FavoritoRepositoryQuery;

public interface FavoritoRepository extends JpaRepository<Favorito, Long>, FavoritoRepositoryQuery {

}
