package tela;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

public class BuscarVenda extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField nomecliente;
	private JTextField data;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuscarVenda frame = new BuscarVenda();
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
	public BuscarVenda() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 864, 482);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 64));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Buscar Venda", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(92, 76, 195, 290);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.setBounds(52, 240, 85, 21);
		panel.add(btnNewButton);
		
		nomecliente = new JTextField();
		nomecliente.setBounds(37, 75, 114, 19);
		panel.add(nomecliente);
		nomecliente.setColumns(10);
		
		data = new JTextField();
		data.setColumns(10);
		data.setBounds(37, 148, 114, 19);
		panel.add(data);
		
		JLabel lblNewLabel = new JLabel("Nome do cliente");
		lblNewLabel.setBounds(37, 55, 85, 13);
		panel.add(lblNewLabel);
		
		JLabel lblDataDaVenda = new JLabel("Data da venda");
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
				"Cliente", "Data","Combustivel"
			}
		));
		scrollPane.setViewportView(table);
	}
}
