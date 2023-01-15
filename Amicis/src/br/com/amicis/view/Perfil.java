package br.com.amicis.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Label;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class Perfil extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentJPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Perfil frame = new Perfil();
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
	public Perfil() {
		setBackground(new Color(255, 255, 255));
		getContentPane().setBackground(new Color(255, 255, 255));

		setIconImage(Toolkit.getDefaultToolkit().getImage("Amicis\\resources\\pngwing.com.png"));
		setTitle("Perfil");
		setFont(new Font("Inconsolata", Font.PLAIN, 14));
		setBounds(100, 100, 414, 575);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		contentJPanel = new JPanel();
		setContentPane(contentJPanel);
		contentJPanel.setLayout(null);

		JLabel icon = new JLabel("😟");
		icon.setHorizontalAlignment(SwingConstants.CENTER);
		icon.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
		icon.setFont(new Font("Noto Emoji Medium", Font.PLAIN, 110));
		icon.setBounds(125, 39, 150, 150);
		contentJPanel.add(icon);

		Label nome = new Label("Maykon");
		nome.setFont(new Font("Dialog", Font.PLAIN, 24));
		nome.setAlignment(Label.CENTER);
		nome.setBounds(49, 220, 302, 36);
		contentJPanel.add(nome);

		JLabel linha = new JLabel("");
		linha.setBounds(76, 275, 247, 1);
		linha.setBorder(BorderFactory.createLineBorder(Color.black));
		contentJPanel.add(linha);

		JLabel lblNewLabel = new JLabel("Sobrenome");
		lblNewLabel.setFont(new Font("Roboto", Font.PLAIN, 12));
		lblNewLabel.setBounds(76, 364, 129, 15);
		contentJPanel.add(lblNewLabel);

		JLabel lblDataNascimento = new JLabel("Data Nascimento");
		lblDataNascimento.setFont(new Font("Roboto", Font.PLAIN, 12));
		lblDataNascimento.setBounds(76, 386, 129, 15);
		contentJPanel.add(lblDataNascimento);

		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setFont(new Font("Roboto", Font.PLAIN, 12));
		lblTelefone.setBounds(76, 411, 129, 15);
		contentJPanel.add(lblTelefone);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Roboto", Font.PLAIN, 12));
		lblEmail.setBounds(76, 432, 129, 15);
		contentJPanel.add(lblEmail);

		JLabel lblBio = new JLabel("Bio");
		lblBio.setFont(new Font("Roboto", Font.PLAIN, 12));
		lblBio.setBounds(76, 286, 129, 15);
		contentJPanel.add(lblBio);

		JButton btnNewButton = new JButton("Alterar");
		btnNewButton.setFont(new Font("Roboto", Font.PLAIN, 12));
		btnNewButton.setBounds(157, 486, 85, 21);
		contentJPanel.add(btnNewButton);

	}
}
