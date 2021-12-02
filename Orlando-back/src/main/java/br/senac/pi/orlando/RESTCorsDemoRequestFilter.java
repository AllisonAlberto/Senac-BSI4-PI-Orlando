package br.senac.pi.orlando;
 
import java.io.IOException;
import java.util.logging.Logger;

import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.container.PreMatching;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;
 
@Provider
@PreMatching
public class RESTCorsDemoRequestFilter implements ContainerRequestFilter {
 
    private final static Logger log = Logger.getLogger( RESTCorsDemoRequestFilter.class.getName() );
 
    @Override
    public void filter( ContainerRequestContext requestCtx ) throws IOException {
        log.info( "Executing REST request filter" );
 
        // Quando HttpMethod vier como OPTIONS, informar que aceita o envio...
        if ( requestCtx.getRequest().getMethod().equals( "OPTIONS" ) ) {
            log.info( "HTTP Method (OPTIONS) - Detected!" );
 
            // Just send a OK signal back to the browser
            requestCtx.abortWith( Response.status( Response.Status.OK ).build() );
        }
    }
}