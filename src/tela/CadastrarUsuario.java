package tela;

import java.awt.Color;
import java.awt.EventQueue;
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
import util.CriptografiaUtils;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastrarUsuario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nome;
	private JTextField email;
	private JPasswordField passwordField;

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
	 */
	public CadastrarUsuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 620, 471);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 64));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Cadastrar Usuario", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(104, 50, 384, 318);
		contentPane.add(panel);
		panel.setLayout(null);
		
		nome = new JTextField();
		nome.setBounds(91, 92, 193, 19);
		panel.add(nome);
		nome.setColumns(10);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(91, 158, 193, 19);
		panel.add(email);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setBounds(91, 79, 94, 13);
		panel.add(lblNewLabel);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(91, 146, 94, 13);
		panel.add(lblEmail);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(91, 212, 94, 13);
		panel.add(lblSenha);
		
		JButton btCadastrar = new JButton("Cadastrar");
		btCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					cadastrarUsuario();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btCadastrar.setBounds(91, 269, 94, 21);
		panel.add(btCadastrar);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(91, 224, 193, 19);
		panel.add(passwordField);
	}
	
	protected void cadastrarUsuario() throws ClassNotFoundException, SQLException {
		String nomee = nome.getText();
		String emaill = email.getText();
		String senha = new String(passwordField.getPassword());
		String senhaCriptografada = CriptografiaUtils.criptografarMD5(senha);

		if (nome == null || nomee.isEmpty()) {
			exibirMensagemErro("Nome não pode ser vazio");
			return;
		}

		if (email == null || emaill.isEmpty()) {
			exibirMensagemErro("email não pode ser vazio");
			return;
		}

		if (senha == null || senha.isEmpty()) {
			exibirMensagemErro("senha não pode ser vazio");
			return;
		}
		
		UsuarioDao dao = new UsuarioDao();
		dao.cadastrarUsuario(nomee, senhaCriptografada, emaill);
		
	}

	private void exibirMensagemErro(String string) {
		JOptionPane.showMessageDialog(null, string);
		
	}
}
