package com.brasilia.teatro.api.repository.favorito;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.brasilia.teatro.api.model.Evento;
import com.brasilia.teatro.api.model.Favorito;

public class FavoritoRepositoryImpl implements FavoritoRepositoryQuery {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<Evento> buscarEventosFavoritoPorUsuario(Long codigoUsuario) {

		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Evento> criteria = builder.createQuery(Evento.class);
		Root<Evento> root = criteria.from(Evento.class);
		Join<Evento, Favorito> join = root.join("favoritos");

		Predicate predicate = builder.equal(join.get("usuario"), codigoUsuario);
		criteria.where(predicate);

		TypedQuery<Evento> query = manager.createQuery(criteria);

		return query.getResultList();
	}

}
