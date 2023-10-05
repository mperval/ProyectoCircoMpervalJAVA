package vista;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import controlador.ControladorAnimal;
import modelo.ConsultasAnimales;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

/**
 * Clase que representa la ventana de insercion de animales.
 * Permite al usuario ingresar los datos de un animal y luego
 * insertarlos en la base de datos.
 * 
 * @author Miguel Angel Perez Valverde
 * @version 1.0
 *
 */
public class VistaInsertarAnimal extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	public JTextField textFieldNombrePK, textFieldEstatura, textFieldPeso, textFieldAnios;
	public JButton botonInsertar;
	private ConsultasAnimales consultas;
	public JComboBox<String> comboBoxTipo, comboBoxNombreAtraccion, comboBoxNombrePistas;
	private VistaSecundaria vistaSecundaria;

	/**
	 * Launch.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaInsertarAnimal frame = new VistaInsertarAnimal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Constructor de la clase ConsultasAnimales. Crea una instancia de
	 * ConsultasAnimales, configura los componentes de la ventana y aniade los
	 * listeners de los botones.
	 */
	public VistaInsertarAnimal() {

		consultas = new ConsultasAnimales();

		ventanaPrincipal();

		jLabelTexto();

		cajaDeTexto();

		tresComboBox();

		botonInsertar();

		botonAtras();

		botonLimpiar();

		imgInsertarAnimal();
	}

	/**
	 * metodo de la ventana principal.
	 */
	private void ventanaPrincipal() {
		setResizable(false);
		setFont(new Font("Showcard Gothic", Font.PLAIN, 20));
		setBackground(new Color(255, 255, 255));
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"C:\\Users\\bafli\\Desktop\\Programacion\\ProyectosJava3tTrimestre\\ProyectoCircoMiguelAngelPV\\src\\img\\lionDefinitivo.png"));
		setTitle("Insertar Animal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1178, 697);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}

	/**
	 * Metodo privado que configura los campos de texto del panel. Configura el
	 * tamanio y la posicion de los campos de texto.
	 */
	private void cajaDeTexto() {
		textFieldNombrePK = new JTextField();
		textFieldNombrePK.setFont(new Font("Showcard Gothic", Font.PLAIN, 15));
		textFieldNombrePK.setBounds(333, 84, 217, 30);
		contentPane.add(textFieldNombrePK);
		textFieldNombrePK.setColumns(10);

		textFieldAnios = new JTextField();
		textFieldAnios.setFont(new Font("Showcard Gothic", Font.PLAIN, 15));
		textFieldAnios.setColumns(10);
		textFieldAnios.setBounds(333, 166, 217, 33);
		contentPane.add(textFieldAnios);

		textFieldPeso = new JTextField();
		textFieldPeso.setFont(new Font("Showcard Gothic", Font.PLAIN, 15));
		textFieldPeso.setColumns(10);
		textFieldPeso.setBounds(333, 286, 217, 33);
		contentPane.add(textFieldPeso);

		textFieldEstatura = new JTextField();
		textFieldEstatura.setFont(new Font("Showcard Gothic", Font.PLAIN, 15));
		textFieldEstatura.setColumns(10);
		textFieldEstatura.setBounds(333, 329, 217, 33);
		contentPane.add(textFieldEstatura);
	}

	/**
	 * Crea y configura tres JComboBox<String> en el contenedor de contenido.
	 * El primer JComboBox<String> muestra el tipo de animal obtenido de la base de datos.
	 * El segundo JComboBox<String> muestra el nombre de la atraccion obtenido de la base de datos.
	 * El tercer JComboBox<String> muestra el nombre de las pistas obtenido de la base de datos.
	 * Se establecen propiedades como la fuente y el tamanio de cada JComboBox<String>, asi como su posicion en el panel.
	 * Se utiliza la clase ControladorAnimal para obtener los datos de los JComboBox<String>, en lugar de hacer consultas directamente en la base de datos.
	 */
	private void tresComboBox() {
		// tipo de animal sacado de la base de datos.
		comboBoxTipo = new JComboBox<String>();
		comboBoxTipo.setFont(new Font("Showcard Gothic", Font.PLAIN, 17));
		comboBoxTipo.setBounds(333, 124, 217, 30);
		contentPane.add(comboBoxTipo);

		/**
		 * NEW CODE: 25/052023
		 * 
		 * @author Miguelpv
		 * 
		 *         cambio por tener mas limpio el codigo ya que el comboBox hace una
		 *         consulta en la base de datos y deberia ir en ControladorAnimal.
		 */
		ControladorAnimal.comboBoxTipoAnimal(comboBoxTipo);

		/**
		 * OLD CODE.
		 */
		/*
		 * try { consultas.tipoAnimal(comboBoxTipo); } catch (SQLException e) {
		 * e.printStackTrace(); }
		 */
		// nombre de la atraccion cogido de la base de datos.
		comboBoxNombreAtraccion = new JComboBox<String>();
		comboBoxNombreAtraccion.setFont(new Font("Showcard Gothic", Font.PLAIN, 17));
		comboBoxNombreAtraccion.setBounds(333, 442, 217, 33);
		contentPane.add(comboBoxNombreAtraccion);
		/**
		 * NEW CODE: 25/052023
		 * 
		 * @author Miguelpv
		 * 
		 *         cambio por tener mas limpio el codigo ya que el comboBox hace una
		 *         consulta en la base de datos y deberia ir en ControladorAnimal.
		 */
		ControladorAnimal.comboBoxNombreAtraccion(comboBoxNombreAtraccion);
		/**
		 * OLD CODE.
		 *
		 * try { consultas.nombreAtracciones(comboBoxNombreAtraccion); } catch
		 * (SQLException e) { e.printStackTrace(); }
		 */
		// nombre de las pitas sacado de la base de datos.
		comboBoxNombrePistas = new JComboBox<String>();
		comboBoxNombrePistas.setFont(new Font("Showcard Gothic", Font.PLAIN, 17));
		comboBoxNombrePistas.setBounds(333, 485, 217, 33);
		contentPane.add(comboBoxNombrePistas);
		/**
		 * NEW CODE: 25/052023
		 * 
		 * @author Miguelpv
		 * 
		 *         cambio por tener mas limpio el codigo ya que el comboBox hace una
		 *         consulta en la base de datos y deberia ir en ControladorAnimal.
		 */
		ControladorAnimal.comboBoxNombrePistas(comboBoxNombrePistas);
		/**
		 * OLD CODE.
		 *
		 * try { consultas.nombrePista(comboBoxNombrePistas); } catch (SQLException e) {
		 * e.printStackTrace(); }
		 */

	}

	/**
	 * Crea y configura un boton "Insertar" en el contenedor de contenido.
	 * Se establecen propiedades como la fuente, el tamanio, la posicion y el borde del boton.
	 * Se crea un ActionListener para el boton que invoca al ControladorAnimal para realizar la insercion del animal en la base de datos.
	 * Despues de insertar el animal, se llama al metodo "limpiar()" para limpiar los campos de texto.
	 */
	private void botonInsertar() {
		botonInsertar = new JButton("Insertar");
		botonInsertar.setVerticalAlignment(SwingConstants.BOTTOM);
		botonInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControladorAnimal ca = new ControladorAnimal(consultas, VistaInsertarAnimal.this);
				ca.actionPerformed(e);
				limpiar();
			}
		});
		botonInsertar.setFont(new Font("Showcard Gothic", Font.PLAIN, 20));
		botonInsertar.setBounds(343, 571, 180, 33);
		botonInsertar.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		contentPane.add(botonInsertar);
	}

	/**
	 * Crea y configura un botón "Atras" en el contenedor de contenido.
	 * Se establecen propiedades como la fuente, el tamanio y la posicion del boton.
	 * Se crea un ActionListener para el boton que muestra la vista secundaria y cierra la vista actual.
	 */
	private void botonAtras() {
		JButton volver = new JButton("Atrás");
		volver.setVerticalAlignment(SwingConstants.TOP);
		vistaSecundaria = new VistaSecundaria();
		volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vistaSecundaria.setVisible(true);
				dispose();
			}
		});
		volver.setFont(new Font("Showcard Gothic", Font.PLAIN, 20));
		volver.setBounds(1015, 595, 111, 27);
		contentPane.add(volver);
	}

	/**
	 * Crea y configura un botón "Limpiar" en el contenedor de contenido.
	 * Se establecen propiedades como la fuente, el borde y la posicion del boton.
	 * Se crea un ActionListener para el boton que invoca al metodo "limpiar()" para limpiar los campos de texto.
	 */
	private void botonLimpiar() {
		JButton botonLimpiar = new JButton("Limpiar");
		botonLimpiar.setVerticalAlignment(SwingConstants.BOTTOM);
		botonLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiar();
			}
		});
		botonLimpiar.setFont(new Font("Showcard Gothic", Font.PLAIN, 17));
		botonLimpiar.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		botonLimpiar.setBounds(233, 575, 89, 27);
		contentPane.add(botonLimpiar);
	}

	/**
	 * Configura la imagen del panel de insercion de animal.
	 * Se crea una etiqueta JLabel y se establecen propiedades como el fondo, el color de fuente y la posicion.
	 * Se establece un icono de imagen usando la clase ImageIcon y la ruta de la imagen.
	 */
	private void imgInsertarAnimal() {
		// imagen del panel.
		JLabel imgInsertarAnimal = new JLabel("");
		imgInsertarAnimal.setToolTipText("");
		imgInsertarAnimal.setForeground(new Color(255, 255, 255));
		imgInsertarAnimal.setBackground(new Color(255, 255, 255));
		imgInsertarAnimal.setFont(new Font("Showcard Gothic", Font.PLAIN, 20));
		imgInsertarAnimal.setIcon(new ImageIcon(
				"C:\\Users\\bafli\\Desktop\\Programacion\\ProyectosJava3tTrimestre\\ProyectoCircoMiguelAngelPV\\src\\img\\tigre.jpg"));
		imgInsertarAnimal.setBounds(0, 10, 1164, 658);
		contentPane.add(imgInsertarAnimal);
	}

	/**
	 * Configura los JLabels de texto en el panel.
	 * Se crean varios JLabels con texto, alineacion, fuente, color y posicion especificados.
	 * Estos JLabels representan etiquetas de texto para diferentes campos en el panel.
	 */
	private void jLabelTexto() {

		JLabel lbNombrePK = new JLabel("Nombre PK:");
		lbNombrePK.setHorizontalAlignment(SwingConstants.RIGHT);
		lbNombrePK.setFont(new Font("Showcard Gothic", Font.PLAIN, 23));
		lbNombrePK.setForeground(new Color(255, 255, 255));
		lbNombrePK.setToolTipText("");
		lbNombrePK.setBounds(164, 84, 159, 33);
		contentPane.add(lbNombrePK);

		JLabel lbTipo = new JLabel("Tipo:");
		lbTipo.setToolTipText("");
		lbTipo.setHorizontalAlignment(SwingConstants.RIGHT);
		lbTipo.setForeground(Color.WHITE);
		lbTipo.setFont(new Font("Showcard Gothic", Font.PLAIN, 23));
		lbTipo.setBounds(234, 123, 89, 33);
		contentPane.add(lbTipo);

		JLabel lbAnios = new JLabel("Anos:");
		lbAnios.setToolTipText("");
		lbAnios.setHorizontalAlignment(SwingConstants.RIGHT);
		lbAnios.setForeground(Color.WHITE);
		lbAnios.setFont(new Font("Showcard Gothic", Font.PLAIN, 23));
		lbAnios.setBounds(241, 166, 82, 33);
		contentPane.add(lbAnios);

		JLabel lblPeso = new JLabel("Peso:");
		lblPeso.setToolTipText("");
		lblPeso.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPeso.setForeground(Color.WHITE);
		lblPeso.setFont(new Font("Showcard Gothic", Font.PLAIN, 23));
		lblPeso.setBounds(241, 286, 82, 33);
		contentPane.add(lblPeso);

		JLabel lblEstatura = new JLabel("Estatura:");
		lblEstatura.setToolTipText("");
		lblEstatura.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEstatura.setForeground(Color.WHITE);
		lblEstatura.setFont(new Font("Showcard Gothic", Font.PLAIN, 23));
		lblEstatura.setBounds(184, 329, 138, 33);
		contentPane.add(lblEstatura);

		JLabel lblNomAtraccion = new JLabel("Nombre Atracción:");
		lblNomAtraccion.setToolTipText("");
		lblNomAtraccion.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNomAtraccion.setForeground(Color.WHITE);
		lblNomAtraccion.setFont(new Font("Showcard Gothic", Font.PLAIN, 23));
		lblNomAtraccion.setBounds(88, 442, 238, 33);
		contentPane.add(lblNomAtraccion);

		JLabel lblNombrePistas = new JLabel("Nombre Pista:");
		lblNombrePistas.setToolTipText("");
		lblNombrePistas.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombrePistas.setForeground(Color.WHITE);
		lblNombrePistas.setFont(new Font("Showcard Gothic", Font.PLAIN, 23));
		lblNombrePistas.setBounds(123, 485, 200, 33);
		contentPane.add(lblNombrePistas);
	}

	/**
	 * Metodo que limpia las cajas de texto.
	 */
	private void limpiar() {
		textFieldNombrePK.setText("");
		textFieldAnios.setText("");
		textFieldEstatura.setText("");
		textFieldPeso.setText("");
	}
}
