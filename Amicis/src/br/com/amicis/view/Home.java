package br.com.amicis.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import br.com.amicis.dao.UsuarioDAO;
import br.com.amicis.model.Usuario;

public class Home extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel publicacoesPanel;
	private JTextField textField;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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

	public Home() throws SQLException {
		setBackground(new Color(255, 255, 255));
		getContentPane().setBackground(new Color(255, 255, 255));

		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("Amicis\\resources\\pngwing.com.png"));
		setTitle("Home");
		setFont(new Font("Inconsolata", Font.PLAIN, 14));
		setBounds(100, 100, 1118, 660);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JScrollPane timeline = new JScrollPane();
		timeline.setBorder(BorderFactory.createLineBorder(new Color(230, 230, 230)));
		timeline.setBackground(new Color(255, 255, 255));
		timeline.setPreferredSize(new Dimension(500, 350));

		publicacoesPanel = new JPanel();

		publicacoesPanel.setLayout(new BoxLayout(publicacoesPanel, BoxLayout.Y_AXIS));
		publicacoesPanel.setBackground(new Color(255, 255, 255));
		timeline.setViewportView(publicacoesPanel);

		JPanel publicacoes = new JPanel();
		publicacoes.setLayout(new BoxLayout(publicacoes, BoxLayout.PAGE_AXIS));

		JPanel novaPublicacao = new JPanel();
		novaPublicacao.setForeground(Color.LIGHT_GRAY);
		novaPublicacao.setBackground(UIManager.getColor("InternalFrame.borderColor"));

		publicacoes.add(novaPublicacao);
		novaPublicacao.setLayout(null);

		JButton publicar = new JButton("publicar");
		publicar.setBackground(UIManager.getColor("InternalFrame.borderColor"));
		publicar.setBounds(405, 107, 89, 23);
		novaPublicacao.add(publicar);

		JTextArea textArea = new JTextArea();
		textArea.setForeground(UIManager.getColor("InternalFrame.activeTitleForeground"));
		textArea.setBackground(new Color(255, 255, 255));
		textArea.setBounds(10, 11, 482, 87);
		novaPublicacao.add(textArea);

		JButton apagar = new JButton("apagar");
		apagar.setBackground(SystemColor.menu);
		apagar.setBounds(307, 107, 89, 23);
		novaPublicacao.add(apagar);
		publicacoes.add(timeline);
		getContentPane().add(publicacoes, BorderLayout.CENTER);

		JPanel menu = new JPanel();
		menu.setBackground(new Color(255, 255, 255));
		getContentPane().add(menu, BorderLayout.LINE_START);
		menu.setLayout(null);
		menu.setPreferredSize(new Dimension(300, 100));

		JButton perfil = new JButton("perfil");
		perfil.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Perfil frame = new Perfil();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				frame.setResizable(false);
			}
		});
		perfil.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
		perfil.setBounds(94, 105, 156, 33);
		menu.add(perfil);

		JButton status = new JButton("status");
		status.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
		status.setBounds(94, 164, 156, 33);
		menu.add(status);

		JButton amigos = new JButton("amigos");
		amigos.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
		amigos.setBounds(94, 223, 156, 33);
		menu.add(amigos);

		JButton notificacoes = new JButton("notificacoes");
		notificacoes.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
		notificacoes.setBounds(94, 282, 156, 33);
		menu.add(notificacoes);

		JLabel emojiUm = new JLabel("👤");
		emojiUm.setHorizontalAlignment(SwingConstants.CENTER);
		emojiUm.setFont(new Font("Noto Emoji Medium", Font.BOLD, 28));
		emojiUm.setBounds(10, 90, 78, 63);
		menu.add(emojiUm);

		JLabel emojiUm_1 = new JLabel("📢");
		emojiUm_1.setHorizontalAlignment(SwingConstants.CENTER);
		emojiUm_1.setFont(new Font("Noto Emoji Medium", Font.BOLD, 28));
		emojiUm_1.setBounds(10, 149, 78, 63);
		menu.add(emojiUm_1);

		JLabel emojiUm_1_1 = new JLabel("👥");
		emojiUm_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		emojiUm_1_1.setFont(new Font("Noto Emoji Medium", Font.BOLD, 28));
		emojiUm_1_1.setBounds(10, 208, 78, 63);
		menu.add(emojiUm_1_1);

		JLabel emojiUm_1_2 = new JLabel("🔥");
		emojiUm_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		emojiUm_1_2.setFont(new Font("Noto Emoji Medium", Font.PLAIN, 28));
		emojiUm_1_2.setBounds(10, 267, 78, 63);
		menu.add(emojiUm_1_2);

		JButton notificacoes_1 = new JButton("configurações");
		notificacoes_1.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
		notificacoes_1.setBounds(94, 529, 156, 33);
		menu.add(notificacoes_1);

		JLabel emojiUm_1_2_1 = new JLabel("⚙️");
		emojiUm_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		emojiUm_1_2_1.setFont(new Font("Noto Emoji Medium", Font.BOLD, 28));
		emojiUm_1_2_1.setBounds(10, 514, 78, 63);
		menu.add(emojiUm_1_2_1);

		JLabel lblNewLabel = new JLabel("Olá, Maykon");
		lblNewLabel.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblNewLabel.setBounds(101, 30, 98, 39);
		menu.add(lblNewLabel);

		JPanel publicacao = new JPanel();
		publicacao.setBackground(new Color(255, 255, 255));
		getContentPane().add(publicacao, BorderLayout.NORTH);
		publicacao.setLayout(null);

		JLabel T_publicacao = new JLabel("nova publicação");
		T_publicacao.setBounds(512, 5, 77, 14);

		publicacao.add(T_publicacao);

		JPanel conversas = new JPanel();
		conversas.setLayout(null);
		conversas.setPreferredSize(new Dimension(100, 100));
		conversas.setBackground(new Color(255, 255, 255));
		conversas.setPreferredSize(new Dimension(300, 100));
		getContentPane().add(conversas, BorderLayout.EAST);

		JButton btnConversas = new JButton("conversas");
		btnConversas.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
		btnConversas.setBounds(0, 591, 297, 29);
		conversas.add(btnConversas);

		textField = new JTextField();
		textField.setBounds(26, 105, 177, 29);
		conversas.add(textField);
		textField.setColumns(10);

		JButton perfil_1 = new JButton("🔎");
		perfil_1.setFont(new Font("Noto Emoji", Font.BOLD, 14));
		perfil_1.setBounds(213, 105, 51, 29);
		conversas.add(perfil_1);

		JLabel lblEncontreNovosAmigos = new JLabel("Faça novos amigos...");
		lblEncontreNovosAmigos.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblEncontreNovosAmigos.setBounds(65, 30, 169, 39);
		conversas.add(lblEncontreNovosAmigos);

		UsuarioDAO usuarioDAO = new UsuarioDAO();

		for (Usuario usuario : usuarioDAO.getUsuarios()) {
			try {
				JPanel publicacaoPanel = criarPublicacaoPanel(usuario.getPerfil().getThis_usuario());
				publicacaoPanel.setFont(new Font("Roboto", Font.PLAIN, 12));
				publicacaoPanel.setPreferredSize(new Dimension(100, 85));
				publicacoesPanel.add(publicacaoPanel);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private JPanel criarPublicacaoPanel(String nome) {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.LINE_AXIS));
		panel.setBorder(BorderFactory.createLineBorder(new Color(220, 220, 220)));
		panel.setBackground(new Color(255, 255, 255));

		JLabel label = new JLabel(nome);
		label.setPreferredSize(new Dimension(100, 100));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBackground(new Color(200, 200, 200));
		panel.add(label);

		JLabel textArea = new JLabel();
		textArea.setText(
				"Pego minha caneca de café cheia, acendo meu ultimo cigarro e corro pra velha janela do quarto. Observo a noite fria e chuvosa, até parece confortável por um momento, se não fossem as dezenas de preocupações que me desmotivam a cada dia.");
		textArea.setFont(new Font("Roboto", Font.PLAIN, 12));
		textArea.setBackground(new Color(255, 255, 255));

		textArea.setPreferredSize(new Dimension(250, 250));
		textArea.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(textArea);

		JPanel botoes = new JPanel();
		botoes.setPreferredSize(new Dimension(100, 100));
		botoes.setBackground(new Color(255, 255, 255));

		JButton curtir = new JButton("curtir");
		curtir.setFont(new Font("Roboto Medium", Font.PLAIN, 10));
		curtir.setPreferredSize(new Dimension(80, 21));
		curtir.setBackground(new Color(255, 255, 255));
		curtir.setHorizontalAlignment(SwingConstants.CENTER);
		botoes.add(curtir, BorderLayout.CENTER);

		JButton resposta = new JButton("respostas");
		resposta.setFont(new Font("Roboto Medium", Font.PLAIN, 10));
		resposta.setPreferredSize(new Dimension(80, 21));
		resposta.setBackground(new Color(255, 255, 255));
		botoes.add(resposta, BorderLayout.CENTER);
		panel.add(botoes, BorderLayout.CENTER);

		JButton expandir = new JButton("expandir");
		expandir.setFont(new Font("Roboto Medium", Font.PLAIN, 10));
		expandir.setPreferredSize(new Dimension(80, 21));
		expandir.setBackground(new Color(255, 255, 255));
		botoes.add(expandir, BorderLayout.CENTER);
		panel.add(botoes, BorderLayout.CENTER);

		return panel;
	}
}