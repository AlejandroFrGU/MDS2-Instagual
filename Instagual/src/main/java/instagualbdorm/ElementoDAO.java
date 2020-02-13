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

public class ElementoDAO {
	public static Elemento loadElementoByORMID(int IDElemento) throws PersistentException {
		try {
			PersistentSession session = ProyectoInstagualPersistentManager.instance().getSession();
			return loadElementoByORMID(session, IDElemento);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Elemento getElementoByORMID(int IDElemento) throws PersistentException {
		try {
			PersistentSession session = ProyectoInstagualPersistentManager.instance().getSession();
			return getElementoByORMID(session, IDElemento);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Elemento loadElementoByORMID(int IDElemento, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = ProyectoInstagualPersistentManager.instance().getSession();
			return loadElementoByORMID(session, IDElemento, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Elemento getElementoByORMID(int IDElemento, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = ProyectoInstagualPersistentManager.instance().getSession();
			return getElementoByORMID(session, IDElemento, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Elemento loadElementoByORMID(PersistentSession session, int IDElemento) throws PersistentException {
		try {
			return (Elemento) session.load(instagualbdorm.Elemento.class, new Integer(IDElemento));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Elemento getElementoByORMID(PersistentSession session, int IDElemento) throws PersistentException {
		try {
			return (Elemento) session.get(instagualbdorm.Elemento.class, new Integer(IDElemento));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Elemento loadElementoByORMID(PersistentSession session, int IDElemento, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Elemento) session.load(instagualbdorm.Elemento.class, new Integer(IDElemento), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Elemento getElementoByORMID(PersistentSession session, int IDElemento, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Elemento) session.get(instagualbdorm.Elemento.class, new Integer(IDElemento), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryElemento(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = ProyectoInstagualPersistentManager.instance().getSession();
			return queryElemento(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryElemento(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = ProyectoInstagualPersistentManager.instance().getSession();
			return queryElemento(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Elemento[] listElementoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = ProyectoInstagualPersistentManager.instance().getSession();
			return listElementoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Elemento[] listElementoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = ProyectoInstagualPersistentManager.instance().getSession();
			return listElementoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryElemento(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From instagualbdorm.Elemento as Elemento");
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
	
	public static List queryElemento(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From instagualbdorm.Elemento as Elemento");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Elemento", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Elemento[] listElementoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryElemento(session, condition, orderBy);
			return (Elemento[]) list.toArray(new Elemento[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Elemento[] listElementoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryElemento(session, condition, orderBy, lockMode);
			return (Elemento[]) list.toArray(new Elemento[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Elemento loadElementoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = ProyectoInstagualPersistentManager.instance().getSession();
			return loadElementoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Elemento loadElementoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = ProyectoInstagualPersistentManager.instance().getSession();
			return loadElementoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Elemento loadElementoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Elemento[] elementos = listElementoByQuery(session, condition, orderBy);
		if (elementos != null && elementos.length > 0)
			return elementos[0];
		else
			return null;
	}
	
	public static Elemento loadElementoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Elemento[] elementos = listElementoByQuery(session, condition, orderBy, lockMode);
		if (elementos != null && elementos.length > 0)
			return elementos[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateElementoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = ProyectoInstagualPersistentManager.instance().getSession();
			return iterateElementoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateElementoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = ProyectoInstagualPersistentManager.instance().getSession();
			return iterateElementoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateElementoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From instagualbdorm.Elemento as Elemento");
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
	
	public static java.util.Iterator iterateElementoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From instagualbdorm.Elemento as Elemento");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Elemento", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Elemento createElemento() {
		return new instagualbdorm.Elemento();
	}
	
	public static boolean save(instagualbdorm.Elemento elemento) throws PersistentException {
		try {
			ProyectoInstagualPersistentManager.instance().saveObject(elemento);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(instagualbdorm.Elemento elemento) throws PersistentException {
		try {
			ProyectoInstagualPersistentManager.instance().deleteObject(elemento);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(instagualbdorm.Elemento elemento)throws PersistentException {
		try {
			if (elemento.getContenido_en() != null) {
				elemento.getContenido_en().contiene.remove(elemento);
			}
			
			return delete(elemento);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(instagualbdorm.Elemento elemento, org.orm.PersistentSession session)throws PersistentException {
		try {
			if (elemento.getContenido_en() != null) {
				elemento.getContenido_en().contiene.remove(elemento);
			}
			
			try {
				session.delete(elemento);
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
	
	public static boolean refresh(instagualbdorm.Elemento elemento) throws PersistentException {
		try {
			ProyectoInstagualPersistentManager.instance().getSession().refresh(elemento);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(instagualbdorm.Elemento elemento) throws PersistentException {
		try {
			ProyectoInstagualPersistentManager.instance().getSession().evict(elemento);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Elemento loadElementoByCriteria(ElementoCriteria elementoCriteria) {
		Elemento[] elementos = listElementoByCriteria(elementoCriteria);
		if(elementos == null || elementos.length == 0) {
			return null;
		}
		return elementos[0];
	}
	
	public static Elemento[] listElementoByCriteria(ElementoCriteria elementoCriteria) {
		return elementoCriteria.listElemento();
	}
}
