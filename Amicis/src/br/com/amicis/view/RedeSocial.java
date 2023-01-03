package br.com.amicis.view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class RedeSocial {
    private JFrame frame;
    private JPanel publicacoesPanel;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    RedeSocial window = new RedeSocial();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public RedeSocial() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout(0, 0));

        JScrollPane scrollPane = new JScrollPane();
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);

        publicacoesPanel = new JPanel();
        publicacoesPanel.setLayout(new BoxLayout(publicacoesPanel, BoxLayout.Y_AXIS));
        scrollPane.setViewportView(publicacoesPanel);

        // Adiciona alguns JPanels de publicação ao JPanel de publicações
        for (int i = 0; i < 20; i++) {
            JPanel publicacaoPanel = criarPublicacaoPanel(i + 1);
            publicacoesPanel.add(publicacaoPanel);
        }
    }

    // Método que cria um JPanel de publicação com o número especificado
    private JPanel criarPublicacaoPanel(int numero) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		panel.setPreferredSize(new Dimension(400, 100));
		
		JLabel label = new JLabel("Publicação " + numero);
		panel.add(label);
		
		JTextArea textArea = new JTextArea();
		textArea.setText("Conteúdo da publicação " + numero);
		panel.add(textArea);
		
		JButton button = new JButton("Curtir");
		panel.add(button);
		
		return panel;
    }
}