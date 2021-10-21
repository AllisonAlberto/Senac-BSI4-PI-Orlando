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

@Path("Usuario")
public class ServiceUsuario {

	private static List<Usuario> Lista = new ArrayList<Usuario>();

	@GET
	public List<Usuario> getAll() {
		return Lista;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void inserir(Usuario usuario) {
		Lista.add(usuario);
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void atualizar(Usuario usuario) {
		for (int i = 0; i < Lista.size(); i++) {
			Usuario AvaBusca = Lista.get(i);
			if (AvaBusca.getId() == usuario.getId()) {
				AvaBusca.setNome(usuario.getNome());
				AvaBusca.setUsuario(usuario.getUsuario());
				AvaBusca.setSenha(usuario.getSenha());
				AvaBusca.setDtNascimento(usuario.getDtNascimento());
				break;
			}
		}
	}
	
	@DELETE	
	@Consumes(MediaType.APPLICATION_JSON)
	public void excluir(@QueryParam("id") int id) {
		int pos = -1;
		for (int i = 0; i <Lista.size(); i++) {
			Usuario usuario = Lista.get(i);
			if(usuario.getId() == id) {
				pos = i;
				break;
			}
		}
	
		if (pos >= 0) {
			Lista.remove(pos);
		}
		
	}

}