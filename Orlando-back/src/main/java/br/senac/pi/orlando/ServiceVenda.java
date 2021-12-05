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

@Path("venda")
public class ServiceVenda {
		
	@GET
	public List<Venda> listar(){
		try {
			return DaoVenda.listar();
		} catch (Exception e) {

			e.printStackTrace();
		}
		
		return null;
		
	}
	
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("id")
	public List<Venda> buscarById(@QueryParam("id") long id) {
		try {
			return DaoVenda.buscarById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("relatorio")
	public List<Venda> relatorio(@QueryParam("preco") float preco, @QueryParam("datavenda") String datavenda) {
		try {
			return DaoVenda.relatorio(preco, datavenda);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
		
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void inserir(Venda venda) {
		try {
			DaoVenda.inserir(venda);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void atualizar(Venda venda) {
		try {
			DaoVenda.atualizar(venda);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@DELETE	
	@Consumes(MediaType.APPLICATION_JSON)
	public void excluir(@QueryParam("id") long id) {
		try {
			DaoVenda.excluir(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
