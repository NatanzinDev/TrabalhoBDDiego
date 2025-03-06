package banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;

import banco.FrabricaConexao.FabricaConexao;
import dominio.Combustivel;

public class CombustivelDao {
	public List<Combustivel> buscarCombustivel(String string,String string2) throws ClassNotFoundException, SQLException{
		Connection conexao = FabricaConexao.criarConexao();

		String sql = "SELECT * FROM postocombustivel";

		
		boolean tem = false;

		if (string != null && !string.isEmpty()) {
			sql += " WHERE nome LIKE ?";
			tem = true;
		}

		if (string2 != null && !string2.isEmpty()) {
			sql += tem ? " AND tipo LIKE ?" : " WHERE tipo LIKE ?";
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
		}
		
		ResultSet resultado = comando.executeQuery();

		List<Combustivel> lista = new ArrayList<Combustivel>();

		while (resultado.next()) {
			Combustivel f = new Combustivel();

			f.setId(resultado.getInt("id_combustivel"));
			f.setNome(resultado.getString("nome"));
			f.setValor(resultado.getString("valor"));
			f.setTipo(resultado.getString("tipo"));

			lista.add(f);

		}

		
		return lista;
	}
}
