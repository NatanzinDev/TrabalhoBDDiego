package tela;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Principal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
		setTitle("POSTO DE COMBUSTIVEL BAIXINHA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 102, 51));
		panel.setBounds(0, 0, 434, 261);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("CADASTRAR COMBUSTIVEL");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CadastrarCombustivel a = null;
				try {
					a = new CadastrarCombustivel();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				a.setLocationRelativeTo(null);
				a.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				a.setVisible(true);
				
			}

			
		});
		btnNewButton.setBounds(111, 98, 213, 23);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("SE VOCÊ FOR FUNCIONÁRIO, CLIQUE ABAIXO");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(46, 47, 327, 36);
		panel.add(lblNewLabel);
		
		JButton btnCadastrarVenda = new JButton("CADASTRAR VENDA");
		btnCadastrarVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastrarVenda a = null;
				try {
					a = new CadastrarVenda();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				a.setLocationRelativeTo(null);
				a.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				a.setVisible(true);
			}
		});
		btnCadastrarVenda.setBounds(111, 131, 213, 23);
		panel.add(btnCadastrarVenda);
		
		JButton btnNewButton_1_1 = new JButton("BUSCAR VENDA");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BuscarVenda a = null;
				a = new BuscarVenda();
				a.setLocationRelativeTo(null);
				a.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				a.setVisible(true);
			}
		});
		btnNewButton_1_1.setBounds(111, 164, 213, 23);
		panel.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("BUSCAR COMBUSTIVEL");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BuscarCombustivel a = null;
				a = new BuscarCombustivel();
				a.setLocationRelativeTo(null);
				a.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				a.setVisible(true);
			}
		});
		btnNewButton_1_1_1.setBounds(111, 197, 213, 23);
		panel.add(btnNewButton_1_1_1);
	}
}

