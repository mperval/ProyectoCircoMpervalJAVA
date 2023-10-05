package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import modelo.Animales;
import modelo.ConsultaVisualizarAnimal;
import vista.VistaVisualizarAnimal;

/**
 * Esta clase actua como el controlador para la funcionalidad de visualizacion
 * de animales. Implementa la interfaz ActionListener para manejar los eventos
 * de accion.
 * 
 * @author Miguel Angel Perez Valverde
 * @version 1.0
 *
 */
public class ControladorVisualizarAnimal implements ActionListener {

	private ConsultaVisualizarAnimal consulta;
	private static ConsultaVisualizarAnimal consultas;
	private VistaVisualizarAnimal vistaVisualizarAnimal;
	private Animales animal;

	public ControladorVisualizarAnimal(ConsultaVisualizarAnimal consulta, VistaVisualizarAnimal vistaVisualizarAnimal) {
		this.consulta = consulta;
		this.vistaVisualizarAnimal = vistaVisualizarAnimal;
	}

	/**
	 * buscar un animal utilizando el valor seleccionado en el JComboBox
	 * "comboBoxNombrePK" de la vista, a traves de la instancia de la clase
	 * "consulta". Luego, se llama al metodo "MostrarAnimal" para mostrar los datos
	 * del animal obtenido.
	 * 
	 * @param e El objeto ActionEvent que representa el evento de accion.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == vistaVisualizarAnimal.botonVisualizar) {
			try {
				animal = consulta.buscarAnimal((String) vistaVisualizarAnimal.comboBoxNombrePK.getSelectedItem());
				MostrarAnimal(animal);
			} catch (SQLException e1) {
				e1.printStackTrace();
			} catch (NullPointerException e2) {
				e2.printStackTrace();
				JOptionPane.showMessageDialog(null, "No se ha seleccionado ningún animal para visualizar", "Error",
						JOptionPane.ERROR_MESSAGE);
			} catch (Exception e3) {
				e3.printStackTrace();
				JOptionPane.showMessageDialog(null, "Se ha producido un error al visualizar el animal", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	/**
	 * Esta funcion Java, llamada "MostrarAnimal", se encarga de actualizar los
	 * campos de texto de una vista con los datos de un objeto de la clase
	 * "Animales".
	 * 
	 * @param animal El objeto de la clase "Animales" del cual se obtienen los
	 *               datos.
	 */
	private void MostrarAnimal(Animales animal) {
		vistaVisualizarAnimal.textFieldTipo.setText(animal.getTipo());
		vistaVisualizarAnimal.textFieldAnios.setText(String.valueOf(animal.getAnios()));
		vistaVisualizarAnimal.textFieldPeso.setText(String.valueOf(animal.getPeso()));
		vistaVisualizarAnimal.textFieldEstatura.setText(String.valueOf(animal.getEstatura()));
		vistaVisualizarAnimal.textFieldNombreAtraccion.setText(animal.getNombre_atraccion());
		vistaVisualizarAnimal.textFieldNombrePista.setText(animal.getNombre_pista());

	}

	/**
	 * Esta funcion Java, llamada "comboBoxNombreAnimal", actualiza el contenido de
	 * un objeto JComboBox<String> con los nombres de los animales obtenidos a
	 * traves de la clase "ConsultaVisualizarAnimal".
	 * 
	 * @param comboBoxNombreAnimal El objeto JComboBox<String> a actualizar.
	 * @return El objeto JComboBox<String> actualizado.
	 */
	public static JComboBox<String> comboBoxNombreAnimal(JComboBox<String> comboBoxNombreAnimal) {
		consultas = new ConsultaVisualizarAnimal();
		try {
			consultas.NombreAnimal(comboBoxNombreAnimal);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e2) {
			e2.printStackTrace();
			JOptionPane.showMessageDialog(null, "Se ha producido un error al cargar los nombres de los animales",
					"Error", JOptionPane.ERROR_MESSAGE);
		}
		return comboBoxNombreAnimal;
	}
}
