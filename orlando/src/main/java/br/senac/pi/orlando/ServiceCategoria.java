package br.senac.pi.orlando;

import java.util.ArrayList;
import java.util.List;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("Categoria")
public class ServiceCategoria {
	private static List<Categoria> Lista = new ArrayList<Categoria>();

	@GET
	public List<Categoria> getAll() {
		return Lista;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void inserir(Categoria categoria) {
		Lista.add(categoria);
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void atualizar(Categoria categoria) {
		for (int i = 0; i < Lista.size(); i++) {
			Categoria AvaBusca = Lista.get(i);
			if (AvaBusca.getId() == categoria.getId()) {
				AvaBusca.setFilme(categoria.getFilme());
				AvaBusca.setSerie(categoria.getSerie());
				AvaBusca.setJogo(categoria.getJogo());
				AvaBusca.setLivro(categoria.getLivro());
				AvaBusca.setRestaurante(categoria.getRestaurante());
				AvaBusca.setOutros(categoria.getOutros());
				break;
			}
		}
	}
	
	@DELETE	
	@Consumes(MediaType.APPLICATION_JSON)
	public void excluir(@QueryParam("id") int id) {
		int pos = -1;
		for (int i = 0; i <Lista.size(); i++) {
			Categoria categoria = Lista.get(i);
			if(categoria.getId() == id) {
				pos = i;
				break;
			}
		}
	
		if (pos >= 0) {
			Lista.remove(pos);
		}
		
	}

}