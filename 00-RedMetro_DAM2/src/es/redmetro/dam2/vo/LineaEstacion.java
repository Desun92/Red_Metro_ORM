package es.redmetro.dam2.vo;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="T_LINEA_ESTACION")
public class LineaEstacion implements Serializable{
	
	@EmbeddedId
	private LineaEstacionId id = new LineaEstacionId();
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="cod_linea",insertable=false,updatable=false,foreignKey=@ForeignKey(name="fk_linea_estacion"))
	private Linea linea;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="cod_estacion",insertable=false,updatable=false,foreignKey=@ForeignKey(name="fk_estacion_linea"))
	private Estacion estacion;
	
	@Column(name="ordenM")
	private int ordenM;
	
	public Linea getLinea() {
		return linea;
	}
	public void setLinea(Linea linea) {
		this.linea = linea;
		this.id.codLinea = linea.getCodigoLinea();
	}
	public Estacion getEstacion() {
		return estacion;
	}
	public void setEstacion(Estacion estacion) {
		this.estacion = estacion;
		this.id.codEstacion = estacion.getCodigoEstacion();
	}
	public int getOrdenM() {
		return ordenM;
	}
	public void setOrdenM(int ordenM) {
		this.ordenM = ordenM;
	}
	
	@Embeddable
	public static class LineaEstacionId implements Serializable{
		
		@Column(name="cod_linea")
		private int codLinea;
		
		@Column(name="cod_estacion")
		private int codEstacion;
		
		public LineaEstacionId() {
			
		}
		
		public LineaEstacionId(int codLinea, int codEstacion) {
			this.codLinea=codLinea;
			this.codEstacion=codEstacion;
		}

		public boolean equals(Object o) {
			boolean resultado=false;
			if (o != null && o instanceof LineaEstacionId) {
				LineaEstacionId that = (LineaEstacionId) o;
				resultado= (this.codLinea==that.codLinea) && (this.codEstacion == that.codEstacion);
			}
			return resultado;
		}
		public int hashCode() {
			return Integer.hashCode(codLinea)+ Integer.hashCode(codEstacion);
		}
	}
}
