package controlador;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import modelo.Animales;
import modelo.ConsultasAnimales;
import vista.VistaInsertarAnimal;

/**
 * Esta clase actua como el controlador para la funcionalidad relacionada con
 * los animales. Implementa la interfaz ActionListener para manejar los eventos
 * de accion.
 * 
 * @author Miguel Angel Perez Valverde
 * @version 1.0
 *
 */
public class ControladorAnimal implements ActionListener {

	private ConsultasAnimales consulta;
	private static ConsultasAnimales consultas;// para utilizarlos en los metodos de los comboBox.
	private VistaInsertarAnimal VistaInsertarAnimal;
	private Animales animal;

	public ControladorAnimal(ConsultasAnimales consulta, VistaInsertarAnimal VistaInsertarAnimal) {
		this.consulta = consulta;
		this.VistaInsertarAnimal = VistaInsertarAnimal;
	}

	/**
	 * Este método se encarga de insertar un nuevo registro de animal en la base de
	 * datos cuando se presiona el botón de inserción en la interfaz de la vista
	 * "VistaInsertarAnimal".
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == VistaInsertarAnimal.botonInsertar) {
			try {
				animal = new Animales();

				animal.setNombre(VistaInsertarAnimal.textFieldNombrePK.getText());

				animal.setTipo(VistaInsertarAnimal.comboBoxTipo.getSelectedItem().toString());

				String aniosString = VistaInsertarAnimal.textFieldAnios.getText();
				aniosString = aniosString.replace(",", ".");
				animal.setAnios(Float.parseFloat(aniosString));

				String pesoString = VistaInsertarAnimal.textFieldPeso.getText();
				pesoString = pesoString.replace(",", ".");
				animal.setPeso(Float.parseFloat(pesoString));

				String estaturaString = VistaInsertarAnimal.textFieldEstatura.getText();
				estaturaString = estaturaString.replace(",", ".");
				animal.setEstatura(Float.parseFloat(estaturaString));

				animal.setNombre_atraccion(VistaInsertarAnimal.comboBoxNombreAtraccion.getSelectedItem().toString());

				animal.setNombre_pista(VistaInsertarAnimal.comboBoxNombrePistas.getSelectedItem().toString());

				if (consulta.createAnimal(animal)) {
					JOptionPane.showMessageDialog(null, "registro insertado");
				} else {
					JOptionPane.showMessageDialog(null, "El registro no ha sido insertado");
				}
			} catch (HeadlessException e1) {
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null,
						"operación gráfica no se puede realizar debido a la falta de un entorno gráfico disponible.",
						"Error", JOptionPane.ERROR_MESSAGE);
			} catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(null, "Estas metiendo un caracter en un valor numérico", "Error",
						JOptionPane.ERROR_MESSAGE);
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "El valor no es válido", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	/**
	 * Esta funcion realiza una consulta a traves de la instancia de la clase
	 * "ConsultasAnimales" para obtener los tipos de animales. Luego, carga dichos
	 * tipos en el objeto JComboBox de tipo String llamado "comboBoxTipo".
	 * 
	 * @param comboBoxTipo: Objeto JComboBox<String> donde se cargaran los tipos de
	 *                      animales obtenidos.
	 * @return El objeto JComboBox<String> "comboBoxTipo" actualizado con los tipos
	 *         de animales cargados.
	 */
	public static JComboBox<String> comboBoxTipoAnimal(JComboBox<String> comboBoxTipo) {
		consultas = new ConsultasAnimales();
		try {
			consultas.tipoAnimal(comboBoxTipo);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e2) {
			e2.printStackTrace();
			JOptionPane.showMessageDialog(null, "Se ha producido un error al cargar el tipo de los animales", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
		return comboBoxTipo;
	}

	/**
	 * Esta funcion realiza una consulta a traves de la instancia de la clase
	 * "ConsultasAnimales" para obtener los nombres de las atracciones. Luego, carga
	 * dichos tipos en el objeto JComboBox<String> llamado
	 * "comboBoxNombreAtraccion".
	 * 
	 * @param comboBoxNombreAtraccion: Objeto JComboBox<String> donde se cargaran
	 *                                 los nombres de las atracciones obtenidas.
	 * @return El objeto JComboBox<String> "comboBoxNombreAtraccion" actualizado con
	 *         los nombres de las atracciones cargados.
	 */
	public static JComboBox<String> comboBoxNombreAtraccion(JComboBox<String> comboBoxNombreAtraccion) {
		consultas = new ConsultasAnimales();
		try {
			consultas.nombreAtracciones(comboBoxNombreAtraccion);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e2) {
			e2.printStackTrace();
			JOptionPane.showMessageDialog(null, "Se ha producido un error al cargar los nombres de las atracciones",
					"Error", JOptionPane.ERROR_MESSAGE);
		}
		return comboBoxNombreAtraccion;
	}

	/**
	 * Esta funcion realiza una consulta a traves de la instancia de la clase
	 * "ConsultasAnimales" para obtener los nombres de las pistas. Luego, carga
	 * dichas pistas en el objeto JComboBox<String> llamado "comboBoxNombrePistas".
	 * 
	 * @param comboBoxNombrePistas: Objeto JComboBox de tipo String donde se
	 *                              cargaran los nombres de las pistas obtenidas.
	 * @return El objeto JComboBox<String> "comboBoxNombrePistas" actualizado con
	 *         los nombres de las atracciones cargados.
	 */
	public static JComboBox<String> comboBoxNombrePistas(JComboBox<String> comboBoxNombrePistas) {
		consultas = new ConsultasAnimales();
		try {
			consultas.nombrePista(comboBoxNombrePistas);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e2) {
			e2.printStackTrace();
			JOptionPane.showMessageDialog(null, "Se ha producido un error al cargar los nombres de las pistas", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
		return comboBoxNombrePistas;
	}

}
