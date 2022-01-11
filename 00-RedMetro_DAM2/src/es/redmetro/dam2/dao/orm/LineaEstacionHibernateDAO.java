package es.redmetro.dam2.dao.orm;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import es.redmetro.dam2.dao.IBaseDeDatos;
import es.redmetro.dam2.utilidades.UtilidadHibernate;
import es.redmetro.dam2.vo.LineaEstacion;

public class LineaEstacionHibernateDAO implements IBaseDeDatos<LineaEstacion> {
	
	public void crear(LineaEstacion entidad) {
		Session session = UtilidadHibernate.getSession();
		
		Transaction tx = session.beginTransaction();
		
		try {
			session.save(entidad);
			tx.commit();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
	}

	public void modificar(LineaEstacion entidad) {
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

	public void borrar(LineaEstacion entidad) {
		Session session = UtilidadHibernate.getSession();
		
		Transaction tx = session.beginTransaction();
		
		try {
			session.delete(entidad);
			tx.commit();
		}
		catch(Exception e) {
			e.printStackTrace();
		}

		session.close();
	}

	public LineaEstacion consultarPorID(int codEntidad, Class<LineaEstacion> clase) {
		Session session = UtilidadHibernate.getSession();
		
		LineaEstacion acceso = session.find(LineaEstacion.class, codEntidad);
		
		if(acceso==null) 
			System.out.println("No existe el acceso");
		
		session.close();
		return acceso;
	}

	public List<LineaEstacion> consultarLista(Class<LineaEstacion> clase) {
		List<LineaEstacion> lineaEstaciones = null;
		Session session = UtilidadHibernate.getSession();
		
		lineaEstaciones = session.createNativeQuery("SELECT * FROM T_ACCESO", LineaEstacion.class).list();
		return lineaEstaciones;
	}
}
