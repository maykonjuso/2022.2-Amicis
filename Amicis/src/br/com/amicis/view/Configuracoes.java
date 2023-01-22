package br.com.amicis.view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;


public class Configuracoes extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;



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
		setBackground(new Color(255, 255, 255));
		getContentPane().setBackground(new Color(255, 255, 255));
		setIconImage(Toolkit.getDefaultToolkit().getImage("Amicis\\resources\\pngwing.com.png"));
		setTitle("Configurações");
		setFont(new Font("Inconsolata", Font.PLAIN, 14));
		setBounds(100, 100, 520, 405);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Editar perfil");
		btnNewButton.setFont(new Font("Roboto Medium", Font.PLAIN, 12));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setBounds(38, 63, 120, 30);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Alterar senha");
		btnNewButton_1.setFont(new Font("Roboto Medium", Font.PLAIN, 12));
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setBounds(38, 119, 120, 30);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Privacidade");
		btnNewButton_2.setFont(new Font("Roboto Medium", Font.PLAIN, 12));
		btnNewButton_2.setBackground(new Color(255, 255, 255));
		btnNewButton_2.setBounds(38, 175, 120, 30);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Suporte");
		btnNewButton_3.setFont(new Font("Roboto Medium", Font.PLAIN, 12));
		btnNewButton_3.setBackground(new Color(255, 255, 255));
		btnNewButton_3.setBounds(38, 231, 120, 30);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("voltar");
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		btnNewButton_4.setFont(new Font("Roboto", Font.PLAIN, 12));
		btnNewButton_4.setBackground(new Color(255, 255, 255));
		btnNewButton_4.setBounds(319, 297, 70, 23);
		contentPane.add(btnNewButton_4);
		//##########################################################################################
		JPanel cardPanel = new JPanel(new CardLayout());
		cardPanel.setBackground(new Color(255, 255, 255));
		cardPanel.setBounds(195, 63, 275, 198);
		contentPane.add(cardPanel);
		
		JPanel editarPerfilPanel = new JPanel();
		editarPerfilPanel.setBackground(new Color(255, 255, 255));
	    cardPanel.add(editarPerfilPanel, "editarPerfil");

	    JPanel alterarSenhaPanel = new JPanel();
	    alterarSenhaPanel.setBackground(new Color(255, 255, 255));
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
	    lblNome.setFont(new Font("Roboto", Font.PLAIN, 12));
	    lblNome.setBounds(10, 13, 114, 14);
	    editarPerfilPanel.add(lblNome);

	    JTextField txtNome = new JTextField();
	    txtNome.setBounds(144, 10, 121, 20);
	    editarPerfilPanel.add(txtNome);
	    txtNome.setColumns(10);

	    JTextField txtEmail = new JTextField();
	    txtEmail.setBounds(144, 72, 121, 20);
	    editarPerfilPanel.add(txtEmail);
	    txtEmail.setColumns(10);

	    JLabel lblNumero = new JLabel("Sobrenome:");
	    lblNumero.setFont(new Font("Roboto", Font.PLAIN, 12));
	    lblNumero.setBounds(10, 44, 114, 14);
	    editarPerfilPanel.add(lblNumero);
	    
	    	    JLabel lblEmail = new JLabel("Data de Nascimento:");
	    	    lblEmail.setFont(new Font("Roboto", Font.PLAIN, 12));
	    	    lblEmail.setBounds(10, 75, 114, 14);
	    	    editarPerfilPanel.add(lblEmail);

	    JTextField txtNumero = new JTextField();
	    txtNumero.setBounds(144, 41, 121, 20);
	    editarPerfilPanel.add(txtNumero);
	    txtNumero.setColumns(10);
	    
	    JLabel lblNumero_1 = new JLabel("Número:");
	    lblNumero_1.setFont(new Font("Roboto", Font.PLAIN, 12));
	    lblNumero_1.setBounds(10, 105, 114, 14);
	    editarPerfilPanel.add(lblNumero_1);
	    
	    textField = new JTextField();
	    textField.setColumns(10);
	    textField.setBounds(144, 102, 121, 20);
	    editarPerfilPanel.add(textField);
	    
	    JLabel lblEmail_1 = new JLabel("Email:");
	    lblEmail_1.setFont(new Font("Roboto", Font.PLAIN, 12));
	    lblEmail_1.setBounds(10, 136, 114, 14);
	    editarPerfilPanel.add(lblEmail_1);
	    
	    textField_1 = new JTextField();
	    textField_1.setColumns(10);
	    textField_1.setBounds(144, 133, 121, 20);
	    editarPerfilPanel.add(textField_1);
	    alterarSenhaPanel.setLayout(null);

	    JPasswordField txtSenhaAtual = new JPasswordField();
	    txtSenhaAtual.setBounds(155, 7, 120, 20);
	    alterarSenhaPanel.add(txtSenhaAtual);

	    JPasswordField txtNovaSenha = new JPasswordField();
	    txtNovaSenha.setBounds(155, 38, 120, 20);
	    alterarSenhaPanel.add(txtNovaSenha);

	    JPasswordField txtRepetirNovaSenha = new JPasswordField();
	    txtRepetirNovaSenha.setBounds(155, 69, 120, 20);
	    alterarSenhaPanel.add(txtRepetirNovaSenha);
	    
	    JLabel lblNome_1 = new JLabel("Senha atual:");
	    lblNome_1.setFont(new Font("Roboto", Font.PLAIN, 12));
	    lblNome_1.setBounds(10, 10, 127, 14);
	    alterarSenhaPanel.add(lblNome_1);
	    
	    JLabel lblNumero_2 = new JLabel("Nova senha:");
	    lblNumero_2.setFont(new Font("Roboto", Font.PLAIN, 12));
	    lblNumero_2.setBounds(10, 41, 127, 14);
	    alterarSenhaPanel.add(lblNumero_2);
	    
	    JLabel lblEmail_2 = new JLabel("Repetir nova senha:");
	    lblEmail_2.setFont(new Font("Roboto", Font.PLAIN, 12));
	    lblEmail_2.setBounds(10, 72, 127, 14);
	    alterarSenhaPanel.add(lblEmail_2);
	    
	    //================================================================================
	    JButton btnNewButton_7 = new JButton("Privacidade");
	    contentPane.add(btnNewButton_2);
	    btnNewButton_2.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            CardLayout cl = (CardLayout)(cardPanel.getLayout());
	            cl.show(cardPanel, "privacidade");
	        }
	    });

	    JButton btnNewButton_8 = new JButton("Suporte");
	    contentPane.add(btnNewButton_3);
	    btnNewButton_3.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            CardLayout cl = (CardLayout)(cardPanel.getLayout());
	            cl.show(cardPanel, "suporte");
	        }
	    });
	    
	 // privacidadePanel
	    JPanel privacidadePanel = new JPanel();
	    privacidadePanel.setBackground(new Color(255, 255, 255));
	    cardPanel.add(privacidadePanel, "privacidade");
	    privacidadePanel.setLayout(null);

	    JLabel lblStatus = new JLabel("Status:");
	    lblStatus.setFont(new Font("Roboto", Font.PLAIN, 12));
	    lblStatus.setBounds(10, 14, 102, 21);
	    privacidadePanel.add(lblStatus);

	    JComboBox cmbStatus = new JComboBox();
	    cmbStatus.setFont(new Font("Roboto", Font.PLAIN, 12));
	    cmbStatus.setBounds(191, 14, 74, 21);
	    cmbStatus.addItem("Online");
	    cmbStatus.addItem("Ocupado");
	    cmbStatus.addItem("Ausente");
	    privacidadePanel.add(cmbStatus);

	    JLabel lblPerfisBloqueados = new JLabel("Perfis bloqueados:");
	    lblPerfisBloqueados.setFont(new Font("Roboto", Font.PLAIN, 12));
	    lblPerfisBloqueados.setBounds(10, 33, 102, 32);
	    privacidadePanel.add(lblPerfisBloqueados);
	    JList listPerfisBloqueados = new JList();
	    listPerfisBloqueados.setBounds(253, 15, 0, 0);
	    privacidadePanel.add(listPerfisBloqueados);
	    
	    JList list = new JList();
	    list.setBounds(10, 75, 102, 113);
	    privacidadePanel.add(list);
	 // suportePanel
	    JPanel suportePanel = new JPanel();
	    suportePanel.setBackground(new Color(255, 255, 255));
	    cardPanel.add(suportePanel, "suporte");
	    suportePanel.setLayout(null);

	    JButton btnContatar = new JButton("Criar ticket");
	    btnContatar.setFont(new Font("Roboto", Font.PLAIN, 10));
	    btnContatar.setBounds(10, 10, 92, 23);
	    suportePanel.add(btnContatar);
	    
	    JLabel lblTickes = new JLabel("Tickes:");
	    lblTickes.setFont(new Font("Roboto", Font.PLAIN, 12));
	    lblTickes.setBounds(10, 45, 70, 23);
	    suportePanel.add(lblTickes);
	    
	    JButton btnNewButton_5 = new JButton("salvar");
	    btnNewButton_5.setFont(new Font("Roboto", Font.PLAIN, 12));
	    btnNewButton_5.setBackground(new Color(255, 255, 255));
	    btnNewButton_5.setBounds(400, 297, 70, 23);
	    contentPane.add(btnNewButton_5);
	}
}