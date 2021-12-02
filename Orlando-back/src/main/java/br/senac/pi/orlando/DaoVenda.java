package br.senac.pi.orlando;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DaoVenda {
	
	public static List<Venda> listar() throws Exception {
		String sql = "SELECT * FROM tb_venda INNER JOIN tb_cliente "
				+ "ON tb_venda.cliente_id = tb_cliente.id_cliente";
		
		List<Venda> resultado = new ArrayList<Venda>();
		
		try(PreparedStatement ps = DB.connect().prepareStatement(sql)) {
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Venda venda = new Venda();
				Cliente cliente = new Cliente();
				
				
				venda.setId(rs.getLong("id_venda"));
				
				cliente.setId(rs.getLong("id_cliente"));
			    cliente.setNome(rs.getString("nome"));	
				cliente.setUsuario(rs.getString("usuario"));
				cliente.setSenha(rs.getString("senha"));	
				cliente.setCnpj(rs.getString("cnpj"));
				venda.setCliente(cliente);
				
		
				venda.setProduto(rs.getString("produto"));	
				venda.setPreco(rs.getFloat("preco"));
				venda.setDataVenda(rs.getString("dataVenda"));


				resultado.add(venda);
			}
		}
		
		return resultado;
		
	}
	
	public static List<Venda> buscarById(long id) throws Exception {
		String sql = "SELECT * FROM tb_venda INNER JOIN tb_cliente "
				+ "ON tb_venda.cliente_id = tb_cliente.id_cliente "
				+ "WHERE id_venda = ?";
		
		List<Venda> resultado = new ArrayList<Venda>();
		
		try(PreparedStatement ps = DB.connect().prepareStatement(sql)) {
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
				
			while(rs.next()) {
				Venda venda = new Venda();
				Cliente cliente = new Cliente();
				
				
				venda.setId(rs.getLong("id_venda"));
				
				cliente.setId(rs.getLong("id_cliente"));
				cliente.setNome(rs.getString("nome"));	
				cliente.setUsuario(rs.getString("usuario"));
				cliente.setSenha(rs.getString("senha"));	
				cliente.setCnpj(rs.getString("cnpj"));
				venda.setCliente(cliente);

				venda.setProduto(rs.getString("produto"));	
				venda.setPreco(rs.getFloat("preco"));
				venda.setDataVenda(rs.getString("dataVenda"));

				resultado.add(venda);
			}
		}
		
		return resultado;
		
	}
	
	public static void inserir(Venda venda) throws Exception {
		String sql = "INSERT INTO tb_venda (cliente_id,"
				+ "produto, preco, dataVenda)"
				+ "	VALUES (?, ?, ?, ?)";
		
		try (PreparedStatement ps = DB.connect().prepareStatement(sql)) {
			ps.setLong(1, venda.getCliente().getId());
			ps.setString(2, venda.getProduto());
			ps.setFloat(3, venda.getPreco());
			ps.setString(4, venda.getDataVenda());

			ps.execute();
		}
	}
	
	public static void atualizar(Venda venda) throws Exception {
		String sql = "UPDATE tb_venda SET cliente_id = ?,"
				+ "produto = ?, preco = ?, dataVenda = ?"
				+ "WHERE id_venda = ?";
		
		try (PreparedStatement ps = DB.connect().prepareStatement(sql)) {
			ps.setLong(1, venda.getCliente().getId());
			ps.setString(2, venda.getProduto());
			ps.setFloat(3, venda.getPreco());
			ps.setString(4, venda.getDataVenda());
			ps.setLong(5, venda.getId());
			
			ps.execute();
		}
	}
	
	public static void excluir(long id) throws Exception {
		String sql = "DELETE FROM tb_venda WHERE id_venda = ?";
		
		try (PreparedStatement ps = DB.connect().prepareStatement(sql)) {
			ps.setLong(1, id);
			
			ps.execute();
		}
	}
	
	public static List<Venda> relatorio(float preco, String datavenda) throws Exception {
		String sql = "SELECT id_venda, produto, preco, dataVenda "
				+ "FROM tb_venda WHERE preco >= ? AND dataVenda LIKE ?";
		
		List<Venda> resultado = new ArrayList<Venda>();
		
		try(PreparedStatement ps = DB.connect().prepareStatement(sql)) {
			ps.setFloat(1, preco);
			ps.setString(2, datavenda);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Venda venda = new Venda();

				venda.setId(rs.getLong("id_venda"));
				venda.setProduto(rs.getString("produto"));	
				venda.setPreco(rs.getFloat("preco"));
				venda.setDataVenda(rs.getString("dataVenda"));

				resultado.add(venda);
			}
		}
		
		return resultado;
		
	}

}