package br.senac.pi.orlando;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DaoUsuario {
	
	public static List<Usuario> listar() throws Exception {
		String sql = "SELECT * FROM tb_usuario";
		
		List<Usuario> resultado = new ArrayList<Usuario>();
		
		try(PreparedStatement ps = DB.connect().prepareStatement(sql)) {
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Usuario usuario = new Usuario();
				
				usuario.setId(rs.getLong("id_usuario"));
				usuario.setNome(rs.getString("nome"));	
				usuario.setUsuario(rs.getString("usuario"));
				usuario.setSenha(rs.getString("senha"));	
				usuario.setDtNascimento(rs.getString("dtNascimento"));

				resultado.add(usuario);
			}
		}
		
		return resultado;
		
	}
	
	
	public static List<Usuario> buscarByNome(String nome) throws Exception {
		String sql = "SELECT * FROM tb_usuario WHERE nome LIKE ?";
		
		List<Usuario> resultado = new ArrayList<Usuario>();
		
		try(PreparedStatement ps = DB.connect().prepareStatement(sql)) {
			ps.setString(1, nome);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Usuario usuario = new Usuario();
				
				usuario.setId(rs.getLong("id_usuario"));
				usuario.setNome(rs.getString("nome"));	
				usuario.setUsuario(rs.getString("usuario"));
				usuario.setSenha(rs.getString("senha"));	
				usuario.setDtNascimento(rs.getString("dtNascimento"));

				resultado.add(usuario);
			}
		}
		
		return resultado;
		
	}
	
	public static List<Usuario> buscarById(long id) throws Exception {
		String sql = "SELECT * FROM tb_usuario WHERE id_usuario = ?";
		
		List<Usuario> resultado = new ArrayList<Usuario>();
		
		try(PreparedStatement ps = DB.connect().prepareStatement(sql)) {
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
				
			while(rs.next()) {
				Usuario usuario = new Usuario();
				
				usuario.setId(rs.getLong("id_usuario"));
				usuario.setNome(rs.getString("nome"));	
				usuario.setUsuario(rs.getString("usuario"));
				usuario.setSenha(rs.getString("senha"));	
				usuario.setDtNascimento(rs.getString("dtNascimento"));

				resultado.add(usuario);
			}

		}
		
		return resultado;
		
	}
	
	public static void inserir(Usuario usuario) throws Exception {
		String sql = "INSERT INTO tb_usuario (nome, usuario, senha, dtNascimento)"
				+ "VALUES (?, ?, ?, ?)";
		
		try (PreparedStatement ps = DB.connect().prepareStatement(sql)) {
			ps.setString(1, usuario.getNome());
			ps.setString(2, usuario.getUsuario());
			ps.setString(3, usuario.getSenha());
			ps.setString(4, usuario.getDtNascimento());
			
			ps.execute();
		}
	}
	
	public static void atualizar(Usuario usuario) throws Exception {
		String sql = "UPDATE tb_usuario SET nome = ?, usuario = ?, senha = ?, "
				+ "dtNascimento = ? WHERE id_usuario = ?";
		
		try (PreparedStatement ps = DB.connect().prepareStatement(sql)) {
			ps.setString(1, usuario.getNome());
			ps.setString(2, usuario.getUsuario());
			ps.setString(3, usuario.getSenha());
			ps.setString(4, usuario.getDtNascimento());
			ps.setLong(5, usuario.getId());
			
			ps.execute();
		}
	}
	
	public static void excluir(long id) throws Exception {
		String sql = "DELETE FROM tb_usuario WHERE id_usuario = ?";
		
		try (PreparedStatement ps = DB.connect().prepareStatement(sql)) {
			ps.setLong(1, id);
			
			ps.execute();
		}
	}

}