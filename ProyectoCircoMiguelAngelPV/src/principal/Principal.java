package principal;

import vista.VentanaPrincipal;

/**
 * Esta clase sirve como punto de entrada principal del programa. Crea una
 * instancia de la clase {@link vista.VentanaPrincipal} y la muestra en
 * pantalla. La clase {@link vista.VentanaPrincipal} representa la ventana
 * principal de la aplicación. Al establecer su visibilidad en verdadero, la
 * ventana se hace visible para el usuario.
 * 
 * @author Miguel Angel Perez Valverde
 * @version 1.0
 *
 */
public class Principal {
	/**
     * Punto de entrada principal del programa.
     * 
     * @param
     */
	public static void main(String[] args) {

		VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();

		ventanaPrincipal.setVisible(true);

	}

}
