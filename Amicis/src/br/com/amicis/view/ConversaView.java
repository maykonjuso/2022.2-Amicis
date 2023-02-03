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
import javax.swing.UIManager;

import br.com.amicis.dao.ConversaDAO;
import br.com.amicis.dao.MensagemDAO;
import br.com.amicis.model.Conversa;
import br.com.amicis.model.Mensagem;
import br.com.amicis.model.Usuario;

public class ConversaView extends JFrame {

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
					ConversaView frame = new ConversaView(null, null);
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
	 * 
	 * @throws SQLException
	 */
	public ConversaView(Usuario usuarioTela, Usuario amigo) throws SQLException {
		ConversaDAO conversaDAO = new ConversaDAO();
		MensagemDAO mensagemDAO = new MensagemDAO();
	
		Conversa conversaAtual = conversaDAO.getConversaUnica(usuarioTela, amigo);
		
		if (conversaAtual.temId()) {
			conversaAtual = new Conversa(usuarioTela, amigo);
			conversaDAO.save(conversaAtual);
		}
		
		setBackground(new Color(255, 255, 255));
		getContentPane().setBackground(new Color(255, 255, 255));

		setIconImage(Toolkit.getDefaultToolkit().getImage("Amicis\\resources\\pngwing.com.png"));
		setTitle("Home");
		setFont(new Font("Inconsolata", Font.PLAIN, 14));
		setBounds(100, 100, 520, 660);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		// --------------------------------------------------//
		
		JScrollPane timeline = new JScrollPane();
		timeline.setBorder(BorderFactory.createLineBorder(new Color(230, 230, 230)));
		timeline.setBackground(new Color(255, 255, 255));
		timeline.setPreferredSize(new Dimension(10000, 345));
		
		publicacao = new JPanel();
		
		publicacao.setLayout(new BoxLayout(publicacao, BoxLayout.Y_AXIS));
		publicacao.setBackground(new Color(255, 255, 255));
		publicacao.setAlignmentY(CENTER_ALIGNMENT);
		timeline.setViewportView(publicacao);

		JPanel publicacoes = new JPanel();
		publicacoes.setBackground(new Color(255, 255, 255));
		publicacoes.setLayout(new BoxLayout(publicacoes, BoxLayout.PAGE_AXIS));
		
		// --------------------------------------------------//
		
		JPanel novaPublicacao = new JPanel();
		novaPublicacao.setBounds(0, 479, 504, 141);
		novaPublicacao.setForeground(Color.LIGHT_GRAY);
		novaPublicacao.setBackground(UIManager.getColor("InternalFrame.borderColor"));

		novaPublicacao.setLayout(null);

		JTextArea textAreaResposta = new JTextArea();
		textAreaResposta.setFont(new Font("Roboto", Font.PLAIN, 13));
		textAreaResposta.setLineWrap(true);
		textAreaResposta.setWrapStyleWord(true);
		textAreaResposta.setForeground(UIManager.getColor("InternalFrame.activeTitleForeground"));
		textAreaResposta.setBackground(new Color(255, 255, 255));
		textAreaResposta.setBounds(10, 11, 482, 87);
		novaPublicacao.add(textAreaResposta);

		JButton publicar = new JButton("responder");
		publicar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (textAreaResposta.getText().equals("")) {
					JOptionPane.showMessageDialog(publicacoes, "Campo vazio.");
				} else {
					try {
						Conversa conversaNova = conversaDAO.getConversaUnica(usuarioTela, amigo);
						Mensagem mensagem = new Mensagem(usuarioTela, conversaNova);
						mensagem.setConteudo(textAreaResposta.getText());
						mensagemDAO.save(mensagem);
						JOptionPane.showMessageDialog(publicacoes, "Mensagem enviada com sucesso.");
						textAreaResposta.setText("");
					} catch (SQLException e2) {
						e2.printStackTrace();
					}
					try {
						
						ConversaView frame = new ConversaView(usuarioTela, amigo);
						frame.setVisible(true);
						frame.setLocationRelativeTo(null);
						frame.setResizable(false);
						dispose();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});

		publicar.setBackground(UIManager.getColor("InternalFrame.borderColor"));
		publicar.setBounds(391, 107, 103, 23);
		novaPublicacao.add(publicar);

		JButton apagar1 = new JButton("apagar");
		apagar1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textAreaResposta.setText("");
			}
		});

		apagar1.setBackground(SystemColor.menu);
		apagar1.setBounds(278, 107, 103, 23);
		novaPublicacao.add(apagar1);

		// --------------------------------------------------//
		publicacoes.add(timeline);
		publicacoes.add(novaPublicacao);

		JPanel fundo = new JPanel();
		fundo.setBackground(new Color(255, 255, 255));
		fundo.setBorder(BorderFactory.createLineBorder(new Color(230, 230, 230)));
		fundo.setLayout(new BoxLayout(fundo, BoxLayout.PAGE_AXIS));

		fundo.add(publicacoes);

		getContentPane().add(fundo, BorderLayout.CENTER);

		// --------------------------------------------------//
		
		Conversa conversa = new Conversa(usuarioTela, amigo);
		for (Mensagem mensagem : mensagemDAO.getMensagens(usuarioTela, conversa)) {
			try {
				JPanel div = new JPanel();
				div.setBackground(new Color(255, 255, 255));
				div.setBorder(BorderFactory.createLineBorder(new Color(230, 230, 230)));
				div.setLayout(new BoxLayout(div, BoxLayout.PAGE_AXIS));

				JLabel espaço = new JLabel();
				espaço.setPreferredSize(new Dimension(20, 20));
				espaço.setBackground(new Color(255, 255, 255));

				div.add(espaço);
				
				JPanel respostaPanel = criarPublicacaoPanel(usuarioTela, amigo, mensagem, usuarioTela, amigo);
				respostaPanel.setFont(new Font("Roboto", Font.PLAIN, 12));
				respostaPanel.setAlignmentY(Component.CENTER_ALIGNMENT);
				respostaPanel.setPreferredSize(new Dimension(120, 120));
				respostaPanel.setMaximumSize(getPreferredSize());

				div.add(respostaPanel);
				publicacao.add(div);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	private JPanel criarPublicacaoPanel(Usuario remetente, Usuario destinatario, Mensagem mensagem, Usuario usuarioTela, Usuario amigo) {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.LINE_AXIS));
		panel.setPreferredSize(new Dimension(100, 100));
		panel.setMaximumSize(getPreferredSize());
		panel.setBackground(new Color(255, 255, 255));

		JPanel perfil = new JPanel();
		perfil.setPreferredSize(new Dimension(100, 100));
		perfil.setBackground(new Color(255, 255, 255));
		perfil.setMaximumSize(getPreferredSize());
		perfil.setAlignmentY(Component.CENTER_ALIGNMENT);
		perfil.setLayout(new BoxLayout(perfil, BoxLayout.PAGE_AXIS));
		panel.add(perfil);
		
		DateFormat dateFormat = new SimpleDateFormat("dd 'de' MMMM");      
		String dateToStr = dateFormat.format(mensagem.getDate());
		JLabel data = new JLabel(dateToStr);
		data.setFont(new Font("Roboto", Font.PLAIN, 8));
		data.setAlignmentX(Component.CENTER_ALIGNMENT);
		data.setBackground(new Color(200, 200, 200));
		data.setPreferredSize(new Dimension(100, 100));
		perfil.add(data);

		URL url;
		try {
			url = new URL(mensagem.getFoto());
			ImageIcon imgIcon = new ImageIcon(url);
			JLabel jLabel = new JLabel(imgIcon);
			jLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
			perfil.add(jLabel);
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		}

		JLabel label = new JLabel("@"+mensagem.getUsuario());
		label.setFont(new Font("Roboto medium", Font.PLAIN, 12));
		label.setAlignmentX(Component.CENTER_ALIGNMENT);
		label.setBackground(new Color(200, 200, 200));
		label.setPreferredSize(new Dimension(100, 100));
		perfil.add(label);

		JPanel interecao = new JPanel();
		interecao.setBackground(new Color(255, 255, 255));
		interecao.setAlignmentX(Component.CENTER_ALIGNMENT);
		interecao.setLayout(new BoxLayout(interecao, BoxLayout.X_AXIS));
		interecao.setPreferredSize(new Dimension(100, 100));
		perfil.add(interecao);
		
		JTextArea textArea = new JTextArea();
		textArea.setText(mensagem.getConteudo());
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setFont(new Font("Roboto", Font.PLAIN, 12));
		textArea.setBackground(new Color(255, 255, 255));
		textArea.setPreferredSize(new Dimension(10, 10));
		panel.add(textArea);
		
		JPanel botoes = new JPanel();
		botoes.setPreferredSize(new Dimension(100, 100));
		botoes.setBackground(new Color(255, 255, 255));
		
		JButton excluir = new JButton("excluir");
		excluir.setFont(new Font("Roboto Medium", Font.PLAIN, 10));
		excluir.setPreferredSize(new Dimension(80, 21));
		excluir.setBackground(new Color(255, 255, 255));
		botoes.add(excluir, BorderLayout.CENTER);
		panel.add(botoes, BorderLayout.CENTER);
		excluir.setVisible(true);
		excluir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MensagemDAO mensagemDAO = new MensagemDAO();
				mensagemDAO.delete(mensagem);
				ConversaView frame;
				try {
					frame = new ConversaView(usuarioTela, amigo);
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					frame.setResizable(false);
					dispose();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "Mensagem excluída com sucesso.");

			}
		});

		return panel;
	}
}