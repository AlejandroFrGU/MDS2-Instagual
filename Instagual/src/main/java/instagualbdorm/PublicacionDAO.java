/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: Alejandro(University of Almeria)
 * License Type: Academic
 */
package instagualbdorm;

import org.orm.*;
import org.hibernate.Query;
import org.hibernate.LockMode;
import java.util.List;

public class PublicacionDAO {
	public static Publicacion loadPublicacionByORMID(int IDpublicacion) throws PersistentException {
		try {
			PersistentSession session = ProyectoInstagualPersistentManager.instance().getSession();
			return loadPublicacionByORMID(session, IDpublicacion);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Publicacion getPublicacionByORMID(int IDpublicacion) throws PersistentException {
		try {
			PersistentSession session = ProyectoInstagualPersistentManager.instance().getSession();
			return getPublicacionByORMID(session, IDpublicacion);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Publicacion loadPublicacionByORMID(int IDpublicacion, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = ProyectoInstagualPersistentManager.instance().getSession();
			return loadPublicacionByORMID(session, IDpublicacion, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Publicacion getPublicacionByORMID(int IDpublicacion, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = ProyectoInstagualPersistentManager.instance().getSession();
			return getPublicacionByORMID(session, IDpublicacion, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Publicacion loadPublicacionByORMID(PersistentSession session, int IDpublicacion) throws PersistentException {
		try {
			return (Publicacion) session.load(instagualbdorm.Publicacion.class, new Integer(IDpublicacion));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Publicacion getPublicacionByORMID(PersistentSession session, int IDpublicacion) throws PersistentException {
		try {
			return (Publicacion) session.get(instagualbdorm.Publicacion.class, new Integer(IDpublicacion));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Publicacion loadPublicacionByORMID(PersistentSession session, int IDpublicacion, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Publicacion) session.load(instagualbdorm.Publicacion.class, new Integer(IDpublicacion), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Publicacion getPublicacionByORMID(PersistentSession session, int IDpublicacion, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Publicacion) session.get(instagualbdorm.Publicacion.class, new Integer(IDpublicacion), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryPublicacion(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = ProyectoInstagualPersistentManager.instance().getSession();
			return queryPublicacion(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryPublicacion(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = ProyectoInstagualPersistentManager.instance().getSession();
			return queryPublicacion(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Publicacion[] listPublicacionByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = ProyectoInstagualPersistentManager.instance().getSession();
			return listPublicacionByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Publicacion[] listPublicacionByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = ProyectoInstagualPersistentManager.instance().getSession();
			return listPublicacionByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryPublicacion(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From instagualbdorm.Publicacion as Publicacion");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryPublicacion(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From instagualbdorm.Publicacion as Publicacion");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Publicacion", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Publicacion[] listPublicacionByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryPublicacion(session, condition, orderBy);
			return (Publicacion[]) list.toArray(new Publicacion[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Publicacion[] listPublicacionByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryPublicacion(session, condition, orderBy, lockMode);
			return (Publicacion[]) list.toArray(new Publicacion[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Publicacion loadPublicacionByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = ProyectoInstagualPersistentManager.instance().getSession();
			return loadPublicacionByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Publicacion loadPublicacionByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = ProyectoInstagualPersistentManager.instance().getSession();
			return loadPublicacionByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Publicacion loadPublicacionByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Publicacion[] publicacions = listPublicacionByQuery(session, condition, orderBy);
		if (publicacions != null && publicacions.length > 0)
			return publicacions[0];
		else
			return null;
	}
	
	public static Publicacion loadPublicacionByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Publicacion[] publicacions = listPublicacionByQuery(session, condition, orderBy, lockMode);
		if (publicacions != null && publicacions.length > 0)
			return publicacions[0];
		else
			return null;
	}
	
	public static java.util.Iterator iteratePublicacionByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = ProyectoInstagualPersistentManager.instance().getSession();
			return iteratePublicacionByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iteratePublicacionByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = ProyectoInstagualPersistentManager.instance().getSession();
			return iteratePublicacionByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iteratePublicacionByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From instagualbdorm.Publicacion as Publicacion");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iteratePublicacionByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From instagualbdorm.Publicacion as Publicacion");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Publicacion", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Publicacion createPublicacion() {
		return new instagualbdorm.Publicacion();
	}
	
	public static boolean save(instagualbdorm.Publicacion publicacion) throws PersistentException {
		try {
			ProyectoInstagualPersistentManager.instance().saveObject(publicacion);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(instagualbdorm.Publicacion publicacion) throws PersistentException {
		try {
			ProyectoInstagualPersistentManager.instance().deleteObject(publicacion);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(instagualbdorm.Publicacion publicacion)throws PersistentException {
		try {
			if (publicacion.getPropiedad_de() != null) {
				publicacion.getPropiedad_de().sube.remove(publicacion);
			}
			
			if (publicacion.getTiene() != null) {
				publicacion.getTiene().esta_en.remove(publicacion);
			}
			
			instagualbdorm.Comentario[] lContiene_as = publicacion.contiene_a.toArray();
			for(int i = 0; i < lContiene_as.length; i++) {
				lContiene_as[i].setContenido_en(null);
			}
			instagualbdorm.Usuario_Registrado[] lMenciona_as = publicacion.menciona_a.toArray();
			for(int i = 0; i < lMenciona_as.length; i++) {
				lMenciona_as[i].mencionado_en.remove(publicacion);
			}
			instagualbdorm.Usuario_Registrado[] lGustada_pors = publicacion.gustada_por.toArray();
			for(int i = 0; i < lGustada_pors.length; i++) {
				lGustada_pors[i].le_gusta.remove(publicacion);
			}
			instagualbdorm.Elemento[] lContienes = publicacion.contiene.toArray();
			for(int i = 0; i < lContienes.length; i++) {
				lContienes[i].setContenido_en(null);
			}
			return delete(publicacion);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(instagualbdorm.Publicacion publicacion, org.orm.PersistentSession session)throws PersistentException {
		try {
			if (publicacion.getPropiedad_de() != null) {
				publicacion.getPropiedad_de().sube.remove(publicacion);
			}
			
			if (publicacion.getTiene() != null) {
				publicacion.getTiene().esta_en.remove(publicacion);
			}
			
			instagualbdorm.Comentario[] lContiene_as = publicacion.contiene_a.toArray();
			for(int i = 0; i < lContiene_as.length; i++) {
				lContiene_as[i].setContenido_en(null);
			}
			instagualbdorm.Usuario_Registrado[] lMenciona_as = publicacion.menciona_a.toArray();
			for(int i = 0; i < lMenciona_as.length; i++) {
				lMenciona_as[i].mencionado_en.remove(publicacion);
			}
			instagualbdorm.Usuario_Registrado[] lGustada_pors = publicacion.gustada_por.toArray();
			for(int i = 0; i < lGustada_pors.length; i++) {
				lGustada_pors[i].le_gusta.remove(publicacion);
			}
			instagualbdorm.Elemento[] lContienes = publicacion.contiene.toArray();
			for(int i = 0; i < lContienes.length; i++) {
				lContienes[i].setContenido_en(null);
			}
			try {
				session.delete(publicacion);
				return true;
			} catch (Exception e) {
				return false;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean refresh(instagualbdorm.Publicacion publicacion) throws PersistentException {
		try {
			ProyectoInstagualPersistentManager.instance().getSession().refresh(publicacion);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(instagualbdorm.Publicacion publicacion) throws PersistentException {
		try {
			ProyectoInstagualPersistentManager.instance().getSession().evict(publicacion);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Publicacion loadPublicacionByCriteria(PublicacionCriteria publicacionCriteria) {
		Publicacion[] publicacions = listPublicacionByCriteria(publicacionCriteria);
		if(publicacions == null || publicacions.length == 0) {
			return null;
		}
		return publicacions[0];
	}
	
	public static Publicacion[] listPublicacionByCriteria(PublicacionCriteria publicacionCriteria) {
		return publicacionCriteria.listPublicacion();
	}
}
