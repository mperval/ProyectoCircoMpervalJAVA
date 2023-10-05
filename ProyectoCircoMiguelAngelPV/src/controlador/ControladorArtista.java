package controlador;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import vista.VistaInsertarArtista;
import modelo.Artista;
import modelo.ConsultasArtistas;

/**
 * Esta clase actua como el controlador para la funcionalidad relacionada con
 * los artistas. Implementa la interfaz ActionListener para manejar los eventos
 * de accion.
 * 
 * @author Miguel Angel Perez Valverde
 * @version 1.0
 *
 */
public class ControladorArtista implements ActionListener {
	private ConsultasArtistas consulta;
	private static ConsultasArtistas consultas;
	private VistaInsertarArtista vistaInsertarArtista;
	private Artista artista;

	public ControladorArtista(ConsultasArtistas consulta, VistaInsertarArtista vistaInsertarArtista) {
		this.consulta = consulta;
		this.vistaInsertarArtista = vistaInsertarArtista;
	}

	/**
	 * crear un objeto "Artista" con los valores ingresados en los campos de texto
	 * de la vista, y asigna el valor seleccionado en el JComboBox<String>. Luego,
	 * llama al metodo "createArtista" de la instancia de "consulta"
	 * 
	 * @param e objeto ActionEvent que representa el evento de accion.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == vistaInsertarArtista.botonInsertar) {
			try {
				artista = new Artista();

				artista.setNif(vistaInsertarArtista.textFieldDNIArtista.getText());
				artista.setApellido(vistaInsertarArtista.textFieldApellidos.getText());
				artista.setNombre(vistaInsertarArtista.textFieldNombre.getText());
				artista.setNif_jefe(vistaInsertarArtista.comboBoxDNIJefe.getSelectedItem().toString());

				if (consulta.createArtista(artista)) {
					JOptionPane.showMessageDialog(null, "registro insertado");
				} else {
					JOptionPane.showMessageDialog(null, "El registro no ha sido insertado");
				}
			} catch (HeadlessException e1) {
				e1.printStackTrace();
			} catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(null, "El valor numérico no es válido", "Error",
						JOptionPane.ERROR_MESSAGE);
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "El valor no es válido", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	/**
	 * Esta funcion Java, llamada "comboBoxDniJefe", actualiza el contenido de un
	 * objeto JComboBox<String> con los DNIs de los jefes obtenidos a traves de la
	 * clase "ConsultasArtistas".
	 * 
	 * @param comboBoxDniJefe El objeto JComboBox<String> a actualizar.
	 * @return El objeto JComboBox<String> actualizado.
	 */
	public static JComboBox<String> comboBoxDniJefe(JComboBox<String> comboBoxDniJefe) {
		consultas = new ConsultasArtistas();
		try {
			consultas.tipoDniJefe(comboBoxDniJefe);
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e2) {
			e2.printStackTrace();
			JOptionPane.showMessageDialog(null, "Se ha producido un error al cargar los DNIs de los Artistas", "Error",
			JOptionPane.ERROR_MESSAGE);
			}
		return comboBoxDniJefe;
	}
}
