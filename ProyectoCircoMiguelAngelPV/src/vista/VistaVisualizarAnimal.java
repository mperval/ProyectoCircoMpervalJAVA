package vista;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import controlador.ControladorVisualizarAnimal;
import modelo.ConsultaVisualizarAnimal;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

/**
 * Clase que representa la ventana de visualizacion de un animal en el sistema.
 * Permite visualizar los detalles de un animal seleccionado, como su tipo,
 * anos, peso, estatura, nombre de atraccion y nombre de pista asociados.
 * 
 * @author Miguel Angel Perez Valverde
 * @version 1.0
 *
 */
public class VistaVisualizarAnimal extends JFrame {

	private ConsultaVisualizarAnimal visuAnimal;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField textFieldTipo, textFieldAnios, textFieldPeso, textFieldEstatura, textFieldNombreAtraccion,
			textFieldNombrePista;
	public JButton botonVisualizar;
	public JComboBox<String> comboBoxNombrePK;
	private VistaSecundaria vistaSecundaria;

	/**
	 * Launch.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaVisualizarAnimal frame = new VistaVisualizarAnimal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * configura los componentes de la ventana.
	 */
	public VistaVisualizarAnimal() {
		setResizable(false);
		setTitle("Visualizar Animal");
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"C:\\Users\\bafli\\Desktop\\Programacion\\ProyectosJava3tTrimestre\\ProyectoCircoMiguelAngelPV\\src\\img\\lionDefinitivo.png"));

		panelPrincipal();
		camposDeTextos();
		jLabels();
		comboBoxPK();
		botonVisualizar();
		botonLimpiar();
		botonAtras();
		imgPanel();
	}

	/**
	 * Metodo privado que configura el panel que muestra una imagen de fondo.
	 */
	private void imgPanel() {
		JLabel imgTigre = new JLabel("");
		imgTigre.setIcon(new ImageIcon(
				"C:\\Users\\bafli\\Desktop\\Programacion\\ProyectosJava3tTrimestre\\ProyectoCircoMiguelAngelPV\\src\\img\\minitigre.jpg"));
		imgTigre.setBounds(0, 0, 1330, 597);
		contentPane.add(imgTigre);
	}

	/**
	 * Metodo privado que configura el boton "Atras". Crea una instancia de
	 * VistaSecundaria y la muestra cuando se hace clic en el boton. Luego, cierra
	 * la ventana actual.
	 */
	private void botonAtras() {
		vistaSecundaria = new VistaSecundaria();
		JButton botonAtras = new JButton("Atras");
		botonAtras.setVerticalAlignment(SwingConstants.BOTTOM);
		botonAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vistaSecundaria.setVisible(true);
				dispose();
			}
		});
		botonAtras.setFont(new Font("Showcard Gothic", Font.PLAIN, 17));
		botonAtras.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		botonAtras.setBounds(661, 416, 89, 27);
		contentPane.add(botonAtras);
	}

	/**
	 * Metodo privado que configura el boton "Limpiar". Borra los campos de texto
	 * cuando se hace clic en el boton.
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
		botonLimpiar.setBounds(661, 524, 89, 27);
		contentPane.add(botonLimpiar);
	}

	/**
	 * Crea y configura un boton "Visualizar" en el contenedor de contenido. Al
	 * hacer clic en el boton, se crea y ejecuta un ControladorVisualizarAnimal
	 * utilizando la instancia de la clase VistaVisualizarAnimal actual.
	 */
	private void botonVisualizar() {
		botonVisualizar = new JButton("Visualizar");
		botonVisualizar.setVerticalAlignment(SwingConstants.BOTTOM);
		botonVisualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ControladorVisualizarAnimal cva = new ControladorVisualizarAnimal(visuAnimal,
						VistaVisualizarAnimal.this);
				cva.actionPerformed(e);
			}
		});
		botonVisualizar.setFont(new Font("Showcard Gothic", Font.PLAIN, 20));
		botonVisualizar.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		botonVisualizar.setBounds(609, 470, 180, 33);
		contentPane.add(botonVisualizar);
	}

	/**
	 * Crea y configura un JComboBox<String> para mostrar las claves primarias en un
	 * formulario. Se establecen propiedades como la fuente y la posición del
	 * JComboBox. Se inicializa una instancia de ConsultaVisualizarAnimal y se llama
	 * al metodo ControladorVisualizarAnimal.comboBoxNombreAnimal() para poblar el
	 * JComboBox.
	 */
	private void comboBoxPK() {
		comboBoxNombrePK = new JComboBox<String>();
		comboBoxNombrePK.setFont(new Font("Showcard Gothic", Font.PLAIN, 17));
		comboBoxNombrePK.setBounds(271, 64, 217, 30);
		contentPane.add(comboBoxNombrePK);
		visuAnimal = new ConsultaVisualizarAnimal();
		ControladorVisualizarAnimal.comboBoxNombreAnimal(comboBoxNombrePK);
	}

	/**
	 * Crea y configura varias etiquetas (JLabels) en el contenedor de contenido. Se
	 * establecen propiedades como el texto, la alineacion, el color y la fuente de
	 * cada etiqueta. Cada etiqueta se coloca en una posicion especifica dentro del
	 * contenedor.
	 */
	private void jLabels() {
		JLabel lbTipo = new JLabel("Tipo:");
		lbTipo.setToolTipText("");
		lbTipo.setHorizontalAlignment(SwingConstants.RIGHT);
		lbTipo.setForeground(Color.WHITE);
		lbTipo.setFont(new Font("Showcard Gothic", Font.PLAIN, 23));
		lbTipo.setBounds(171, 159, 89, 33);
		contentPane.add(lbTipo);

		JLabel lbAnios = new JLabel("Años:");
		lbAnios.setToolTipText("");
		lbAnios.setHorizontalAlignment(SwingConstants.RIGHT);
		lbAnios.setForeground(Color.WHITE);
		lbAnios.setFont(new Font("Showcard Gothic", Font.PLAIN, 23));
		lbAnios.setBounds(179, 211, 82, 33);
		contentPane.add(lbAnios);

		JLabel lblEstatura = new JLabel("Estatura:");
		lblEstatura.setToolTipText("");
		lblEstatura.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEstatura.setForeground(Color.WHITE);
		lblEstatura.setFont(new Font("Showcard Gothic", Font.PLAIN, 23));
		lblEstatura.setBounds(128, 345, 138, 33);
		contentPane.add(lblEstatura);

		JLabel lblPeso = new JLabel("Peso:");
		lblPeso.setToolTipText("");
		lblPeso.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPeso.setForeground(Color.WHITE);
		lblPeso.setFont(new Font("Showcard Gothic", Font.PLAIN, 23));
		lblPeso.setBounds(181, 294, 82, 33);
		contentPane.add(lblPeso);

		JLabel lblNombrePistas = new JLabel("Nombre Pista:");
		lblNombrePistas.setToolTipText("");
		lblNombrePistas.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombrePistas.setForeground(Color.WHITE);
		lblNombrePistas.setFont(new Font("Showcard Gothic", Font.PLAIN, 23));
		lblNombrePistas.setBounds(71, 467, 200, 33);
		contentPane.add(lblNombrePistas);

		JLabel lblNomAtraccion = new JLabel("Nombre Atracción:");
		lblNomAtraccion.setToolTipText("");
		lblNomAtraccion.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNomAtraccion.setForeground(Color.WHITE);
		lblNomAtraccion.setFont(new Font("Showcard Gothic", Font.PLAIN, 23));
		lblNomAtraccion.setBounds(32, 416, 238, 33);
		contentPane.add(lblNomAtraccion);

		JLabel lbNombrePK = new JLabel("Nombre PK:");
		lbNombrePK.setToolTipText("");
		lbNombrePK.setHorizontalAlignment(SwingConstants.RIGHT);
		lbNombrePK.setForeground(Color.WHITE);
		lbNombrePK.setFont(new Font("Showcard Gothic", Font.PLAIN, 23));
		lbNombrePK.setBounds(94, 65, 159, 33);
		contentPane.add(lbNombrePK);
	}

	/**
	 * Crea y configura varios campos de texto (JTextFields) en el contenedor de
	 * contenido. Se establecen propiedades como la capacidad de edicion, el tamaño
	 * y la posición de cada campo de texto.
	 */
	private void camposDeTextos() {
		textFieldTipo = new JTextField();
		textFieldTipo.setFont(new Font("Showcard Gothic", Font.PLAIN, 15));
		textFieldTipo.setEditable(false);
		textFieldTipo.setColumns(10);
		textFieldTipo.setBounds(273, 157, 217, 30);
		contentPane.add(textFieldTipo);

		textFieldAnios = new JTextField();
		textFieldAnios.setFont(new Font("Showcard Gothic", Font.PLAIN, 15));
		textFieldAnios.setEditable(false);
		textFieldAnios.setColumns(10);
		textFieldAnios.setBounds(274, 208, 217, 30);
		contentPane.add(textFieldAnios);

		textFieldPeso = new JTextField();
		textFieldPeso.setFont(new Font("Showcard Gothic", Font.PLAIN, 15));
		textFieldPeso.setEditable(false);
		textFieldPeso.setColumns(10);
		textFieldPeso.setBounds(274, 294, 217, 30);
		contentPane.add(textFieldPeso);

		textFieldEstatura = new JTextField();
		textFieldEstatura.setFont(new Font("Showcard Gothic", Font.PLAIN, 15));
		textFieldEstatura.setEditable(false);
		textFieldEstatura.setColumns(10);
		textFieldEstatura.setBounds(275, 345, 217, 30);
		contentPane.add(textFieldEstatura);

		textFieldNombreAtraccion = new JTextField();
		textFieldNombreAtraccion.setFont(new Font("Showcard Gothic", Font.PLAIN, 15));
		textFieldNombreAtraccion.setEditable(false);
		textFieldNombreAtraccion.setColumns(10);
		textFieldNombreAtraccion.setBounds(277, 414, 217, 30);
		contentPane.add(textFieldNombreAtraccion);

		textFieldNombrePista = new JTextField();
		textFieldNombrePista.setFont(new Font("Showcard Gothic", Font.PLAIN, 15));
		textFieldNombrePista.setEditable(false);
		textFieldNombrePista.setColumns(10);
		textFieldNombrePista.setBounds(276, 466, 217, 30);
		contentPane.add(textFieldNombrePista);
	}

	/**
	 * Configura el panel principal de la ventana. Se establece la operacion de
	 * cierre al hacer clic en el boton de cierre de la ventana. Se establecen las
	 * dimensiones y posicion de la ventana. Se crea un JPanel como contenedor de
	 * contenido y se establecen propiedades como el color de fondo y el borde. Se
	 * establece el panel de contenido como el panel principal de la ventana.
	 */
	private void panelPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1344, 626);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(31, 48, 69));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
	}

	/**
	 * Metodo privado que limpia los campos de texto.
	 */
	private void limpiar() {
		textFieldTipo.setText("");
		textFieldAnios.setText("");
		textFieldPeso.setText("");
		textFieldEstatura.setText("");
		textFieldNombreAtraccion.setText("");
		textFieldNombrePista.setText("");
	}
}
