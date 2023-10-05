package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * Esta clase proporciona una conexion a la base de datos del circo.
 * Utiliza la biblioteca JDBC para establecer una conexion con MySQL.
 * 
 * @author Miguel Angel Perez Valverde
 * @version 1.0
 *
 */
public class Conexion {
	/**
     * Establece una conexion a la base de datos MySQL.
     * 
     * @return La conexion establecida o null si ocurre algun error.
     */
	public static Connection conexion(){

		Connection connection = null;

		try {
			String url = "jdbc:mysql://localhost:3306/circo";
			String user = "root";
			String pass = "P4$$woRD";
			connection = DriverManager.getConnection(url, user, pass);

		} catch (SQLException u) {
			System.out.println("ERROR: " + u.getMessage());
		} catch (Exception u) {
			System.out.println("ERROR. " + u.getMessage());
		}
		return connection;
	}
}
