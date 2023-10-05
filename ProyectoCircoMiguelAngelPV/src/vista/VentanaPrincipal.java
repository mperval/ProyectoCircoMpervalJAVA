package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import java.awt.Toolkit;

/**
 * La clase VentanaPrincipal representa la ventana principal de la aplicacion.
 * Extiende la clase JFrame e implementa la interfaz ActionListener para manejar
 * eventos de botones.
 * 
 * @author Miguel Angel Perez Valverde
 * @version 1.0
 *
 */
public class VentanaPrincipal extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private VistaSecundaria vistaSecundaria;
	private JButton btn_entrar;

	/**
	 * Constructor de la ventana principal. Crea y configura la ventana principal.
	 */
	public VentanaPrincipal() {

		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"C:\\Users\\bafli\\Desktop\\Programacion\\ProyectosJava3tTrimestre\\ProyectoCircoMiguelAngelPV\\src\\img\\lionDefinitivo.png"));
		setResizable(false);
		setTitle("PROYECTO CIRCO MIGUEL ANGEL");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1031, 732);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTituloPrincipal = new JLabel("CIRCO MIGUEL ANGEL PV");
		lblTituloPrincipal.setVerticalAlignment(SwingConstants.BOTTOM);
		lblTituloPrincipal.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloPrincipal.setBounds(235, 172, 536, 66);
		lblTituloPrincipal.setFont(new Font("Showcard Gothic", Font.PLAIN, 45));
		lblTituloPrincipal.setForeground(new Color(255, 255, 255));
		contentPane.add(lblTituloPrincipal);

		btn_entrar = new JButton("ENTRAR");
		btn_entrar.setVerticalAlignment(SwingConstants.BOTTOM);
		btn_entrar.setForeground(new Color(0, 0, 0));
		btn_entrar.setFont(new Font("Showcard Gothic", Font.PLAIN, 40));
		btn_entrar.setBounds(414, 466, 213, 80);
		contentPane.add(btn_entrar);

		JLabel lblImagenFondo = new JLabel("New label");
		lblImagenFondo.setBounds(0, 0, 1026, 702);
		lblImagenFondo.setIcon(new ImageIcon(
				"C:\\Users\\bafli\\Desktop\\Programacion\\ProyectosJava3tTrimestre\\ProyectoCircoMiguelAngelPV\\src\\img\\Leonardo_Diffusion_circus_of_terror_black_background_high_qual_1.jpg"));
		contentPane.add(lblImagenFondo);

		vistaSecundaria = new VistaSecundaria();

		btn_entrar.addActionListener(this);
	}

	/**
	 * Implementacion del metodo actionPerformed de la interfaz ActionListener.
	 * Maneja el evento de clic en el boton "ENTRAR". Abre la ventana secundaria y
	 * cierra la ventana principal.
	 *
	 * @param e El evento de accion.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn_entrar) {
			vistaSecundaria.setVisible(true);
			dispose();
		}
	}
}
