package vista;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import controlador.ControladorVisualizarArtista;
import modelo.ConsultaVisualizarArtista;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

/**
 * Clase que representa la ventana de visualizacion de un artista en el sistema.
 * Permite visualizar los detalles de un artista seleccionado, como su nif,
 * apellidos, nombre, nif_jefe.
 * 
 * @author Miguel Angel Perez Valverde
 * @version 1.0
 *
 */
public class VistaVisualizarArtista extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField textFieldDNIJefe, textFieldApellidos, textFieldNombre;
	public JComboBox<String> comboBoxDNIArtista;
	public JButton botonVisualizar;
	private VistaSecundaria vistaSecundaria;
	private ConsultaVisualizarArtista consulta;

	/**
	 * Launch.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaVisualizarArtista frame = new VistaVisualizarArtista();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create VistaVisualizarArtista.
	 */
	public VistaVisualizarArtista() {

		panelPrincipal();
		jLabel();
		unComboBox();
		textField();
		botonVisualizar();
		botonLimpiar();
		botonAtras();
		imagePanel();
	}

	/**
	 * Configura un panel de imagen con una etiqueta que muestra una imagen.
	 */
	private void imagePanel() {
		JLabel lblImg = new JLabel("");
		lblImg.setIcon(new ImageIcon(
				"C:\\Users\\bafli\\Desktop\\Programacion\\ProyectosJava3tTrimestre\\ProyectoCircoMiguelAngelPV\\src\\img\\paaayaaaasoooo.jpg"));
		lblImg.setBounds(0, 0, 1193, 690);
		contentPane.add(lblImg);
	}

	/**
	 * Configura un boton de limpiar en la interfaz grafica. Cuando se presiona el
	 * boton, se ejecuta el metodo "limpiar()".
	 */
	private void botonLimpiar() {
		JButton botonLimpiar = new JButton("Limpiar");
		botonLimpiar.setVerticalAlignment(SwingConstants.TOP);
		botonLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiar();
			}
		});
		botonLimpiar.setFont(new Font("Showcard Gothic", Font.PLAIN, 17));
		botonLimpiar.setBounds(58, 601, 144, 28);
		contentPane.add(botonLimpiar);
	}

	/**
	 * Configura un boton de regresar en la interfaz grafica. Cuando se presiona el
	 * boton, se muestra la vista secundaria y se cierra la vista actual.
	 */
	private void botonAtras() {
		vistaSecundaria = new VistaSecundaria();
		JButton botonAtras = new JButton("Atras");
		botonAtras.setVerticalAlignment(SwingConstants.TOP);
		botonAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vistaSecundaria.setVisible(true);
				dispose();
			}
		});
		botonAtras.setFont(new Font("Showcard Gothic", Font.PLAIN, 17));
		botonAtras.setBounds(965, 612, 124, 28);
		contentPane.add(botonAtras);
	}

	/**
	 * Configura un boton de visualizar en la interfaz grafica. Cuando se presiona
	 * el boton, se ejecuta el controlador para visualizar artistas.
	 */
	private void botonVisualizar() {
		botonVisualizar = new JButton("Visualizar");
		botonVisualizar.setVerticalAlignment(SwingConstants.TOP);
		botonVisualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControladorVisualizarArtista cva = new ControladorVisualizarArtista(consulta,
						VistaVisualizarArtista.this);
				cva.actionPerformed(e);
			}
		});
		botonVisualizar.setFont(new Font("Showcard Gothic", Font.PLAIN, 17));
		botonVisualizar.setBounds(295, 539, 150, 28);
		contentPane.add(botonVisualizar);
	}

	/**
	 * Configura los campos de texto en la interfaz grafica. Crea y configura los
	 * campos de texto para nombre, DNI del jefe y apellidos.
	 */
	private void textField() {
		textFieldNombre = new JTextField();
		textFieldNombre.setFont(new Font("Showcard Gothic", Font.PLAIN, 15));
		textFieldNombre.setEditable(false);
		textFieldNombre.setColumns(10);
		textFieldNombre.setBounds(282, 287, 185, 29);
		contentPane.add(textFieldNombre);

		textFieldDNIJefe = new JTextField();
		textFieldDNIJefe.setFont(new Font("Showcard Gothic", Font.PLAIN, 15));
		textFieldDNIJefe.setEditable(false);
		textFieldDNIJefe.setColumns(10);
		textFieldDNIJefe.setBounds(282, 423, 185, 29);
		contentPane.add(textFieldDNIJefe);

		textFieldApellidos = new JTextField();
		textFieldApellidos.setFont(new Font("Showcard Gothic", Font.PLAIN, 15));
		textFieldApellidos.setEditable(false);
		textFieldApellidos.setColumns(10);
		textFieldApellidos.setBounds(282, 235, 185, 29);
		contentPane.add(textFieldApellidos);
	}

	/**
	 * Configura un combo box en la interfaz grafica. Crea y configura un combo box
	 * para el DNI del artista. Asigna una fuente y posicion al combo box. Realiza
	 * una consulta para obtener los datos del artista y los asigna al combo box.
	 */
	private void unComboBox() {
		comboBoxDNIArtista = new JComboBox<String>();
		comboBoxDNIArtista.setFont(new Font("Showcard Gothic", Font.PLAIN, 17));
		comboBoxDNIArtista.setBounds(282, 104, 185, 28);
		contentPane.add(comboBoxDNIArtista);
		consulta = new ConsultaVisualizarArtista();
		ControladorVisualizarArtista.comboBoxNIFArtista(comboBoxDNIArtista);
	}

	/**
	 * Configura las etiquetas en la interfaz grafica. Crea y configura las
	 * etiquetas para mostrar informacion en la interfaz. Asigna alineacion, color,
	 * fuente y posicion a cada etiqueta.
	 */
	private void jLabel() {
		JLabel DniArtista = new JLabel("DNI del Artista:");
		DniArtista.setHorizontalAlignment(SwingConstants.RIGHT);
		DniArtista.setForeground(Color.WHITE);
		DniArtista.setFont(new Font("Showcard Gothic", Font.PLAIN, 20));
		DniArtista.setBounds(58, 105, 214, 27);
		contentPane.add(DniArtista);

		JLabel Apellidos = new JLabel("Apellidos:");
		Apellidos.setVerticalAlignment(SwingConstants.BOTTOM);
		Apellidos.setHorizontalAlignment(SwingConstants.RIGHT);
		Apellidos.setForeground(Color.WHITE);
		Apellidos.setFont(new Font("Showcard Gothic", Font.PLAIN, 20));
		Apellidos.setBounds(122, 235, 150, 28);
		contentPane.add(Apellidos);

		JLabel Nombre = new JLabel("Nombre:");
		Nombre.setVerticalAlignment(SwingConstants.BOTTOM);
		Nombre.setHorizontalAlignment(SwingConstants.RIGHT);
		Nombre.setForeground(Color.WHITE);
		Nombre.setFont(new Font("Showcard Gothic", Font.PLAIN, 20));
		Nombre.setBounds(130, 284, 142, 34);
		contentPane.add(Nombre);

		JLabel DniJefe = new JLabel("DNI del Jefe:");
		DniJefe.setVerticalAlignment(SwingConstants.BOTTOM);
		DniJefe.setHorizontalAlignment(SwingConstants.RIGHT);
		DniJefe.setForeground(Color.WHITE);
		DniJefe.setFont(new Font("Showcard Gothic", Font.PLAIN, 20));
		DniJefe.setBounds(84, 423, 185, 34);
		contentPane.add(DniJefe);
	}

	/**
	 * Configura el panel principal de la interfaz grafica. Establece las
	 * propiedades del panel principal, como el titulo, el icono, el tamanio y el
	 * comportamiento al cerrar la ventana. Crea un panel de contenido y lo
	 * configura con bordes vacios. Establece el panel de contenido como el panel
	 * principal y configura su disenio.
	 */
	private void panelPrincipal() {
		setResizable(false);
		setTitle("Visualizar Artistas");
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"C:\\Users\\bafli\\Desktop\\Programacion\\ProyectosJava3tTrimestre\\ProyectoCircoMiguelAngelPV\\src\\img\\lionDefinitivo.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1207, 727);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
	}

	/**
	 * metodo que limpia los campos de textos.
	 */
	private void limpiar() {
		textFieldApellidos.setText("");
		textFieldDNIJefe.setText("");
		textFieldNombre.setText("");
	}
}
