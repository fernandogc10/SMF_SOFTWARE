
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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

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
		
		
		
		setResizable(false);
		setTitle("Consulta de Estadisticas");
		setIconImage(Toolkit.getDefaultToolkit().getImage(".\\src\\main\\resources\\LogoAPP.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 795, 473);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setForeground(new Color(64, 224, 208));
		contentPane.setBackground(new Color(240,255,255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnPrincipal = new JButton("Principal");
		btnPrincipal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PantallaPrincipal principal = new PantallaPrincipal();
				principal.setVisible(true);
				dispose();
			}
		});
		btnPrincipal.setBackground(new Color(19,98,143));
		btnPrincipal.setForeground(Color.WHITE);
		btnPrincipal.setFont(new Font("Tw Cen MT", Font.BOLD, 16));
		btnPrincipal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPrincipal.setBounds(672, 398, 97, 25);
		contentPane.add(btnPrincipal);
		
		JComboBox comboBox_Regiones = new JComboBox();
		comboBox_Regiones.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		comboBox_Regiones.setModel(new DefaultComboBoxModel(new String[] {"            -- --", "Andalucia", "Aragón", "Asturias", "Cantabria", "Castilla-La Mancha", "Castilla y León", "Cataluña", "Extremadura", "Galicia", "Islas Baleares", "Islas Canarias", "La Rioja", "Madrid", "Murcia", "Navarra", "País Vasco", "Valencia"}));
		comboBox_Regiones.setToolTipText("");
		comboBox_Regiones.setBounds(528, 142, 135, 38);
		contentPane.add(comboBox_Regiones);
		
		comboBox_Regiones.setVisible(false);
		
		JLabel lblTitulo = new JLabel("Selecciones la opción que desea consultar");
		lblTitulo.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(155, 35, 385, 46);
		contentPane.add(lblTitulo);
		
		JButton btnTotalVacunados = new JButton("Total vacunados");
		btnTotalVacunados.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				comboBox_Regiones.setVisible(false);
			}
		});
		btnTotalVacunados.setFont(new Font("Tw Cen MT", Font.BOLD, 17));
		btnTotalVacunados.setBounds(181, 92, 337, 40);
		contentPane.add(btnTotalVacunados);
		
		JButton btnTotalVacunadosRegion = new JButton("Total vacunados por Región");
		btnTotalVacunadosRegion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				comboBox_Regiones.setVisible(true);
			}
		});
		btnTotalVacunadosRegion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTotalVacunadosRegion.setFont(new Font("Tw Cen MT", Font.BOLD, 17));
		btnTotalVacunadosRegion.setBounds(181, 142, 337, 40);
		contentPane.add(btnTotalVacunadosRegion);
		
		JButton btnPorcentajeVacunadosRecividas = new JButton("Porcentaje Vacunados sobre Recividas");
		btnPorcentajeVacunadosRecividas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				comboBox_Regiones.setVisible(false);
			}
		});
		btnPorcentajeVacunadosRecividas.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		btnPorcentajeVacunadosRecividas.setBounds(181, 193, 341, 40);
		contentPane.add(btnPorcentajeVacunadosRecividas);
		
		JButton btnNewButton = new JButton("Porcentaje Vacunados sobre recividas en región");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				comboBox_Regiones.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		btnNewButton.setBounds(181, 244, 341, 39);
		contentPane.add(btnNewButton);
		

		
		
	}
}
