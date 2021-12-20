package es.redmetro.dam2;

import java.sql.Date;
import java.util.List;

import es.redmetro.dam2.dao.IBaseDeDatos;
import es.redmetro.dam2.dao.orm.*;
import es.redmetro.dam2.vo.*;

public class AppRedMetro {
	public static void main(String[] args) {
		AppRedMetro red = new AppRedMetro();
		IBaseDeDatos operacion = new TrenHibernateDAO();
		LineaHibernateDAO operacionLinea = new LineaHibernateDAO();
		CocheraHibernateDAO operacionCochera = new CocheraHibernateDAO();
		EstacionHibernateDAO operacionEstacion = new EstacionHibernateDAO();
		AccesoHibernateDAO operacionAcceso = new AccesoHibernateDAO();
		
		/*Estacion estacion = new Estacion();
		estacion.setCodigoEstacion(0);
		estacion.setDireccion("La que sea");
		estacion.setlineas(null);
		estacion.setNombre("El nombre");
		//operacionEstacion.crear(estacion);
		
		
		Acceso acceso = new Acceso();
		acceso.setCodigoAcceso(0);
		acceso.setEstacion(estacion);
		acceso.setNombre("AccesoA");
		acceso.setTieneAccesoDiscapacidad(true);
		operacionAcceso.crear(acceso);*/
		
		//operacionEstacion.modificar(estacion);
		
		/*Estacion estacion = operacionEstacion.consultarPorID(1, Estacion.class);
		System.out.println(estacion.toString());*/
		
		List<Linea> lineas = operacionLinea.consultarLista(Linea.class);
		for(Linea line : lineas) {
			System.out.println(line.toString());
		}
		
		/*Tren tren = new Tren();
		Date fecha = new Date(11/12/2001);
		tren.setCodigoTren(0);
		tren.setLinea(operacionLinea.consultarPorID(11, Linea.class));
		tren.setCochera(operacionCochera.consultarPorID(13, Cochera.class));
		tren.setAnyoIncorporacion(fecha);
		tren.setEmpresaConstructora("La que sea");
		tren.setModelo("Alvia 500-S");
		
		operacion.crear(tren);*/
	}
}

