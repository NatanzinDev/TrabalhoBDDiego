package tela;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import banco.CombustivelDao;
import banco.VendaDao;
import dominio.Combustivel;
import dominio.Venda;
import javax.swing.border.EtchedBorder;

public class BuscarCombustivel extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField nome;
	private JTextField tipo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuscarCombustivel frame = new BuscarCombustivel();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BuscarCombustivel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 864, 482);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 64));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Buscar Combustivel", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(92, 76, 195, 290);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					buscarCombustivel();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(52, 240, 85, 21);
		panel.add(btnNewButton);
		
		nome = new JTextField();
		nome.setBounds(37, 75, 114, 19);
		panel.add(nome);
		nome.setColumns(10);
		
		tipo = new JTextField();
		tipo.setColumns(10);
		tipo.setBounds(37, 148, 114, 19);
		panel.add(tipo);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setBounds(37, 55, 85, 13);
		panel.add(lblNewLabel);
		
		JLabel lblDataDaVenda = new JLabel("Tipo");
		lblDataDaVenda.setBounds(37, 130, 85, 13);
		panel.add(lblDataDaVenda);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Resultado", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setLayout(null);
		panel_1.setBounds(410, 76, 305, 290);
		contentPane.add(panel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 23, 285, 257);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome","Tipo", "Valor"
			}
		));
		scrollPane.setViewportView(table);
	}

	protected void buscarCombustivel() throws ClassNotFoundException, SQLException {
		if((nome.getText() == null || nome.getText().isEmpty()) && (tipo.getText() == null || tipo.getText().isEmpty()) ) {
			JOptionPane.showMessageDialog(null, "Algum campo precisa está preenchido para buscar.");
			return;
		}
		
		CombustivelDao dao = new CombustivelDao();
		List<Combustivel> encontrado = new ArrayList<>();
		
		encontrado = dao.buscarCombustivel(nome.getText(), tipo.getText());
		DefaultTableModel modelo = new DefaultTableModel(new String[] { "Nome", "Tipo", "Valor"}, 0);
		
		for (int i = 0; i < encontrado.size(); i++) {
			Combustivel c = encontrado.get(i);
			
			modelo.addRow(new String[] { c.getNome(),c.getTipo() ,c.getValor() ,});
		}
		
		table.setModel(modelo);
		
		
	}


}
