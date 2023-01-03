package br.com.amicis.view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import br.com.amicis.dao.UsuarioDAO;
import br.com.amicis.model.Usuario;

public class RedeSocial extends JFrame {
	
	private static final long serialVersionUID = 1L;
    private JPanel publicacoesPanel;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    RedeSocial frame = new RedeSocial();
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

    public RedeSocial() throws SQLException {
    	
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\mayko\\git\\Amicis\\Amicis\\resources\\pngwing.com.png"));
		setTitle("Login");
		setFont(new Font("Inconsolata", Font.PLAIN, 14));
        setBounds(100, 100, 1118, 660);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout(0, 0));
        

        JScrollPane timeline = new JScrollPane();
        getContentPane().add(timeline);

        publicacoesPanel = new JPanel();
        publicacoesPanel.setLayout(new BoxLayout(publicacoesPanel, BoxLayout.Y_AXIS));
        timeline.setViewportView(publicacoesPanel);
        getContentPane().add(timeline, BorderLayout.CENTER);
        
        JPanel menu = new JPanel();
        menu.setBackground(new Color(74, 252, 0));
        getContentPane().add(menu, BorderLayout.LINE_START);
        menu.setLayout(null);
        menu.setPreferredSize(new Dimension(150, 100));
        
        JButton perfil = new JButton("perfil");
        perfil.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
        perfil.setBounds(10, 10, 130, 21);
        menu.add(perfil);
        
        JButton status = new JButton("status");
        status.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
        status.setBounds(10, 41, 130, 21);
        menu.add(status);
        
        JButton amigos = new JButton("amigos");
        amigos.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
        amigos.setBounds(10, 72, 130, 21);
        menu.add(amigos);
        
        JButton btnNewButton_2_1 = new JButton("suporte");
        btnNewButton_2_1.setFont(new Font("Roboto Medium", Font.PLAIN, 14));
        btnNewButton_2_1.setBounds(10, 103, 130, 21);
        menu.add(btnNewButton_2_1);
        
        JPanel publicacao = new JPanel();
        publicacao.setBackground(new Color(75, 0, 130));
        getContentPane().add(publicacao, BorderLayout.NORTH);
        
        JLabel T_publicacao = new JLabel("nova publicação");
        publicacao.add(T_publicacao);
        
        JPanel menu_1 = new JPanel();
        menu_1.setLayout(null);
        menu_1.setPreferredSize(new Dimension(100, 100));
        menu_1.setBackground(new Color(74, 252, 0));
        getContentPane().add(menu_1, BorderLayout.EAST);
        
        JButton btnNewButton_3 = new JButton("New button");
        btnNewButton_3.setBounds(10, 10, 85, 21);
        menu_1.add(btnNewButton_3);
        
        JButton btnNewButton_1_1 = new JButton("New button");
        btnNewButton_1_1.setBounds(10, 41, 85, 21);
        menu_1.add(btnNewButton_1_1);
        
        JButton btnNewButton_2_2 = new JButton("New button");
        btnNewButton_2_2.setBounds(10, 72, 85, 21);
        menu_1.add(btnNewButton_2_2);
        
        JButton btnNewButton_2_1_1 = new JButton("New button");
        btnNewButton_2_1_1.setBounds(10, 103, 85, 21);
        menu_1.add(btnNewButton_2_1_1);
        
        
    	UsuarioDAO usuarioDAO = new UsuarioDAO();
    	for (Usuario usuario : usuarioDAO.getUsuarios()) {
			try {
				JPanel publicacaoPanel = criarPublicacaoPanel(usuario.getPerfil().getThis_usuario());
				publicacoesPanel.add(publicacaoPanel);	
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
    }
    
    private JPanel criarPublicacaoPanel(String nome) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.LINE_AXIS));
		panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		panel.setPreferredSize(new Dimension(100, 100));
		
		JLabel label = new JLabel(nome);
		label.setPreferredSize(new Dimension(100, 100));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(label);
		
		JTextArea textArea = new JTextArea();
		textArea.setText("Conteúdo da publicação");
		textArea.setEditable(false);
		panel.add(textArea);
		
		JButton curtir = new JButton("Curtir");
		curtir.setFont(new Font("Roboto Medium", Font.PLAIN, 13));
		curtir.setPreferredSize(new Dimension(100, 100));
		panel.add(curtir);
		
		return panel;
    }
}