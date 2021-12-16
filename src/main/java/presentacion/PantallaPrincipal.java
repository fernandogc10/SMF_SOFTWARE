package presentacion;


import java.io.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import persistencia.AgenteBD;

import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class PantallaPrincipal extends JFrame {

	private JPanel contentPane;
////
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaPrincipal frame = new PantallaPrincipal();
					AgenteBD agente = new AgenteBD();
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
	public PantallaPrincipal() {
		
		setBackground(Color.GRAY);
		setIconImage(Toolkit.getDefaultToolkit().getImage(".\\src\\main\\resources\\LogoAPP.png"));
		setTitle("SMF_SOFTWARE");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 453);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnConEst = new JButton("Consultar estadísticas");
		btnConEst.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PantallaConsultaEstadisticas estadisticas = new PantallaConsultaEstadisticas();
				estadisticas.setVisible(true);
				dispose();
			}

		});
		btnConEst.setForeground(Color.WHITE);
		btnConEst.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		btnConEst.setBackground(new Color(19,98,143));
		
		btnConEst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		btnConEst.setBounds(266, 155, 266, 41);
		contentPane.add(btnConEst);
		
		JButton btnSRS = new JButton("Sistema Regional de Salud");
		btnSRS.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PantallaGestionSistemaRegionalSalud regional = new PantallaGestionSistemaRegionalSalud();
				regional.setVisible(true);
				dispose();
			}
		});
		btnSRS.setForeground(Color.WHITE);
		btnSRS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSRS.setBackground(new Color(19,98,143));
		btnSRS.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		btnSRS.setBounds(266, 259, 266, 41);
		contentPane.add(btnSRS);
		
		JButton btnSNS = new JButton("Sistema Nacional de Salud");
		btnSNS.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PantallaGestionSistemaSaludNacional nacional = new PantallaGestionSistemaSaludNacional();
				nacional.setVisible(true);
				dispose();
			}
		});
		btnSNS.setForeground(Color.WHITE);
		btnSNS.setBackground(new Color(19,98,143));
		btnSNS.setFont(new Font("Tw Cen MT", Font.BOLD, 18));
		btnSNS.setBounds(266, 207, 266, 41);
		contentPane.add(btnSNS);
		
		JLabel lblLogoEmpresa = new JLabel("SMF SOFTWARE © ");
		lblLogoEmpresa.setFont(new Font("Roboto Medium", Font.PLAIN, 11));
		lblLogoEmpresa.setBounds(350, 389, 99, 14);
		contentPane.add(lblLogoEmpresa);
		
		JLabel lbl_Img_Izq = new JLabel("");
		lbl_Img_Izq.setIcon(new ImageIcon(".\\src\\main\\resources\\sani_1.png"));
		lbl_Img_Izq.setBounds(63, 134, 165, 311);
		contentPane.add(lbl_Img_Izq);
		
		JLabel lblTitulo = new JLabel("VACUNACIÓN COVID");
		lblTitulo.setForeground(new Color(19, 98, 143));
		lblTitulo.setBackground(new Color(0, 0, 0));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tw Cen MT", Font.BOLD, 26));
		lblTitulo.setBounds(271, 53, 261, 53);
		contentPane.add(lblTitulo);
		
		JLabel lblLogoAbajo = new JLabel("");
		lblLogoAbajo.setIcon(new ImageIcon(".\\src\\main\\resources\\LOGO_SMF.png"));
		lblLogoAbajo.setBounds(360, 348, 64, 41);
		contentPane.add(lblLogoAbajo);
		
		JLabel lbl_Img_Der = new JLabel("");
		lbl_Img_Der.setIcon(new ImageIcon(".\\src\\main\\resources\\sani_2.png"));
		lbl_Img_Der.setBounds(578, 86, 271, 365);
		contentPane.add(lbl_Img_Der);
	}
}
