
package presentacion;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dominio.controller.GestorRepartoVacunas;
import dominio.entitymodel.EntregaVacunas;

import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JList;

public class PantallaGestionSistemaSaludNacional extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldFecha;
	private JTextField textFieldTipo;
	private JTextField textFieldCantidad;

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
		contentPane.setBackground(new Color(240, 255, 255));
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
		btnPrincipal.setBackground(new Color(19, 98, 143));
		btnPrincipal.setForeground(Color.WHITE);
		btnPrincipal.setFont(new Font("Tw Cen MT", Font.BOLD, 16));
		btnPrincipal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPrincipal.setBounds(672, 398, 97, 25);
		contentPane.add(btnPrincipal);

		JList listaRegiones = new JList();
		listaRegiones.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		listaRegiones.setBounds(448, 179, 192, 243);
		contentPane.add(listaRegiones);
		
		JLabel lblregioneslista = new JLabel("Se deben realizar entregas a las siguientes regiones:");
		lblregioneslista.setBounds(378, 151, 328, 16);
		contentPane.add(lblregioneslista);

		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTipo.setFont(new Font("Tw Cen MT", Font.BOLD, 16));
		lblTipo.setBounds(116, 162, 57, 35);
		contentPane.add(lblTipo);

		textFieldTipo = new JTextField();
		textFieldTipo.setBounds(176, 163, 192, 35);
		contentPane.add(textFieldTipo);
		textFieldTipo.setColumns(10);
		
		JLabel lblloteEntregados = new JLabel("El lote de vacunas ha sido dado de alta correctamente.");
		lblloteEntregados.setBounds(73, 304, 357, 16);
		contentPane.add(lblloteEntregados);

		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setFont(new Font("Tw Cen MT", Font.BOLD, 16));
		lblCantidad.setHorizontalAlignment(SwingConstants.CENTER);
		lblCantidad.setBounds(94, 209, 68, 35);
		contentPane.add(lblCantidad);

		textFieldCantidad = new JTextField();
		textFieldCantidad.setBounds(176, 210, 192, 35);
		contentPane.add(textFieldCantidad);
		textFieldCantidad.setColumns(10);

		JButton btnDarDeAlta = new JButton("Dar de alta el Lote");
		btnDarDeAlta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				java.util.Date date = new java.util.Date();
				java.sql.Date sqlDate = new java.sql.Date(date.getTime());

				try {
					GestorRepartoVacunas.altaNuevoLoteVacunas(sqlDate, textFieldTipo.getText(),
							Integer.parseInt(textFieldCantidad.getText()));

				} catch (Exception e1) {

					e1.printStackTrace();
				}
				
				lblloteEntregados.setVisible(true);

				textFieldCantidad.setText(null);
				textFieldTipo.setText(null);
			}
		});
		btnDarDeAlta.setForeground(Color.WHITE);
		btnDarDeAlta.setBackground(new Color(19, 98, 143));
		btnDarDeAlta.setFont(new Font("Tw Cen MT", Font.BOLD, 14));
		btnDarDeAlta.setBounds(206, 257, 150, 35);
		contentPane.add(btnDarDeAlta);

		JLabel lblSeleccioneLaOpcion = new JLabel("Seleccione la opcion que desee realizar");
		lblSeleccioneLaOpcion.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeleccioneLaOpcion.setFont(new Font("Tw Cen MT", Font.BOLD, 17));
		lblSeleccioneLaOpcion.setBounds(206, 49, 286, 43);
		contentPane.add(lblSeleccioneLaOpcion);

		listaRegiones.setVisible(false);
		textFieldTipo.setVisible(false);
		lblTipo.setVisible(false);
		textFieldCantidad.setVisible(false);
		lblCantidad.setVisible(false);
		btnDarDeAlta.setVisible(false);
		lblregioneslista.setVisible(false);
		lblloteEntregados.setVisible(false);

		JButton btnCalcularEntregasRegion = new JButton("Calcular entregas región");
		btnCalcularEntregasRegion.setForeground(Color.WHITE);
		btnCalcularEntregasRegion.setBackground(new Color(19, 98, 143));
		btnCalcularEntregasRegion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				textFieldTipo.setVisible(false);
				lblTipo.setVisible(false);
				textFieldCantidad.setVisible(false);
				lblCantidad.setVisible(false);
				btnDarDeAlta.setVisible(false);
				listaRegiones.setVisible(true);
				lblregioneslista.setVisible(true);
				lblloteEntregados.setVisible(false);

				List<EntregaVacunas> listaEntregaVacunas = new ArrayList<>();

				try {
					listaEntregaVacunas.addAll(GestorRepartoVacunas.calcularEntregasRegion());

				} catch (SQLException e1) {

					e1.printStackTrace();
				} catch (Exception e1) {
					e1.printStackTrace();
				}

				
				DefaultListModel modelo = new DefaultListModel();

				for (int i = 0; i < listaEntregaVacunas.size(); i++) {

					modelo.addElement(listaEntregaVacunas.get(i).get_region().toString());
				}
				
				listaRegiones.setModel(modelo);
			}
		});
		btnCalcularEntregasRegion.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		btnCalcularEntregasRegion.setBounds(378, 104, 262, 35);
		contentPane.add(btnCalcularEntregasRegion);

		JButton btnDarDeAltaNuevoLoteDeVacunas = new JButton("Dar de alta nuevo lote de vacunas");
		btnDarDeAltaNuevoLoteDeVacunas.setForeground(Color.WHITE);
		btnDarDeAltaNuevoLoteDeVacunas.setBackground(new Color(19, 98, 143));
		btnDarDeAltaNuevoLoteDeVacunas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				textFieldTipo.setVisible(true);
				lblTipo.setVisible(true);
				textFieldCantidad.setVisible(true);
				lblCantidad.setVisible(true);
				btnDarDeAlta.setVisible(true);
				lblloteEntregados.setVisible(false);
				
				listaRegiones.setVisible(false);
				lblregioneslista.setVisible(false);
				

	
			}
		});
		btnDarDeAltaNuevoLoteDeVacunas.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		btnDarDeAltaNuevoLoteDeVacunas.setBounds(106, 103, 262, 36);
		contentPane.add(btnDarDeAltaNuevoLoteDeVacunas);
		
		
		
	

	}
}