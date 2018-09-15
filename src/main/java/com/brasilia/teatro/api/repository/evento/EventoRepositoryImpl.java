package com.brasilia.teatro.api.repository.evento;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;

import com.brasilia.teatro.api.model.Evento;
import com.brasilia.teatro.api.model.Favorito;
import com.brasilia.teatro.api.model.Genero;
import com.brasilia.teatro.api.repository.filter.EventoFilter;

public class EventoRepositoryImpl implements EventoRepositoryQuery {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<Evento> listarEventos(String uid) {
		TypedQuery<Object[]> query = manager.createQuery(
				"SELECT ev , (SELECT CASE WHEN (count(*) > 0) THEN true else false end FROM Favorito AS f WHERE f.uid=:uid and f.evento.id = ev.id)  FROM Evento AS ev",
				Object[].class);
		query.setParameter("uid", uid);

		List<Object[]> results = query.getResultList();
		List<Evento> eventos = new ArrayList<>();

		for (Object[] result : results) {
			Evento ev = (Evento) result[0];
			ev.setFavoritado((boolean) result[1]);

			eventos.add(ev);
		}
		return eventos;
	}

	@Override
	public List<Evento> buscarEventosFavoritoPorUsuario(String uid) {
		TypedQuery<Object[]> query = manager.createQuery(
				"SELECT ev , (SELECT CASE WHEN (count(*) > 0) THEN true else false end FROM Favorito AS fa WHERE fa.uid=:uid and fa.evento.id = ev.id) "
						+ "FROM Evento AS ev, Favorito as f " + "WHERE ev.id=f.evento.id AND f.uid=:uid",
				Object[].class);
		query.setParameter("uid", uid);

		List<Object[]> results = query.getResultList();
		List<Evento> eventos = new ArrayList<>();

		for (Object[] result : results) {
			Evento ev = (Evento) result[0];
			ev.setFavoritado((boolean) result[1]);

			eventos.add(ev);
		}
		return eventos;
	}

	@Override
	public List<Evento> filtrarComUsuarioLogado(String uid, EventoFilter eventoFilter) {
		this.removerSelecaoTodos(eventoFilter);
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Object[]> criteria = builder.createQuery(Object[].class);
		Root<Evento> root = criteria.from(Evento.class);

		Subquery<Long> scount = criteria.subquery(Long.class);
		Root<Favorito> sarticolo = scount.from(Favorito.class);
		scount.select(builder.count(sarticolo));
		scount.where(builder.equal(sarticolo.get("uid"), uid),
				builder.equal(sarticolo.get("evento").get("id"), root.get("id")));

		criteria.multiselect(root, builder.selectCase().when(builder.greaterThan(scount, 0L), true).otherwise(false));

		Predicate[] predicates = criarRestricoes(eventoFilter, builder, root);
		criteria.where(predicates);

		TypedQuery<Object[]> query = manager.createQuery(criteria);
		List<Object[]> results = query.getResultList();
		List<Evento> eventos = new ArrayList<>();

		for (Object[] result : results) {
			Evento ev = (Evento) result[0];
			ev.setFavoritado((boolean) result[1]);

			eventos.add(ev);
		}
		// adicionarRestricoesDePaginacao(query, pageable);

		return eventos;
	}

	@Override
	public List<Evento> filtrar(EventoFilter eventoFilter) {
		this.removerSelecaoTodos(eventoFilter);

		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Evento> criteria = builder.createQuery(Evento.class);
		Root<Evento> root = criteria.from(Evento.class);

		Predicate[] predicates = criarRestricoes(eventoFilter, builder, root);
		criteria.where(predicates);

		TypedQuery<Evento> query = manager.createQuery(criteria);
		// adicionarRestricoesDePaginacao(query, pageable);

		return query.getResultList();
	}

	@Override
	public Page<Evento> findAllPaged(Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Evento> criteria = builder.createQuery(Evento.class);
		Root<Evento> root = criteria.from(Evento.class);

		TypedQuery<Evento> query = manager.createQuery(criteria);
		adicionarRestricoesDePaginacao(query, pageable);

		return new PageImpl<>(query.getResultList(), pageable, total());
	}

	@Override
	public List<Evento> buscarPaginado(Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Evento> criteria = builder.createQuery(Evento.class);
		Root<Evento> root = criteria.from(Evento.class);

		TypedQuery<Evento> query = manager.createQuery(criteria);
		adicionarRestricoesDePaginacao(query, pageable);

		return query.getResultList();
	}

	private void adicionarRestricoesDePaginacao(TypedQuery<?> query, Pageable pageable) {
		int paginaAtual = pageable.getPageNumber();
		int totalRegistrosPorPagina = pageable.getPageSize();
		int primeiroRegistroDaPagina = paginaAtual * totalRegistrosPorPagina;

		query.setFirstResult(primeiroRegistroDaPagina);
		query.setMaxResults(totalRegistrosPorPagina);
	}

	private Long total() {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<Evento> root = criteria.from(Evento.class);

		criteria.select(builder.count(root));
		return manager.createQuery(criteria).getSingleResult();
	}

	private Predicate[] criarRestricoes(EventoFilter eventoFilter, CriteriaBuilder builder, Root<Evento> root) {
		List<Predicate> predicates = new ArrayList<>();

		if (!StringUtils.isEmpty(eventoFilter.getNome())) {
			predicates.add(
					builder.like(builder.lower(root.get("nome")), "%" + eventoFilter.getNome().toLowerCase() + "%"));
		}

		if (!StringUtils.isEmpty(eventoFilter.getDescricao())) {
			predicates.add(builder.like(builder.lower(root.get("descricao")),
					"%" + eventoFilter.getDescricao().toLowerCase() + "%"));
		}

		if (!StringUtils.isEmpty(eventoFilter.getGenero())) {
			predicates.add(builder.equal(root.get("genero"), eventoFilter.getGenero()));
		}

		if (!StringUtils.isEmpty(eventoFilter.getNomeLocal())) {
			predicates.add(builder.like(builder.lower(root.get("local").get("nome")),
					"%" + eventoFilter.getNomeLocal().toLowerCase() + "%"));
		}

		if (!StringUtils.isEmpty(eventoFilter.getEstadoLocal())) {
			predicates.add(builder.like(builder.lower(root.get("local").get("estado")),
					"%" + eventoFilter.getEstadoLocal().toLowerCase() + "%"));
		}

		return predicates.toArray(new Predicate[predicates.size()]);
	}

	private void removerSelecaoTodos(EventoFilter eventoFilter) {
		if (eventoFilter.getNomeLocal().equals("Todos")) {
			eventoFilter.setNomeLocal(null);
		}

		if (eventoFilter.getGenero().equals(Genero.TODOS)) {
			eventoFilter.setGenero(null);
		}

	}

}
