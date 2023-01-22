package br.com.amicis.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;

import br.com.amicis.factory.ConnectionFactory;
import textfield.SearchOptinEvent;
import textfield.SearchOption;
import textfield.TextFieldSearchOption;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Pesquisar extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	String[] coluna = {"ID", "Nome", "Telefone", "Email"};
	String[][] linha = {{" ", " ", " ", " "}};



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pesquisar frame = new Pesquisar();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Pesquisar() {

		try {
			ConnectionFactory.createConnectionToMySQL();
			
			
		}catch (Exception e) {
			
			e.printStackTrace();
		
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 799, 485);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		TextFieldSearchOption txt = new TextFieldSearchOption();
		
		txt.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if(txt.isSelected()) {
                    int option=txt.getSelectedIndex();
                    String text = "%" + txt.getText().trim() + "%";

                    if(option == 0) {
                        try {
							loadData("WHERE nome LIKE ?", text);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

                    }else if (option == 1) {
                        try {
							loadData("WHERE telefone LIKE ?", text);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

                    }else if (option == 2) {
                        try {
							loadData("WHERE email LIKE ?", text);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

                    }
                }
            }
        });
		
//		txt.addKeyListener(new KeyAdapter() {
//			@Override
//			public void keyReleased(KeyEvent e) {
//				if(txt.isSelected()) {
//					int option=txt.getSelectedIndex();
//					String text = "%" + txt.getText().trim() + "%";
//					
//					if(option == 0) {
//						loadData("where 'this_usuario' =?", text);
//						
//					}else if (option == 1) {
//						loadData("where 'telefone' = ?", text);
//
//					}else if (option == 2) {
//						loadData("where 'email' = ?", text);
//				
//					}
//				}
//			}
//		});

		
		txt.setBounds(481, 11, 255, 34);
		contentPane.add(txt);
		
		txt.addEventOptionSelected(new SearchOptinEvent() {
			
			@Override
			public void optionSelected(SearchOption option, int index) {
				txt.setHint("Pesquisar por " + option.getName()+"...");
				
			}
		});
				
		txt.addOption(new SearchOption("Nome", new ImageIcon(getClass().getResource("/splashscreen/user.png"))));
		txt.addOption(new SearchOption("Telefone", new ImageIcon(getClass().getResource("/splashscreen/tel.png"))));
		txt.addOption(new SearchOption("Email", new ImageIcon(getClass().getResource("/splashscreen/email.png"))));
		txt.setSelectedIndex(0);
		
		JTable table = new JTable();
		Object[] columns = {"ID", "Usuário", "Telefone", "Email"};
		DefaultTableModel model = new DefaultTableModel();
		
		model.setColumnIdentifiers(columns);
		table.setModel(model);
		
		table.setBackground(Color.white);
		table.setForeground(Color.black);
		table.setGridColor(Color.red);
		table.setSelectionBackground(Color.BLUE);
		table.setSelectionForeground(Color.WHITE);
		table.setFont(new Font("Tahoma",Font.PLAIN,17));
		table.setRowHeight(30);
		table.setAutoCreateRowSorter(true);
		this.table= table;
		
		JScrollPane pane = new JScrollPane(table);
		pane.setForeground(Color.RED);
		pane.setBackground(Color.WHITE);
		pane.setBounds(54,56,655,339);
		
		contentPane.add(pane);
		
		JButton btnNewButton = new JButton("Voltar");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(594, 412, 89, 23);
		contentPane.add(btnNewButton);
		
		Object[] row = new Object[4];
		
		contentPane.setVisible(true);
		
		//loadData("");
	
		}
	
	
	public void loadData(String option, String text) throws Exception {
	        try {
	            Connection conn = ConnectionFactory.createConnectionToMySQL();
	            String sql = "SELECT id, nome, telefone, email FROM usuario " + option;
	            PreparedStatement pstm = conn.prepareStatement(sql);
	            pstm.setString(1, text);
	            ResultSet rs = pstm.executeQuery();

	            DefaultTableModel model = new DefaultTableModel(coluna, 0);
	            while (rs.next()) {
	                int id = rs.getInt("id");
	                String nome = rs.getString("nome");
	                String telefone = rs.getString("telefone");
	                String email = rs.getString("email");
	                model.addRow(new Object[]{id, nome, telefone, email});
	            }
	            table.setModel(model);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }}}
	    

		
//	public void loadData(String where, Object... search) {
//
//		String sql = "select * from usuario" + where;
//
//		Connection conn = null;
//		PreparedStatement pstm = null;
//
//		try {
//
//			DefaultTableModel model = (DefaultTableModel) table.getModel();
//			model.setRowCount(0);
//			
//			conn = ConnectionFactory.createConnectionToMySQL();
//
//			pstm = (PreparedStatement) conn.prepareStatement(sql);
//			
//			for(int i= 0; i< search.length; i++) {
//				
//				pstm.setObject(i+1, search);
//			}
//			
//			ResultSet rset = pstm.executeQuery();
//			
//			while(rset.next()) {
//				
//				String id = rset.getString("id");
//				String nome = rset.getString("this_usuario");
//				String telefone = rset.getString("telefone");
//				String email = rset.getString("email");
//
//				model.addRow(new Object[] {table.getRowCount()+1,id,nome,telefone,email});
//			}
//			
//			
//			rset.close();
//			pstm.execute();
//
//		}
//
//		catch (Exception e) {
//
//			e.printStackTrace();
//		}
//
//		finally {
//
//			try {
//
//				if (pstm != null) {
//					pstm.close();
//				}
//
//				if (conn != null) {
//					conn.close();
//				}
//			}
//
//			catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//		
//}}
