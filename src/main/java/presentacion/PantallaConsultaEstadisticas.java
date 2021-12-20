
package presentacion;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dominio.controller.GestorEstadisticas;
import dominio.entitymodel.RegionEnum;
import dominio.entitymodel.Vacunacion;

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
import javax.swing.DefaultListModel;
import javax.swing.JTextPane;
import javax.swing.JList;

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

		final JComboBox comboBox_Regiones = new JComboBox();
		comboBox_Regiones.setForeground(new Color(255, 255, 255));
		comboBox_Regiones.setBackground(new Color(19, 98, 143));
		comboBox_Regiones.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		comboBox_Regiones.setModel(new DefaultComboBoxModel(
				new String[] { "                 -- --", "Andalucia", "Aragón", "Asturias", "Cantabria",
						"Castilla-La Mancha", "Castilla y León", "Cataluña", "Extremadura", "Galicia", "Islas Baleares",
						"Islas Canarias", "La Rioja", "Madrid", "Murcia", "Navarra", "País Vasco", "Valencia" }));
		comboBox_Regiones.setToolTipText("");
		comboBox_Regiones.setBounds(528, 128, 172, 38);
		contentPane.add(comboBox_Regiones);

		comboBox_Regiones.setVisible(false);

		final JList listVacunados = new JList();
		listVacunados.setBounds(188, 287, 328, 136);
		contentPane.add(listVacunados);
		listVacunados.setVisible(false);

		final JLabel lblResultado = new JLabel("Número");
		lblResultado.setFont(new Font("Tw Cen MT", Font.BOLD, 11));
		lblResultado.setHorizontalAlignment(SwingConstants.CENTER);
		lblResultado.setBounds(31, 245, 103, 38);
		contentPane.add(lblResultado);

		lblResultado.setVisible(false);

		final JLabel lblTitulo = new JLabel("Selecciones la opción que desea consultar");
		lblTitulo.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(155, 16, 385, 46);
		contentPane.add(lblTitulo);

		final JButton btnTotalVacunados = new JButton("Total vacunados");
		btnTotalVacunados.setForeground(Color.WHITE);
		btnTotalVacunados.setBackground(new Color(19, 98, 143));
		btnTotalVacunados.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				List<Vacunacion> listaVacunados = new ArrayList<>();

				try {

					listaVacunados = GestorEstadisticas.consultarTotalVacunados();

					DefaultListModel modelo = new DefaultListModel();

					for (int i = 0; i < listaVacunados.size(); i++) {

						modelo.addElement(listaVacunados.get(i).get_paciente().get_dni().toString());
					}

					listVacunados.setModel(modelo);

					listVacunados.setVisible(true);

				} catch (Exception e1) {

					e1.printStackTrace();
				}

				comboBox_Regiones.setVisible(false);
				lblResultado.setVisible(true);

			}
		});
		btnTotalVacunados.setFont(new Font("Tw Cen MT", Font.BOLD, 17));
		btnTotalVacunados.setBounds(181, 74, 337, 40);
		contentPane.add(btnTotalVacunados);

		final JButton btnTotalVacunadosRegion = new JButton("Total vacunados por Región");
		btnTotalVacunadosRegion.setForeground(Color.WHITE);
		btnTotalVacunadosRegion.setBackground(new Color(19, 98, 143));
		btnTotalVacunadosRegion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				comboBox_Regiones.setVisible(true);
				lblResultado.setVisible(true);

				comboBox_Regiones.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						List<Vacunacion> listaVacunados = new ArrayList<>();
						
						System.out.println(RegionEnum.valueOf(comboBox_Regiones.getSelectedItem().toString()));
						
						RegionEnum region = RegionEnum.valueOf(comboBox_Regiones.getSelectedItem().toString());

						try {

							listaVacunados = GestorEstadisticas.consultarTotalVacunadosPorRegion(region);

							DefaultListModel modelo = new DefaultListModel();

							for (int i = 0; i < listaVacunados.size(); i++) {

								modelo.addElement(listaVacunados.get(i).get_paciente().get_dni().toString());
							}

							listVacunados.setModel(modelo);

							listVacunados.setVisible(true);

						} catch (Exception e1) {

							e1.printStackTrace();
						}

					}
				});

			}
		});
		btnTotalVacunadosRegion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTotalVacunadosRegion.setFont(new Font("Tw Cen MT", Font.BOLD, 17));
		btnTotalVacunadosRegion.setBounds(179, 126, 337, 40);
		contentPane.add(btnTotalVacunadosRegion);

		final JButton btnPorcentajeVacunadosRecibidas = new JButton("Porcentaje Vacunados sobre Recibidas");
		btnPorcentajeVacunadosRecibidas.setForeground(Color.WHITE);
		btnPorcentajeVacunadosRecibidas.setBackground(new Color(19, 98, 143));
		btnPorcentajeVacunadosRecibidas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				comboBox_Regiones.setVisible(false);
				lblResultado.setVisible(true);
			}
		});
		btnPorcentajeVacunadosRecibidas.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		btnPorcentajeVacunadosRecibidas.setBounds(181, 178, 341, 40);
		contentPane.add(btnPorcentajeVacunadosRecibidas);

		JButton btnPorcentajeVacunadosRecibidasRegion = new JButton("Porcentaje Vacunados sobre recibidas en región");
		btnPorcentajeVacunadosRecibidasRegion.setForeground(Color.WHITE);
		btnPorcentajeVacunadosRecibidasRegion.setBackground(new Color(19, 98, 143));
		btnPorcentajeVacunadosRecibidasRegion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				comboBox_Regiones.setVisible(true);
				lblResultado.setVisible(true);
			}
		});
		btnPorcentajeVacunadosRecibidasRegion.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		btnPorcentajeVacunadosRecibidasRegion.setBounds(181, 230, 341, 39);
		contentPane.add(btnPorcentajeVacunadosRecibidasRegion);

	}
}
