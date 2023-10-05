package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JComboBox;

import controlador.Conexion;

/**
 * La clase ConsultasAnimales proporciona metodos para realizar consultas y
 * operaciones relacionadas con la entidad "Animales" en la base de datos. Estos
 * metodos incluyen la insercion de animales, la obtencion de tipos de animales,
 * nombres de atracciones y nombres de pistas desde la base de datos.
 * 
 * @author Miguel Angel Perez Valverde
 * @version 1.0
 *
 */
public class ConsultasAnimales {
	private Connection c;

	/**
	 * Este metodo llamado "createAnimal", intenta insertar un objeto "Animales" en
	 * la base de datos. Devuelve un valor booleano indicando si el proceso de
	 * insercion fue exitoso o no.
	 * 
	 * @param a El objeto "Animales" a insertar en la base de datos.
	 * @return true si se inserto correctamente, false en caso contrario.
	 */
	public boolean createAnimal(Animales a) {
		boolean insertado = false;
		try {
			c = Conexion.conexion();

			String sql = "INSERT INTO animales VALUES (?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement ss = c.prepareStatement(sql);
			c.setAutoCommit(false);

			ss.setString(1, a.getNombre());
			ss.setString(2, a.getTipo());
			ss.setFloat(3, a.getAnios());
			ss.setFloat(4, a.getPeso());
			ss.setFloat(5, a.getEstatura());
			ss.setString(6, a.getNombre_atraccion());
			ss.setString(7, a.getNombre_pista());

			int filasAfectadas = ss.executeUpdate();

			if (filasAfectadas > 0) {
				insertado = true;
				c.commit();
			} else {
				c.rollback();
			}

			c.setAutoCommit(true);
			ss.close();

			System.out.println("Fin de la conexión...");
		} catch (SQLException e) {
			insertado = false;
			e.printStackTrace();
		} catch (Exception e) {
			insertado = false;
			e.printStackTrace();
		} finally {
			if (c != null) {
				try {
					c.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return insertado;
	}

	/**
	 * Este metodo llamado "tipoAnimal", actualiza el contenido de un objeto
	 * JComboBox<String> con los tipos de animales obtenidos de la base de datos.
	 * 
	 * @param tipoAnimal El objeto JComboBox<String> a actualizar.
	 * @throws SQLException Si se produce un error al acceder a la base de datos.
	 */
	public void tipoAnimal(JComboBox<String> tipoAnimal) throws SQLException {

		Connection c = Conexion.conexion();

		try {
			String sql = "SELECT * FROM animales";
			PreparedStatement statement = c.prepareStatement(sql);
			ResultSet res = statement.executeQuery();

			Set<String> tipos = new HashSet<>();// evita los duplicados

			if (tipoAnimal != null) {
				while (res.next()) {

					String tipo = res.getString("tipo");
					tipos.add(tipo);
				}
			}

			for (String tipo : tipos) {
				tipoAnimal.addItem(tipo);
			}

			if (tipoAnimal.getItemCount() == 0) {
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
	 * 
	 * Este metodo actualiza el contenido de un objeto JComboBox<String> con los
	 * nombres de las atracciones obtenidos de la base de datos.
	 * 
	 * @param nombreAtraccion El objeto JComboBox<String> a actualizar.
	 * @throws SQLException Si se produce un error al acceder a la base de datos.
	 */
	public void nombreAtracciones(JComboBox<String> nombreAtraccion) throws SQLException {
		Connection c = Conexion.conexion(); // nos conectamos

		try {
			String sql = "SELECT nombre FROM atracciones";
			PreparedStatement statement = c.prepareStatement(sql);
			ResultSet res = statement.executeQuery();

			Set<String> atraccion = new HashSet<>();// evita los duplicados

			while (res.next()) {
				String nombre = res.getString("nombre");
				atraccion.add(nombre);
			}
			for (String NombreAtraccion : atraccion) {
				nombreAtraccion.addItem(NombreAtraccion);
			}

			if (nombreAtraccion.getItemCount() == 0) {
				System.out.println("No se encontraron pistas.");
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
	 * Este metodo actualiza el contenido de un objeto JComboBox<String> con los
	 * nombres de las pistas obtenidos de la base de datos.
	 * 
	 * @param nombrePista JComboBox donde se agregaran los nombres de las pistas.
	 * @throws SQLException si ocurre un error al interactuar con la base de datos.
	 */
	public void nombrePista(JComboBox<String> nombrePista) throws SQLException {

		Connection c = Conexion.conexion();

		try {
			String sql = "SELECT nombre FROM pistas";
			PreparedStatement statement = c.prepareStatement(sql);
			ResultSet res = statement.executeQuery();

			Set<String> pistas = new HashSet<>();// evita los duplicados

			while (res.next()) {
				String nombre = res.getString("nombre");
				pistas.add(nombre);
			}
			for (String Nombretipo : pistas) {
				nombrePista.addItem(Nombretipo);
			}

			if (nombrePista.getItemCount() == 0) {
				System.out.println("No se encontraron pistas.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (c != null) {
				c.close();
			}
		}

	}
}
