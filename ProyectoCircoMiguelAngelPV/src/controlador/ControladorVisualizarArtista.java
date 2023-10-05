package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import modelo.Artista;
import modelo.ConsultaVisualizarArtista;
import vista.VistaVisualizarArtista;

/**
 * Esta clase actua como el controlador para la funcionalidad de visualizacion
 * de artistas. Implementa la interfaz ActionListener para manejar los eventos
 * de accion.
 * 
 * @author Miguel Angel Perez Valverde
 * @version 1.0
 *
 */
public class ControladorVisualizarArtista implements ActionListener {

	private ConsultaVisualizarArtista consulta;
	private static ConsultaVisualizarArtista consultas;
	private VistaVisualizarArtista vistaVisualizarArtista;
	private Artista artista;

	public ControladorVisualizarArtista(ConsultaVisualizarArtista consulta,
			VistaVisualizarArtista vistaVisualizarArtista) {
		this.consulta = consulta;
		this.vistaVisualizarArtista = vistaVisualizarArtista;
	}

	/**
	 * Este metodo se ejecuta cuando se produce un evento de accion, clic en el
	 * boton de visualizacion. Verifica si la fuente del evento es el boton de
	 * visualizacion en la interfaz y realiza las acciones correspondientes. Si es
	 * asi, busca un artista utilizando el valor seleccionado en el comboBox<String>
	 * de DNI de artista de la vista y muestra los detalles del artista en la vista.
	 * 
	 * @param e El objeto ActionEvent que representa el evento de accion.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == vistaVisualizarArtista.botonVisualizar) {
			try {
				artista = consulta
						.buscarNifArtista((String) vistaVisualizarArtista.comboBoxDNIArtista.getSelectedItem());
				mostrarArtistas(artista);
			} catch (SQLException e1) {
				e1.printStackTrace();
			} catch (Exception e2) {
				e2.printStackTrace();
				JOptionPane.showMessageDialog(null, "Se ha producido un error al buscar el artista por su NIF", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	/**
	 * Actualiza los campos de texto en la vista con los detalles del artista.
	 * 
	 * @param artista El objeto Artista del cual se obtienen los detalles.
	 */
	private void mostrarArtistas(Artista artista) {
		vistaVisualizarArtista.textFieldApellidos.setText(artista.getApellido());
		vistaVisualizarArtista.textFieldNombre.setText(artista.getNombre());
		vistaVisualizarArtista.textFieldDNIJefe.setText(artista.getNif_jefe());
	}

	/**
	 * Actualiza el contenido de un combo box con los DNIs de los artistas obtenidos
	 * a traves de la clase ConsultaVisualizarArtista.
	 * 
	 * @param comboBoxNIFArtista El objeto JComboBox<String> a actualizar.
	 * @return El objeto JComboBox<String> actualizado.
	 */
	public static JComboBox<String> comboBoxNIFArtista(JComboBox<String> comboBoxNIFArtista) {
		consultas = new ConsultaVisualizarArtista();
		try {
			consultas.DNIArtistas(comboBoxNIFArtista);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e2) {
			e2.printStackTrace();
			JOptionPane.showMessageDialog(null, "Se ha producido un error al cargar los NIFs de los artistas", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
		return comboBoxNIFArtista;
	}

}
