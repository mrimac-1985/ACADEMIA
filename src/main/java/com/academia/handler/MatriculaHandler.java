package com.academia.handler;

import static org.springframework.web.reactive.function.BodyInserters.fromValue;

import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.academia.document.Curso;
import com.academia.document.Matricula;
import com.academia.service.IMatriculaService;

import reactor.core.publisher.Mono;

@Component
public class MatriculaHandler {

	private static final Logger log = LoggerFactory.getLogger(MatriculaHandler.class);
	
	
	@Autowired
	private IMatriculaService service;
	
	
	public Mono<ServerResponse> listar(ServerRequest req){	
		return ServerResponse
				.ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(service.listar(), Curso.class);		
	}
	
	
	public Mono<ServerResponse> listarPorId(ServerRequest req){
		String id = req.pathVariable("id");
		return service.listarPorId(id)
				.flatMap(p -> ServerResponse
								.ok()
								.contentType(MediaType.APPLICATION_JSON)
								.body(fromValue(p))
				)				
				.switchIfEmpty(ServerResponse
							.notFound()
							.build()
				);
	}
	
	public Mono<ServerResponse> registrar(ServerRequest req){
		
		Mono<Matricula> matriculaMono = req.bodyToMono(Matricula.class);
		
		return matriculaMono.flatMap(c-> {
			return service.registrar(c);
		}).flatMap(c -> ServerResponse.created(URI.create(req.uri().toString().concat("/").concat(c.getId())))
				.contentType(MediaType.APPLICATION_JSON)
				.body(fromValue(c)));
	}
	
	public Mono<ServerResponse> modificar(ServerRequest req){
		
		Mono<Matricula> matriculaMono = req.bodyToMono(Matricula.class);
		
		return matriculaMono.flatMap(c-> {
			return service.modificar(c);
		}).flatMap(c -> ServerResponse.ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(fromValue(c)));
	}
	
	public Mono<ServerResponse> eliminar(ServerRequest req){
		String id = req.pathVariable("id");
		
		return service.listarPorId(id)
				.flatMap(c -> service.eliminar(c.getId())
				.then(ServerResponse
						.noContent()
						.build()
				)
				.switchIfEmpty(ServerResponse
						.notFound()
						.build()
				)
			);
	}
	
	
}
