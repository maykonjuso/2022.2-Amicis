package br.com.amicis.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import br.com.amicis.dao.UsuarioDAO;
import br.com.amicis.model.Usuario;

public class Login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel fundo;
	private JTextField thisUsuario;
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
					frame.setLocationRelativeTo(null);
					frame.setResizable(false);
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
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
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("Amicis\\resources\\pngwing.com.png"));
		setTitle("Login");
		setFont(new Font("Inconsolata", Font.PLAIN, 14));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 931, 651);
		fundo = new JPanel();
		fundo.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(fundo);
		getContentPane().setLayout(null);

		JButton btnEntrar = new JButton("entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				autenticarLogin();
			}
		});
		btnEntrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Home frame;
				try {
					frame = new Home();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					frame.setResizable(false);
					dispose();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnEntrar.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
		btnEntrar.setBounds(384, 366, 149, 29);
		getContentPane().add(btnEntrar);

		JButton btnCadastrarUsurio = new JButton("cadastrar usuário");
		btnCadastrarUsurio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Cadastro frame = new Cadastro();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				frame.setResizable(false);
				dispose();
			}
		});
		btnCadastrarUsurio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCadastrarUsurio.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
		btnCadastrarUsurio.setBounds(384, 406, 149, 29);
		getContentPane().add(btnCadastrarUsurio);

		JLabel T_thisUsuario = new JLabel("usuário");
		T_thisUsuario.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
		T_thisUsuario.setBounds(327, 224, 262, 16);
		getContentPane().add(T_thisUsuario);

		thisUsuario = new JTextField();
		thisUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		thisUsuario.setFont(new Font("Roboto", Font.PLAIN, 12));
		thisUsuario.setColumns(10);
		thisUsuario.setBounds(327, 250, 262, 29);
		getContentPane().add(thisUsuario);

		JLabel T_senha = new JLabel("senha");
		T_senha.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
		T_senha.setBounds(327, 290, 262, 16);
		getContentPane().add(T_senha);

		Label T_conhecendoVoce = new Label("Acesse seu perfil");
		T_conhecendoVoce.setAlignment(Label.CENTER);
		T_conhecendoVoce.setFont(new Font("Dialog", Font.PLAIN, 24));
		T_conhecendoVoce.setBounds(307, 141, 302, 36);
		getContentPane().add(T_conhecendoVoce);

		JLabel emojiUm = new JLabel("🤠");
		emojiUm.setHorizontalAlignment(SwingConstants.CENTER);
		emojiUm.setFont(new Font("Noto Emoji Medium", Font.PLAIN, 28));
		emojiUm.setBounds(418, 92, 78, 63);
		getContentPane().add(emojiUm);

		senha = new JPasswordField();
		senha.setHorizontalAlignment(SwingConstants.CENTER);
		senha.setBounds(327, 313, 262, 29);
		fundo.add(senha);

		JTextArea lblNewJText = new JTextArea(
				"Copyright©2022-2023, Amicis. Todos os direitos reservados. Todos os textos, imagens, gráficos, animações, vídeos, músicas, sons e outros materiais são protegidos por direitos autorais.");
		lblNewJText.setBackground(new Color(1, 1, 1, 0.5f));
		lblNewJText.setForeground(new Color(128, 128, 128));
		lblNewJText.setFont(new Font("Arial", Font.PLAIN, 10));
		lblNewJText.setEditable(false);
		lblNewJText.setLineWrap(true);
		lblNewJText.setBounds(238, 565, 439, 36);
		fundo.add(lblNewJText);
	}

	private void autenticarLogin() {
		try {
			Usuario usuario = new Usuario();
			usuario.setUsuario(thisUsuario.getText());
			usuario.setSenha(senha.getPassword());
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			ResultSet resultDAO = usuarioDAO.autenticacaoUsuario(usuario);

			if (resultDAO.next()) {
				Home frame = new Home();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				frame.setResizable(false);
				dispose();
			} else {
				JOptionPane.showMessageDialog(null, "Usuário ou Senha Inválida");
			}

		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, "LOGINVIEW");
		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}
}
