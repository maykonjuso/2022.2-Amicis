package br.com.amicis.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.charset.Charset;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import br.com.amicis.model.Usuario;

import javax.swing.JCheckBox;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Principal extends JFrame {

	private JPanel fundo;
	private JTextField sobrenome;
	private JTextField thisUsuario;
	private JTextField dataNascimento;
	private JTextField telefone;
	private JTextField email;
	private JPasswordField senha;
	private JPasswordField repetirSenha;
	private JTextField nome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
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
	public Principal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\mayko\\git\\Amicis\\Amicis\\resources\\pngwing.com.png"));
		
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
		nome.setFont(new Font("Roboto Medium", Font.PLAIN, 12));
		nome.setHorizontalAlignment(SwingConstants.LEFT);
		nome.setBounds(186, 146, 262, 29);
		fundo.add(nome);
		nome.setColumns(10);
		
		JLabel T_nome = new JLabel("Nome:");
		T_nome.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
		T_nome.setBounds(186, 120, 262, 16);
		fundo.add(T_nome);
		
		JButton criarUsuario = new JButton("criar usuário");
		criarUsuario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Usuario usuario = new Usuario();
				
				usuario.setNome(nome.getText());
				usuario.setSobrenome(sobrenome.getText());
				usuario.setUsuario(thisUsuario.getText());
				usuario.setDataNascimeto(new Date());
				usuario.setTelefone(telefone.getText());
				usuario.setEmail(email.getText());
				usuario.setSenha(senha.getPassword());
	
				System.out.println(usuario.getNome());
				
			}
		});
		criarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		criarUsuario.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
		criarUsuario.setBounds(603, 508, 127, 29);
		fundo.add(criarUsuario);
		
		JLabel T_sobrenome = new JLabel("Sobrenome:");
		T_sobrenome.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
		T_sobrenome.setBounds(468, 123, 177, 13);
		fundo.add(T_sobrenome);
		
		sobrenome = new JTextField();
		sobrenome.setName("");
		sobrenome.setHorizontalAlignment(SwingConstants.LEFT);
		sobrenome.setColumns(10);
		sobrenome.setBounds(468, 146, 262, 29);
		fundo.add(sobrenome);
		
		JLabel T_usuario = new JLabel("Usuário:");
		T_usuario.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
		T_usuario.setBounds(186, 247, 262, 13);
		fundo.add(T_usuario);
		
		thisUsuario = new JTextField();
		thisUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		thisUsuario.setColumns(10);
		thisUsuario.setBounds(186, 270, 262, 29);
		fundo.add(thisUsuario);
		
		dataNascimento = new JTextField();
		dataNascimento.setHorizontalAlignment(SwingConstants.LEFT);
		dataNascimento.setColumns(10);
		dataNascimento.setBounds(468, 270, 262, 29);
		fundo.add(dataNascimento);
		
		JLabel T_dataNascimento = new JLabel("Data de nascimento:");
		T_dataNascimento.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
		T_dataNascimento.setBounds(468, 247, 177, 13);
		fundo.add(T_dataNascimento);
		
		JLabel T_telefone = new JLabel("Telefone:");
		T_telefone.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
		T_telefone.setBounds(468, 185, 177, 13);
		fundo.add(T_telefone);
		
		telefone = new JTextField();
		telefone.setHorizontalAlignment(SwingConstants.LEFT);
		telefone.setColumns(10);
		telefone.setBounds(468, 208, 262, 29);
		fundo.add(telefone);
		
		JLabel T_senha = new JLabel("Criar nova senha:");
		T_senha.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
		T_senha.setBounds(185, 405, 163, 13);
		fundo.add(T_senha);
		
		JLabel T_email = new JLabel("Email:");
		T_email.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
		T_email.setBounds(186, 185, 262, 13);
		fundo.add(T_email);
		
		email = new JTextField();
		email.setFont(new Font("Roboto Medium", Font.PLAIN, 12));
		email.setHorizontalAlignment(SwingConstants.LEFT);
		email.setColumns(10);
		email.setBounds(186, 208, 262, 29);
		fundo.add(email);
		
		JLabel T_repetirSenha = new JLabel("Repetir senha:");
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
		
		JCheckBox aceitarTermos = new JCheckBox("Aceitar termos e condições...");
		aceitarTermos.setFont(new Font("Roboto Medium", Font.PLAIN, 12));
		aceitarTermos.setBounds(186, 512, 203, 21);
		fundo.add(aceitarTermos);
		
		JButton contrato = new JButton("contrato");
		contrato.setFont(new Font("Roboto Medium", Font.PLAIN, 12));
		contrato.setBounds(189, 482, 94, 21);
		fundo.add(contrato);
		
		senha = new JPasswordField();
		senha.setBounds(186, 428, 162, 29);
		fundo.add(senha);
		
		repetirSenha = new JPasswordField();
		repetirSenha.setBounds(368, 428, 162, 29);
		fundo.add(repetirSenha);
	}
}
