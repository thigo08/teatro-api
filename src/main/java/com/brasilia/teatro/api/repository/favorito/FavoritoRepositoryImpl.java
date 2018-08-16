package com.brasilia.teatro.api.repository.favorito;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.util.StringUtils;

import com.brasilia.teatro.api.model.Favorito;

public class FavoritoRepositoryImpl implements FavoritoRepositoryQuery {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public Favorito buscarFavorito(Favorito favorito) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Favorito> criteria = builder.createQuery(Favorito.class);
		Root<Favorito> root = criteria.from(Favorito.class);

		Predicate[] predicates = criarRestricoes(favorito, builder, root);
		criteria.where(predicates);

		TypedQuery<Favorito> query = manager.createQuery(criteria);

		return query.getSingleResult();
	}

	private Predicate[] criarRestricoes(Favorito favorito, CriteriaBuilder builder, Root<Favorito> root) {
		List<Predicate> predicates = new ArrayList<>();

		if (!StringUtils.isEmpty(favorito.getUid())) {
			predicates.add(builder.equal(root.get("uid"), favorito.getUid()));
		}

		if (favorito.getEvento() != null && favorito.getEvento().getId() != null) {
			predicates.add(builder.equal(root.get("evento").get("id"), favorito.getEvento().getId()));
		}

		return predicates.toArray(new Predicate[predicates.size()]);
	}

}
