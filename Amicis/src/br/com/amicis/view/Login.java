package br.com.amicis.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

public class Login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel fundo;
	private JTextField textField;
	private JPasswordField passwordField;
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
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\mayko\\git\\Amicis\\Amicis\\resources\\pngwing.com.png"));
		setTitle("Login");
		setFont(new Font("Inconsolata", Font.PLAIN, 14));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 931, 651);
		fundo = new JPanel();
		fundo.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(fundo);
		getContentPane().setLayout(null);
		
		JButton btnEntrar = new JButton("entrar");
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
		
		JLabel T_nome = new JLabel("usuário");
		T_nome.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
		T_nome.setBounds(327, 224, 262, 16);
		getContentPane().add(T_nome);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Roboto", Font.PLAIN, 12));
		textField.setColumns(10);
		textField.setBounds(327, 250, 262, 29);
		getContentPane().add(textField);
		
		JLabel T_nome_1 = new JLabel("senha");
		T_nome_1.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
		T_nome_1.setBounds(327, 290, 262, 16);
		getContentPane().add(T_nome_1);
		
		Label T_conhecendoVoce = new Label("Acesse seu perfil");
		T_conhecendoVoce.setAlignment(Label.CENTER);
		T_conhecendoVoce.setFont(new Font("Dialog", Font.PLAIN, 24));
		T_conhecendoVoce.setBounds(352, 141, 210, 36);
		getContentPane().add(T_conhecendoVoce);
		
		JLabel emojiUm = new JLabel("🤠");
		emojiUm.setHorizontalAlignment(SwingConstants.CENTER);
		emojiUm.setFont(new Font("Noto Emoji Medium", Font.PLAIN, 28));
		emojiUm.setBounds(418, 92, 78, 63);
		getContentPane().add(emojiUm);
		
		passwordField = new JPasswordField();
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setBounds(327, 313, 262, 29);
		fundo.add(passwordField);
		
		JTextArea lblNewJText = new JTextArea("Copyright©2022-2023, Amicis. Todos os direitos reservados. Todos os textos, imagens, gráficos, animações, vídeos, músicas, sons e outros materiais são protegidos por direitos autorais.");
		lblNewJText.setBackground(new Color(1, 1, 1, 0.5f));
		lblNewJText.setForeground(new Color(128, 128, 128));
		lblNewJText.setFont(new Font("Arial", Font.PLAIN, 10));
		lblNewJText.setEditable(false); 
		lblNewJText.setLineWrap(true);
		lblNewJText.setBounds(238, 565, 439, 36);
		fundo.add(lblNewJText);
	}
}
