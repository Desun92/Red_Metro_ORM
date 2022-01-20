package es.redmetro.dam2;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import es.redmetro.dam2.dao.IBaseDeDatos;
import es.redmetro.dam2.dao.orm.*;
import es.redmetro.dam2.utilidades.APPPruebaFTP;
import es.redmetro.dam2.utilidades.GestorConexion;
import es.redmetro.dam2.utilidades.UtilidadHibernate;
import es.redmetro.dam2.vo.*;

public class AppRedMetro {
	public static void main(String[] args) {
		
		//PRUEBA XML
		
		/*UtilidadHibernate utilidad = new UtilidadHibernate();
		utilidad.getSession(); CREAR LAS TABLAS*/
		
		AppRedMetro red = new AppRedMetro();
		AccesoHibernateDAO operacionAcceso = new AccesoHibernateDAO();
		CocheraHibernateDAO operacionCochera = new CocheraHibernateDAO();
		ColorHibernateDAO operacionColor = new ColorHibernateDAO();
		EstacionHibernateDAO operacionEstacion = new EstacionHibernateDAO();
		LineaHibernateDAO operacionLinea = new LineaHibernateDAO();
		TrenHibernateDAO operacionTren = new TrenHibernateDAO();
		
		//MODIFICAR LINEA 12 CON EL NOMBRE LARGO METROSUR EN LUGAR DE METROUR
		
		/*Color color = new Color();
		color = operacionColor.consultarPorID(12, Color.class);
		
		Linea lineaModificar = new Linea();
		lineaModificar.setCodigoLinea(13);
		lineaModificar.setNombreCorto("Línea 12");
		lineaModificar.setNombreLargo("Metrosur");
		lineaModificar.setKilometros(10.75f);
		lineaModificar.setColor(color);
		operacionLinea.modificar(lineaModificar);*/

		//----------------------------------------------------------------------
		//----------------------------------------------------------------------
		
		List<Tren> listaTrenes = new ArrayList<Tren>();
		List<Acceso> listaAccesos = new ArrayList<Acceso>();
		List<Estacion> listaEstaciones = new ArrayList<Estacion>();
		APPPruebaFTP.parseo(listaTrenes,listaAccesos,listaEstaciones);
		
		/*for(Tren tren : listaTrenes) {
			operacionTren.crear(tren);
		}
		
		for(Estacion estacion : listaEstaciones) {
			operacionEstacion.crear(estacion);
		}
		
		for(Acceso acceso : listaAccesos) {
			operacionAcceso.crear(acceso);
		}*/
		
	}
}

