package br.com.amicis.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import br.com.amicis.dao.UsuarioDAO;
import br.com.amicis.model.Usuario;

public class Cadastro extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel fundo;
	private JTextField sobrenome;
	private JTextField thisUsuario;
	private JTextField telefone;
	private JTextField email;
	private JPasswordField repetirSenha;
	private JTextField nome;
	private JPasswordField senha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cadastro frame = new Cadastro();
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
	public Cadastro() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("Amicis\\resources\\pngwing.com.png"));

		setTitle("Cadastrar usuário");
		setFont(new Font("Inconsolata", Font.PLAIN, 14));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 931, 651);
		fundo = new JPanel();

		fundo.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(fundo);
		fundo.setLayout(null);

		Label T_protegendoSuaConta = new Label("Protegendo sua conta");
		T_protegendoSuaConta.setFont(new Font("Open Sans Medium", Font.PLAIN, 18));
		T_protegendoSuaConta.setBounds(231, 344, 240, 34);
		fundo.add(T_protegendoSuaConta);

		nome = new JTextField();
		nome.setFont(new Font("Roboto", Font.PLAIN, 12));
		nome.setHorizontalAlignment(SwingConstants.LEFT);
		nome.setBounds(186, 146, 262, 29);
		fundo.add(nome);
		nome.setColumns(10);

		JLabel T_nome = new JLabel("nome");
		T_nome.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
		T_nome.setBounds(186, 120, 262, 16);
		fundo.add(T_nome);

		JButton criarUsuario = new JButton("criar usuário");

		criarUsuario.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
		criarUsuario.setBounds(603, 508, 127, 29);
		fundo.add(criarUsuario);

		JLabel T_sobrenome = new JLabel("sobrenome");
		T_sobrenome.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
		T_sobrenome.setBounds(468, 123, 262, 13);
		fundo.add(T_sobrenome);

		sobrenome = new JTextField();
		sobrenome.setFont(new Font("Roboto", Font.PLAIN, 12));
		sobrenome.setName("");
		sobrenome.setHorizontalAlignment(SwingConstants.LEFT);
		sobrenome.setColumns(10);
		sobrenome.setBounds(468, 146, 262, 29);
		fundo.add(sobrenome);

		JLabel T_usuario = new JLabel("usuário");
		T_usuario.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
		T_usuario.setBounds(186, 247, 262, 13);
		fundo.add(T_usuario);

		thisUsuario = new JTextField();
		thisUsuario.setFont(new Font("Roboto", Font.PLAIN, 12));
		thisUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		thisUsuario.setColumns(10);
		thisUsuario.setBounds(186, 270, 262, 29);
		fundo.add(thisUsuario);

		JLabel T_dataNascimento = new JLabel("data de nascimento");
		T_dataNascimento.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
		T_dataNascimento.setBounds(468, 247, 262, 13);
		fundo.add(T_dataNascimento);

		JLabel T_telefone = new JLabel("telefone");
		T_telefone.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
		T_telefone.setBounds(468, 185, 262, 13);
		fundo.add(T_telefone);

		telefone = new JTextField();
		telefone.setFont(new Font("Roboto", Font.PLAIN, 12));
		telefone.setHorizontalAlignment(SwingConstants.LEFT);
		telefone.setColumns(10);
		telefone.setBounds(468, 208, 262, 29);
		fundo.add(telefone);

		JLabel T_senha = new JLabel("criar uma senha");
		T_senha.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
		T_senha.setBounds(185, 405, 163, 13);
		fundo.add(T_senha);

		JLabel T_email = new JLabel("e-mail");
		T_email.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
		T_email.setBounds(186, 185, 262, 13);
		fundo.add(T_email);

		email = new JTextField();
		email.setFont(new Font("Roboto", Font.PLAIN, 12));
		email.setHorizontalAlignment(SwingConstants.LEFT);
		email.setColumns(10);
		email.setBounds(186, 208, 262, 29);
		fundo.add(email);

		JLabel T_repetirSenha = new JLabel("repetir senha");
		T_repetirSenha.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
		T_repetirSenha.setBounds(368, 405, 163, 13);
		fundo.add(T_repetirSenha);

		Label T_conhecendoVoce = new Label("Conhecendo você");
		T_conhecendoVoce.setFont(new Font("Open Sans Medium", Font.PLAIN, 18));
		T_conhecendoVoce.setBounds(231, 62, 240, 29);
		fundo.add(T_conhecendoVoce);

		JLabel emojiUm = new JLabel("🤩");
		emojiUm.setHorizontalAlignment(SwingConstants.CENTER);
		emojiUm.setFont(new Font("Noto Emoji Medium", Font.PLAIN, 28));
		emojiUm.setBounds(160, 44, 78, 63);
		fundo.add(emojiUm);

		JLabel emojiDois = new JLabel("🚨");
		emojiDois.setHorizontalAlignment(SwingConstants.CENTER);
		emojiDois.setFont(new Font("Noto Emoji Medium", Font.PLAIN, 28));
		emojiDois.setBounds(162, 328, 78, 63);
		fundo.add(emojiDois);

		JCheckBox aceitarTermos = new JCheckBox(" Aceitar Termos de Uso e Política de Privacidade.");
		aceitarTermos.setFont(new Font("Roboto Medium", Font.PLAIN, 12));
		aceitarTermos.setBounds(186, 512, 303, 21);
		fundo.add(aceitarTermos);

		JButton contrato = new JButton("contrato");
		contrato.setFont(new Font("Roboto Medium", Font.PLAIN, 13));
		contrato.setBounds(189, 482, 94, 21);
		fundo.add(contrato);

		senha = new JPasswordField();
		senha.setFont(new Font("Tahoma", Font.PLAIN, 12));
		senha.setBounds(186, 428, 162, 29);
		fundo.add(senha);

		repetirSenha = new JPasswordField();
		repetirSenha.setFont(new Font("Tahoma", Font.PLAIN, 12));
		repetirSenha.setBounds(368, 428, 162, 29);
		fundo.add(repetirSenha);

		JButton btnVoltar = new JButton("voltar");
		btnVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login frame = new Login();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				frame.setResizable(false);
				dispose();
			}
		});
		btnVoltar.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
		btnVoltar.setBounds(517, 508, 78, 29);
		fundo.add(btnVoltar);
		
		JDateChooser dataNascimento = new JDateChooser();
		dataNascimento.setDateFormatString("dd/MM/yyyy");
		dataNascimento.setBounds(468, 270, 262, 29);
		fundo.add(dataNascimento);

		criarUsuario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UsuarioDAO usuarioDAO = new UsuarioDAO();
				if (nome.getText().trim().isEmpty() || sobrenome.getText().trim().isEmpty()
						|| thisUsuario.getText().trim().isEmpty() || dataNascimento.getDate().equals(null)
						|| telefone.getText().trim().isEmpty() || email.getText().trim().isEmpty()) {
					JOptionPane.showMessageDialog(fundo, "Preencha todas as informações.");
				} else {

					char[] senha_ = senha.getPassword();
					char[] repetirSenha_ = repetirSenha.getPassword();
					try {
						if (telefone.getText() != null && telefone.getText().matches("[0-9]+")
								&& telefone.getText().length() >= 8) {
							if (verificarUsuario(thisUsuario.getText()) != false) {
								if (validarEmail(email.getText()) == true) {
									if (Arrays.equals(senha_, repetirSenha_)) {
										if (senha_.length >= 4) {
											Usuario usuario = new Usuario();
											usuario.setNome(nome.getText());
											usuario.setSobrenome(sobrenome.getText());
											usuario.setUsuario(thisUsuario.getText());
											usuario.setDataNascimeto(dataNascimento.getDate());
											usuario.setTelefone(telefone.getText());
											usuario.setEmail(email.getText());
											usuario.setSenha(senha.getPassword());
											usuarioDAO.save(usuario);

											if (aceitarTermos.isSelected()) {
												Login frame = new Login();
												frame.setVisible(true);
												frame.setLocationRelativeTo(null);
												frame.setResizable(false);
												dispose();
												JOptionPane.showMessageDialog(frame, "Usuário cadastrado com sucesso.");
											} else {
												JOptionPane.showMessageDialog(fundo,
														"Aceite os Termos de Uso e Política de Privacidade.");
											}
										} else {
											JOptionPane.showMessageDialog(fundo,
													"A senha precisa conter 4 caracteres ou mais.");
										}
									} else {
										JOptionPane.showMessageDialog(fundo, "As senhas devem ser iguais.");
									}
								} else {
									JOptionPane.showMessageDialog(fundo, "Email inválido.");
								}
							} else {
								JOptionPane.showMessageDialog(fundo, "O usuário já existe.");
							}
						} else {
							JOptionPane.showMessageDialog(fundo, "Número de telefone inválido.");
						}

					} catch (HeadlessException | SQLException e1) {
						e1.printStackTrace();
				}
			}
		}});
	}

	public static boolean validarEmail(String email) {
		boolean emailValido = false;
		if (email != null && email.length() > 0) {
			String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
			Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
			Matcher matcher = pattern.matcher(email);
			if (matcher.matches()) {
				emailValido = true;
			}
		}
		return emailValido;
	}

	public boolean verificarUsuario(String usuario) throws SQLException {
		boolean emailValido = true;
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		for (Usuario u : usuarioDAO.getUsuarios()) {
			if (u.getUsuario().equals(usuario)) {
				return false;
			}
		}
		return emailValido;
	}
}
