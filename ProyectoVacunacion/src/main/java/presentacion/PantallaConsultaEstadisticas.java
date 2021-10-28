package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.AttributeSet.ColorAttribute;

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
import java.awt.Panel;


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
		setTitle("SMF_SOFTWARE");
		setIconImage(Toolkit.getDefaultToolkit().getImage(PantallaConsultaEstadisticas.class.getResource("/presentacion/images/IconoApp.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 795, 473);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(64, 224, 208));
		contentPane.setBackground(new Color(136, 212, 234));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Elige una opcion");
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Roboto Medium", Font.PLAIN, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(173, 130, 255, 35);
		contentPane.add(lblNewLabel);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(PantallaConsultaEstadisticas.class.getResource("/presentacion/images/Fondo.png")));
		lblFondo.setHorizontalAlignment(SwingConstants.CENTER);
		lblFondo.setBounds(591, 0, 188, 434);
		contentPane.add(lblFondo);
		
		JButton btnSNS = new JButton("Sistema Nacional de Salud");
		btnSNS.setOpaque(false);
		btnSNS.setAutoscrolls(true);
		btnSNS.setBackground(Color.WHITE);
		
		btnSNS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//frame.setVisible(true);
			}
		});
		
		btnSNS.setForeground(Color.BLACK);
		btnSNS.setFont(new Font("Roboto Medium", Font.PLAIN, 17));
		btnSNS.setBounds(173, 190, 255, 41);
		contentPane.add(btnSNS);
		
		JButton btnSRS = new JButton("Sistema Regional de Salud");
		btnSRS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSRS.setForeground(Color.BLACK);
		btnSRS.setFont(new Font("Roboto Medium", Font.PLAIN, 17));
		btnSRS.setBackground(Color.WHITE);
		btnSRS.setBounds(173, 242, 255, 35);
		contentPane.add(btnSRS);
		
		JButton btnNewButton = new JButton("Consulta de Estadisticas");
		btnNewButton.setFont(new Font("Roboto Medium", Font.PLAIN, 17));
		btnNewButton.setBounds(173, 288, 255, 35);
		contentPane.add(btnNewButton);
	}
}
