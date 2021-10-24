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

@Path("categoria")
public class ServiceCategoria {
	
	@GET
	public List<Categoria> listar() {
		try {
			return DaoCategoria.listar();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("tipo")
	public List<Categoria> buscarByTipo(@QueryParam("tipo") String tipo) {
		try {
			return DaoCategoria.buscarByTipo(tipo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("id")
	public List<Categoria> buscarById(@QueryParam("id") long id) {
		try {
			return DaoCategoria.buscarById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void inserir(Categoria categoria) {
		try {
			DaoCategoria.inserir(categoria);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void atualizar(Categoria categoria) {
		try {
			DaoCategoria.atualizar(categoria);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@DELETE	
	@Consumes(MediaType.APPLICATION_JSON)
	public void excluir(@QueryParam("id") long id) {
		try {
			DaoCategoria.excluir(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}