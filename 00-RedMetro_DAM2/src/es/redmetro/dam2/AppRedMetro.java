package es.redmetro.dam2;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import es.redmetro.dam2.dao.ICocheraDao;
import es.redmetro.dam2.dao.jdbc.CocheraJdbcDao;
import es.redmetro.dam2.dao.orm.CocheraOrmDao;
import es.redmetro.dam2.excepciones.RedMetroException;
import es.redmetro.dam2.procesos.ProcesoFicheros;
import es.redmetro.dam2.utilidades.GestorConexion;
import es.redmetro.dam2.utilidades.UtilidadHibernate;
import es.redmetro.dam2.vo.Cochera;

public class AppRedMetro {
	public static void main(String[] args) {
		AppRedMetro red = new AppRedMetro();
		ICocheraDao cochera = new CocheraOrmDao();
		Cochera coche = new Cochera(8,"aaaa","bbbb",0);
		try {
			cochera.crearCochera(coche);
		} catch (RedMetroException e) {
			e.printStackTrace();
		}
	}
}

