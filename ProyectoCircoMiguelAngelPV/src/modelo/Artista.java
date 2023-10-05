package modelo;

/**
 * La clase Artista representa a los artistas en el sistema.
 * 
 * @author Miguel Angel Perez Valverde
 * @version 1.0
 *
 */
public class Artista {

	private String nif;
	private String apellido;
	private String nombre;
	private String nif_jefe;

	public Artista(String nif, String apellido, String nombre, String nif_jefe) {
		this.nif = nif;
		this.apellido = apellido;
		this.nombre = nombre;
		this.nif_jefe = nif_jefe;
	}

	public Artista() {

	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNif_jefe() {
		return nif_jefe;
	}

	public void setNif_jefe(String nif_jefe) {
		this.nif_jefe = nif_jefe;
	}

	@Override
	public String toString() {
		return "Artista [nif=" + nif + ", apellido=" + apellido + ", nombre=" + nombre + ", nif_jefe=" + nif_jefe + "]";
	}

}
