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

public class NotificacionDAO {
	public static Notificacion loadNotificacionByORMID(int IDNotificacion) throws PersistentException {
		try {
			PersistentSession session = ProyectoInstagualPersistentManager.instance().getSession();
			return loadNotificacionByORMID(session, IDNotificacion);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Notificacion getNotificacionByORMID(int IDNotificacion) throws PersistentException {
		try {
			PersistentSession session = ProyectoInstagualPersistentManager.instance().getSession();
			return getNotificacionByORMID(session, IDNotificacion);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Notificacion loadNotificacionByORMID(int IDNotificacion, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = ProyectoInstagualPersistentManager.instance().getSession();
			return loadNotificacionByORMID(session, IDNotificacion, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Notificacion getNotificacionByORMID(int IDNotificacion, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = ProyectoInstagualPersistentManager.instance().getSession();
			return getNotificacionByORMID(session, IDNotificacion, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Notificacion loadNotificacionByORMID(PersistentSession session, int IDNotificacion) throws PersistentException {
		try {
			return (Notificacion) session.load(instagualbdorm.Notificacion.class, new Integer(IDNotificacion));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Notificacion getNotificacionByORMID(PersistentSession session, int IDNotificacion) throws PersistentException {
		try {
			return (Notificacion) session.get(instagualbdorm.Notificacion.class, new Integer(IDNotificacion));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Notificacion loadNotificacionByORMID(PersistentSession session, int IDNotificacion, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Notificacion) session.load(instagualbdorm.Notificacion.class, new Integer(IDNotificacion), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Notificacion getNotificacionByORMID(PersistentSession session, int IDNotificacion, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Notificacion) session.get(instagualbdorm.Notificacion.class, new Integer(IDNotificacion), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryNotificacion(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = ProyectoInstagualPersistentManager.instance().getSession();
			return queryNotificacion(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryNotificacion(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = ProyectoInstagualPersistentManager.instance().getSession();
			return queryNotificacion(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Notificacion[] listNotificacionByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = ProyectoInstagualPersistentManager.instance().getSession();
			return listNotificacionByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Notificacion[] listNotificacionByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = ProyectoInstagualPersistentManager.instance().getSession();
			return listNotificacionByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryNotificacion(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From instagualbdorm.Notificacion as Notificacion");
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
	
	public static List queryNotificacion(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From instagualbdorm.Notificacion as Notificacion");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Notificacion", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Notificacion[] listNotificacionByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryNotificacion(session, condition, orderBy);
			return (Notificacion[]) list.toArray(new Notificacion[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Notificacion[] listNotificacionByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryNotificacion(session, condition, orderBy, lockMode);
			return (Notificacion[]) list.toArray(new Notificacion[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Notificacion loadNotificacionByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = ProyectoInstagualPersistentManager.instance().getSession();
			return loadNotificacionByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Notificacion loadNotificacionByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = ProyectoInstagualPersistentManager.instance().getSession();
			return loadNotificacionByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Notificacion loadNotificacionByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Notificacion[] notificacions = listNotificacionByQuery(session, condition, orderBy);
		if (notificacions != null && notificacions.length > 0)
			return notificacions[0];
		else
			return null;
	}
	
	public static Notificacion loadNotificacionByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Notificacion[] notificacions = listNotificacionByQuery(session, condition, orderBy, lockMode);
		if (notificacions != null && notificacions.length > 0)
			return notificacions[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateNotificacionByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = ProyectoInstagualPersistentManager.instance().getSession();
			return iterateNotificacionByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateNotificacionByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = ProyectoInstagualPersistentManager.instance().getSession();
			return iterateNotificacionByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateNotificacionByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From instagualbdorm.Notificacion as Notificacion");
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
	
	public static java.util.Iterator iterateNotificacionByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From instagualbdorm.Notificacion as Notificacion");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Notificacion", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Notificacion createNotificacion() {
		return new instagualbdorm.Notificacion();
	}
	
	public static boolean save(instagualbdorm.Notificacion notificacion) throws PersistentException {
		try {
			ProyectoInstagualPersistentManager.instance().saveObject(notificacion);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(instagualbdorm.Notificacion notificacion) throws PersistentException {
		try {
			ProyectoInstagualPersistentManager.instance().deleteObject(notificacion);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(instagualbdorm.Notificacion notificacion)throws PersistentException {
		try {
			if (notificacion.getContiene_notificaciones() != null) {
				notificacion.getContiene_notificaciones().notificaciones_de.remove(notificacion);
			}
			
			return delete(notificacion);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(instagualbdorm.Notificacion notificacion, org.orm.PersistentSession session)throws PersistentException {
		try {
			if (notificacion.getContiene_notificaciones() != null) {
				notificacion.getContiene_notificaciones().notificaciones_de.remove(notificacion);
			}
			
			try {
				session.delete(notificacion);
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
	
	public static boolean refresh(instagualbdorm.Notificacion notificacion) throws PersistentException {
		try {
			ProyectoInstagualPersistentManager.instance().getSession().refresh(notificacion);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(instagualbdorm.Notificacion notificacion) throws PersistentException {
		try {
			ProyectoInstagualPersistentManager.instance().getSession().evict(notificacion);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Notificacion loadNotificacionByCriteria(NotificacionCriteria notificacionCriteria) {
		Notificacion[] notificacions = listNotificacionByCriteria(notificacionCriteria);
		if(notificacions == null || notificacions.length == 0) {
			return null;
		}
		return notificacions[0];
	}
	
	public static Notificacion[] listNotificacionByCriteria(NotificacionCriteria notificacionCriteria) {
		return notificacionCriteria.listNotificacion();
	}
}
