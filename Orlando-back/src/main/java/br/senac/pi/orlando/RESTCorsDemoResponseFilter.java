package br.senac.pi.orlando;

import java.io.IOException;
import java.util.logging.Logger;

import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerResponseContext;
import jakarta.ws.rs.container.ContainerResponseFilter;
import jakarta.ws.rs.container.PreMatching;
import jakarta.ws.rs.ext.Provider;

@Provider
@PreMatching
public class RESTCorsDemoResponseFilter implements ContainerResponseFilter {

	private final static Logger log = Logger.getLogger(RESTCorsDemoResponseFilter.class.getName());

	@Override
	public void filter(ContainerRequestContext requestCtx, ContainerResponseContext responseCtx) throws IOException {
		log.info("Executing REST response filter");

		responseCtx.getHeaders().add("Access-Control-Allow-Origin", "*");
		responseCtx.getHeaders().add("Access-Control-Allow-Headers", "origin, content-type, accept, authorization");
		responseCtx.getHeaders().add("Access-Control-Allow-Credentials", "true");
		responseCtx.getHeaders().add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
	}
}