package vista;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingConstants;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Toolkit;
/**
 * clase que accede a todos los menus del panel.
 * 
 * @author Miguel Angel Perez Valverde
 * @version 1.0
 *
 */
public class VistaSecundaria extends JFrame{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenuItem insertAnimal;
	private VistaInsertarAnimal ia;
	private VistaInsertarArtista iar;
	private VistaVisualizarAnimal vistaVisualizarAnimal;
	private VistaVisualizarArtista vistaVisualizarArtista;
	/**
	 * Launch.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaSecundaria frame = new VistaSecundaria();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Ventana Secundaria.
	 */
	public VistaSecundaria() {
		
		imgPanel();
		menuInsertar();
		menuVisualizar();
		menuAyuda();
		botonSalir();
		imgLogo();
	}
	/**
	 * Configura la imagen del logo en el panel.
	 * Se crea un JLabel y se le asigna un ícono utilizando una imagen especifica.
	 * Luego se establecen las coordenadas y dimensiones del JLabel en el panel.
	 */
	private void imgLogo() {
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\bafli\\Desktop\\Programacion\\ProyectosJava3tTrimestre\\ProyectoCircoMiguelAngelPV\\src\\img\\Default_Prompt_detailsa_silhouette_design_of_a_lion_sunset_des_0.jpg"));
		lblNewLabel.setBounds(10, 0, 987, 656);
		contentPane.add(lblNewLabel);
	}
	/**
	 * Configura el boton de salir en el panel.
	 * Se crea un JButton y se le asigna un ActionListener que oculta la ventana actual y la cierra.
	 * Luego se establecen algunas propiedades del boton, como la alineacion vertical, la fuente y las coordenadas y dimensiones.
	 * Finalmente, se agrega el boton al contentPane del JFrame.
	 */
	private void botonSalir() {
		JButton botonSalir = new JButton("Salir");
		botonSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VistaSecundaria.this.setVisible(false);
				dispose();
			}
		});
		botonSalir.setVerticalAlignment(SwingConstants.TOP);
		botonSalir.setFont(new Font("Showcard Gothic", Font.PLAIN, 30));
		botonSalir.setBounds(418, 447, 133, 37);
		contentPane.add(botonSalir);
	}
	/**
	 * 
	 * Configura la imagen del panel y la barra de menu.
	 * Se establece el titulo de la ventana y se asigna un icono a la ventana.
	 * Ademas, se configuran la capacidad de redimensionamiento, la operacion de cierre y los limites del tamanio de la ventana.
	 * Tambien se crea una barra de menu.
	 * 
	 */
	private void imgPanel() {
		setTitle("Ventana Menú");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\bafli\\Desktop\\Programacion\\ProyectosJava3tTrimestre\\ProyectoCircoMiguelAngelPV\\src\\img\\lionDefinitivo.png"));
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1005, 715);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
	}
	/**
	 * Configura el menu de insercion en la barra de menu.
	 * Se crea un nuevo JMenu y se establecen algunas propiedades, como el texto, la alineacion, la fuente y el color.
	 * Luego se crea un JMenuItem para insertar animales y se le asigna un ActionListener que muestra la vista de insercion de animales (VistaInsertarAnimal) y cierra la ventana actual.
	 * Se realiza un proceso similar para el JMenuItem de insercion de artistas (VistaInsertarArtista).
	 * Finalmente, se agregan los JMenuItem al JMenu y se agrega el JMenu a la barra de menu (menuBar).
	 */
	private void menuInsertar() {
		JMenu menuInsertar = new JMenu("Insertar");
		menuInsertar.setHorizontalAlignment(SwingConstants.CENTER);
		menuInsertar.setFont(new Font("Showcard Gothic", Font.PLAIN, 20));
		menuInsertar.setForeground(new Color(0, 0, 0));
		menuBar.add(menuInsertar);
		
		insertAnimal = new JMenuItem("Animales");
		insertAnimal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ia = new VistaInsertarAnimal();
				ia.setVisible(true);
				dispose();
			}
		});
		insertAnimal.setFont(new Font("Showcard Gothic", Font.PLAIN, 15));
		menuInsertar.add(insertAnimal);
		
		JMenuItem insertArtista = new JMenuItem("Artista");
		insertArtista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iar = new VistaInsertarArtista();
				iar.setVisible(true);
				dispose();
			}
		});
		insertArtista.setFont(new Font("Showcard Gothic", Font.PLAIN, 15));
		menuInsertar.add(insertArtista);
	}
	/**
	 * Configura el menu de visualizacion en la barra de menu.
	 * Se crea un nuevo JMenu y se establecen algunas propiedades, como el texto, la alineacion, la fuente y el color.
	 * Luego se crea un JMenuItem para visualizar animales y se le asigna un ActionListener que muestra la vista de visualizacion de animales (VistaVisualizarAnimal) y cierra la ventana actual.
	 * Se realiza un proceso similar para el JMenuItem de visualizacion de artistas (VistaVisualizarArtista).
	 * A continuacion, se crea un nuevo JMenu para informacion y se establecen propiedades similares.
	 * Se crea un JTextArea que muestra informacion sobre el autor, la version y la fecha del programa.
	 * Finalmente, se agregan los JMenuItem al JMenu correspondiente y se agrega el JMenu a la barra de menu (menuBar).
	 */
	private void menuVisualizar() {
		JMenu menuVisualizar = new JMenu("Visualizar");
		menuVisualizar.setHorizontalAlignment(SwingConstants.CENTER);
		menuVisualizar.setForeground(Color.BLACK);
		menuVisualizar.setFont(new Font("Showcard Gothic", Font.PLAIN, 20));
		menuBar.add(menuVisualizar);
		
		JMenuItem visualizarAnimal = new JMenuItem("Animales");
		visualizarAnimal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vistaVisualizarAnimal = new VistaVisualizarAnimal();
				vistaVisualizarAnimal.setVisible(true);
				dispose();
			}
		});
		visualizarAnimal.setFont(new Font("Showcard Gothic", Font.PLAIN, 15));
		menuVisualizar.add(visualizarAnimal);
		
		JMenuItem visualizarArtista = new JMenuItem("Artista");
		visualizarArtista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vistaVisualizarArtista = new VistaVisualizarArtista();
				vistaVisualizarArtista.setVisible(true);
				dispose();
			}
		});
		visualizarArtista.setFont(new Font("Showcard Gothic", Font.PLAIN, 15));
		menuVisualizar.add(visualizarArtista);
		
		JMenu mnNewMenu = new JMenu("información");
		mnNewMenu.setForeground(new Color(0, 0, 0));
		mnNewMenu.setFont(new Font("Showcard Gothic", Font.PLAIN, 20));
		menuBar.add(mnNewMenu);
		
		JTextArea txtInfoo = new JTextArea();
		txtInfoo.setEditable(false);
		txtInfoo.setFont(new Font("Monospaced", Font.ITALIC, 15));
		txtInfoo.setText("Autor: Miguel Angel Perez Valverde.\r\nVersion 1.0 \tFecha: 27/05/2023\r\nInterfaz diseniada con Java para realizar insercciones y visualizaciones\r\nde datos de animales y artistas en la BBDD Circo.");
		mnNewMenu.add(txtInfoo);
	}
	/**
	 * se crea el menuAyuda.
	 */
	private void menuAyuda() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
}
