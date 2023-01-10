package br.com.amicis.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class Perfil extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentJPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Perfil frame = new Perfil();
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
	public Perfil() {
		setBackground(new Color(255, 255, 255));
		getContentPane().setBackground(new Color(255, 255, 255));

		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("C:\\Users\\mayko\\git\\Amicis\\Amicis\\resources\\pngwing.com.png"));
		setTitle("Home");
		setFont(new Font("Inconsolata", Font.PLAIN, 14));
		setBounds(100, 100, 1118, 660);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentJPanel = new JPanel();
		setContentPane(contentJPanel);
		getContentPane().setLayout(null);

	}
}
