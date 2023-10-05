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
 * La clase ConsultaVisualizarArtista proporciona metodos para realizar
 * consultas y operaciones relacionadas con la entidad "Artista" en la base de
 * datos. Estos metodos incluyen la obtencion de los DNIs de los artistas y la
 * busqueda de un artista por su DNI en la base de datos.
 * 
 * @author Miguel Angel Perez Valverde
 * @version 1.0
 *
 */
public class ConsultaVisualizarArtista {

	private Connection c;
	private static Artista artista;

	/**
	 * El metodo "DNIArtistas" actualiza el contenido de un objeto JComboBox<String>
	 * con los DNIs de los artistas obtenidos de la base de datos.
	 * 
	 * @param comboBoxDNIArtista El objeto JComboBox<String> a actualizar.
	 * @throws SQLException Si se produce un error al acceder a la base de datos.
	 */
	public void DNIArtistas(JComboBox<String> comboBoxDNIArtista) throws SQLException {

		c = Conexion.conexion();

		try {
			String sql = "SELECT * FROM artistas";
			PreparedStatement statement = c.prepareStatement(sql);
			ResultSet res = statement.executeQuery();

			ArrayList<Artista> artistas = new ArrayList<Artista>();
			Set<String> dniArtistas = new HashSet<>();// evita los duplicados

			if (comboBoxDNIArtista != null) {
				while (res.next()) {
					String nifArtista = res.getString("nif");
					String apellidos = res.getString("apellidos");
					String nombre = res.getString("nombre");
					String nif_jefe = res.getString("nif_jefe");
					artista = new Artista(nifArtista, apellidos, nombre, nif_jefe);
					artistas.add(artista);
				}
			}

			for (Artista arti : artistas) {
				String dniArti = arti.getNif();
				if (dniArti != null && !dniArti.isEmpty()) {
					dniArtistas.add(dniArti);
				}
			}

			for (String nif : dniArtistas) {
				comboBoxDNIArtista.addItem(nif);
			}

			if (comboBoxDNIArtista.getItemCount() == 0) {
				System.out.println("No se encontraron tipos de animal.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// Cerrar la conexión
			if (c != null) {
				c.close();
			}
		}
	}

	/**
	 * El metodo "buscarNifArtista" busca y devuelve un objeto Artista de la base de
	 * datos que coincide con el DNI especificado.
	 * 
	 * @param nif El DNI del artista a buscar.
	 * @return El objeto Artista encontrado o un objeto Artista vacio si no se
	 *         encontro ninguna coincidencia.
	 * @throws SQLException Si se produce un error al acceder a la base de datos.
	 */
	public Artista buscarNifArtista(String nif) throws SQLException {

		c = Conexion.conexion();
		Artista artista = new Artista();

		try {

			String sql = "SELECT * FROM circo.artistas WHERE nif = ?";

			PreparedStatement sentencia = c.prepareStatement(sql);

			sentencia.setString(1, nif);

			ResultSet rs = sentencia.executeQuery();

			while (rs.next()) {

				artista.setNif(rs.getString("nif"));
				artista.setApellido(rs.getString("apellidos"));
				artista.setNombre(rs.getString("nombre"));
				artista.setNif_jefe(rs.getString("nif_jefe"));

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
		return artista;
	}
}
