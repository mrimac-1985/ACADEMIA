package com.academia.service.impl;

import java.util.stream.Collectors;

import org.springframework.data.domain.Pageable;

import com.academia.pagination.PageSupport;
import com.academia.repo.IGenericRepo;
import com.academia.service.ICRUD;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public abstract class ICRUDImpl<T, ID> implements ICRUD<T, ID> {
	
	protected abstract IGenericRepo<T, ID> getRepo();

	@Override
	public Mono<T> registrar(T t) {
		return getRepo().save(t);
	}

	@Override
	public Mono<T> modificar(T t) {
		return getRepo().save(t);
	}

	@Override
	public Flux<T> listar() {
		return getRepo().findAll();
	}

	@Override
	public Mono<T> listarPorId(ID v) {
		return getRepo().findById(v);
	}

	@Override
	public Mono<Void> eliminar(ID v) {
		return getRepo().deleteById(v);		
		/*return getRepo().findById(v)
				.flatMap(x -> getRepo().deleteById(v));*/
	}
	
	@Override
	public Mono<PageSupport<T>> listarPage(Pageable page){
		return getRepo().findAll()
				.collectList()
				.map(list -> new PageSupport<>(
						list
						.stream()
						.skip(page.getPageNumber() * page.getPageSize())
						.limit(page.getPageSize())
						.collect(Collectors.toList()),
					page.getPageNumber(), page.getPageSize(), list.size()	
					));
	}

}
