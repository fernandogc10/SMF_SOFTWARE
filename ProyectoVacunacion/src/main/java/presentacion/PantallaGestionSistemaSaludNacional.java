
package presentacion;

import java.io.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class PantallaGestionSistemaSaludNacional extends JFrame {

	private JPanel contentPane;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaGestionSistemaSaludNacional nacional = new PantallaGestionSistemaSaludNacional();
					nacional.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PantallaGestionSistemaSaludNacional() {
		setResizable(false);
		setTitle("Sistema Nacional de Salud");
		setIconImage(Toolkit.getDefaultToolkit().getImage(".\\src\\main\\resources\\LogoAPP.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 795, 473);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(64, 224, 208));
		contentPane.setBackground(new Color(240,255,255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
}