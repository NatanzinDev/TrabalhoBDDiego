package tela;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import banco.FrabricaConexao.FabricaConexao;
import dominio.Combustivel;

import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JList;

public class CadastrarUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldValor;
	private JTextField textFielTipo;
	private JTextField textFieldDataabastecimento;
	private Combustivel EdicaoCombustivel;
	private JButton btnNewButtonCadastar;
	private JList ListaCombustivel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarUsuario frame = new CadastrarUsuario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public CadastrarUsuario() throws ClassNotFoundException, SQLException {
		setBackground(Color.BLACK);
		setTitle("POSTO DE COMBUSTIVEL BAIXINHA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 665, 363);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 102, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Cadastrar Combustivel", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(62, 162, 487, 125);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(10, 36, 119, 20);
		panel.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		textFieldValor = new JTextField();
		textFieldValor.setBounds(10, 80, 119, 20);
		panel.add(textFieldValor);
		textFieldValor.setColumns(10);
		
		textFielTipo = new JTextField();
		textFielTipo.setBounds(152, 36, 119, 20);
		panel.add(textFielTipo);
		textFielTipo.setColumns(10);
		
		textFieldDataabastecimento = new JTextField();
		textFieldDataabastecimento.setBounds(152, 80, 119, 20);
		panel.add(textFieldDataabastecimento);
		textFieldDataabastecimento.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setBounds(10, 22, 46, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Valor");
		lblNewLabel_1.setBounds(10, 67, 46, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Tipo");
		lblNewLabel_2.setBounds(156, 22, 46, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Data Abastecimento");
		lblNewLabel_3.setBounds(152, 67, 103, 14);
		panel.add(lblNewLabel_3);
		
		btnNewButtonCadastar = new JButton("Cadastrar");
		btnNewButtonCadastar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					cadastrarClientes();
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButtonCadastar.setBounds(330, 54, 119, 23);
		panel.add(btnNewButtonCadastar);
		
		JButton btnNewButtonExibir = new JButton("Exibir Dados");
		btnNewButtonExibir.setBackground(Color.WHITE);
		btnNewButtonExibir.setBounds(339, 40, 108, 23);
		contentPane.add(btnNewButtonExibir);
		
		JButton btnRemover = new JButton("Remove");
		btnRemover.setBackground(Color.WHITE);
		btnRemover.setBounds(426, 111, 89, 23);
		contentPane.add(btnRemover);
		JButton btnEditarDados = new JButton(" Editar Dados");
		btnEditarDados.setBackground(Color.WHITE);
		btnEditarDados.setBounds(376, 76, 110, 23);
		contentPane.add(btnEditarDados);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(16, 15, 304, 130);
		contentPane.add(panel_1);
		panel_1.setBackground(Color.WHITE);
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Listagem de Vendas", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 22, 285, 96);
		panel_1.add(scrollPane);
		
		ListaCombustivel = new JList();
		scrollPane.setViewportView(ListaCombustivel);
		btnEditarDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				iniciarEdicaoCombustivel();
				
			}
		});
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					removerDados();
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButtonExibir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Combustivel CombustivelSelecionado = (Combustivel) ListaCombustivel.getSelectedValue();
				
				String msg = "Nome: " + CombustivelSelecionado.getNome() +
						"\nValor: " + CombustivelSelecionado.getValor() +
						"\nTipo: " + CombustivelSelecionado.getTipo() +
						"\nData Abastecimento: " + CombustivelSelecionado.getDataabastecimento();
				
				ExibirMensagem(msg);
				
				
				}
		});
		
		atualizarListagemCombustivel();
		
	}

	protected void removerDados() throws ClassNotFoundException, SQLException {
		
		if (ListaCombustivel.getSelectedIndex() == -1) {
			ExibirMensagemErro("Selecione uma pessoa - combustivel");
			
		}
		
		EdicaoCombustivel = (Combustivel) ListaCombustivel.getSelectedValue();
		
		Connection conexao = FabricaConexao.criarConexao();
		
		String sql = "DELETE FROM POSTOCOMBUSTIVEL WHERE ID_COMBUSTIVEL = ?";
		
		PreparedStatement comando = conexao.prepareStatement(sql);   
		
		comando.setInt(1, EdicaoCombustivel.getId());
		comando.executeUpdate();
		
		ExibirMensagem("Dados Removidos");
		
		atualizarListagemCombustivel();
		
		comando.close();
		conexao.close();
		
	}

	protected void iniciarEdicaoCombustivel() {
		
		if (ListaCombustivel.getSelectedIndex() == -1) {
			ExibirMensagemErro("Selecione uma pessoa - combustivel");
			
		}
		
		EdicaoCombustivel = (Combustivel) ListaCombustivel.getSelectedValue();
		
		textFieldNome.setText(EdicaoCombustivel.getNome());
		textFieldValor.setText(EdicaoCombustivel.getValor());
		textFielTipo.setText(EdicaoCombustivel.getTipo());
		textFieldDataabastecimento.setText(EdicaoCombustivel.getDataabastecimento());
		
		btnNewButtonCadastar.setText("Editar Dados");
		
	}

	protected void ExibirMensagem(String msg) {
		
		JOptionPane.showMessageDialog(null, msg, "Posto Baixinha", JOptionPane.INFORMATION_MESSAGE);
		
	}

	private void atualizarListagemCombustivel() throws ClassNotFoundException, SQLException {
		
		Connection conexao = FabricaConexao.criarConexao();
		
		String sql = "SELECT * FROM POSTOCOMBUSTIVEL";
		
		PreparedStatement comando = conexao.prepareStatement(sql);
		
		ResultSet resultado = comando.executeQuery();
		
		List <Combustivel> CombustivelCadastrados = new ArrayList<Combustivel>();
		
		while (resultado.next()) {
			Combustivel a = new Combustivel();
			
			a.setId(resultado.getInt("id_combustivel"));
			a.setNome(resultado.getString("nome"));
			a.setValor(resultado.getString("valor"));
			a.setTipo(resultado.getString("tipo"));
			a.setDataabastecimento(resultado.getString("dataabastecimento"));
			
			CombustivelCadastrados.add(a);
			
		}
		
		DefaultListModel <Combustivel> modelo = new DefaultListModel <>();
		
		for (int i = 0; i < CombustivelCadastrados.size(); i++) {
			Combustivel a = CombustivelCadastrados.get(i);
			modelo.addElement(a);
			
		}
		
		ListaCombustivel.setModel(modelo);
		
		comando.close();
		conexao.close();
		
		
		
		
	}

	protected void cadastrarClientes() throws ClassNotFoundException, SQLException {
		
		if(textFieldNome.getText() == null || textFieldNome.getText().isEmpty()) {
			ExibirMensagemErro("Nome não pode ser vazio");
			return;
		} 
		
		if(textFieldValor.getText() == null || textFieldValor.getText().isEmpty()) {
			ExibirMensagemErro("Valor não pode ser vazio");
			return;
		}
		
		if(textFielTipo.getText() == null || textFielTipo.getText().isEmpty()) {
			ExibirMensagemErro("Tipo não pode ser vazio");
			return;
		}
		
		if(textFieldDataabastecimento.getText() == null || textFieldDataabastecimento.getText().isEmpty()) {
			ExibirMensagemErro("Data Abastecimentonão pode ser vazio");
			return;
		}
		
		if (btnNewButtonCadastar.getText().equals("Cadastrar")) {
			
			Connection conexao = FabricaConexao.criarConexao();
			
		String sql = "INSERT INTO POSTOCOMBUSTIVEL (nome, valor, tipo, dataabastecimento) VALUES (?,?,?,?)";
		
		Combustivel a = new Combustivel();
		
		a.setNome(textFieldNome.getText());
		a.setValor(textFieldValor.getText());
		a.setTipo(textFielTipo.getText());
		a.setDataabastecimento(textFieldDataabastecimento.getText());
		
		PreparedStatement comando = conexao.prepareStatement(sql);
		
		comando.setString(1, a.getNome());
		comando.setString(2, a.getValor());
		comando.setString(3, a.getTipo());
		comando.setString(4, a.getDataabastecimento());
		comando.execute();
		
		System.out.println("Fechando conexão...");
		
		comando.close();
		conexao.close();
		
		JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso", "Posto Baixinha", JOptionPane.INFORMATION_MESSAGE);
		
		} else if (btnNewButtonCadastar.getText().equals("Editar Dados")){
			
			Connection conexao = FabricaConexao.criarConexao();
			
			EdicaoCombustivel.setNome(textFieldNome.getText());
			EdicaoCombustivel.setValor(textFieldValor.getText());
			EdicaoCombustivel.setTipo(textFielTipo.getText());
			EdicaoCombustivel.setDataabastecimento(textFieldDataabastecimento.getText());
			
			String sql = "UPDATE POSTOCOMBUSTIVEL SET NOME=?, VALOR=?, TIPO=?, DATAABASTECIMENTO=? WHERE ID_COMBUSTIVEL=?";
			
			PreparedStatement comando = conexao.prepareStatement(sql);
			comando.setString(1, EdicaoCombustivel.getNome());
			comando.setString(2, EdicaoCombustivel.getValor());
			comando.setString(3, EdicaoCombustivel.getTipo());
			comando.setString(4, EdicaoCombustivel.getDataabastecimento());
			comando.setInt(5, EdicaoCombustivel.getId());
			comando.executeUpdate();
			
			ExibirMensagem("Dados Alterados");
			
			comando.close();
			conexao.close();
			
			EdicaoCombustivel = null;
		    btnNewButtonCadastar.setText("Cadastrar");
		}
		
		atualizarListagemCombustivel();
		
		textFieldNome.setText("");
		textFieldValor.setText("");
		textFielTipo.setText("");
		textFieldDataabastecimento.setText("");
		
	}

	private void ExibirMensagemErro(String msg) {
		
		JOptionPane.showMessageDialog(null, msg, "Erro", JOptionPane.ERROR_MESSAGE);
		
		
	}
}
