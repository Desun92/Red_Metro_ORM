package es.redmetro.dam2.dao.orm;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import es.redmetro.dam2.dao.ICocheraDao;
import es.redmetro.dam2.excepciones.RedMetroException;
import es.redmetro.dam2.utilidades.UtilidadHibernate;
import es.redmetro.dam2.vo.Cochera;

public class CocheraOrmDao implements ICocheraDao {

	public int crearCochera(Cochera cochera) throws RedMetroException {
		int resultado = 0;
		Session session = UtilidadHibernate.getSession();
		
		Transaction tx = session.beginTransaction();
		
		try {
			session.save(cochera);
			tx.commit();
			resultado=1;
		}
		catch(Exception e) {
			System.out.println("La cochera ya existe en la base de datos");
		}
		finally {
			session.close();
		}
		return resultado;
	}

	public int modificarCochera(Cochera cochera) throws RedMetroException {
		int resultado=0;
		Session session = UtilidadHibernate.getSession();
		
		Transaction tx = session.beginTransaction();
		
		try {
			session.update(cochera);
			tx.commit();
			resultado=1;
		}
		catch(Exception e) {
			System.out.println("No existe la entidad a modificar");
		}
		finally {
			session.close();
		}
		return resultado;
	}

	public int borrarCochera(int codigoCochera) throws RedMetroException {
		int resultado=0;
		Session session = UtilidadHibernate.getSession();
		
		Transaction tx = session.beginTransaction();
		
		Cochera cochera = session.find(Cochera.class, codigoCochera);
		
		if(cochera!=null) {
			session.delete(cochera);
			tx.commit();
			resultado=1;
		}
		else
			System.out.println("No existe la cochera a borrar");
		
		session.close();
		return resultado;
	}

	public Cochera consultarCochera(int codigoCochera) throws RedMetroException {
		Session session = UtilidadHibernate.getSession();
		
		Cochera cochera = session.find(Cochera.class, codigoCochera);
		
		if(cochera==null) 
			System.out.println("No existe la cochera");
		
		session.close();
		return cochera;
	}

	public List<Cochera> consultarCocheras() throws RedMetroException {
		List<Cochera> listaCocheras = null;
		Session session = UtilidadHibernate.getSession();
		
		listaCocheras = session.createNativeQuery("SELECT * FROM T_COCHERA", Cochera.class).list();
		return listaCocheras;
	}

}
