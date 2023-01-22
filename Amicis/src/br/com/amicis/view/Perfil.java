package br.com.amicis.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import br.com.amicis.dao.AmigoDAO;
import br.com.amicis.dao.BloqueadoDAO;
import br.com.amicis.dao.PerfilDAO;
import br.com.amicis.model.Usuario;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Perfil extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentJPanel;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Perfil frame = new Perfil(null, null, false);
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
	 * @wbp.parser.constructor
	 */
	public Perfil(Usuario usuarioDoPerfil, Usuario usuarioSistema, boolean seuPerfil) {
		setBackground(new Color(255, 255, 255));
		getContentPane().setBackground(new Color(255, 255, 255));

		setIconImage(Toolkit.getDefaultToolkit().getImage("Amicis\\resources\\pngwing.com.png"));
		setTitle("Perfil");
		setFont(new Font("Inconsolata", Font.PLAIN, 14));
		setBounds(100, 100, 414, 575);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		contentJPanel = new JPanel();
		contentJPanel.setBackground(new Color(255, 255, 255));
		setContentPane(contentJPanel);
		contentJPanel.setLayout(null);

		URL url;
		try {
			url = new URL(usuarioDoPerfil.getFoto());
			ImageIcon imgIcon = new ImageIcon(url);
			imgIcon.setImage(imgIcon.getImage().getScaledInstance(100, 100, 100));
			JLabel foto = new JLabel(imgIcon);
			foto.setAlignmentX(Component.CENTER_ALIGNMENT);
			foto.setBounds(125, 39, 150, 150);
			contentJPanel.add(foto);
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		}
		
		AmigoDAO amigoDAO = new AmigoDAO();
		
		JButton adicionar = new JButton();
		
		if (usuarioSistema.getPerfil().sizeAmigos() == 0) {
			adicionar.setText("adicionar amigo");
		}
		
		boolean amigo = false;
		
		for (int i = 0; i < usuarioSistema.getPerfil().sizeAmigos(); i++) {
			if (usuarioSistema.getPerfil().getAmigo(i).equals(usuarioDoPerfil.getUsuario())) {
				adicionar.setText("remover amigo");
				amigo = true;
			}
			if (!usuarioSistema.getPerfil().getAmigo(i).equals(usuarioDoPerfil.getUsuario()) && amigo == false) {
				adicionar.setText("adicionar amigo");
			}
		}
		
		adicionar.setBackground(new Color(255, 255, 255));
		adicionar.setFont(new Font("Roboto", Font.PLAIN, 12));
		adicionar.setBounds(10, 240, 121, 21);
		adicionar.setVisible(seuPerfil);
		contentJPanel.add(adicionar);
		
		adicionar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (adicionar.getText().equals("adicionar amigo")) {
					amigoDAO.saveIndividual(usuarioSistema, usuarioDoPerfil);
					adicionar.setText("remover amigo");
				} else {
					amigoDAO.delete(usuarioSistema, usuarioDoPerfil);
					adicionar.setText("adicionar amigo");
				}
			}
		});
		
		BloqueadoDAO bloqueadoDAO = new BloqueadoDAO();
		JButton bloquear = new JButton();
		
		if (usuarioSistema.getPerfil().sizeBloqueados() == 0) {
			bloquear.setText("bloquear");
		}
		
		boolean bloqueado = false;
		
		for (int i = 0; i < usuarioSistema.getPerfil().sizeBloqueados(); i++) {
			if (usuarioSistema.getPerfil().getBloqueado(i).equals(usuarioDoPerfil.getUsuario())) {
				bloquear.setText("desbloquear");
				bloqueado = true;
			}
			if (!usuarioSistema.getPerfil().getBloqueado(i).equals(usuarioDoPerfil.getUsuario()) && bloqueado == false) {
				bloquear.setText("bloquear");
			}
		}
		
		bloquear.setBackground(new Color(255, 255, 255));
		bloquear.setFont(new Font("Roboto", Font.PLAIN, 12));
		bloquear.setBounds(140, 240, 121, 21);
		bloquear.setVisible(seuPerfil);
		contentJPanel.add(bloquear);
		
		bloquear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (bloquear.getText().equals("bloquear")) {
					bloqueadoDAO.saveIndividual(usuarioSistema, usuarioDoPerfil);
					bloquear.setText("desbloquear");
				} else {
					bloqueadoDAO.delete(usuarioSistema, usuarioDoPerfil);
					bloquear.setText("bloquear");
				}
			}
		});
		
		JButton conversar = new JButton("conversar");
		conversar.setBackground(new Color(255, 255, 255));
		conversar.setFont(new Font("Roboto", Font.PLAIN, 12));
		conversar.setBounds(270, 240, 121, 21);
		conversar.setVisible(seuPerfil);
		contentJPanel.add(conversar);
		
		JLabel emojiUm = new JLabel("🗿");
		emojiUm.setHorizontalAlignment(SwingConstants.CENTER);
		emojiUm.setFont(new Font("Noto Emoji Medium", Font.PLAIN, 24));
		emojiUm.setBounds(45, 269, 55, 45);
		contentJPanel.add(emojiUm);
		
		JLabel emojiUm_1 = new JLabel("🎈");
		emojiUm_1.setHorizontalAlignment(SwingConstants.CENTER);
		emojiUm_1.setFont(new Font("Noto Emoji Medium", Font.PLAIN, 24));
		emojiUm_1.setBounds(45, 324, 55, 45);
		contentJPanel.add(emojiUm_1);
		
		JLabel emojiUm_2 = new JLabel("✉️");
		emojiUm_2.setHorizontalAlignment(SwingConstants.CENTER);
		emojiUm_2.setFont(new Font("Noto Emoji Medium", Font.PLAIN, 24));
		emojiUm_2.setBounds(45, 379, 55, 45);
		contentJPanel.add(emojiUm_2);
		
		JLabel emojiUm_3 = new JLabel("📞");
		emojiUm_3.setHorizontalAlignment(SwingConstants.CENTER);
		emojiUm_3.setFont(new Font("Noto Emoji Medium", Font.PLAIN, 24));
		emojiUm_3.setBounds(45, 434, 55, 45);
		contentJPanel.add(emojiUm_3);
		
		JTextArea bio = new JTextArea();
		bio.setEditable(false);
		bio.setLineWrap(true);
		bio.setWrapStyleWord(true);
		bio.setBounds(109, 282, 225, 19);
		bio.setFont(new Font("Roboto", Font.PLAIN, 13));
		contentJPanel.add(bio);
		
		if(usuarioDoPerfil.getPerfil().getBio() == null) {
			bio.setText("Sem biografia");
		} else {
			bio.setText(usuarioDoPerfil.getPerfil().getBio());
		}
		
		JTextArea aniversario = new JTextArea();
		aniversario.setEditable(false);
		aniversario.setLineWrap(true);
		aniversario.setWrapStyleWord(true);
		aniversario.setBounds(110, 337, 225, 19);
		aniversario.setFont(new Font("Roboto", Font.PLAIN, 13));
		contentJPanel.add(aniversario);
		
		if(usuarioDoPerfil.getDataNascimeto() == null) {
			aniversario.setText("Sem data de nascimento");
		} else {
			DateFormat dateFormat = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy");      
			String dateToStr = dateFormat.format(usuarioDoPerfil.getDataNascimeto());
			aniversario.setText("Nascido(a) em " + dateToStr);
		}
		
		JTextArea email = new JTextArea();
		email.setEditable(false);
		email.setLineWrap(true);
		email.setWrapStyleWord(true);
		email.setBounds(110, 392, 225, 19);
		email.setFont(new Font("Roboto", Font.PLAIN, 13));
		contentJPanel.add(email);
		
		if(usuarioDoPerfil.getEmail() ==  null) {
			email.setText("Sem email");
		} else {
			email.setText(usuarioDoPerfil.getEmail());
		}
		
		JTextArea telefone = new JTextArea();
		telefone.setEditable(false);
		telefone.setLineWrap(true);
		telefone.setWrapStyleWord(true);
		telefone.setFont(new Font("Roboto", Font.PLAIN, 13));
		telefone.setBounds(110, 447, 225, 19);
		contentJPanel.add(telefone);
		
		if(usuarioDoPerfil.getTelefone() == null) {
			telefone.setText("Sem telefone");
		} else {
			telefone.setText(usuarioDoPerfil.getTelefone());
		}
		
		JLabel nome = new JLabel();
		nome.setHorizontalAlignment(SwingConstants.CENTER);
		nome.setFont(new Font("Roboto medium", Font.PLAIN, 13));
		nome.setBounds(85, 183, 225, 19);
		contentJPanel.add(nome);
		
		if (usuarioDoPerfil.getNome() == null) {
			nome.setText("Sem nome");
		} else {
			nome.setText(usuarioDoPerfil.getNome() + " " + usuarioDoPerfil.getSobrenome());
		}
		
		JLabel usuario = new JLabel();
		usuario.setHorizontalAlignment(SwingConstants.CENTER);
		usuario.setText("@" + usuarioDoPerfil.getUsuario());
		usuario.setFont(new Font("Roboto", Font.PLAIN, 12));
		usuario.setBounds(85, 200, 225, 19);
		contentJPanel.add(usuario);
		
		JButton alterar = new JButton("alterar");
		alterar.setFont(new Font("Roboto", Font.PLAIN, 12));
		alterar.setBackground(Color.WHITE);
		alterar.setBounds(158, 490, 85, 21);
		alterar.setVisible(!seuPerfil);
		contentJPanel.add(alterar);
		alterar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (alterar.getText().equals("alterar")) {
					bio.setText("");
					bio.setBackground(new Color(230, 230, 230));
					alterar.setText("salvar");
					bio.setEditable(true);					
				} else {
					bio.setBackground(new Color(255, 255, 255));
					if (bio.getText().equals("")) {
						usuarioSistema.getPerfil().setBio("sem bio");
					} else {
						usuarioSistema.getPerfil().setBio(bio.getText());						
					}
					PerfilDAO perfilDAO = new PerfilDAO();
					perfilDAO.updateBio(usuarioSistema.getPerfil());
					alterar.setText("alterar");
					bio.setEditable(false);
				}
			}
		});
	}

}
