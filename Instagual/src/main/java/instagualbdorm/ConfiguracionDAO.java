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

public class ConfiguracionDAO {
	public static Configuracion loadConfiguracionByORMID(int IDConfiguracion) throws PersistentException {
		try {
			PersistentSession session = ProyectoInstagualPersistentManager.instance().getSession();
			return loadConfiguracionByORMID(session, IDConfiguracion);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Configuracion getConfiguracionByORMID(int IDConfiguracion) throws PersistentException {
		try {
			PersistentSession session = ProyectoInstagualPersistentManager.instance().getSession();
			return getConfiguracionByORMID(session, IDConfiguracion);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Configuracion loadConfiguracionByORMID(int IDConfiguracion, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = ProyectoInstagualPersistentManager.instance().getSession();
			return loadConfiguracionByORMID(session, IDConfiguracion, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Configuracion getConfiguracionByORMID(int IDConfiguracion, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = ProyectoInstagualPersistentManager.instance().getSession();
			return getConfiguracionByORMID(session, IDConfiguracion, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Configuracion loadConfiguracionByORMID(PersistentSession session, int IDConfiguracion) throws PersistentException {
		try {
			return (Configuracion) session.load(instagualbdorm.Configuracion.class, new Integer(IDConfiguracion));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Configuracion getConfiguracionByORMID(PersistentSession session, int IDConfiguracion) throws PersistentException {
		try {
			return (Configuracion) session.get(instagualbdorm.Configuracion.class, new Integer(IDConfiguracion));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Configuracion loadConfiguracionByORMID(PersistentSession session, int IDConfiguracion, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Configuracion) session.load(instagualbdorm.Configuracion.class, new Integer(IDConfiguracion), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Configuracion getConfiguracionByORMID(PersistentSession session, int IDConfiguracion, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Configuracion) session.get(instagualbdorm.Configuracion.class, new Integer(IDConfiguracion), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryConfiguracion(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = ProyectoInstagualPersistentManager.instance().getSession();
			return queryConfiguracion(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryConfiguracion(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = ProyectoInstagualPersistentManager.instance().getSession();
			return queryConfiguracion(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Configuracion[] listConfiguracionByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = ProyectoInstagualPersistentManager.instance().getSession();
			return listConfiguracionByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Configuracion[] listConfiguracionByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = ProyectoInstagualPersistentManager.instance().getSession();
			return listConfiguracionByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryConfiguracion(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From instagualbdorm.Configuracion as Configuracion");
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
	
	public static List queryConfiguracion(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From instagualbdorm.Configuracion as Configuracion");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Configuracion", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Configuracion[] listConfiguracionByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryConfiguracion(session, condition, orderBy);
			return (Configuracion[]) list.toArray(new Configuracion[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Configuracion[] listConfiguracionByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryConfiguracion(session, condition, orderBy, lockMode);
			return (Configuracion[]) list.toArray(new Configuracion[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Configuracion loadConfiguracionByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = ProyectoInstagualPersistentManager.instance().getSession();
			return loadConfiguracionByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Configuracion loadConfiguracionByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = ProyectoInstagualPersistentManager.instance().getSession();
			return loadConfiguracionByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Configuracion loadConfiguracionByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Configuracion[] configuracions = listConfiguracionByQuery(session, condition, orderBy);
		if (configuracions != null && configuracions.length > 0)
			return configuracions[0];
		else
			return null;
	}
	
	public static Configuracion loadConfiguracionByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Configuracion[] configuracions = listConfiguracionByQuery(session, condition, orderBy, lockMode);
		if (configuracions != null && configuracions.length > 0)
			return configuracions[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateConfiguracionByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = ProyectoInstagualPersistentManager.instance().getSession();
			return iterateConfiguracionByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateConfiguracionByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = ProyectoInstagualPersistentManager.instance().getSession();
			return iterateConfiguracionByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateConfiguracionByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From instagualbdorm.Configuracion as Configuracion");
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
	
	public static java.util.Iterator iterateConfiguracionByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From instagualbdorm.Configuracion as Configuracion");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Configuracion", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Configuracion createConfiguracion() {
		return new instagualbdorm.Configuracion();
	}
	
	public static boolean save(instagualbdorm.Configuracion configuracion) throws PersistentException {
		try {
			ProyectoInstagualPersistentManager.instance().saveObject(configuracion);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(instagualbdorm.Configuracion configuracion) throws PersistentException {
		try {
			ProyectoInstagualPersistentManager.instance().deleteObject(configuracion);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(instagualbdorm.Configuracion configuracion)throws PersistentException {
		try {
			if (configuracion.getConfigurado_por() != null) {
				configuracion.getConfigurado_por().setConfigura(null);
			}
			
			return delete(configuracion);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(instagualbdorm.Configuracion configuracion, org.orm.PersistentSession session)throws PersistentException {
		try {
			if (configuracion.getConfigurado_por() != null) {
				configuracion.getConfigurado_por().setConfigura(null);
			}
			
			try {
				session.delete(configuracion);
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
	
	public static boolean refresh(instagualbdorm.Configuracion configuracion) throws PersistentException {
		try {
			ProyectoInstagualPersistentManager.instance().getSession().refresh(configuracion);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(instagualbdorm.Configuracion configuracion) throws PersistentException {
		try {
			ProyectoInstagualPersistentManager.instance().getSession().evict(configuracion);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Configuracion loadConfiguracionByCriteria(ConfiguracionCriteria configuracionCriteria) {
		Configuracion[] configuracions = listConfiguracionByCriteria(configuracionCriteria);
		if(configuracions == null || configuracions.length == 0) {
			return null;
		}
		return configuracions[0];
	}
	
	public static Configuracion[] listConfiguracionByCriteria(ConfiguracionCriteria configuracionCriteria) {
		return configuracionCriteria.listConfiguracion();
	}
}
