package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLTimeoutException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JComboBox;

import controlador.Conexion;

/**
 * La clase ConsultaVisualizarAnimal proporciona metodos para realizar consultas
 * y operaciones relacionadas con la entidad "Animales" en la base de datos.
 * Estos metodos incluyen la obtencion de los nombres de los animales y la
 * busqueda de un animal por su nombre en la base de datos.
 * 
 * @author Miguel Angel Perez Valverde
 * @version 1.0
 *
 */
public class ConsultaVisualizarAnimal {

	private Connection c;
	private static Animales animal;

	/**
	 * Este metodo llamado "NombreAnimal", actualiza el contenido de un objeto
	 * JComboBox<String> con los nombres de animales obtenidos de la base de datos.
	 * 
	 * @param nombreAnimal El objeto JComboBox<String> a actualizar.
	 * @throws SQLException Si se produce un error al acceder a la base de datos.
	 */
	public void NombreAnimal(JComboBox<String> nombreAnimal) throws SQLException {

		c = Conexion.conexion();

		try {
			String sql = "SELECT * FROM animales";
			PreparedStatement statement = c.prepareStatement(sql);
			ResultSet res = statement.executeQuery();

			ArrayList<Animales> animales = new ArrayList<Animales>();
			Set<String> nomAnimales = new HashSet<>();// evita los duplicados

			if (nombreAnimal != null) {
				while (res.next()) {
					String nomb = res.getString("nombre");
					String tipo = res.getString("tipo");
					int anyos = res.getInt("anhos");
					float peso = res.getFloat("peso");
					float estatura = res.getFloat("estatura");
					String nombreAtr = res.getString("nombre_atraccion");
					String nombrePi = res.getString("nombre_pista");
					animal = new Animales(nomb, tipo, anyos, peso, estatura, nombreAtr, nombrePi);
					animales.add(animal);
				}
			}

			for (Animales NomAnim : animales) {
				String nomAnimal = NomAnim.getNombre();
				if (nomAnimal != null && !nomAnimal.isEmpty()) {
					nomAnimales.add(nomAnimal);
				}
			}

			for (String nom : nomAnimales) {
				nombreAnimal.addItem(nom);
			}

			if (nombreAnimal.getItemCount() == 0) {
				System.out.println("No se encontraron tipos de animal.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (c != null) {
				c.close();
			}
		}
	}

	/**
	 * Este metodo llamado "buscarAnimal", busca y devuelve un objeto Animales de la
	 * base de datos que coincide con el nombre especificado.
	 * 
	 * @param nombre El nombre del animal a buscar.
	 * @return El objeto Animales encontrado o un objeto Animales vacio si no se
	 *         encontro ninguna coincidencia.
	 * @throws SQLException Si se produce un error al acceder a la base de datos.
	 */
	public Animales buscarAnimal(String nombre) throws SQLException {

		c = Conexion.conexion();
		Animales animal = new Animales();

		try {

			String sql = "SELECT * FROM circo.animales WHERE nombre = ?";

			PreparedStatement sentencia = c.prepareStatement(sql);

			sentencia.setString(1, nombre);

			ResultSet rs = sentencia.executeQuery();

			while (rs.next()) {

				animal.setAnios(rs.getInt("anhos"));
				animal.setTipo(rs.getString("tipo"));
				animal.setPeso(rs.getFloat("peso"));
				animal.setEstatura(rs.getFloat("estatura"));
				animal.setNombre_atraccion(rs.getString("nombre_atraccion"));
				animal.setNombre_pista(rs.getString("nombre_pista"));

			}

			rs.close();

		} catch (SQLTimeoutException sqte) {
			System.out.println(sqte.getMessage());

		} catch (SQLException sqe) {
			System.out.println(sqe.getMessage());
			c.rollback();
		} finally {

			c.close();
		}
		return animal;
	}
}
