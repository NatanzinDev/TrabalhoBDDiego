package tela;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import banco.UsuarioDao;
import dominio.Usuario;
import util.CriptografiaUtils;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField email;
	private JPasswordField senha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 512, 467);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 64));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Login", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(97, 62, 293, 309);
		contentPane.add(panel);
		panel.setLayout(null);
		
		email = new JTextField();
		email.setBounds(64, 75, 147, 19);
		panel.add(email);
		email.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Email");
		lblNewLabel.setBounds(64, 60, 45, 13);
		panel.add(lblNewLabel);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(64, 139, 45, 13);
		panel.add(lblSenha);
		
		JButton btEntrar = new JButton("Entrar");
		btEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					entrar();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btEntrar.setBounds(64, 218, 85, 21);
		panel.add(btEntrar);
		
		senha = new JPasswordField();
		senha.setBounds(64, 151, 147, 19);
		panel.add(senha);
	}

	protected void entrar() throws ClassNotFoundException, SQLException {
		String emaill = email.getText();
		String senhaa = new String(senha.getPassword());
		String senhaCriptografada = CriptografiaUtils.criptografarMD5(senhaa);

		UsuarioDao dao = new UsuarioDao();

		Usuario u = dao.encontrarUsuarioPorEmailESenha(emaill, senhaCriptografada);

		if (u == null) {

			JOptionPane.showMessageDialog(null, "Não foi encontrado usuários");
		} else {

			Principal ba = new Principal();
			ba.setLocationRelativeTo(null);
			ba.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			ba.setVisible(true);

		}
	}
}
