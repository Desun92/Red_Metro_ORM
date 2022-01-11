package es.redmetro.dam2.vo;

public class Estacion {
	
	private int codigoEstacion;
	private String nombre;
	private String direccion;
	
	public int getCodigoEstacion() {
		return codigoEstacion;
	}
	public void setCodigoEstacion(int codigoEstacion) {
		this.codigoEstacion = codigoEstacion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	@Override
	public String toString() {
		return "Estacion [codigoEstacion=" + codigoEstacion + ", nombre=" + nombre + ", direccion=" + direccion + "]";
	}
	
}
