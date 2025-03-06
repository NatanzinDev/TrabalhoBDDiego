package banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import banco.FrabricaConexao.FabricaConexao;
import dominio.Combustivel;
import dominio.Venda;

public class VendaDao {

	public void cadastrarVenda(Venda v, Combustivel c) throws ClassNotFoundException, SQLException {
		Connection conexao = FabricaConexao.criarConexao();
		
		String sql = "INSERT INTO venda (nomecliente,datavenda,idcomb) VALUES (?,?,?)";
					
		
		PreparedStatement comando = conexao.prepareStatement(sql);
		
		comando.setString(1, v.getNomecliente());
		comando.setString(2, v.getData());
		comando.setInt(3, c.getId());
	
		comando.execute();
		
		System.out.println("Fechando ...");
		comando.close();
		conexao.close();
		
		JOptionPane.showMessageDialog(null,"Venda cadastrada com sucesso","Info",JOptionPane.INFORMATION_MESSAGE);
		
	}
	
	public List<Venda> buscarVenda(String string, String string2) throws SQLException, ClassNotFoundException{
		Connection conexao = FabricaConexao.criarConexao();
		String sql = "SELECT v.nomecliente, v.datavenda, c.nome FROM venda v JOIN postocombustivel c ON v.idcomb= c.id_combustivel";

		boolean tem = false;

		if (string != null && !string.isEmpty()) {
			sql += " WHERE v.nomecliente LIKE ?";
			tem = true;
		}

		if (string2 != null && !string2.isEmpty()) {
			sql += tem ? " AND v.datavenda LIKE ?" : " WHERE v.datavenda LIKE ?";
			tem = true;
		}

		

		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		int i = 1;

		if (string != null && !string.isEmpty()) {
			comando.setString(i, "%" + string.toUpperCase() + "%");
			i++;
		}

		if (string2 != null && !string2.isEmpty()) {
			comando.setString(i, "%" + string2.toUpperCase() + "%");
			i++;
		}

		


		ResultSet resultado = comando.executeQuery();

		List<Venda> ce = new ArrayList<>();

		while (resultado.next()) {
			Venda v = new Venda();
			v.setNomecliente(resultado.getString("nomecliente"));
			v.setData(resultado.getString("datavenda"));
			

			Combustivel m = new Combustivel();
			m.setNome(resultado.getString("nome"));
			v.setCombustivel(m);

			ce.add(v);

		}
		
		return ce;
	}

}
