package es.redmetro.dam2.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.ForeignKey;

@Entity
@Table(name="T_ACCESO")
public class Acceso {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cod_acceso")
	private int codigoAcceso;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="acceso_discapacidad")
	private int tieneAccesoDiscapacidad;
	
	@ManyToOne
	@JoinColumn(name="cod_estacion", referencedColumnName="cod_estacion", foreignKey = @ForeignKey(name="fk_estacion"))
	private Estacion estacion;
	
	public Acceso() {
		
	}
	
	public Acceso(int codigoAcceso, String nombre, int tieneAccesoDiscapacidad, Estacion estacion) {
		this.codigoAcceso=codigoAcceso;
		this.nombre=nombre;
		this.tieneAccesoDiscapacidad=tieneAccesoDiscapacidad;
		this.estacion=estacion;
	}
	
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
	public int isTieneAccesoDiscapacidad() {
		return tieneAccesoDiscapacidad;
	}
	public void setTieneAccesoDiscapacidad(int tieneAccesoDiscapacidad) {
		this.tieneAccesoDiscapacidad = tieneAccesoDiscapacidad;
	}
	public Estacion getEstacion() {
		return estacion;
	}
	public void setEstacion(Estacion estacion) {
		this.estacion = estacion;
	}
}
