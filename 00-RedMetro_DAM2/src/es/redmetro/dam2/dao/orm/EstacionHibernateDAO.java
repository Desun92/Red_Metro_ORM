package es.redmetro.dam2.dao.orm;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import es.redmetro.dam2.dao.IBaseDeDatos;
import es.redmetro.dam2.utilidades.UtilidadHibernate;
import es.redmetro.dam2.vo.Estacion;
import es.redmetro.dam2.vo.Linea;
import es.redmetro.dam2.vo.LineaEstacion;

public class EstacionHibernateDAO implements IBaseDeDatos<Estacion> {
	
	private LineaHibernateDAO linea = new LineaHibernateDAO();
	private LineaEstacionHibernateDAO lineaEstacionOperacion = new LineaEstacionHibernateDAO();
	
	public void crear(Estacion entidad) {
		Session session = UtilidadHibernate.getSession();
		
		Transaction tx = session.beginTransaction();
		
		try {
			session.save(entidad);
			tx.commit();
			if(entidad.getLineaEstacion()!=null) {
				for(LineaEstacion codigoLinea : entidad.getLineaEstacion()) {
					LineaEstacion lineaEstacion = new LineaEstacion();
					lineaEstacion.setEstacion(entidad);
					lineaEstacion.setLinea(linea.consultarPorID(codigoLinea.getLinea().getCodigoLinea(), Linea.class));
					lineaEstacion.setOrdenM(codigoLinea.getOrdenM());
					lineaEstacionOperacion.crear(lineaEstacion);
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
	}

	public void modificar(Estacion entidad) {
		Session session = UtilidadHibernate.getSession();
		
		Transaction tx = session.beginTransaction();
		
		try {
			session.update(entidad);
			tx.commit();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
	}

	public void borrar(Estacion entidad) {
		Session session = UtilidadHibernate.getSession();
		
		Transaction tx = session.beginTransaction();
		
		Estacion estacion = session.find(Estacion.class, entidad.getCodigoEstacion());
		
		if(estacion!=null) {
			session.delete(entidad);
			tx.commit();
		}
		else
			System.out.println("No existe la estacion a borrar");
		
		session.close();
	}

	public Estacion consultarPorID(int codEntidad, Class<Estacion> clase) {
		Session session = UtilidadHibernate.getSession();
		
		Estacion estacion = session.find(Estacion.class, codEntidad);
		
		if(estacion==null) 
			System.out.println("No existe el tren");
		
		session.close();
		return estacion;
	}

	public List<Estacion> consultarLista(Class<Estacion> clase) {
		List<Estacion> listaEstaciones = null;
		Session session = UtilidadHibernate.getSession();
		
		listaEstaciones = session.createNativeQuery("SELECT * FROM T_TREN", Estacion.class).list();
		return listaEstaciones;
	}
	
}
