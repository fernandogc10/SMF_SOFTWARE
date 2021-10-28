package presentacion;

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


public class PantallaPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaPrincipal frame = new PantallaPrincipal();
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
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\usuario\\WorkSpace-Sergio\\SMF_SOFTWARE\\ProyectoVacunacion\\src\\main\\resources\\IconoApp.png"));
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
		btnConEst.setForeground(new Color(0, 0, 0));
		btnConEst.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
		btnConEst.setBackground(new Color(99, 165, 21));
		
		btnConEst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		btnConEst.setBounds(266, 155, 266, 41);
		contentPane.add(btnConEst);
		
		JButton btnSRS = new JButton("Sistema Regional de Salud");
		btnSRS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSRS.setBackground(new Color(99, 165, 21));
		btnSRS.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
		btnSRS.setBounds(266, 259, 266, 41);
		contentPane.add(btnSRS);
		
		JButton btnSNS = new JButton("Sistema Nacional de Salud");
		btnSNS.setBackground(new Color(99, 165, 21));
		btnSNS.setFont(new Font("Roboto Medium", Font.PLAIN, 16));
		btnSNS.setBounds(266, 207, 266, 41);
		contentPane.add(btnSNS);
		
		JLabel lblLogoEmpresa = new JLabel("SMF SOFTWARE © ");
		lblLogoEmpresa.setFont(new Font("Roboto Medium", Font.PLAIN, 11));
		lblLogoEmpresa.setBounds(350, 389, 99, 14);
		contentPane.add(lblLogoEmpresa);
		
		JLabel lbl_Img_Izq = new JLabel("");
		lbl_Img_Izq.setIcon(new ImageIcon("C:\\Users\\usuario\\WorkSpace-Sergio\\SMF_SOFTWARE\\ProyectoVacunacion\\src\\main\\resources\\PicsArt_10-27-11.36.30.png"));
		lbl_Img_Izq.setBounds(63, 134, 165, 311);
		contentPane.add(lbl_Img_Izq);
		
		JLabel lblTitulo = new JLabel("VACUNACIÓN COVID");
		lblTitulo.setForeground(new Color(19, 98, 143));
		lblTitulo.setBackground(new Color(0, 0, 0));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Roboto Medium", Font.BOLD, 26));
		lblTitulo.setBounds(271, 53, 261, 53);
		contentPane.add(lblTitulo);
		
		JLabel lblLogoAbajo = new JLabel("");
		lblLogoAbajo.setIcon(new ImageIcon("..\\resources\\LOGO_SMF.png"));
		lblLogoAbajo.setBounds(360, 348, 64, 41);
		contentPane.add(lblLogoAbajo);
		
		JLabel lbl_Img_Der = new JLabel("");
		lbl_Img_Der.setIcon(new ImageIcon("..\\SMF_SOFTWARE\\ProyectoVacunacion\\src\\main\\resources\\PicsArt_10-27-11.36.58.png"));
		lbl_Img_Der.setBounds(585, 81, 271, 367);
		contentPane.add(lbl_Img_Der);
	}
}
