package es.redmetro.dam2.vo;

import java.io.Serializable;

public class LineaEstacion implements Serializable{
	
	private Linea linea;
	private Estacion estacion;
	private int ordenM;
	
	public Linea getLinea() {
		return linea;
	}
	public void setLinea(Linea linea) {
		this.linea = linea;
	}
	public Estacion getEstacion() {
		return estacion;
	}
	public void setEstacion(Estacion estacion) {
		this.estacion = estacion;
	}
	public int getOrdenM() {
		return ordenM;
	}
	public void setOrdenM(int ordenM) {
		this.ordenM = ordenM;
	}
	public String toString() {
		return "LineaEstacion [linea=" + linea + ", estacion=" + estacion + ", ordenM=" + ordenM + "]";
	}
}
