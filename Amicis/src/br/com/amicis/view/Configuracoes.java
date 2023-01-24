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
import java.util.Arrays;
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

import br.com.amicis.dao.PerfilDAO;
import br.com.amicis.dao.UsuarioDAO;
import br.com.amicis.model.Usuario;

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
	@SuppressWarnings("unchecked")
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
		JButton btnNewButton = new JButton("editar perfil");
		btnNewButton.setFont(new Font("Roboto Medium", Font.PLAIN, 12));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setBounds(38, 63, 120, 30);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("alterar senha");
		btnNewButton_1.setFont(new Font("Roboto Medium", Font.PLAIN, 12));
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setBounds(38, 119, 120, 30);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("privacidade");
		btnNewButton_2.setFont(new Font("Roboto Medium", Font.PLAIN, 12));
		btnNewButton_2.setBackground(new Color(255, 255, 255));
		btnNewButton_2.setBounds(38, 175, 120, 30);
		contentPane.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("suporte");
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

		JPasswordField senhaAntiga = new JPasswordField();
		senhaAntiga.setBounds(155, 7, 120, 20);
		alterarSenhaPanel.add(senhaAntiga);

		JPasswordField senha = new JPasswordField();
		senha.setBounds(155, 38, 120, 20);
		alterarSenhaPanel.add(senha);

		JPasswordField repetirSenha = new JPasswordField();
		repetirSenha.setBounds(155, 69, 120, 20);
		alterarSenhaPanel.add(repetirSenha);

		JLabel txtSenhaAntiga = new JLabel("Senha atual:");
		txtSenhaAntiga.setFont(new Font("Roboto", Font.PLAIN, 12));
		txtSenhaAntiga.setBounds(10, 10, 127, 14);
		alterarSenhaPanel.add(txtSenhaAntiga);

		JLabel txtNovaSenha = new JLabel("Nova senha:");
		txtNovaSenha.setFont(new Font("Roboto", Font.PLAIN, 12));
		txtNovaSenha.setBounds(10, 41, 127, 14);
		alterarSenhaPanel.add(txtNovaSenha);

		JLabel txtRepetirSenha = new JLabel("Repetir nova senha:");
		txtRepetirSenha.setFont(new Font("Roboto", Font.PLAIN, 12));
		txtRepetirSenha.setBounds(10, 72, 127, 14);
		alterarSenhaPanel.add(txtRepetirSenha);
		alterarSenhaPanel.setLayout(null);
		
		JButton salvarSenha = new JButton("salvar");
		salvarSenha.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				char[] senhaAntiga_ = senhaAntiga.getPassword();
				char[] senha_ = senha.getPassword();
				char[] repetirSenha_ = repetirSenha.getPassword();
				if(Arrays.equals(senhaAntiga_, usuarioTela.getSenha())) {
					if (Arrays.equals(senha_, repetirSenha_)) {
						usuarioTela.setSenha(senha_);
						UsuarioDAO usuarioDAO = new UsuarioDAO();
						try {
							usuarioDAO.updateSenha(usuarioTela);
							JOptionPane.showMessageDialog(null, "Senha atualizada com sucesso!");
							senhaAntiga.setText("");
							senha.setText("");
							repetirSenha.setText("");
						} catch (Exception e1) {
							e1.printStackTrace();
						}
				} else {
					JOptionPane.showMessageDialog(null, "As senhas não são iguais.");
				}
			} else {
				JOptionPane.showMessageDialog(null, "A senha anterior está incorreta.");
			}
				}
		});
		salvarSenha.setFont(new Font("Roboto", Font.PLAIN, 12));
		salvarSenha.setBackground(Color.WHITE);
		salvarSenha.setBounds(115, 235, 70, 23);
		alterarSenhaPanel.add(salvarSenha);
		
		JButton voltarSenha = new JButton("voltar");
		voltarSenha.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		voltarSenha.setFont(new Font("Roboto", Font.PLAIN, 12));
		voltarSenha.setBackground(Color.WHITE);
		voltarSenha.setBounds(195, 235, 70, 23);
		alterarSenhaPanel.add(voltarSenha);

		// ================================================================================
		@SuppressWarnings("unused")
		JButton btnNewButton_7 = new JButton("Privacidade");
		contentPane.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) (cardPanel.getLayout());
				cl.show(cardPanel, "privacidade");
			}
		});

		@SuppressWarnings("unused")
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

		@SuppressWarnings("rawtypes")
		JComboBox cmbStatus = new JComboBox();
		cmbStatus.setFont(new Font("Roboto", Font.PLAIN, 12));
		cmbStatus.setBounds(191, 14, 74, 21);
		cmbStatus.addItem("Online");
		cmbStatus.addItem("Ocupado");
		cmbStatus.addItem("Ausente");
		privacidadePanel.add(cmbStatus);
		cmbStatus.setSelectedIndex(usuarioTela.getPerfil().getStatus().getOnline());
		
		JLabel lblPerfisBloqueados = new JLabel("Perfis bloqueados:");
		lblPerfisBloqueados.setFont(new Font("Roboto", Font.PLAIN, 12));
		lblPerfisBloqueados.setBounds(10, 33, 102, 32);
		privacidadePanel.add(lblPerfisBloqueados);
		@SuppressWarnings("rawtypes")
		JList listPerfisBloqueados = new JList();
		listPerfisBloqueados.setBounds(253, 15, 0, 0);
		privacidadePanel.add(listPerfisBloqueados);

		@SuppressWarnings("rawtypes")
		JList list = new JList();
		list.setBounds(10, 75, 102, 113);
		privacidadePanel.add(list);
		
		JButton salvarStatus = new JButton("salvar");
		salvarStatus.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				usuarioTela.getPerfil().getStatus().setOnline(cmbStatus.getSelectedIndex());
				PerfilDAO perfilDAO = new PerfilDAO();
				perfilDAO.updateOnline(usuarioTela.getPerfil());
				JOptionPane.showMessageDialog(null, "Status alterado com sucesso.");	
			}
		});
		salvarStatus.setFont(new Font("Roboto", Font.PLAIN, 12));
		salvarStatus.setBackground(Color.WHITE);
		salvarStatus.setBounds(115, 235, 70, 23);
		privacidadePanel.add(salvarStatus);
		
		JButton btnNewButton_4_2 = new JButton("voltar");
		btnNewButton_4_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		btnNewButton_4_2.setFont(new Font("Roboto", Font.PLAIN, 12));
		btnNewButton_4_2.setBackground(Color.WHITE);
		btnNewButton_4_2.setBounds(195, 235, 70, 23);
		privacidadePanel.add(btnNewButton_4_2);
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
		
		JButton btnNewButton_4_3 = new JButton("voltar");
		btnNewButton_4_3.setFont(new Font("Roboto", Font.PLAIN, 12));
		btnNewButton_4_3.setBackground(Color.WHITE);
		btnNewButton_4_3.setBounds(195, 235, 70, 23);
		suportePanel.add(btnNewButton_4_3);
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