package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import java.awt.AWTException;
import java.awt.MouseInfo;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class PantallaConsultaEstadisticas extends JFrame {

	private JPanel contentPane;
	
	int xMouse, yMouse;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaConsultaEstadisticas frame = new PantallaConsultaEstadisticas();
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
	public PantallaConsultaEstadisticas() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(PantallaConsultaEstadisticas.class.getResource("/presentacion/images/Logo.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 795, 473);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(136, 212, 234));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(PantallaConsultaEstadisticas.class.getResource("/presentacion/images/Logo.png")));
		lblLogo.setBounds(451, 41, 100, 100);
		contentPane.add(lblLogo);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(PantallaConsultaEstadisticas.class.getResource("/presentacion/images/Fondo.png")));
		lblFondo.setHorizontalAlignment(SwingConstants.CENTER);
		lblFondo.setBounds(0, -53, 206, 487);
		contentPane.add(lblFondo);
		
		JButton btnSNS = new JButton("SNS");
		btnSNS.setAutoscrolls(true);
		btnSNS.setBackground(Color.WHITE);
		btnSNS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSNS.setForeground(Color.BLACK);
		btnSNS.setFont(new Font("Roboto Medium", Font.PLAIN, 17));
		btnSNS.setBounds(404, 163, 188, 52);
		contentPane.add(btnSNS);
		
		JButton btnSRS = new JButton("SRS");
		btnSRS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSRS.setForeground(Color.BLACK);
		btnSRS.setFont(new Font("Roboto Medium", Font.PLAIN, 17));
		btnSRS.setBackground(Color.WHITE);
		btnSRS.setBounds(404, 260, 188, 52);
		contentPane.add(btnSRS);
	}
}
