package br.com.amicis.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.UIManager;

import br.com.amicis.dao.PerfilDAO;
import br.com.amicis.model.Usuario;



public class StatusView extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel plano;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StatusView frame = new StatusView(null);
					frame.setTitle("Status");
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					frame.setResizable(false);
			        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

					
					//ImageIcon image = new ImageIcon("rede social.png");
					//frame.setIconImage(image.getImage());
//					frame.getContentPane().setBackground(new Color(118,181,197));
					
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});}
	

	/**
	 * Create the frame.
	 */
	public StatusView(Usuario usuarioTela) {
		
		setBackground(new Color(255, 255, 255));
		getContentPane().setBackground(new Color(255, 255, 255));
		setIconImage(Toolkit.getDefaultToolkit().getImage("Amicis\\resources\\pngwing.com.png"));
		setTitle("Configurações");
		setFont(new Font("Inconsolata", Font.PLAIN, 14));
		setBounds(100, 100, 460, 479);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		plano = new JPanel();
		plano.setBackground(new Color(255, 255, 255));
		setContentPane(plano);
		plano.setLayout(null);
		
		JButton Voltar = new JButton("Voltar");
		Voltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		Voltar.setFont(new Font("Roboto", Font.PLAIN, 12));
		Voltar.setBackground(Color.WHITE);
		Voltar.setBounds(138, 389, 70, 23);
		plano.add(Voltar);
		
		JButton Salvar = new JButton("Alterar");

		Salvar.setFont(new Font("Roboto", Font.PLAIN, 12));
		Salvar.setBackground(Color.WHITE);
		Salvar.setBounds(263, 389, 70, 23);
		plano.add(Salvar);
		
		JTextArea UsuarioText = new JTextArea();
		UsuarioText.setBackground(Color.WHITE);
		UsuarioText.setEditable(false);
		UsuarioText.setBounds(177, 198, 112, 22);

		plano.add(UsuarioText);
		
		JTextArea AtualizarRelacionamento = new JTextArea();
		AtualizarRelacionamento.setBackground(Color.WHITE);
		AtualizarRelacionamento.setBounds(75, 263, 242, 23);
		AtualizarRelacionamento.setEditable(false);
		AtualizarRelacionamento.setLineWrap(true);
		AtualizarRelacionamento.setWrapStyleWord(true);
		plano.add(AtualizarRelacionamento);
		
		JTextArea AtualizarLocalidade = new JTextArea();
		AtualizarLocalidade.setBackground(Color.WHITE);
		AtualizarLocalidade.setBounds(75, 329, 242, 22);
		AtualizarLocalidade.setEditable(false);
		AtualizarLocalidade.setLineWrap(true);
		AtualizarLocalidade.setWrapStyleWord(true);
		plano.add(AtualizarLocalidade);
		
		JLabel mapa = new JLabel("🌎");
		mapa.setFont(new Font("Noto Emoji Medium", Font.PLAIN, 24));
		mapa.setBounds(36, 320, 29, 45);
		plano.add(mapa);
		
		JLabel relacao = new JLabel("💟");
		relacao.setFont(new Font("Noto Emoji Medium", Font.PLAIN, 24));
		relacao.setBounds(36, 248, 29, 45);
		plano.add(relacao);
		
		URL url;
		try {
			url = new URL(usuarioTela.getFoto());
			ImageIcon imgIcon = new ImageIcon(url);
			imgIcon.setImage(imgIcon.getImage().getScaledInstance(100, 100, 100));
			JLabel foto = new JLabel(imgIcon);
			foto.setAlignmentX(Component.CENTER_ALIGNMENT);
			foto.setBounds(145, 11, 150, 150);
			plano.add(foto);
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		}
		
		if(usuarioTela.getUsuario() == null) {
			UsuarioText.setText("Não foi Possível exibir o Nome");
		}else
			UsuarioText.setText("@" + usuarioTela.getUsuario());
		
		if(usuarioTela.getPerfil().getStatus().getRelacionamento() == null) {
			AtualizarRelacionamento.setText("Sem Relacionamento");
		} else {
			AtualizarRelacionamento.setText(usuarioTela.getPerfil().getStatus().getRelacionamento());
		}
		
		
		if(usuarioTela.getPerfil().getStatus().getLocalidade() == null) {
			AtualizarLocalidade.setText("Sem Local");
		} else {
			AtualizarLocalidade.setText(usuarioTela.getPerfil().getStatus().getLocalidade());
		}
		
	
		Salvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(Salvar.getText().equals("Alterar")) {
					AtualizarRelacionamento.setText("");
					AtualizarRelacionamento.setBackground(new Color(230, 230, 230));
					Salvar.setText("Salvar");
					AtualizarRelacionamento.setEditable(true);	
					AtualizarLocalidade.setText("");
					AtualizarLocalidade.setBackground(new Color(230, 230, 230));
					Salvar.setText("Salvar");
					AtualizarLocalidade.setEditable(true);	
				}else {
					AtualizarRelacionamento.setBackground(new Color(255, 255, 255));
					AtualizarLocalidade.setBackground(new Color(255, 255, 255));
					
					if(AtualizarRelacionamento.getText().equals("")) {
					usuarioTela.getPerfil().getStatus().setRelacionamento("Sem Relacionamento");
				}else {
					usuarioTela.getPerfil().getStatus().setRelacionamento(AtualizarRelacionamento.getText());
				}
					if(AtualizarLocalidade.getText().equals("")) {
						usuarioTela.getPerfil().getStatus().setLocalidade("Sem Local");
					}else {
						usuarioTela.getPerfil().getStatus().setLocalidade(AtualizarLocalidade.getText());
					}
					PerfilDAO perfilDAO = new PerfilDAO();
					perfilDAO.updateStatus(usuarioTela.getPerfil());
					Salvar.setText("Alterar");
					AtualizarRelacionamento.setEditable(false);
					AtualizarLocalidade.setEditable(false);


				}		
			}
		});
	
	
	
	
	
	
	}
}