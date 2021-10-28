
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
		setTitle("Consulta de Estadisticas");
		setIconImage(Toolkit.getDefaultToolkit().getImage(PantallaConsultaEstadisticas.class.getResource("/presentacion/images/IconoApp.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 795, 473);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(64, 224, 208));
		contentPane.setBackground(new Color(240,255,255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(PantallaConsultaEstadisticas.class.getResource("/presentacion/images/Fondo.png")));
		lblFondo.setHorizontalAlignment(SwingConstants.CENTER);
		lblFondo.setBounds(591, 0, 188, 434);
		contentPane.add(lblFondo);
	}
}
