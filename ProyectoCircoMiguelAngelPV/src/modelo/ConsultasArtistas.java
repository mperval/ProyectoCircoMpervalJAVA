package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JComboBox;

import controlador.Conexion;

/**
 * La clase ConsultasArtistas proporciona metodos para realizar consultas y
 * operaciones relacionadas con la entidad "Artista" en la base de datos. Estos
 * metodos incluyen la insercion de artistas y la obtencion de los tipos de DNI
 * de los jefes desde la base de datos.
 * 
 * @author Miguel Angel Perez Valverde
 * @version 1.0
 *
 */
public class ConsultasArtistas {
	private Connection c;
	private static Artista artista;

	/**
	 * Este metodo llamado "createArtista", inserta un objeto Artista en la base de
	 * datos.
	 * 
	 * @param a El objeto Artista a insertar.
	 * @return true si el artista se insertó correctamente, false en caso contrario.
	 */
	public boolean createArtista(Artista a) {
		boolean insertado = false;
		try {
			c = Conexion.conexion();

			String sql = "INSERT INTO artistas VALUES (?, ?, ?, ?)";
			PreparedStatement ss = c.prepareStatement(sql);
			c.setAutoCommit(false);

			ss.setString(1, a.getNif());
			ss.setString(2, a.getApellido());
			ss.setString(3, a.getNombre());
			ss.setString(4, a.getNif_jefe());

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
			e.getMessage();
		} catch (Exception e) {
			insertado = false;
			e.getMessage();
		} finally {
			if (c != null) {
				try {
					c.close();
				} catch (SQLException e) {
					e.getMessage();
				}
			}
		}
		return insertado;
	}

	/**
	 * Este metodo llamado "tipoDniJefe", actualiza el contenido de un objeto
	 * JComboBox<String> con los tipos de DNI de los jefes obtenidos de la base de
	 * datos.
	 * 
	 * @param dniJefe El objeto JComboBox<String> a actualizar.
	 * @throws SQLException Si se produce un error al acceder a la base de datos.
	 */
	public void tipoDniJefe(JComboBox<String> dniJefe) throws SQLException {

		Connection c = Conexion.conexion();

		try {
			String sql = "SELECT * FROM artistas";
			PreparedStatement statement = c.prepareStatement(sql);
			ResultSet res = statement.executeQuery();

			ArrayList<Artista> artistas = new ArrayList<Artista>();
			Set<String> dni = new HashSet<>();// evita los duplicados

			if (dniJefe != null) {
				while (res.next()) {
					String nif = res.getString("nif");
					String apellidos = res.getString("apellidos");
					String nombre = res.getString("nombre");
					String nif_jefe = res.getString("nif_jefe");

					artista = new Artista(nif, apellidos, nombre, nif_jefe);
					artistas.add(artista);
				}
			}

			for (Artista artis : artistas) {
				String nifJefe = artis.getNif_jefe();
				if (nifJefe != null && !nifJefe.isEmpty()) {
					dni.add(nifJefe);
				}
			}

			for (String nifJefes : dni) {
				dniJefe.addItem(nifJefes);
			}

			if (dniJefe.getItemCount() == 0) {
				System.out.println("No se encontraron tipos de animal.");
			}
		} catch (SQLException e) {
			e.getMessage();
		} finally {
			if (c != null) {
				c.close();
			}
		}

	}
}
