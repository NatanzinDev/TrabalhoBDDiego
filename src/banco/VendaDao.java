package banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

}
