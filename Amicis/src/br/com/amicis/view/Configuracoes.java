package br.com.amicis.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;


public class Configuracoes extends JFrame {

	private JPanel contentPane;



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Configuracoes frame = new Configuracoes();
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
	 */
	public Configuracoes() {
		setTitle("Configurações");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1118, 660);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Configurações");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 11, 115, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Editar perfil");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(10, 57, 102, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Alterar senha");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(10, 91, 102, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Privacidade");
		btnNewButton_2.setBounds(10, 125, 102, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Suporte");
		btnNewButton_3.setBounds(10, 227, 89, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Voltar");
		btnNewButton_4.setBounds(209, 9, 89, 23);
		contentPane.add(btnNewButton_4);
		//##########################################################################################
		JPanel cardPanel = new JPanel(new CardLayout());
		cardPanel.setBounds(122, 36, 298, 216);
		contentPane.add(cardPanel);
		
		JPanel editarPerfilPanel = new JPanel();
	    cardPanel.add(editarPerfilPanel, "editarPerfil");

	    JPanel alterarSenhaPanel = new JPanel();
	    cardPanel.add(alterarSenhaPanel, "alterarSenha");
		    
	    btnNewButton.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            CardLayout cl = (CardLayout)(cardPanel.getLayout());
	            cl.show(cardPanel, "editarPerfil");
	        }
	    });

	    btnNewButton_1.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            CardLayout cl = (CardLayout)(cardPanel.getLayout());
	            cl.show(cardPanel, "alterarSenha");
	        }
	    });	
	    editarPerfilPanel.setLayout(null);
	    
	 // editarPerfilPanel
	    JLabel lblNome = new JLabel("Nome:");
	    lblNome.setBounds(3, 8, 31, 14);
	    editarPerfilPanel.add(lblNome);

	    JTextField txtNome = new JTextField();
	    txtNome.setBounds(49, 5, 86, 20);
	    editarPerfilPanel.add(txtNome);
	    txtNome.setColumns(10);

	    JTextField txtEmail = new JTextField();
	    txtEmail.setBounds(49, 67, 86, 20);
	    editarPerfilPanel.add(txtEmail);
	    txtEmail.setColumns(10);

	    JLabel lblNumero = new JLabel("Número:");
	    lblNumero.setBounds(3, 39, 41, 14);
	    editarPerfilPanel.add(lblNumero);
	    
	    	    JLabel lblEmail = new JLabel("Email:");
	    	    lblEmail.setBounds(3, 70, 28, 14);
	    	    editarPerfilPanel.add(lblEmail);

	    JTextField txtNumero = new JTextField();
	    txtNumero.setBounds(49, 36, 86, 20);
	    editarPerfilPanel.add(txtNumero);
	    txtNumero.setColumns(10);
	    alterarSenhaPanel.setLayout(null);
	    
	    // alterarSenhaPanel
	    JLabel lblSenhaAtual = new JLabel("Senha Atual:");
	    lblSenhaAtual.setBounds(14, 8, 62, 14);
	    alterarSenhaPanel.add(lblSenhaAtual);

	    JPasswordField txtSenhaAtual = new JPasswordField();
	    txtSenhaAtual.setBounds(91, 5, 62, 20);
	    alterarSenhaPanel.add(txtSenhaAtual);

	    JLabel lblNovaSenha = new JLabel("Nova Senha:");
	    lblNovaSenha.setBounds(14, 33, 62, 14);
	    alterarSenhaPanel.add(lblNovaSenha);

	    JPasswordField txtNovaSenha = new JPasswordField();
	    txtNovaSenha.setBounds(91, 30, 62, 20);
	    alterarSenhaPanel.add(txtNovaSenha);

	    JLabel lblRepetirNovaSenha = new JLabel("Repetir senha:");
	    lblRepetirNovaSenha.setBounds(14, 58, 71, 14);
	    alterarSenhaPanel.add(lblRepetirNovaSenha);

	    JPasswordField txtRepetirNovaSenha = new JPasswordField();
	    txtRepetirNovaSenha.setBounds(91, 55, 62, 20);
	    alterarSenhaPanel.add(txtRepetirNovaSenha);
	    
	    //================================================================================
	    JButton btnNewButton_7 = new JButton("Privacidade");
	    btnNewButton_2.setBounds(10, 125, 102, 23);
	    contentPane.add(btnNewButton_2);
	    btnNewButton_2.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            CardLayout cl = (CardLayout)(cardPanel.getLayout());
	            cl.show(cardPanel, "privacidade");
	        }
	    });

	    JButton btnNewButton_8 = new JButton("Suporte");
	    btnNewButton_3.setBounds(10, 227, 89, 23);
	    contentPane.add(btnNewButton_3);
	    btnNewButton_3.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            CardLayout cl = (CardLayout)(cardPanel.getLayout());
	            cl.show(cardPanel, "suporte");
	        }
	    });
	    
	 // privacidadePanel
	    JPanel privacidadePanel = new JPanel();
	    cardPanel.add(privacidadePanel, "privacidade");
	    privacidadePanel.setLayout(null);

	    JLabel lblStatus = new JLabel("Status:");
	    lblStatus.setBounds(10, 8, 35, 14);
	    privacidadePanel.add(lblStatus);

	    JComboBox cmbStatus = new JComboBox();
	    cmbStatus.setBounds(55, 5, 69, 20);
	    cmbStatus.addItem("Online");
	    cmbStatus.addItem("Ocupado");
	    cmbStatus.addItem("Ausente");
	    privacidadePanel.add(cmbStatus);

	    JLabel lblPerfisBloqueados = new JLabel("Perfis bloqueados:");
	    lblPerfisBloqueados.setBounds(10, 33, 89, 14);
	    privacidadePanel.add(lblPerfisBloqueados);
	    JList listPerfisBloqueados = new JList();
	    listPerfisBloqueados.setBounds(253, 15, 0, 0);
	    privacidadePanel.add(listPerfisBloqueados);
	 // suportePanel
	    JPanel suportePanel = new JPanel();
	    cardPanel.add(suportePanel, "suporte");
	    suportePanel.setLayout(null);

	    JButton btnContatar = new JButton("Contatar");
	    btnContatar.setBounds(10, 5, 75, 23);
	    suportePanel.add(btnContatar);

	    JButton btnTicket = new JButton("Ticket");
	    btnTicket.setBounds(10, 39, 75, 23);
	    btnTicket.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    	}
	    });
	    suportePanel.add(btnTicket);
	    
	    JButton btnNewButton_5 = new JButton("Salvar alterações");
	    btnNewButton_5.setBounds(308, 9, 116, 23);
	    contentPane.add(btnNewButton_5);
	}
}