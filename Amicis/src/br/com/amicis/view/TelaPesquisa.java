package br.com.amicis.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import br.com.amicis.dao.AmigoDAO;
import br.com.amicis.dao.UsuarioDAO;
import br.com.amicis.model.Usuario;

public class TelaPesquisa extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel publicacao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPesquisa frame = new TelaPesquisa(null, "");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public TelaPesquisa(Usuario usuarioTela, String nome) throws SQLException {
		setBackground(new Color(255, 255, 255));
		getContentPane().setBackground(new Color(255, 255, 255));
		setIconImage(Toolkit.getDefaultToolkit().getImage("Amicis\\resources\\pngwing.com.png"));
		setTitle("Pesquisar");
		setFont(new Font("Inconsolata", Font.PLAIN, 14));
		setBounds(100, 100, 426, 393);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		// --------------------------------------------------//

		JScrollPane timeline = new JScrollPane();
		timeline.setBorder(BorderFactory.createLineBorder(new Color(230, 230, 230)));
		timeline.setBackground(new Color(255, 255, 255));
		timeline.setPreferredSize(new Dimension(200, 200));
		
		publicacao = new JPanel();
		publicacao.setLayout(new BoxLayout(publicacao, BoxLayout.Y_AXIS));
		publicacao.setPreferredSize(new Dimension(100, 400));
		publicacao.setBackground(new Color(255, 255, 255));
		publicacao.setAlignmentY(CENTER_ALIGNMENT);
		timeline.setViewportView(publicacao);

		JPanel publicacoes = new JPanel();
		publicacoes.setBackground(new Color(255, 255, 255));
		publicacoes.setLayout(new BoxLayout(publicacoes, BoxLayout.PAGE_AXIS));
		
		// --------------------------------------------------//

		publicacoes.add(timeline);

		JPanel fundo = new JPanel();
		fundo.setBackground(new Color(255, 255, 255));
		fundo.setBorder(BorderFactory.createLineBorder(new Color(230, 230, 230)));
		fundo.setPreferredSize(new Dimension(10000, 10000));
		fundo.setLayout(new BoxLayout(fundo, BoxLayout.PAGE_AXIS));

		fundo.add(publicacoes);

		getContentPane().add(fundo, BorderLayout.CENTER);

		// --------------------------------------------------//

		UsuarioDAO usuarioDAO = new UsuarioDAO();

		for (Usuario usuario : usuarioDAO.getUsuariosPesquisa(nome)) {
			try {
				JPanel div = new JPanel();
				div.setBackground(new Color(255, 255, 255));
				div.setPreferredSize(new Dimension(400, 400));
				div.setBorder(BorderFactory.createLineBorder(new Color(230, 230, 230)));
				div.setLayout(new BoxLayout(div, BoxLayout.PAGE_AXIS));

				JLabel espaço = new JLabel();
				espaço.setPreferredSize(new Dimension(100, 100));
				espaço.setBackground(new Color(255, 255, 255));
				div.add(espaço);

				JPanel perfisPanel = criarPerfis(usuario, usuarioTela);
				perfisPanel.setFont(new Font("Roboto", Font.PLAIN, 12));
				perfisPanel.setAlignmentY(Component.CENTER_ALIGNMENT);
				perfisPanel.setPreferredSize(new Dimension(400, 400));

				div.add(perfisPanel);
				publicacao.add(div);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	private JPanel criarPerfis(Usuario usuarioPesquisa, Usuario usuarioTela) {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.LINE_AXIS));
		panel.setPreferredSize(new Dimension(100, 100));
		panel.setPreferredSize(getMaximumSize());
		panel.setBackground(new Color(255, 255, 255));

		JPanel perfil = new JPanel();
		perfil.setPreferredSize(new Dimension(150, 150));
		perfil.setBackground(new Color(255, 255, 255));
		perfil.setAlignmentY(Component.CENTER_ALIGNMENT);
		perfil.setLayout(new BoxLayout(perfil, BoxLayout.PAGE_AXIS));
		perfil.setMaximumSize(getPreferredSize());
		panel.add(perfil);

		URL url;
		try {
			url = new URL(usuarioPesquisa.getFoto());
			ImageIcon imgIcon = new ImageIcon(url);
			JLabel jLabel = new JLabel(imgIcon);
			jLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
			perfil.add(jLabel);
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		}

		JLabel label = new JLabel("@" + usuarioPesquisa.getUsuario());
		label.setFont(new Font("Roboto medium", Font.PLAIN, 12));
		label.setAlignmentX(Component.CENTER_ALIGNMENT);
		label.setBackground(new Color(200, 200, 200));
		label.setPreferredSize(new Dimension(100, 100));
		perfil.add(label);

		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setFont(new Font("Roboto", Font.PLAIN, 12));
		textArea.setBackground(new Color(255, 255, 255));
		textArea.setPreferredSize(new Dimension(5, 5));
		panel.add(textArea);
		
		JPanel botoes = new JPanel();
		botoes.setPreferredSize(new Dimension(200, 200));
		botoes.setBackground(new Color(255, 255, 255));
		panel.add(botoes, BorderLayout.CENTER);
		
		JButton verPerfil = new JButton("perfil");
		verPerfil.setFont(new Font("Roboto Medium", Font.PLAIN, 10));
		verPerfil.setPreferredSize(new Dimension(80, 21));
		verPerfil.setBackground(new Color(255, 255, 255));
		botoes.add(verPerfil, BorderLayout.NORTH);
		verPerfil.setVisible(true);
		verPerfil.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("unlikely-arg-type")
			@Override
			public void mouseClicked(MouseEvent e) {
					boolean usuairor = true;
					if (usuarioTela.getUsuario().equals(usuarioPesquisa)) {
						usuairor = false;
					}
					Perfil frame = new Perfil(usuarioPesquisa, usuarioTela, usuairor);
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					frame.setResizable(false);
			}
		});
		
		JButton adicionar = new JButton();
		
		if (usuarioTela.getPerfil().sizeAmigos() == 0) {
			adicionar.setText("adicionar amigo");
		}
		
		boolean amigo = false;
		
		for (int i = 0; i < usuarioTela.getPerfil().sizeAmigos(); i++) {
			if (usuarioTela.getPerfil().getAmigo(i).equals(usuarioPesquisa.getUsuario())) {
				adicionar.setText("remover amigo");
				amigo = true;
			}
			if (!usuarioTela.getPerfil().getAmigo(i).equals(usuarioPesquisa.getUsuario()) && amigo == false) {
				adicionar.setText("adicionar amigo");
			}
		}
		
		adicionar.setBackground(new Color(255, 255, 255));
		adicionar.setFont(new Font("Roboto", Font.PLAIN, 12));
		adicionar.setPreferredSize(new Dimension(80, 21));
		adicionar.setVisible(true);
		botoes.add(adicionar, BorderLayout.SOUTH);
		
		adicionar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AmigoDAO amigoDAO = new AmigoDAO();
				if (adicionar.getText().equals("adicionar amigo")) {
					amigoDAO.saveIndividual(usuarioTela, usuarioPesquisa);
					adicionar.setText("remover amigo");
				} else {
					amigoDAO.delete(usuarioTela, usuarioPesquisa);
					adicionar.setText("adicionar amigo");
				}
			}
		});

		return panel;
	}
}