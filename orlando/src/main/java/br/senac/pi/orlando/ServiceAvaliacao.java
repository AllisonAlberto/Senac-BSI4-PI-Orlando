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

@Path("avaliacao")
public class ServiceAvaliacao {
	
	private static List<Avaliacao> lista = new ArrayList<Avaliacao>();
	
	@GET
	public List<Avaliacao> getAll(){
		return lista;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void inserir(Avaliacao avaliacao) {
		lista.add(avaliacao);
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void atualizar(Avaliacao avaliacao) {
		for (int i = 0; i < lista.size(); i++) {
			Avaliacao avaBusca = lista.get(i);
			if (avaBusca.getId() == avaliacao.getId()) {
				avaBusca.setCategoria(avaliacao.getCategoria());
				avaBusca.setTitulo(avaliacao.getTitulo());
				avaBusca.setComentario(avaliacao.getComentario());
				avaBusca.setNota(avaliacao.getNota());
				avaBusca.setPreco(avaliacao.getPreco());
				break;
			}
		}
	}

	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public void excluir(@QueryParam("id") int id) {
		int pos = -1;
		for (int i = 0; i < lista.size(); i++) {
			Avaliacao avaliacao = lista.get(i);
			if(avaliacao.getId() == id) {
				pos = i;
				break;
			}
		}
		
		if (pos >= 0) {
			lista.remove(pos);
		}
	}
}
