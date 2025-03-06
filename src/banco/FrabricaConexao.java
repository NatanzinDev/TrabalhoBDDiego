package banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FrabricaConexao {
	
	public class FabricaConexao {

		public static Connection criarConexao() throws ClassNotFoundException, SQLException {

			String stringDeConexao = "jdbc:mysql://localhost/combustivelbaixinha?useTimezone=true&serverTimezone=UTC";

			String usuario = "root";

			String senha = "admin";


			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection conexao = DriverManager.getConnection(stringDeConexao, usuario, senha);

			return conexao;

		}
	}

}
