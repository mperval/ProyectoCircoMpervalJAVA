package modelo;
/**
 * La clase Animales representa a los animales en el sistema.
 * 
 * @author Miguel Angel Perez Valverde
 * @version 1.0
 *
 */
public class Animales {

	private String nombre;
	private String tipo;
	private float anios;
	private float peso;
	private float estatura;
	private String nombre_atraccion;
	private String nombre_pista;

	public Animales(String nombre, String tipo, float anios, float peso, float estatura, String nombre_atraccion,
			String nombre_pista) {
		this.nombre = nombre;
		this.tipo = tipo;
		this.anios = anios;
		this.peso = peso;
		this.estatura = estatura;
		this.nombre_atraccion = nombre_atraccion;
		this.nombre_pista = nombre_pista;

	}

	public Animales() {

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public float getAnios() {
		return anios;
	}

	public void setAnios(float anios) {
		this.anios = anios;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public float getEstatura() {
		return estatura;
	}

	public void setEstatura(float estatura) {
		this.estatura = estatura;
	}

	public String getNombre_atraccion() {
		return nombre_atraccion;
	}

	public void setNombre_atraccion(String nombre_atraccion) {
		this.nombre_atraccion = nombre_atraccion;
	}

	public String getNombre_pista() {
		return nombre_pista;
	}

	public void setNombre_pista(String nombre_pista) {
		this.nombre_pista = nombre_pista;
	}

	@Override
	public String toString() {
		return "Animales [nombre=" + nombre + ", tipo=" + tipo + ", anios=" + anios + ", peso=" + peso + ", estatura="
				+ estatura + ", nombre_atraccion=" + nombre_atraccion + ", nombre_pista=" + nombre_pista + "]";
	}

}
