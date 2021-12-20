package es.redmetro.dam2.vo;

public class Acceso {
	private int codigoAcceso;
	private String nombre;
	private boolean tieneAccesoDiscapacidad;
	private Estacion estacion;
	
	
	public int getCodigoAcceso() {
		return codigoAcceso;
	}
	public void setCodigoAcceso(int codigoAcceso) {
		this.codigoAcceso = codigoAcceso;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public boolean isTieneAccesoDiscapacidad() {
		return tieneAccesoDiscapacidad;
	}
	public void setTieneAccesoDiscapacidad(boolean tieneAccesoDiscapacidad) {
		this.tieneAccesoDiscapacidad = tieneAccesoDiscapacidad;
	}
	public Estacion getEstacion() {
		return estacion;
	}
	public void setEstacion(Estacion estacion) {
		this.estacion = estacion;
	}
}
