package tela;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Inicial extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicial frame = new Inicial();
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
	public Inicial() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 612, 445);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Fazer Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login a = null;
				a = new Login();
				a.setLocationRelativeTo(null);
				a.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				a.setVisible(true);
			}
		});
		btnNewButton.setBounds(54, 351, 121, 30);
		contentPane.add(btnNewButton);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastrarUsuario a = null;
				a = new CadastrarUsuario();
				a.setLocationRelativeTo(null);
				a.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				a.setVisible(true);
			}
		});
		btnCadastrar.setBounds(405, 351, 121, 30);
		contentPane.add(btnCadastrar);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Inicial.class.getResource("/imagens/combustivel.jpg")));
		lblNewLabel.setBounds(0, 0, 715, 408);
		contentPane.add(lblNewLabel);
	}

}
