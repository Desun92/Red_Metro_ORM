package es.redmetro.dam2.vo;

import java.util.List;

public class Linea {

	private int codigoLinea;
	private String nombreCorto;
	private String nombreLargo;
	private Color color;
	private float kilometros;
	private List<Estacion> codigoEstaciones;
	
	public List<Estacion> getCodigoEstaciones() {
		return codigoEstaciones;
	}
	public void setCodigoEstaciones(List<Estacion> codigoEstaciones) {
		this.codigoEstaciones = codigoEstaciones;
	}
	public int getCodigoLinea() {
		return codigoLinea;
	}
	public void setCodigoLinea(int codigoLinea) {
		this.codigoLinea = codigoLinea;
	}
	public String getNombreCorto() {
		return nombreCorto;
	}
	public void setNombreCorto(String nombreCorto) {
		this.nombreCorto = nombreCorto;
	}
	public String getNombreLargo() {
		return nombreLargo;
	}
	public void setNombreLargo(String nombreLargo) {
		this.nombreLargo = nombreLargo;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public float getKilometros() {
		return kilometros;
	}
	public void setKilometros(float kilometros) {
		this.kilometros = kilometros;
	}
	@Override
	public String toString() {
		return "Linea [codigoLinea=" + codigoLinea + ", nombreCorto=" + nombreCorto + ", nombreLargo=" + nombreLargo
				+ ", color=" + color + ", kilometros=" + kilometros + "]";
	}
	
}
