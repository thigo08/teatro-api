package com.brasilia.teatro.api.repository.favorito;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.brasilia.teatro.api.model.Evento;
import com.brasilia.teatro.api.model.Favorito;

public class FavoritoRepositoryImpl implements FavoritoRepositoryQuery {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<Evento> buscarEventosFavoritoPorUsuario(String codigoUsuario) {

		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Evento> criteria = builder.createQuery(Evento.class);
		Root<Evento> root = criteria.from(Evento.class);
		Join<Evento, Favorito> join = root.join("favoritos");

		Predicate predicate = builder.equal(join.get("uid"), codigoUsuario);
		criteria.where(predicate);

		TypedQuery<Evento> query = manager.createQuery(criteria);

		return query.getResultList();
	}

	@Override
	@Transactional
	public void deletar(Favorito favorito) {
		Favorito favoritoSalvo = this.buscarFavorito(favorito);

		Query query = manager.createNativeQuery("DELETE FROM favorito where id= :id").setParameter("id",
				favoritoSalvo.getId());
		query.executeUpdate();

	}

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
