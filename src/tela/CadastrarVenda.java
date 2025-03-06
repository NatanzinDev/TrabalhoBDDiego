package tela;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import banco.FrabricaConexao.FabricaConexao;
import banco.VendaDao;
import dominio.Combustivel;
import dominio.Venda;


public class CadastrarVenda extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nome;
	private JTextField data;
	private JList list;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarVenda frame = new CadastrarVenda();
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
	public CadastrarVenda() throws ClassNotFoundException, SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 767, 444);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 64));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Cadastrar Venda", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(114, 28, 503, 322);
		contentPane.add(panel);
		panel.setLayout(null);

		nome = new JTextField();
		nome.setBounds(48, 48, 202, 19);
		panel.add(nome);
		nome.setColumns(10);

		JLabel lblNewLabel = new JLabel("Nome do Cliente");
		lblNewLabel.setBounds(47, 27, 124, 24);
		panel.add(lblNewLabel);

		data = new JTextField();
		data.setColumns(10);
		data.setBounds(47, 94, 202, 19);
		panel.add(data);

		JLabel lblData = new JLabel("Data");
		lblData.setBounds(47, 77, 124, 24);
		panel.add(lblData);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(49, 161, 201, 96);
		panel.add(scrollPane);
		
				list = new JList();
				scrollPane.setViewportView(list);

		JLabel lblResultado = new JLabel("Selecione o combustivel");
		lblResultado.setBounds(47, 138, 124, 24);
		panel.add(lblResultado);

		JButton btCadastrar = new JButton("Cadastrar");
		btCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastrarVenda();
			}
		});
		btCadastrar.setBounds(292, 235, 147, 21);
		panel.add(btCadastrar);
		
		pesquisar();
	}

	protected void pesquisar() throws ClassNotFoundException, SQLException {
		Connection conexao = FabricaConexao.criarConexao();

		String sql = "SELECT * FROM postocombustivel";

		PreparedStatement comando = conexao.prepareStatement(sql);

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

		DefaultListModel<Combustivel> modelo = new DefaultListModel<>();

		for (int i = 0; i < lista.size(); i++) {
			Combustivel f = lista.get(i);
			modelo.addElement(f);
		}

		list.setModel(modelo);

		comando.close();
		conexao.close();

	}

	protected void cadastrarVenda() {
		Venda v = new Venda();
		v.setNomecliente(nome.getText());
		v.setData(data.getText());
		
		if(list.getSelectedIndex() == -1) {
			JOptionPane.showMessageDialog(null, "Selecione um combustivel para cadastrar.");
			return;
		}
		Combustivel c;
		c = (Combustivel) list.getSelectedValue();

		try {
			VendaDao dao = new VendaDao();
			dao.cadastrarVenda(v,c);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro no Sistema");
			e.printStackTrace();
		}
		
		nome.setText("");
		data.setText("");
	}
}
