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
import java.util.Date;

@Entity
@Table(name="T_TREN")
public class Tren {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cod_tren")
	private int codigoTren;
	
	@Column(name="modelo")
	private String modelo;
	
	@Column(name="año_incorporacion")
	private Date anyoIncorporacion;
	
	@Column(name="empresa_constructora")
	private String empresaConstructora;
	
	@ManyToOne
	@JoinColumn(name="cod_linea", referencedColumnName="cod_linea", foreignKey = @ForeignKey(name="fk_linea"))
	private Linea linea;
	
	@ManyToOne
	@JoinColumn(name="cod_cochera", referencedColumnName="cod_cochera", foreignKey = @ForeignKey(name="fk_cochera"))	
	private Cochera cochera;
	
	public Tren() {
		
	}
	
	public Tren(int codigoTren, String modelo, Date anyoIncorporacion, String empresaConstructora, Linea linea, Cochera cochera) {
		this.codigoTren=codigoTren;
		this.modelo=modelo;
		this.anyoIncorporacion=anyoIncorporacion;
		this.empresaConstructora=empresaConstructora;
		this.linea=linea;
		this.cochera=cochera;
	}
	
	public String getEmpresaConstructora() {
		return empresaConstructora;
	}
	public void setEmpresaConstructora(String empresaConstructora) {
		this.empresaConstructora = empresaConstructora;
	}
	public int getCodigoTren() {
		return codigoTren;
	}
	public void setCodigoTren(int codigoTren) {
		this.codigoTren = codigoTren;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public Date getAnyoIncorporacion() {
		return anyoIncorporacion;
	}
	public void setAnyoIncorporacion(Date anyoIncorporacion) {
		this.anyoIncorporacion = anyoIncorporacion;
	}
	public Linea getLinea() {
		return linea;
	}
	public void setLinea(Linea linea) {
		this.linea = linea;
	}
	public Cochera getCochera() {
		return cochera;
	}
	public void setCochera(Cochera cochera) {
		this.cochera = cochera;
	}
	
	public String toString() {
		return "Tren [codigoTren=" + codigoTren + ", modelo=" + modelo + ", anyoIncorporacion=" + anyoIncorporacion
				+ ", empresaConstructora=" + empresaConstructora + ", linea=" + linea + ", cochera=" + cochera + "]";
	}
}
