
package presentacion;

import java.io.*;
import java.sql.SQLException;
import java.util.Random;
import java.util.Vector;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import dominio.controller.GestorVacunacion;
import dominio.entitymodel.LoteVacunas;
import dominio.entitymodel.TipoVacuna;
import persistencia.AgenteBD;

import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class PantallaGestionSistemaRegionalSalud extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldLote;
	private JTextField textFieldRegion;
	private JTextField textFieldCantidad;
	private JTextField textFieldPrioridad;
	private JTextField textFieldNombre;
	private JTextField textFieldApellidos;
	private JTextField textFieldNIF;
	private JTextField textFieldTipo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaGestionSistemaRegionalSalud regional = new PantallaGestionSistemaRegionalSalud();
					regional.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PantallaGestionSistemaRegionalSalud() {
		setResizable(false);
		setTitle("Sistema Regional de Salud");
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

		final JLabel lblAltaprimero = new JLabel("¡PRIMERO DEBE DE ESTAR DADO DE ALTA UN NUEVO LOTE!");
		lblAltaprimero.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		lblAltaprimero.setBounds(54, 365, 326, 47);
		contentPane.add(lblAltaprimero);

		final JButton btnDarDeAlta = new JButton("Dar de alta");
		btnDarDeAlta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){
				
				Vector<Object> vector = new Vector <> ();
				try {
					vector = AgenteBD.getAgente().select("Select * from LoteVacunas");
				} catch (SQLException e2) {
					e2.printStackTrace();
				}

				if (vector.isEmpty()) {

					lblAltaprimero.setVisible(true);
					return;
				} else {
					java.util.Date date = new java.util.Date();
					java.sql.Date sqlDate = new java.sql.Date(date.getTime());

					try {
						
						System.out.println(textFieldLote.getText());

						GestorVacunacion.altaEntregaVacunas(textFieldLote.getText(), sqlDate,
								Integer.parseInt(textFieldCantidad.getText()),
								Integer.parseInt(textFieldPrioridad.getText()),
								textFieldRegion.getText().toString().toUpperCase());
					} catch (NumberFormatException e1) {

						e1.printStackTrace();
					} catch (SQLException e1) {

						e1.printStackTrace();
					} catch (Exception e1) {

						e1.printStackTrace();
					}
				}

				textFieldRegion.setText(null);
				textFieldLote.setText(null);
				textFieldPrioridad.setText(null);
				textFieldCantidad.setText(null);
			}
		});
		btnDarDeAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDarDeAlta.setBackground(new Color(19, 98, 143));
		btnDarDeAlta.setFont(new Font("Tw Cen MT", Font.BOLD, 14));
		btnDarDeAlta.setForeground(Color.WHITE);
		btnDarDeAlta.setBounds(257, 334, 111, 35);
		contentPane.add(btnDarDeAlta);

		final JLabel lblVacunacion = new JLabel("Se ha registrado la vacunación correctamente.");
		lblVacunacion.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		lblVacunacion.setBounds(392, 379, 318, 16);
		contentPane.add(lblVacunacion);

		final JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				java.util.Date date = new java.util.Date();
				java.sql.Date sqlDate = new java.sql.Date(date.getTime());

				Random r = new Random();
				int num = r.nextInt(4);

				String farmaceutica = TipoVacuna.Farmaceuticas.values()[num].toString();

				TipoVacuna nuevoTipoVacuna = new TipoVacuna(textFieldTipo.getText().toString(), farmaceutica,
						sqlDate.toString());

				try {

					GestorVacunacion.registrarVacunacion(sqlDate, textFieldNombre.getText().toString(),
							textFieldApellidos.getText().toString(), textFieldNIF.getText().toString(),
							nuevoTipoVacuna);

					lblVacunacion.setVisible(true);
				} catch (SQLException e1) {

					e1.printStackTrace();
				} catch (Exception e1) {

					e1.printStackTrace();
				}

				textFieldRegion.setText(null);
				textFieldNombre.setText(null);
				textFieldApellidos.setText(null);
				textFieldNIF.setText(null);
				textFieldTipo.setText(null);
			}
		});
		btnRegistrar.setBackground(new Color(19, 98, 143));
		btnRegistrar.setFont(new Font("Tw Cen MT", Font.BOLD, 14));
		btnRegistrar.setForeground(Color.WHITE);
		btnRegistrar.setBounds(546, 334, 91, 35);
		contentPane.add(btnRegistrar);

		final JLabel lblSeleccioneLaOpcion = new JLabel("Seleccione la opcion que desee realizar");
		lblSeleccioneLaOpcion.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeleccioneLaOpcion.setFont(new Font("Tw Cen MT", Font.BOLD, 17));
		lblSeleccioneLaOpcion.setBounds(206, 49, 286, 43);
		contentPane.add(lblSeleccioneLaOpcion);

		final JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setHorizontalAlignment(SwingConstants.CENTER);
		lblCantidad.setFont(new Font("Tw Cen MT", Font.BOLD, 16));
		lblCantidad.setBounds(89, 195, 91, 35);
		contentPane.add(lblCantidad);

		final JLabel lblPrioridad = new JLabel("Prioridad:");
		lblPrioridad.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrioridad.setFont(new Font("Tw Cen MT", Font.BOLD, 16));
		lblPrioridad.setBounds(89, 241, 91, 35);
		contentPane.add(lblPrioridad);

		final JLabel lblRegion = new JLabel("Región:");
		lblRegion.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegion.setFont(new Font("Tw Cen MT", Font.BOLD, 16));
		lblRegion.setBounds(89, 288, 91, 35);
		contentPane.add(lblRegion);

		final JLabel lblLote = new JLabel("Lote:");
		lblLote.setHorizontalAlignment(SwingConstants.CENTER);
		lblLote.setFont(new Font("Tw Cen MT", Font.BOLD, 16));
		lblLote.setBounds(106, 150, 91, 35);
		contentPane.add(lblLote);

		final JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setFont(new Font("Tw Cen MT", Font.BOLD, 16));
		lblNombre.setBounds(378, 150, 69, 35);
		contentPane.add(lblNombre);

		final JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setHorizontalAlignment(SwingConstants.CENTER);
		lblApellidos.setFont(new Font("Tw Cen MT", Font.BOLD, 16));
		lblApellidos.setBounds(378, 195, 69, 35);
		contentPane.add(lblApellidos);

		final JLabel lblNIF = new JLabel("NIF:");
		lblNIF.setHorizontalAlignment(SwingConstants.CENTER);
		lblNIF.setFont(new Font("Tw Cen MT", Font.BOLD, 16));
		lblNIF.setBounds(378, 241, 69, 35);
		contentPane.add(lblNIF);

		final JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTipo.setFont(new Font("Tw Cen MT", Font.BOLD, 16));
		lblTipo.setBounds(378, 288, 69, 35);
		contentPane.add(lblTipo);

		final JButton btnRegistrarVacunacion = new JButton("Registrar Vacunación");
		btnRegistrarVacunacion.setForeground(Color.WHITE);
		btnRegistrarVacunacion.setBackground(new Color(19, 98, 143));
		btnRegistrarVacunacion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				textFieldNombre.setVisible(true);
				lblNombre.setVisible(true);
				textFieldApellidos.setVisible(true);
				lblApellidos.setVisible(true);
				textFieldNIF.setVisible(true);
				lblNIF.setVisible(true);
				textFieldTipo.setVisible(true);
				lblTipo.setVisible(true);
				lblVacunacion.setVisible(false);

				textFieldRegion.setVisible(false);
				lblRegion.setVisible(false);
				textFieldLote.setVisible(false);
				lblLote.setVisible(false);
				lblCantidad.setVisible(false);
				textFieldCantidad.setVisible(false);
				lblPrioridad.setVisible(false);
				textFieldPrioridad.setVisible(false);
				lblCantidad.setVisible(false);
				btnDarDeAlta.setVisible(false);
				lblAltaprimero.setVisible(false);
				btnRegistrar.setVisible(true);

			}
		});
		btnRegistrarVacunacion.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		btnRegistrarVacunacion.setBounds(378, 104, 262, 35);
		contentPane.add(btnRegistrarVacunacion);

		JButton btnDarDeAltaEntregaVacunas = new JButton("Dar de alta entrega vacunas\r\n");
		btnDarDeAltaEntregaVacunas.setForeground(Color.WHITE);
		btnDarDeAltaEntregaVacunas.setBackground(new Color(19, 98, 143));
		btnDarDeAltaEntregaVacunas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				textFieldLote.setText("Ejemplo: lote_0, lote_1...");
				textFieldLote.setVisible(true);
				lblLote.setVisible(true);
				lblCantidad.setVisible(true);
				textFieldCantidad.setVisible(true);
				lblPrioridad.setVisible(true);
				textFieldPrioridad.setVisible(true);

				lblRegion.setVisible(true);
				textFieldRegion.setVisible(true);

				lblCantidad.setVisible(true);
				btnDarDeAlta.setVisible(true);
				btnRegistrar.setVisible(false);

				textFieldNombre.setVisible(false);
				lblNombre.setVisible(false);
				textFieldApellidos.setVisible(false);
				lblApellidos.setVisible(false);
				textFieldNIF.setVisible(false);
				lblNIF.setVisible(false);
				textFieldTipo.setVisible(false);
				lblTipo.setVisible(false);
				lblAltaprimero.setVisible(false);
				lblVacunacion.setVisible(false);

			}
		});
		btnDarDeAltaEntregaVacunas.setFont(new Font("Tw Cen MT", Font.BOLD, 15));
		btnDarDeAltaEntregaVacunas.setBounds(106, 103, 262, 36);
		contentPane.add(btnDarDeAltaEntregaVacunas);

		textFieldLote = new JTextField();
		textFieldLote.setBounds(182, 150, 186, 35);
		contentPane.add(textFieldLote);
		textFieldLote.setColumns(10);

		textFieldCantidad = new JTextField();
		textFieldCantidad.setBounds(182, 196, 186, 35);
		contentPane.add(textFieldCantidad);
		textFieldCantidad.setColumns(10);

		textFieldPrioridad = new JTextField();
		textFieldPrioridad.setBounds(182, 242, 186, 35);
		contentPane.add(textFieldPrioridad);
		textFieldPrioridad.setColumns(10);

		textFieldRegion = new JTextField();
		textFieldRegion.setBounds(182, 288, 186, 35);
		contentPane.add(textFieldRegion);
		textFieldRegion.setColumns(10);

		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(457, 151, 183, 35);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);

		textFieldApellidos = new JTextField();
		textFieldApellidos.setBounds(457, 196, 183, 35);
		contentPane.add(textFieldApellidos);
		textFieldApellidos.setColumns(10);

		textFieldNIF = new JTextField();
		textFieldNIF.setBounds(457, 242, 183, 35);
		contentPane.add(textFieldNIF);
		textFieldNIF.setColumns(10);

		textFieldTipo = new JTextField();
		textFieldTipo.setBounds(457, 289, 183, 35);
		contentPane.add(textFieldTipo);
		textFieldTipo.setColumns(10);

		textFieldLote.setVisible(false);
		lblLote.setVisible(false);
		lblCantidad.setVisible(false);
		textFieldCantidad.setVisible(false);
		lblPrioridad.setVisible(false);
		textFieldPrioridad.setVisible(false);
		textFieldRegion.setVisible(false);
		lblRegion.setVisible(false);
		lblCantidad.setVisible(false);
		btnDarDeAlta.setVisible(false);
		textFieldNombre.setVisible(false);
		lblNombre.setVisible(false);
		textFieldApellidos.setVisible(false);
		lblApellidos.setVisible(false);
		textFieldNIF.setVisible(false);
		lblNIF.setVisible(false);
		textFieldTipo.setVisible(false);
		lblTipo.setVisible(false);
		btnRegistrar.setVisible(false);
		lblAltaprimero.setVisible(false);
		lblVacunacion.setVisible(false);

	}
}