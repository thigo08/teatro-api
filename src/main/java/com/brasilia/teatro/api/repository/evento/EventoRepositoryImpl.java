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

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;

import com.brasilia.teatro.api.model.Evento;
import com.brasilia.teatro.api.repository.filter.EventoFilter;

public class EventoRepositoryImpl implements EventoRepositoryQuery {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<Evento> buscarPaginado(Pageable pageable) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Evento> criteria = builder.createQuery(Evento.class);
		Root<Evento> root = criteria.from(Evento.class);

		TypedQuery<Evento> query = manager.createQuery(criteria);
		adicionarRestricoesDePaginacao(query, pageable);

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
	public List<Evento> filtrar(EventoFilter eventoFilter) {
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

}
