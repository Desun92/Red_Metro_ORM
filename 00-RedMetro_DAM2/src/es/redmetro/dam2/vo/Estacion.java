package es.redmetro.dam2.vo;

import java.util.List;

public class Estacion {
	
	private int codigoEstacion;
	private String nombre;
	private String direccion;
	private List<LineaEstacion> lineaEstacion;
	private Integer orden;
	
	public int getOrden() {
		return orden;
	}
	public void setOrden(int orden) {
		this.orden = orden;
	}
	public List<LineaEstacion> getLineaEstacion() {
		return lineaEstacion;
	}
	public void setLineaEstacion(List<LineaEstacion> lineaEstacion) {
		this.lineaEstacion = lineaEstacion;
	}
	public void setOrden(Integer orden) {
		this.orden = orden;
	}
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
