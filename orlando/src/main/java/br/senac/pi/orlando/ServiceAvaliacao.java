package br.senac.pi.orlando;

import java.util.List;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("avaliacao")
public class ServiceAvaliacao {
		
	@GET
	public List<Avaliacao> listar(){
		try {
			return DaoAvaliacao.listar();
		} catch (Exception e) {

			e.printStackTrace();
		}
		
		return null;
		
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void inserir(Avaliacao avaliacao) {
		try {
			DaoAvaliacao.inserir(avaliacao);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
