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
		
		JButton btnNewButton = new JButton("INICIAR CADASTRO");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CadastrarCombustivel cc = null;
				try {
					
					cc = new CadastrarCombustivel();
					
				} catch (ClassNotFoundException | SQLException e1) {
					
					e1.printStackTrace();
				}
				cc.setVisible(true);
				
			}

			
		});
		btnNewButton.setBounds(142, 140, 159, 23);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("SE VOCÊ FOR FUNCIONÁRIO, CLIQUE ABAIXO");
		lblNewLabel.setBounds(101, 52, 327, 36);
		panel.add(lblNewLabel);
	}
}

