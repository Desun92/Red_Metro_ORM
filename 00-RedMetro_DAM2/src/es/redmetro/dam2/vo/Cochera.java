package es.redmetro.dam2.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="T_COCHERA")
public class Cochera {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cod_cochera")
	private int codigoCochera;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="direccion")
	private String direccion;
	
	@Column(name="deposito")
	private int deposito;
	
	public Cochera(){
		
	}
	
	public Cochera (int codigoCochera, String nombre, String direccion, int deposito){
		this.codigoCochera=codigoCochera;
		this.nombre=nombre;
		this.direccion=direccion;
		this.deposito=deposito;
	}
	
	public int getCodigoCochera() {
		return codigoCochera;
	}
	public void setCodigoCochera(int codigoCochera) {
		this.codigoCochera = codigoCochera;
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
	public int getDeposito() {
		return deposito;
	}
	public void setDeposito(int deposito) {
		this.deposito = deposito;
	}
	
	public String toString() {
		return "Cochera [codigoCochera=" + codigoCochera + ", nombre=" + nombre + ", direccion=" + direccion
				+ ", deposito=" + deposito + "]";
	}
}
