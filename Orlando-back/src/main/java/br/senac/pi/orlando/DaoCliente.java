package br.senac.pi.orlando;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DaoCliente {
	
	public static List<Cliente> listar() throws Exception {
		String sql = "SELECT * FROM tb_cliente";
		
		List<Cliente> resultado = new ArrayList<Cliente>();
		
		try(PreparedStatement ps = DB.connect().prepareStatement(sql)) {
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Cliente cliente = new Cliente();
				
				cliente.setId(rs.getLong("id_cliente"));
			    cliente.setNome(rs.getString("nome"));	
				cliente.setUsuario(rs.getString("usuario"));
				cliente.setSenha(rs.getString("senha"));	
				cliente.setCnpj(rs.getString("cnpj"));

				resultado.add(cliente);
			}
		}
		
		return resultado;
		
	}
	
	
	public static List<Cliente> buscarByNome(String nome) throws Exception {
		String sql = "SELECT * FROM tb_cliente WHERE nome LIKE ?";
		
		List<Cliente> resultado = new ArrayList<Cliente>();
		
		try(PreparedStatement ps = DB.connect().prepareStatement(sql)) {
			ps.setString(1, nome);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Cliente cliente = new Cliente();
				
				cliente.setId(rs.getLong("id_cliente"));
			    cliente.setNome(rs.getString("nome"));	
				cliente.setUsuario(rs.getString("usuario"));
				cliente.setSenha(rs.getString("senha"));	
				cliente.setCnpj(rs.getString("cnpj"));

				resultado.add(cliente);
			}
		}
		
		return resultado;
		
	}
	
	public static List<Cliente> buscarById(long id) throws Exception {
		String sql = "SELECT * FROM tb_cliente WHERE id_cliente = ?";
		
		List<Cliente> resultado = new ArrayList<Cliente>();
		
		try(PreparedStatement ps = DB.connect().prepareStatement(sql)) {
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
				
			while(rs.next()) {
				Cliente cliente = new Cliente();
				
				cliente.setId(rs.getLong("id_cliente"));
			    cliente.setNome(rs.getString("nome"));	
				cliente.setUsuario(rs.getString("usuario"));
				cliente.setSenha(rs.getString("senha"));	
				cliente.setCnpj(rs.getString("cnpj"));

				resultado.add(cliente);
			}

		}
		
		return resultado;
		
	}
	
	public static void inserir(Cliente cliente) throws Exception {
		String sql = "INSERT INTO tb_Cliente (nome, usuario, senha, cnpj)"
				+ "VALUES (?, ?, ?, ?)";
		
		try (PreparedStatement ps = DB.connect().prepareStatement(sql)) {
			ps.setString(1, cliente.getNome());
			ps.setString(2, cliente.getUsuario());
			ps.setString(3, cliente.getSenha());
			ps.setString(4, cliente.getCnpj());
			
			ps.execute();
		}
	}
	
	public static void atualizar(Cliente cliente) throws Exception {
		String sql = "UPDATE tb_Cliente SET nome = ?, usuario = ?, senha = ?, "
				+ "cnpj = ? WHERE id_Cliente = ?";
		
		try (PreparedStatement ps = DB.connect().prepareStatement(sql)) {
			
			ps.setString(1, cliente.getNome());
			ps.setString(2, cliente.getUsuario());
			ps.setString(3, cliente.getSenha());
			ps.setString(4, cliente.getCnpj());
			ps.setLong(5, cliente.getId());
			
			ps.execute();
		}
	}
	
	public static void excluir(long id) throws Exception {
		String sql = "DELETE FROM tb_cliente WHERE id_cliente = ?";
		
		try (PreparedStatement ps = DB.connect().prepareStatement(sql)) {
			ps.setLong(1, id);
			
			ps.execute();
		}
	}

}
