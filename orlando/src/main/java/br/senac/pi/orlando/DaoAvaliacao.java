package br.senac.pi.orlando;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DaoAvaliacao {
	
	public static List<Avaliacao> listar() throws Exception {
		String sql = "SELECT * FROM ((tb_avaliacao INNER JOIN tb_usuario "
				+ "ON tb_avaliacao.usuario_id = tb_usuario.id_usuario) "
				+ "INNER JOIN tb_categoria "
				+ "ON tb_avaliacao.categoria_id = tb_categoria.id_categoria)";
		
		List<Avaliacao> resultado = new ArrayList<Avaliacao>();
		
		try(PreparedStatement ps = DB.connect().prepareStatement(sql)) {
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Avaliacao avaliacao = new Avaliacao();
				Categoria categoria = new Categoria();
				Usuario usuario = new Usuario();
				
				
				avaliacao.setId(rs.getLong("id_avaliacao"));
				
				usuario.setId(rs.getLong("id_usuario"));
				usuario.setNome(rs.getString("nome"));	
				usuario.setUsuario(rs.getString("usuario"));
				usuario.setSenha(rs.getString("senha"));	
				usuario.setDtNascimento(rs.getString("dtNascimento"));
				avaliacao.setUsuario(usuario);
				
				categoria.setId(rs.getLong("id_categoria"));
				categoria.setTipo(rs.getString("tipo"));	
				categoria.setDescricao(rs.getString("descricao"));
				avaliacao.setCategoria(categoria);
				
				avaliacao.setTitulo(rs.getString("titulo"));
				avaliacao.setComentario(rs.getString("comentario"));	
				avaliacao.setNota(rs.getInt("nota"));
				avaliacao.setDuracao(rs.getInt("duracao"));
				avaliacao.setValor(rs.getFloat("valor"));	
				avaliacao.setDataAtividade(rs.getString("dataAtividade"));

				resultado.add(avaliacao);
			}
		}
		
		return resultado;
		
	}
	
	public static List<Avaliacao> buscarById(long id) throws Exception {
		String sql = "SELECT * FROM ((tb_avaliacao INNER JOIN tb_usuario "
				+ "ON tb_avaliacao.usuario_id = tb_usuario.id_usuario) "
				+ "INNER JOIN tb_categoria "
				+ "ON tb_avaliacao.categoria_id = tb_categoria.id_categoria) "
				+ "WHERE id_avaliacao = ?";
		
		List<Avaliacao> resultado = new ArrayList<Avaliacao>();
		
		try(PreparedStatement ps = DB.connect().prepareStatement(sql)) {
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
				
			while(rs.next()) {
				Avaliacao avaliacao = new Avaliacao();
				Categoria categoria = new Categoria();
				Usuario usuario = new Usuario();
				
				
				avaliacao.setId(rs.getLong("id_avaliacao"));
				
				usuario.setId(rs.getLong("id_usuario"));
				usuario.setNome(rs.getString("nome"));	
				usuario.setUsuario(rs.getString("usuario"));
				usuario.setSenha(rs.getString("senha"));	
				usuario.setDtNascimento(rs.getString("dtNascimento"));
				avaliacao.setUsuario(usuario);
				
				categoria.setId(rs.getLong("id_categoria"));
				categoria.setTipo(rs.getString("tipo"));	
				categoria.setDescricao(rs.getString("descricao"));
				avaliacao.setCategoria(categoria);
				
				avaliacao.setTitulo(rs.getString("titulo"));
				avaliacao.setComentario(rs.getString("comentario"));	
				avaliacao.setNota(rs.getInt("nota"));
				avaliacao.setDuracao(rs.getInt("duracao"));
				avaliacao.setValor(rs.getFloat("valor"));	
				avaliacao.setDataAtividade(rs.getString("dataAtividade"));

				resultado.add(avaliacao);
			}
		}
		
		return resultado;
		
	}
	
	public static void inserir(Avaliacao avalicacao) throws Exception {
		String sql = "INSERT INTO tb_avaliacao (usuario_id, categoria_id, "
				+ "titulo, comentario, nota, duracao, valor, dataAtividade)"
				+ "	VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		
		try (PreparedStatement ps = DB.connect().prepareStatement(sql)) {
			ps.setLong(1, avalicacao.getUsuario().getId());
			ps.setLong(2, avalicacao.getCategoria().getId());
			ps.setString(3, avalicacao.getTitulo());
			ps.setString(4, avalicacao.getComentario());
			ps.setInt(5, avalicacao.getNota());
			ps.setInt(6, avalicacao.getDuracao());
			ps.setFloat(7, avalicacao.getValor());
			ps.setString(8, avalicacao.getDataAtividade());
			
			ps.execute();
		}
	}
	
	public static void atualizar(Avaliacao avalicacao) throws Exception {
		String sql = "UPDATE tb_avaliacao SET usuario_id = ?, categoria_id = ?, "
				+ "titulo = ?, comentario = ?, nota = ?, duracao = ?, valor = ?, "
				+ "dataAtividade =? WHERE id_avaliacao = ?";
		
		try (PreparedStatement ps = DB.connect().prepareStatement(sql)) {
			ps.setLong(1, avalicacao.getUsuario().getId());
			ps.setLong(2, avalicacao.getCategoria().getId());
			ps.setString(3, avalicacao.getTitulo());
			ps.setString(4, avalicacao.getComentario());
			ps.setInt(5, avalicacao.getNota());
			ps.setInt(6, avalicacao.getDuracao());
			ps.setFloat(7, avalicacao.getValor());
			ps.setString(8, avalicacao.getDataAtividade());
			ps.setFloat(9, avalicacao.getId());
			
			ps.execute();
		}
	}
	
	public static void excluir(long id) throws Exception {
		String sql = "DELETE FROM tb_avaliacao WHERE id_avaliacao = ?";
		
		try (PreparedStatement ps = DB.connect().prepareStatement(sql)) {
			ps.setLong(1, id);
			
			ps.execute();
		}
	}

}