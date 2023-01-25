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
import java.text.DateFormat;
import java.text.SimpleDateFormat;

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

import br.com.amicis.dao.CoracaoDAO;
import br.com.amicis.dao.PublicacaoDAO;
import br.com.amicis.dao.UsuarioDAO;
import br.com.amicis.model.Publicacao;
import br.com.amicis.model.Usuario;

public class Home extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel publicacoesPanel;
	private JTextField pesquisa;
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
		textArea.setFont(new Font("Roboto", Font.PLAIN, 13));
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setForeground(UIManager.getColor("InternalFrame.activeTitleForeground"));
		textArea.setBackground(new Color(255, 255, 255));
		textArea.setBounds(10, 11, 482, 87);
		novaPublicacao.add(textArea);

		JButton publicar = new JButton("publicar");
		publicar.setFont(new Font("Roboto Medium", Font.PLAIN, 10));
		publicar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (textArea.getText().equals("")) {
					JOptionPane.showMessageDialog(publicacoes, "Publicação vazia.");
				} else {
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
						publicacaoDAO.getPublicacoes(usuarioTela.getPerfil());
						dispose();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		publicar.setBackground(UIManager.getColor("InternalFrame.borderColor"));
		publicar.setBounds(405, 107, 89, 23);
		novaPublicacao.add(publicar);

		JButton apagar = new JButton("apagar");
		apagar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textArea.setText("");
			}
		});
		apagar.setBackground(SystemColor.menu);
		apagar.setBounds(307, 107, 89, 23);
		apagar.setFont(new Font("Roboto Medium", Font.PLAIN, 10));
		novaPublicacao.add(apagar);
		publicacoes.add(timeline);
		getContentPane().add(publicacoes, BorderLayout.CENTER);

		JPanel menu = new JPanel();
		menu.setBackground(new Color(255, 255, 255));
		getContentPane().add(menu, BorderLayout.LINE_START);
		menu.setLayout(null);
		menu.setPreferredSize(new Dimension(300, 100));

		JButton perfil = new JButton("perfil");
		perfil.setBackground(new Color(255, 255, 255));
		perfil.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Perfil frame = new Perfil(usuarioTela, usuarioTela, false);
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				frame.setResizable(false);
			}
		});
		perfil.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
		perfil.setBounds(94, 171, 156, 33);
		menu.add(perfil);
		
		

		JButton amigos = new JButton("amigos");
		amigos.setBackground(new Color(255, 255, 255));
		amigos.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
		amigos.setBounds(94, 228, 156, 33);
		menu.add(amigos);

		JButton notificacoes = new JButton("notificações");
		notificacoes.setBackground(new Color(255, 255, 255));
		notificacoes.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
		notificacoes.setBounds(94, 287, 156, 33);
		menu.add(notificacoes);

		JLabel emojiUm = new JLabel("👤");
		emojiUm.setHorizontalAlignment(SwingConstants.CENTER);
		emojiUm.setFont(new Font("Noto Emoji Medium", Font.BOLD, 28));
		emojiUm.setBounds(10, 156, 78, 63);
		menu.add(emojiUm);

		JLabel emojiUm_1_1 = new JLabel("👥");
		emojiUm_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		emojiUm_1_1.setFont(new Font("Noto Emoji Medium", Font.BOLD, 28));
		emojiUm_1_1.setBounds(10, 213, 78, 63);
		menu.add(emojiUm_1_1);

		JLabel emojiUm_1_2 = new JLabel("🔥");
		emojiUm_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		emojiUm_1_2.setFont(new Font("Noto Emoji Medium", Font.PLAIN, 28));
		emojiUm_1_2.setBounds(10, 272, 78, 63);
		menu.add(emojiUm_1_2);

		JButton configuracoes = new JButton("configurações");
		configuracoes.setBackground(new Color(255, 255, 255));
		configuracoes.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
		configuracoes.setBounds(94, 495, 156, 33);
		menu.add(configuracoes);
		configuracoes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Configuracoes frame = new Configuracoes(usuarioTela);
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				frame.setResizable(false);
			}
		});

		JLabel emojiUm_1_2_1 = new JLabel("⚙️");
		emojiUm_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		emojiUm_1_2_1.setFont(new Font("Noto Emoji Medium", Font.BOLD, 28));
		emojiUm_1_2_1.setBounds(10, 480, 78, 63);
		menu.add(emojiUm_1_2_1);

		JLabel lblNewLabel = new JLabel("Olá, " + usuarioTela.getUsuario() + "!");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblNewLabel.setBounds(55, 30, 189, 39);
		menu.add(lblNewLabel);

		JButton sair = new JButton("sair");
		sair.setBackground(new Color(255, 255, 255));
		sair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login frame = new Login();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				frame.setResizable(false);
				dispose();
			}
		});
		sair.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
		sair.setBounds(94, 554, 156, 33);
		menu.add(sair);

		JLabel emojiUm_1_2_1_1 = new JLabel("😔");
		emojiUm_1_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		emojiUm_1_2_1_1.setFont(new Font("Noto Emoji Medium", Font.BOLD, 28));
		emojiUm_1_2_1_1.setBounds(10, 539, 78, 63);
		menu.add(emojiUm_1_2_1_1);
		
		JButton feed = new JButton("atualizar");
		feed.setBackground(new Color(255, 255, 255));
		feed.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Home frame = new Home(usuarioTela.getUsuario());
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					frame.setResizable(false);
					dispose();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		feed.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
		feed.setBounds(94, 94, 156, 33);
		menu.add(feed);
		
		JLabel emojiUm_2 = new JLabel("🗿");
		emojiUm_2.setHorizontalAlignment(SwingConstants.CENTER);
		emojiUm_2.setFont(new Font("Noto Emoji Medium", Font.PLAIN, 28));
		emojiUm_2.setBounds(10, 79, 78, 63);
		menu.add(emojiUm_2);

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
		btnConversas.setBackground(new Color(255, 255, 255));
		btnConversas.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
		btnConversas.setBounds(0, 591, 297, 29);
		conversas.add(btnConversas);

		pesquisa = new JTextField();
		pesquisa.setBounds(26, 105, 177, 29);
		conversas.add(pesquisa);
		pesquisa.setColumns(10);

		JButton botaoPesquisa = new JButton("🔎");
		botaoPesquisa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaPesquisa frame;
				try {
					frame = new TelaPesquisa(usuarioTela, pesquisa.getText());
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					frame.setResizable(false);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		botaoPesquisa.setBackground(new Color(255, 255, 255));
		botaoPesquisa.setFont(new Font("Noto Emoji", Font.BOLD, 14));
		botaoPesquisa.setBounds(213, 105, 51, 29);
		conversas.add(botaoPesquisa);

		JLabel lblEncontreNovosAmigos = new JLabel("Faça novos amigos...");
		lblEncontreNovosAmigos.setHorizontalAlignment(SwingConstants.CENTER);
		lblEncontreNovosAmigos.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblEncontreNovosAmigos.setBounds(50, 30, 199, 39);
		conversas.add(lblEncontreNovosAmigos);

		PublicacaoDAO publicacaoDAO = new PublicacaoDAO();

		for (Publicacao publicacao2 : publicacaoDAO.getPublicacoesData()) {
			try {
				JPanel div = new JPanel();
				div.setBackground(new Color(255, 255, 255));
				div.setBorder(BorderFactory.createLineBorder(new Color(230, 230, 230)));
				div.setLayout(new BoxLayout(div, BoxLayout.PAGE_AXIS));

				JLabel espaço = new JLabel();
				espaço.setPreferredSize(new Dimension(20, 20));
				espaço.setBackground(new Color(255, 255, 255));

				div.add(espaço);

				JPanel publicacaoPanel = criarPublicacaoPanel(publicacao2.getUsuario(), publicacao2.getConteudo(),
						publicacao2.getFoto(), publicacao2.sizeCoracoes(), publicacao2.sizeRespostas(), publicacao2);
				publicacaoPanel.setFont(new Font("Roboto", Font.PLAIN, 12));
				publicacaoPanel.setAlignmentY(Component.CENTER_ALIGNMENT);
				publicacaoPanel.setPreferredSize(new Dimension(125, 125));

				div.add(publicacaoPanel);
				publicacoesPanel.add(div);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private JPanel criarPublicacaoPanel(String nome, String publicacao, String foto, int numCurtidas, int numRespostas,
			Publicacao publicacao2) {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.LINE_AXIS));
		panel.setPreferredSize(new Dimension(500, 500));
		panel.setMaximumSize(getPreferredSize());
		panel.setBackground(new Color(255, 255, 255));

		JPanel perfil = new JPanel();
		perfil.setPreferredSize(new Dimension(130, 200));
		perfil.setBackground(new Color(255, 255, 255));
		perfil.setMaximumSize(getPreferredSize());
		perfil.setAlignmentY(Component.CENTER_ALIGNMENT);
		perfil.setLayout(new BoxLayout(perfil, BoxLayout.PAGE_AXIS));
		panel.add(perfil);
		
		DateFormat dateFormat = new SimpleDateFormat("dd 'de' MMMM");      
		String dateToStr = dateFormat.format(publicacao2.getData());
		JLabel data = new JLabel(dateToStr);
		data.setFont(new Font("Roboto", Font.PLAIN, 8));
		data.setAlignmentX(Component.CENTER_ALIGNMENT);
		data.setBackground(new Color(200, 200, 200));
		data.setPreferredSize(new Dimension(100, 100));
		perfil.add(data);

		URL url;
		try {
			url = new URL(foto);
			ImageIcon imgIcon = new ImageIcon(url);
			imgIcon.setImage(imgIcon.getImage().getScaledInstance(60, 60, 100));
			JLabel jLabel = new JLabel(imgIcon);
			jLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
			perfil.add(jLabel);
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		}

		JLabel label = new JLabel("@"+nome);
		label.setFont(new Font("Roboto medium", Font.PLAIN, 12));
		label.setAlignmentX(Component.CENTER_ALIGNMENT);
		label.setBackground(new Color(200, 200, 200));
		label.setPreferredSize(new Dimension(250, 250));
		perfil.add(label);
		
		JPanel interecao = new JPanel();
		interecao.setBackground(new Color(255, 255, 255));
		interecao.setAlignmentX(Component.CENTER_ALIGNMENT);
		interecao.setLayout(new BoxLayout(interecao, BoxLayout.X_AXIS));
		interecao.setPreferredSize(new Dimension(300, 300));
		perfil.add(interecao);
		
		JLabel curtidas = new JLabel("🤍");
		curtidas.setHorizontalAlignment(SwingConstants.CENTER);
		curtidas.setFont(new Font("Noto Emoji Medium", Font.BOLD, 11));
		curtidas.setAlignmentX(Component.CENTER_ALIGNMENT);
		interecao.add(curtidas);

		JLabel numeroCurtidas = new JLabel(String.valueOf(numCurtidas));
		numeroCurtidas.setHorizontalAlignment(SwingConstants.CENTER);
		numeroCurtidas.setFont(new Font("Noto Emoji Medium", Font.PLAIN, 14));
		numeroCurtidas.setAlignmentX(Component.CENTER_ALIGNMENT);
		interecao.add(numeroCurtidas);

		JLabel respostas = new JLabel("🗨");
		respostas.setHorizontalAlignment(SwingConstants.CENTER);
		respostas.setFont(new Font("Noto Emoji Medium", Font.BOLD, 14));
		respostas.setAlignmentX(Component.CENTER_ALIGNMENT);
		interecao.add(respostas);

		JLabel numeroRespostas = new JLabel(String.valueOf(numRespostas));
		numeroRespostas.setHorizontalAlignment(SwingConstants.CENTER);
		numeroRespostas.setFont(new Font("Noto Emoji Medium", Font.PLAIN, 14));
		numeroRespostas.setAlignmentX(Component.CENTER_ALIGNMENT);
		interecao.add(numeroRespostas);

		JTextArea textArea = new JTextArea();
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
		
		JButton Perfil = new JButton("perfil");
		Perfil.setFont(new Font("Roboto Medium", Font.PLAIN, 10));
		Perfil.setPreferredSize(new Dimension(80, 21));
		Perfil.setBackground(new Color(255, 255, 255));
		botoes.add(Perfil, BorderLayout.CENTER);
		panel.add(botoes, BorderLayout.CENTER);
		Perfil.setVisible(true);
		
		Perfil.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				UsuarioDAO perfilUsuarioDAO = new UsuarioDAO();
				try {
					Usuario usuario1 = perfilUsuarioDAO.getUsuario(publicacao2.getUsuario());
					boolean usuairor = true;
					if (usuarioTela.getUsuario().equals( publicacao2.getUsuario())) {
						usuairor = false;
					}
					Perfil frame = new Perfil(usuario1, usuarioTela, usuairor);
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					frame.setResizable(false);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});

		JButton curtir = new JButton("curtir");
		curtir.setFont(new Font("Roboto Medium", Font.PLAIN, 10));
		curtir.setPreferredSize(new Dimension(80, 21));
		curtir.setBackground(new Color(255, 255, 255));
		curtir.setHorizontalAlignment(SwingConstants.CENTER);
		curtir.setVisible(false);
		botoes.add(curtir, BorderLayout.CENTER);

		JButton descurtir = new JButton("descurtir");
		descurtir.setFont(new Font("Roboto Medium", Font.PLAIN, 10));
		descurtir.setPreferredSize(new Dimension(80, 21));
		descurtir.setBackground(new Color(255, 255, 255));
		descurtir.setHorizontalAlignment(SwingConstants.CENTER);
		descurtir.setVisible(false);
		botoes.add(descurtir, BorderLayout.CENTER);

		if (publicacao2.sizeCoracoes() == 0) {
			curtir.setVisible(true);
		}

		boolean curtiu = false;

		for (int i = 0; i < publicacao2.sizeCoracoes(); i++) {
			if (publicacao2.getCoracao(i).equals(usuarioTela.getUsuario())) {
				descurtir.setVisible(true);
				curtir.setVisible(false);
				curtiu = true;
				curtidas.setText("🖤");
			}

			if (!publicacao2.getCoracao(i).equals(usuarioTela.getUsuario()) && curtiu == false) {
				curtir.setVisible(true);
				descurtir.setVisible(false);
				curtidas.setText("🤍");
			}
		}

		curtir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				publicacao2.adicionarCoracao(usuarioTela.getUsuario());
				curtir.setVisible(false);
				descurtir.setVisible(true);
				CoracaoDAO coracaoDAO = new CoracaoDAO();
				coracaoDAO.save(publicacao2, usuarioTela.getPerfil());
				curtidas.setText("🖤");
				if (numeroCurtidas.getText().equals(String.valueOf(numCurtidas))) {
					numeroCurtidas.setText(String.valueOf(numCurtidas + 1));
				} else {
					numeroCurtidas.setText(String.valueOf(numCurtidas));
				}

			}
		});

		descurtir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				publicacao2.removerCoracao(usuarioTela.getUsuario());
				descurtir.setVisible(false);
				curtir.setVisible(true);
				CoracaoDAO coracaoDAO = new CoracaoDAO();
				coracaoDAO.delete(publicacao2, usuarioTela.getPerfil());
				curtidas.setText("🤍");
				if (numeroCurtidas.getText().equals(String.valueOf(numCurtidas))) {
					numeroCurtidas.setText(String.valueOf(numCurtidas - 1));
				} else {
					numeroCurtidas.setText(String.valueOf(numCurtidas));
				}
			}
		});
		

		JButton expandir = new JButton("expandir");
		expandir.setFont(new Font("Roboto Medium", Font.PLAIN, 10));
		expandir.setPreferredSize(new Dimension(80, 21));
		expandir.setBackground(new Color(255, 255, 255));
		botoes.add(expandir, BorderLayout.CENTER);
		panel.add(botoes, BorderLayout.CENTER);
		
		JButton excluir = new JButton("excluir");
		excluir.setFont(new Font("Roboto Medium", Font.PLAIN, 10));
		excluir.setPreferredSize(new Dimension(80, 21));
		excluir.setBackground(new Color(255, 255, 255));
		botoes.add(excluir, BorderLayout.CENTER);
		panel.add(botoes, BorderLayout.CENTER);
		excluir.setVisible(false);
		
		JButton listaCurtidas = new JButton("curtidas");
		listaCurtidas.setFont(new Font("Roboto Medium", Font.PLAIN, 10));
		listaCurtidas.setPreferredSize(new Dimension(80, 21));
		listaCurtidas.setBackground(new Color(255, 255, 255));
		botoes.add(listaCurtidas, BorderLayout.CENTER);
		panel.add(botoes, BorderLayout.CENTER);
		listaCurtidas.setVisible(false);
		listaCurtidas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(publicacao2.sizeCoracoes() == 0) {
					JOptionPane.showMessageDialog(null, "Publicação sem curtidas.");
				} else {
					StringBuilder stringBuilder1 = new StringBuilder();
					for (int i = 0; i < publicacao2.sizeCoracoes(); i++) {
						stringBuilder1.append(publicacao2.getCoracao(i) + ", ");
					}
					stringBuilder1.replace(stringBuilder1.length() - 2, stringBuilder1.length() - 1, ".");
					JOptionPane.showMessageDialog(null, stringBuilder1);	
				}
				}
		});
		
		excluir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PublicacaoDAO publicacaoDAO = new PublicacaoDAO();
				publicacaoDAO.delete(publicacao2);
				JOptionPane.showMessageDialog(null, "Publicação excluída com sucesso.");
				Home frame;
				try {
					frame = new Home(usuarioTela.getUsuario());
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					frame.setResizable(false);
					dispose();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		try {
			if (usuarioTela.getUsuario().equals(nome)) {
				excluir.setVisible(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		expandir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ExpandirPublicacao frame;
				try {
					frame = new ExpandirPublicacao(publicacao2, panel, usuarioTela);
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					frame.setResizable(false);
					expandir.setVisible(false);
					listaCurtidas.setVisible(true);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		
		
		return panel;
	}

	public Usuario getUsuarioTela() {
		return usuarioTela;
	}

	public void setUsuarioTela(Usuario usuarioTela) {
		this.usuarioTela = usuarioTela;
	}
}