package vista;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controlador.ControladorArtista;
import modelo.ConsultasArtistas;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Clase que representa la ventana de insercion de artistas. Permite al usuario
 * ingresar los datos de un artista y luego insertarlos en la base de datos.
 * 
 * @author Miguel Angel Perez Valverde
 * @version 1.0
 *
 */
public class VistaInsertarArtista extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ConsultasArtistas consultas;
	public JComboBox<String> comboBoxDNIJefe;
	private VistaSecundaria vistaSecundaria;
	public JTextField textFieldApellidos, textFieldNombre, textFieldDNIArtista;
	public JButton botonInsertar;

	/**
	 * Metodo principal que inicia la aplicacion. Crea una instancia de la ventana
	 * VistaInsertarArtista y la hace visible.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaInsertarArtista frame = new VistaInsertarArtista();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Constructor de la clase VistaInsertarArtista. Crea una instancia de
	 * ConsultasArtistas, configura los componentes de la ventana y aniade los
	 * listeners de los botones.
	 */
	public VistaInsertarArtista() {
		setResizable(false);
		consultas = new ConsultasArtistas();
		panelPrincipal();
		JLabelTexto();
		textFieldDelPanel();
		comboBoxDniJefe();
		botonAtras();
		botonLimpiar();
		botonInsertar();
		imgPanel();
	}

	/**
	 * Metodo privado que configura el panel que muestra una imagen de fondo.
	 */
	private void imgPanel() {
		JLabel jLimgFondo = new JLabel("");
		jLimgFondo.setIcon(new ImageIcon(
				"C:\\Users\\bafli\\Desktop\\Programacion\\ProyectosJava3tTrimestre\\ProyectoCircoMiguelAngelPV\\src\\img\\paya.png"));
		jLimgFondo.setBounds(0, 0, 999, 562);
		contentPane.add(jLimgFondo);
	}

	/**
	 * Metodo privado que configura el boton "Insertar". Crea una instancia de
	 * ControladorArtista y ejecuta el metodo actionPerformed cuando se hace clic en
	 * el boton. Luego, llama al metodo "limpiar" para borrar los campos de texto.
	 */
	private void botonInsertar() {
		botonInsertar = new JButton("Insertar");
		botonInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControladorArtista ca = new ControladorArtista(consultas, VistaInsertarArtista.this);
				ca.actionPerformed(e);
				limpiar();
			}
		});
		botonInsertar.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 17));
		botonInsertar.setBounds(762, 458, 150, 28);
		contentPane.add(botonInsertar);
	}

	/**
	 * Metodo privado que configura el boton "Limpiar". Borra los campos de texto
	 * cuando se hace clic en el boton.
	 */
	private void botonLimpiar() {
		JButton botonLimpiar = new JButton("Limpiar");
		botonLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiar();
			}
		});
		botonLimpiar.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 17));
		botonLimpiar.setBounds(608, 458, 144, 28);
		contentPane.add(botonLimpiar);

	}

	/**
	 * Metodo privado que configura el boton "Atras". Crea una instancia de
	 * VistaSecundaria y la muestra cuando se hace clic en el boton. Luego, cierra
	 * la ventana actual.
	 */
	private void botonAtras() {
		JButton botonAtras = new JButton("Atras");
		vistaSecundaria = new VistaSecundaria();
		botonAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vistaSecundaria.setVisible(true);
				dispose();
			}
		});
		botonAtras.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 17));
		botonAtras.setBounds(51, 458, 124, 28);
		contentPane.add(botonAtras);
	}

	/**
	 * Metodo privado que configura el combo box "DNI del Jefe". Configura el tamanio
	 * y la fuente del combo box. Llama al metodo estático "comboBoxDniJefe" de
	 * ControladorArtista para cargar los datos.
	 */
	private void comboBoxDniJefe() {
		comboBoxDNIJefe = new JComboBox<String>();
		comboBoxDNIJefe.setFont(new Font("Showcard Gothic", Font.PLAIN, 17));
		comboBoxDNIJefe.setBounds(692, 314, 185, 28);
		contentPane.add(comboBoxDNIJefe);
		ControladorArtista.comboBoxDniJefe(comboBoxDNIJefe);

	}

	/**
	 * Metodo privado que configura los campos de texto del panel. Configura el
	 * tamanio y la posicion de los campos de texto.
	 */
	private void textFieldDelPanel() {
		textFieldApellidos = new JTextField();
		textFieldApellidos.setFont(new Font("Showcard Gothic", Font.PLAIN, 15));
		textFieldApellidos.setColumns(10);
		textFieldApellidos.setBounds(692, 188, 185, 29);
		contentPane.add(textFieldApellidos);

		textFieldDNIArtista = new JTextField();
		textFieldDNIArtista.setFont(new Font("Showcard Gothic", Font.PLAIN, 15));
		textFieldDNIArtista.setBounds(692, 142, 185, 29);
		contentPane.add(textFieldDNIArtista);
		textFieldDNIArtista.setColumns(10);

		textFieldNombre = new JTextField();
		textFieldNombre.setFont(new Font("Showcard Gothic", Font.PLAIN, 15));
		textFieldNombre.setColumns(10);
		textFieldNombre.setBounds(692, 242, 185, 29);
		contentPane.add(textFieldNombre);
	}

	/**
	 * Metodo privado que configura el panel principal. Configura el titulo, el
	 * tamanio y el cierre de la ventana. Configura el layout del contentPane.
	 */
	private void panelPrincipal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"C:\\Users\\bafli\\Desktop\\Programacion\\ProyectosJava3tTrimestre\\ProyectoCircoMiguelAngelPV\\src\\img\\lionDefinitivo.png"));
		setTitle("Insertar Artista");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1006, 591);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
	}

	/**
	 * Metodo privado que configura los JLabel de texto. Configura el texto, la
	 * alineacion, el color y la fuente de los JLabel.
	 */
	private void JLabelTexto() {
		JLabel DniArtista = new JLabel("DNI del Artista:");
		DniArtista.setHorizontalAlignment(SwingConstants.RIGHT);
		DniArtista.setForeground(new Color(255, 255, 255));
		DniArtista.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 22));
		DniArtista.setBounds(468, 138, 214, 34);
		contentPane.add(DniArtista);

		JLabel Apellidos = new JLabel("Apellidos:");
		Apellidos.setHorizontalAlignment(SwingConstants.RIGHT);
		Apellidos.setForeground(Color.WHITE);
		Apellidos.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 22));
		Apellidos.setBounds(532, 182, 150, 28);
		contentPane.add(Apellidos);

		JLabel Nombre = new JLabel("Nombre:");
		Nombre.setHorizontalAlignment(SwingConstants.RIGHT);
		Nombre.setForeground(Color.WHITE);
		Nombre.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 22));
		Nombre.setBounds(540, 235, 142, 34);
		contentPane.add(Nombre);

		JLabel DniJefe = new JLabel("DNI del Jefe:");
		DniJefe.setHorizontalAlignment(SwingConstants.RIGHT);
		DniJefe.setForeground(Color.WHITE);
		DniJefe.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 22));
		DniJefe.setBounds(497, 311, 185, 34);
		contentPane.add(DniJefe);
	}

	/**
	 * Metodo privado que limpia los campos de texto.
	 */
	private void limpiar() {
		textFieldApellidos.setText("");
		textFieldDNIArtista.setText("");
		textFieldNombre.setText("");
	}
}
