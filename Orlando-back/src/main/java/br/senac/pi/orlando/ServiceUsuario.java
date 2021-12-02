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

@Path("usuario")
public class ServiceUsuario {
	
	@GET
	public List<Usuario> listar() {
		try {
			return DaoUsuario.listar();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("nome")
	public List<Usuario> buscarByNome(@QueryParam("nome") String nome) {
		try {
			return DaoUsuario.buscarByNome(nome);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("id")
	public List<Usuario> buscarById(@QueryParam("id") long id) {
		try {
			return DaoUsuario.buscarById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void inserir(Usuario usuario) {
		try {
			DaoUsuario.inserir(usuario);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void atualizar(Usuario usuario) {
		try {
			DaoUsuario.atualizar(usuario);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@DELETE	
	@Consumes(MediaType.APPLICATION_JSON)
	public void excluir(@QueryParam("id") long id) {
		try {
			DaoUsuario.excluir(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
