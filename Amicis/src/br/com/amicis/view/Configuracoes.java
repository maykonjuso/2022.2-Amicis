package br.com.amicis.view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

import br.com.amicis.dao.UsuarioDAO;
import br.com.amicis.model.Usuario;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Configuracoes extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField telefone;
	private JTextField email;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Configuracoes frame = new Configuracoes(null);
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
	public Configuracoes(Usuario usuarioTela) {
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

		// Botoes principais
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
		// ##########################################################################################
		JPanel cardPanel = new JPanel(new CardLayout());
		cardPanel.setBackground(new Color(255, 255, 255));
		cardPanel.setBounds(195, 63, 275, 268);
		contentPane.add(cardPanel);

		JPanel editarPerfilPanel = new JPanel();
		editarPerfilPanel.setBackground(new Color(255, 255, 255));
		cardPanel.add(editarPerfilPanel, "editarPerfil");

		JPanel alterarSenhaPanel = new JPanel();
		alterarSenhaPanel.setBackground(new Color(255, 255, 255));
		cardPanel.add(alterarSenhaPanel, "alterarSenha");

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) (cardPanel.getLayout());
				cl.show(cardPanel, "editarPerfil");
			}
		});

		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) (cardPanel.getLayout());
				cl.show(cardPanel, "alterarSenha");
			}
		});
		editarPerfilPanel.setLayout(null);

		// editarPerfilPanel
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Roboto", Font.PLAIN, 12));
		lblNome.setBounds(10, 13, 114, 14);
		editarPerfilPanel.add(lblNome);

		JTextField nome = new JTextField();
		nome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				nome.setText("");
			}
		});
		nome.setFont(new Font("Roboto", Font.PLAIN, 10));
		nome.setText(usuarioTela.getNome());
		nome.setBounds(134, 10, 131, 20);
		editarPerfilPanel.add(nome);
		nome.setColumns(10);
		
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");      
		String dateToStr = dateFormat.format(usuarioTela.getDataNascimeto());
		JTextField txtDataNascimento = new JTextField();
		txtDataNascimento.setFont(new Font("Roboto", Font.PLAIN, 10));
		txtDataNascimento.setEnabled(false);
		txtDataNascimento.setText(dateToStr);
		txtDataNascimento.setBounds(134, 72, 131, 20);
		editarPerfilPanel.add(txtDataNascimento);
		txtDataNascimento.setColumns(10);

		JLabel lblNumero = new JLabel("Sobrenome:");
		lblNumero.setFont(new Font("Roboto", Font.PLAIN, 12));
		lblNumero.setBounds(10, 44, 114, 14);
		editarPerfilPanel.add(lblNumero);

		JLabel lblEmail = new JLabel("Data de nascimento:");
		lblEmail.setFont(new Font("Roboto", Font.PLAIN, 12));
		lblEmail.setBounds(10, 75, 114, 14);
		editarPerfilPanel.add(lblEmail);

		JTextField sobrenome = new JTextField();
		sobrenome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				sobrenome.setText("");
			}
		});
		sobrenome.setFont(new Font("Roboto", Font.PLAIN, 10));
		sobrenome.setText(usuarioTela.getSobrenome());
		sobrenome.setBounds(134, 41, 131, 20);
		editarPerfilPanel.add(sobrenome);
		sobrenome.setColumns(10);

		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Roboto", Font.PLAIN, 12));
		lblTelefone.setBounds(10, 105, 114, 14);
		editarPerfilPanel.add(lblTelefone);

		telefone = new JTextField();
		telefone.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				telefone.setText("");
			}
		});
		telefone.setFont(new Font("Roboto", Font.PLAIN, 10));
		telefone.setText(usuarioTela.getTelefone());
		telefone.setColumns(10);
		telefone.setBounds(134, 102, 131, 20);
		editarPerfilPanel.add(telefone);

		JLabel lblEmail_1 = new JLabel("Email:");
		lblEmail_1.setFont(new Font("Roboto", Font.PLAIN, 12));
		lblEmail_1.setBounds(10, 136, 114, 14);
		editarPerfilPanel.add(lblEmail_1);

		email = new JTextField();
		email.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				email.setText("");
			}
		});
		email.setFont(new Font("Roboto", Font.PLAIN, 10));
		email.setText(usuarioTela.getEmail());
		email.setColumns(10);
		email.setBounds(134, 133, 131, 20);
		editarPerfilPanel.add(email);

		JButton salvarEditarPerfil = new JButton("salvar");
		salvarEditarPerfil.setFont(new Font("Roboto", Font.PLAIN, 12));
		salvarEditarPerfil.setBackground(new Color(255, 255, 255));
		salvarEditarPerfil.setBounds(125, 235, 70, 23);
		editarPerfilPanel.add(salvarEditarPerfil);
		
				JButton btnNewButton_4 = new JButton("voltar");
				btnNewButton_4.setBounds(205, 235, 70, 23);
				editarPerfilPanel.add(btnNewButton_4);
				btnNewButton_4.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						dispose();
					}
				});
				btnNewButton_4.setFont(new Font("Roboto", Font.PLAIN, 12));
				btnNewButton_4.setBackground(new Color(255, 255, 255));
		alterarSenhaPanel.setLayout(null);
		salvarEditarPerfil.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if (nome.getText().trim().isEmpty() || sobrenome.getText().trim().isEmpty()
					|| telefone.getText().trim().isEmpty() || email.getText().trim().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Preencha todas as informações.");
				} else {
					try {
						if (telefone.getText() != null && telefone.getText().matches("[0-9]+")
								&& telefone.getText().length() >= 8) {
								if (validarEmail(email.getText()) == true) {
									nome.setText((String) converter(nome.getText()));
									sobrenome.setText((String) converter(sobrenome.getText()));
									usuarioTela.setNome(nome.getText());
									usuarioTela.setSobrenome(sobrenome.getText());
									usuarioTela.setTelefone(telefone.getText());
									usuarioTela.setEmail(email.getText());
									UsuarioDAO usuarioDAO = new UsuarioDAO();
									usuarioDAO.updatePerfil(usuarioTela);
									JOptionPane.showMessageDialog(null, "Cadastro atualizado com sucesso!");
								} else {
									JOptionPane.showMessageDialog(null, "Email inválido.");
								}
							} else {
								JOptionPane.showMessageDialog(null, "Número de telefone inválido.");
							}
						} catch (HeadlessException e1) {
							e1.printStackTrace();
					} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				}
			}});

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

		JButton salvarSenha = new JButton("Salvar");
		salvarSenha.setBounds(176, 164, 89, 23);
		alterarSenhaPanel.add(salvarSenha);
		alterarSenhaPanel.setLayout(null);
		salvarSenha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Usuario usuario = new Usuario();
				usuario.setId(1);
				String senhaAtual = new String(txtSenhaAtual.getPassword());
				String novaSenha = new String(txtNovaSenha.getPassword());
				UsuarioDAO usuarioDAO = new UsuarioDAO();
				try {
					usuarioDAO.updateSenha(usuario, senhaAtual, novaSenha);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});

		// ================================================================================
		JButton btnNewButton_7 = new JButton("Privacidade");
		contentPane.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) (cardPanel.getLayout());
				cl.show(cardPanel, "privacidade");
			}
		});

		JButton btnNewButton_8 = new JButton("Suporte");
		contentPane.add(btnNewButton_3);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) (cardPanel.getLayout());
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

		JButton salvarPrivacidade = new JButton("Salvar");
		salvarPrivacidade.setBounds(176, 164, 89, 23);
		privacidadePanel.add(salvarPrivacidade);
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

		JButton salvarSuporte = new JButton("Salvar");
		salvarSuporte.setBounds(176, 164, 89, 23);
		suportePanel.add(salvarSuporte);
	}
	
	public static boolean validarEmail(String email) {
		boolean emailValido = false;
		if (email != null && email.length() > 0) {
			String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
			Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
			Matcher matcher = pattern.matcher(email);
			if (matcher.matches()) {
				emailValido = true;
			}
		}
		return emailValido;
	}
	
	public Object converter(String nome) {
        char[] palavras = nome.toCharArray();
        
        for(int i = 1; i < palavras.length; i++) {
            //convertendo todas as letras para minúsculo para casos como tEsTe = teste
            if(Character.isAlphabetic(palavras[i])) {
                palavras[i] = Character.toLowerCase(palavras[i]);
            }
            //se o carácter anterior for espaço então o atual sera maiúsculo
            if(Character.isWhitespace(palavras[i - 1])) {
                palavras[i] = Character.toUpperCase(palavras[i]);
            }
        }
        //por fim a primeira letra de toda frase ou palavra será maiúscula
        palavras[0] = Character.toUpperCase(palavras[0]);
       
        //retorna o Array de char como String
        String nomeConvertido = new String(palavras);       
        
        return nomeConvertido;
    }
}