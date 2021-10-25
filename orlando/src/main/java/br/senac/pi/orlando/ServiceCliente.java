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

@Path("cliente")
public class ServiceCliente {
	
	@GET
	public List<Cliente> listar() {
		try {
			return DaoCliente.listar();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("nome")
	public List<Cliente> buscarByNome(@QueryParam("nome") String nome) {
		try {
			return DaoCliente.buscarByNome(nome);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("id")
	public List<Cliente> buscarById(@QueryParam("id") long id) {
		try {
			return DaoCliente.buscarById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void inserir(Cliente cliente) {
		try {
			DaoCliente.inserir(cliente);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void atualizar(Cliente cliente) {
		try {
			DaoCliente.atualizar(cliente);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@DELETE	
	@Consumes(MediaType.APPLICATION_JSON)
	public void excluir(@QueryParam("id") long id) {
		try {
			DaoCliente.excluir(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
