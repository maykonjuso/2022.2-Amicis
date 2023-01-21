package br.com.amicis.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import br.com.amicis.dao.PerfilDAO;
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
					frame.getContentPane().setBackground(new Color(118,181,197));
					
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
		
		setBounds(100, 100, 674, 422);
		plano = new JPanel();
		plano.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(plano);
		plano.setLayout(null);
		
		JButton btnPaginaInicial = new JButton("Voltar à Página Inicial");
		btnPaginaInicial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPaginaInicial.setBounds(426, 307, 222, 54);
		plano.add(btnPaginaInicial);
		
		AtualizarStatus = new JTextField();
		AtualizarStatus.setBounds(10, 128, 139, 34);
		plano.add(AtualizarStatus);
		AtualizarStatus.setColumns(10);
		
		AtualizarRelacionamento = new JTextField();
		AtualizarRelacionamento.setBounds(10, 194, 139, 41);
		plano.add(AtualizarRelacionamento);
		AtualizarRelacionamento.setColumns(10);
		
		AtualizarLocalidade = new JTextField();
		AtualizarLocalidade.setBounds(10, 270, 139, 34);
		plano.add(AtualizarLocalidade);
		AtualizarLocalidade.setColumns(10);
		
		JButton btnAtualizarStatus = new JButton("Atualizar Status");
		btnAtualizarStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

		}});
		btnAtualizarStatus.setBounds(251, 307, 152, 54);
		plano.add(btnAtualizarStatus);
		
		textUsuario = new JTextField();
		textUsuario.setEditable(false);
		textUsuario.setBounds(419, 36, 114, 34);
		plano.add(textUsuario);
		textUsuario.setColumns(10);
		
		btnAtualizarStatus.addMouseListener(new MouseAdapter() {
			//AtualizarStatus.getText().trim().isEmpty() ||
			@Override
			public void mouseClicked(MouseEvent e) {
				PerfilDAO perfilDAO = new PerfilDAO();

				if(AtualizarRelacionamento.getText().trim().isEmpty() || AtualizarLocalidade.getText().trim().isEmpty()){
					JOptionPane.showMessageDialog(null, "Não foi Possível Atualizar os Status. Preencha Todas as Informações.");
				}else {
				
					try {
//					Perfil status = new Perfil();
//					Home status1 = new Home(null);
//					Login status2 = new Login();
//					
					//status1.getUsuarioTela();
					//status.getThis_usuario();					
					
					//					
//					status.getStatus().setRelacionamento(AtualizarRelacionamento.getText());
//					status.getStatus().setLocalidade(AtualizarLocalidade.getText());
					
					if(usuarioTela != null){
						usuarioTela.getPerfil().getStatus().setRelacionamento(AtualizarRelacionamento.getText());
						usuarioTela.getPerfil().getStatus().setLocalidade(AtualizarLocalidade.getText());
						
						perfilDAO.updateStatus(usuarioTela.getPerfil());

					}else {
						JOptionPane.showMessageDialog(null, "Não foi Possível Atualizar os Status");
					}
				}catch (HeadlessException e1) {
					e1.printStackTrace();
					
			}
		}

			}});
		
		btnPaginaInicial.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				dispose();	
			}
		});
		
	}
	

	
	
}