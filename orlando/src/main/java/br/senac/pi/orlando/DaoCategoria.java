package br.senac.pi.orlando;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DaoCategoria {
	
	public static List<Categoria> listar() throws Exception {
		String sql = "SELECT * FROM tb_categoria";
		
		List<Categoria> resultado = new ArrayList<Categoria>();
		
		try(PreparedStatement ps = DB.connect().prepareStatement(sql)) {
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Categoria categoria = new Categoria();
				
				categoria.setId(rs.getLong("id_categoria"));
				categoria.setTipo(rs.getString("tipo"));	
				categoria.setDescricao(rs.getString("descricao"));

				resultado.add(categoria);
			}
		}
		
		return resultado;
		
	}
	
	public static List<Categoria> buscarByTipo(String tipo) throws Exception {
		String sql = "SELECT * FROM tb_categoria WHERE tipo LIKE ?";
		
		List<Categoria> resultado = new ArrayList<Categoria>();
		
		try(PreparedStatement ps = DB.connect().prepareStatement(sql)) {
			ps.setString(1, tipo);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Categoria categoria = new Categoria();
				
				categoria.setId(rs.getLong("id_categoria"));
				categoria.setTipo(rs.getString("tipo"));	
				categoria.setDescricao(rs.getString("descricao"));

				resultado.add(categoria);
			}
		}
		
		return resultado;
		
	}
	
	public static List<Categoria> buscarById(long id) throws Exception {
		String sql = "SELECT * FROM tb_categoria WHERE id_categoria = ?";
		
		List<Categoria> resultado = new ArrayList<Categoria>();
		
		try(PreparedStatement ps = DB.connect().prepareStatement(sql)) {
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
				
			while(rs.next()) {
				Categoria categoria = new Categoria();
				
				categoria.setId(rs.getLong("id_categoria"));
				categoria.setTipo(rs.getString("tipo"));	
				categoria.setDescricao(rs.getString("descricao"));

				resultado.add(categoria);
			}

		}
		
		return resultado;
		
	}

	public static void inserir(Categoria categoria) throws Exception {
		String sql = "INSERT INTO tb_categoria (tipo, descricao) VALUES (?, ?)";
		
		try (PreparedStatement ps = DB.connect().prepareStatement(sql)) {
			ps.setString(1, categoria.getTipo());
			ps.setString(2, categoria.getDescricao());
			
			ps.execute();
		}
	}
	
	public static void atualizar(Categoria categoria) throws Exception {
		String sql = "UPDATE tb_categoria SET tipo = ?, descricao = ? "
				+ "WHERE id_categoria = ?";
		
		try (PreparedStatement ps = DB.connect().prepareStatement(sql)) {
			ps.setString(1, categoria.getTipo());
			ps.setString(2, categoria.getDescricao());
			ps.setLong(3, categoria.getId());
			
			ps.execute();
		}
	}
	
	public static void excluir(long id) throws Exception {
		String sql = "DELETE FROM tb_categoria WHERE id_categoria = ?";
		
		try (PreparedStatement ps = DB.connect().prepareStatement(sql)) {
			ps.setLong(1, id);
			
			ps.execute();
		}
	}

}