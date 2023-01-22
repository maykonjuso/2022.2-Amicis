package br.com.amicis.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

import br.com.amicis.model.Usuario;



public class StatusView extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel plano;
	private JTextField AtualizarStatus;
	private JTextField AtualizarRelacionamento;
	private JTextField AtualizarLocalidade;
	private JTextField textUsuario;

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
		setBounds(100, 100, 520, 405);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		plano = new JPanel();
		plano.setBackground(new Color(255, 255, 255));
		setContentPane(plano);
		plano.setLayout(null);
		
		AtualizarStatus = new JTextField();
		AtualizarStatus.setBounds(60, 63, 139, 34);
		plano.add(AtualizarStatus);
		AtualizarStatus.setColumns(10);
		
		AtualizarRelacionamento = new JTextField();
		AtualizarRelacionamento.setBounds(60, 163, 139, 34);
		plano.add(AtualizarRelacionamento);
		AtualizarRelacionamento.setColumns(10);
		
		AtualizarLocalidade = new JTextField();
		AtualizarLocalidade.setBounds(60, 263, 139, 34);
		plano.add(AtualizarLocalidade);
		AtualizarLocalidade.setColumns(10);
		
		textUsuario = new JTextField();
		textUsuario.setEditable(false);
		textUsuario.setBounds(345, 63, 114, 34);
		plano.add(textUsuario);
		textUsuario.setColumns(10);
		
		JButton btnNewButton_4 = new JButton("voltar");
		btnNewButton_4.setFont(new Font("Roboto", Font.PLAIN, 12));
		btnNewButton_4.setBackground(Color.WHITE);
		btnNewButton_4.setBounds(345, 335, 70, 23);
		plano.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("salvar");
		btnNewButton_5.setFont(new Font("Roboto", Font.PLAIN, 12));
		btnNewButton_5.setBackground(Color.WHITE);
		btnNewButton_5.setBounds(426, 335, 70, 23);
		plano.add(btnNewButton_5);
		
	}
}