package br.com.amicis.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import br.com.amicis.dao.PublicacaoDAO;
import br.com.amicis.dao.UsuarioDAO;
import br.com.amicis.model.Publicacao;
import br.com.amicis.model.Usuario;

public class Home extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel publicacoesPanel;
	private JTextField textField;
	private Usuario usuarioTela;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home("teste");
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

	public Home(String nomeUsuario) throws SQLException {
		
		UsuarioDAO usuarioDAOTela = new UsuarioDAO();
		
		usuarioTela = usuarioDAOTela.getUsuario(nomeUsuario);
		
		
		setBackground(new Color(255, 255, 255));
		getContentPane().setBackground(new Color(255, 255, 255));

		setIconImage(Toolkit.getDefaultToolkit().getImage("Amicis\\resources\\pngwing.com.png"));
		setTitle("Home");
		setFont(new Font("Inconsolata", Font.PLAIN, 14));
		setBounds(100, 100, 1118, 660);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JScrollPane timeline = new JScrollPane();
		timeline.setBorder(BorderFactory.createLineBorder(new Color(230, 230, 230)));
		timeline.setBackground(new Color(255, 255, 255));
		timeline.setPreferredSize(new Dimension(10000, 350));

		publicacoesPanel = new JPanel();

		publicacoesPanel.setLayout(new BoxLayout(publicacoesPanel, BoxLayout.Y_AXIS));
		publicacoesPanel.setBackground(new Color(255, 255, 255));
		publicacoesPanel.setAlignmentY(CENTER_ALIGNMENT);
		timeline.setViewportView(publicacoesPanel);

		JPanel publicacoes = new JPanel();
		publicacoes.setLayout(new BoxLayout(publicacoes, BoxLayout.PAGE_AXIS));

		JPanel novaPublicacao = new JPanel();
		novaPublicacao.setForeground(Color.LIGHT_GRAY);
		novaPublicacao.setBackground(UIManager.getColor("InternalFrame.borderColor"));

		publicacoes.add(novaPublicacao);
		novaPublicacao.setLayout(null);


		JTextArea textArea = new JTextArea();
		textArea.setForeground(UIManager.getColor("InternalFrame.activeTitleForeground"));
		textArea.setBackground(new Color(255, 255, 255));
		textArea.setBounds(10, 11, 482, 87);
		novaPublicacao.add(textArea);

		JButton publicar = new JButton("publicar");
		publicar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(textArea.getText().equals(null)) {
					JOptionPane.showMessageDialog(publicacoes, "Publicação vazia.");
				}
				Publicacao publicacao = new Publicacao(usuarioTela.getPerfil());
				PublicacaoDAO publicacaoDAO = new PublicacaoDAO();
				publicacao.setConteudo(textArea.getText());
				publicacaoDAO.save(publicacao);
				
				JOptionPane.showMessageDialog(publicacoes, "Publicação realizada com sucesso.");
				textArea.setText("");
				try {
					Home frame = new Home(usuarioTela.getUsuario());
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					frame.setResizable(false);
					dispose();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		publicar.setBackground(UIManager.getColor("InternalFrame.borderColor"));
		publicar.setBounds(405, 107, 89, 23);
		novaPublicacao.add(publicar);
		
		
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

		JLabel lblNewLabel = new JLabel("Olá, " + usuarioTela.getUsuario() + "!");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblNewLabel.setBounds(55, 30, 189, 39);
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
		PublicacaoDAO publicacaoDAO = new PublicacaoDAO();
		

		for (Publicacao publicacao2: publicacaoDAO.getPublicacoesData()) {
			try {
				JPanel div = new JPanel();
				div.setBackground(new Color(255, 255, 255));
				div.setBorder(BorderFactory.createLineBorder(new Color(230, 230, 230)));
				div.setLayout(new BoxLayout(div, BoxLayout.PAGE_AXIS));
				
				JLabel espaço = new JLabel();
				espaço.setPreferredSize(new Dimension(20, 20));
				espaço.setBackground(new Color(255, 255, 255));
				
				div.add(espaço);
				
				JPanel publicacaoPanel = criarPublicacaoPanel(publicacao2.getUsuario(),
						publicacao2.getConteudo(), publicacao2.getFoto(), publicacao2.sizeCoracoes(), publicacao2.sizeRespostas());
				publicacaoPanel.setFont(new Font("Roboto", Font.PLAIN, 12));
				publicacaoPanel.setAlignmentY(Component.CENTER_ALIGNMENT);
				publicacaoPanel.setPreferredSize(new Dimension(120, 120));
				
				div.add(publicacaoPanel);
				publicacoesPanel.add(div);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private JPanel criarPublicacaoPanel(String nome, String publicacao, String foto, int numCurtidas, int numRespostas) {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.LINE_AXIS));
		panel.setPreferredSize(new Dimension(500, 500));
		panel.setMaximumSize(getPreferredSize());
		panel.setBackground(new Color(255, 255, 255));
		
		try {
			JPanel perfil = new JPanel();
			perfil.setPreferredSize(new Dimension(125, 200));
			perfil.setBackground(new Color(255, 255, 255));
			perfil.setMaximumSize(getPreferredSize());
			perfil.setAlignmentY(Component.CENTER_ALIGNMENT);
			perfil.setLayout(new BoxLayout(perfil, BoxLayout.PAGE_AXIS));
			panel.add(perfil);
			
			URL url = new URL(foto);
			ImageIcon imgIcon = new ImageIcon(url);
			JLabel jLabel = new JLabel(imgIcon);
			jLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
			perfil.add(jLabel);
			
			JLabel label = new JLabel(nome);
			label.setFont(new Font("Roboto medium", Font.PLAIN, 12));
			label.setAlignmentX(Component.CENTER_ALIGNMENT);
			label.setBackground(new Color(200, 200, 200));
			perfil.add(label);
			
			
			JPanel interecao = new JPanel();
			interecao.setPreferredSize(new Dimension(125, 200));
			interecao.setBackground(new Color(255, 255, 255));
			interecao.setMaximumSize(getPreferredSize());
			interecao.setAlignmentX(Component.CENTER_ALIGNMENT);
			interecao.setLayout(new BoxLayout(interecao, BoxLayout.X_AXIS));
			perfil.add(interecao);
			
			JLabel curtidas = new JLabel(" 🖤");
			curtidas.setHorizontalAlignment(SwingConstants.CENTER);
			curtidas.setFont(new Font("Noto Emoji Medium", Font.BOLD, 14));
			curtidas.setAlignmentX(Component.CENTER_ALIGNMENT);
			interecao.add(curtidas);
			
			JLabel numeroCurtidas = new JLabel(String.valueOf(numCurtidas));
			numeroCurtidas.setHorizontalAlignment(SwingConstants.CENTER);
			numeroCurtidas.setFont(new Font("Noto Emoji Medium", Font.PLAIN, 14));
			numeroCurtidas.setAlignmentX(Component.CENTER_ALIGNMENT);
			interecao.add(numeroCurtidas);
			
			
			
			JLabel respostas = new JLabel(" 🗨");
			respostas.setHorizontalAlignment(SwingConstants.CENTER);
			respostas.setFont(new Font("Noto Emoji Medium", Font.BOLD, 14));
			respostas.setAlignmentX(Component.CENTER_ALIGNMENT);
			interecao.add(respostas);
			
			JLabel numeroRespostas = new JLabel(String.valueOf(numRespostas));
			numeroRespostas.setHorizontalAlignment(SwingConstants.CENTER);
			numeroRespostas.setFont(new Font("Noto Emoji Medium", Font.PLAIN, 14));
			numeroRespostas.setAlignmentX(Component.CENTER_ALIGNMENT);
			interecao.add(numeroRespostas);
			
			
			
			
	
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		

		
		JTextArea textArea= new JTextArea();
		textArea.setText(publicacao);
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setFont(new Font("Roboto", Font.PLAIN, 12));
		textArea.setBackground(new Color(255, 255, 255));
		textArea.setPreferredSize(new Dimension(100, 100));
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

	public Usuario getUsuarioTela() {
		return usuarioTela;
	}

	public void setUsuarioTela(Usuario usuarioTela) {
		this.usuarioTela = usuarioTela;
	}

}