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

public class EtiquetaDAO {
	public static Etiqueta loadEtiquetaByORMID(int IDEtiqueta) throws PersistentException {
		try {
			PersistentSession session = ProyectoInstagualPersistentManager.instance().getSession();
			return loadEtiquetaByORMID(session, IDEtiqueta);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Etiqueta getEtiquetaByORMID(int IDEtiqueta) throws PersistentException {
		try {
			PersistentSession session = ProyectoInstagualPersistentManager.instance().getSession();
			return getEtiquetaByORMID(session, IDEtiqueta);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Etiqueta loadEtiquetaByORMID(int IDEtiqueta, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = ProyectoInstagualPersistentManager.instance().getSession();
			return loadEtiquetaByORMID(session, IDEtiqueta, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Etiqueta getEtiquetaByORMID(int IDEtiqueta, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = ProyectoInstagualPersistentManager.instance().getSession();
			return getEtiquetaByORMID(session, IDEtiqueta, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Etiqueta loadEtiquetaByORMID(PersistentSession session, int IDEtiqueta) throws PersistentException {
		try {
			return (Etiqueta) session.load(instagualbdorm.Etiqueta.class, new Integer(IDEtiqueta));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Etiqueta getEtiquetaByORMID(PersistentSession session, int IDEtiqueta) throws PersistentException {
		try {
			return (Etiqueta) session.get(instagualbdorm.Etiqueta.class, new Integer(IDEtiqueta));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Etiqueta loadEtiquetaByORMID(PersistentSession session, int IDEtiqueta, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Etiqueta) session.load(instagualbdorm.Etiqueta.class, new Integer(IDEtiqueta), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Etiqueta getEtiquetaByORMID(PersistentSession session, int IDEtiqueta, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Etiqueta) session.get(instagualbdorm.Etiqueta.class, new Integer(IDEtiqueta), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryEtiqueta(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = ProyectoInstagualPersistentManager.instance().getSession();
			return queryEtiqueta(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryEtiqueta(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = ProyectoInstagualPersistentManager.instance().getSession();
			return queryEtiqueta(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Etiqueta[] listEtiquetaByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = ProyectoInstagualPersistentManager.instance().getSession();
			return listEtiquetaByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Etiqueta[] listEtiquetaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = ProyectoInstagualPersistentManager.instance().getSession();
			return listEtiquetaByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryEtiqueta(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From instagualbdorm.Etiqueta as Etiqueta");
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
	
	public static List queryEtiqueta(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From instagualbdorm.Etiqueta as Etiqueta");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Etiqueta", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Etiqueta[] listEtiquetaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryEtiqueta(session, condition, orderBy);
			return (Etiqueta[]) list.toArray(new Etiqueta[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Etiqueta[] listEtiquetaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryEtiqueta(session, condition, orderBy, lockMode);
			return (Etiqueta[]) list.toArray(new Etiqueta[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Etiqueta loadEtiquetaByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = ProyectoInstagualPersistentManager.instance().getSession();
			return loadEtiquetaByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Etiqueta loadEtiquetaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = ProyectoInstagualPersistentManager.instance().getSession();
			return loadEtiquetaByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Etiqueta loadEtiquetaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Etiqueta[] etiquetas = listEtiquetaByQuery(session, condition, orderBy);
		if (etiquetas != null && etiquetas.length > 0)
			return etiquetas[0];
		else
			return null;
	}
	
	public static Etiqueta loadEtiquetaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Etiqueta[] etiquetas = listEtiquetaByQuery(session, condition, orderBy, lockMode);
		if (etiquetas != null && etiquetas.length > 0)
			return etiquetas[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateEtiquetaByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = ProyectoInstagualPersistentManager.instance().getSession();
			return iterateEtiquetaByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateEtiquetaByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = ProyectoInstagualPersistentManager.instance().getSession();
			return iterateEtiquetaByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateEtiquetaByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From instagualbdorm.Etiqueta as Etiqueta");
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
	
	public static java.util.Iterator iterateEtiquetaByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From instagualbdorm.Etiqueta as Etiqueta");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Etiqueta", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Etiqueta createEtiqueta() {
		return new instagualbdorm.Etiqueta();
	}
	
	public static boolean save(instagualbdorm.Etiqueta etiqueta) throws PersistentException {
		try {
			ProyectoInstagualPersistentManager.instance().saveObject(etiqueta);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(instagualbdorm.Etiqueta etiqueta) throws PersistentException {
		try {
			ProyectoInstagualPersistentManager.instance().deleteObject(etiqueta);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(instagualbdorm.Etiqueta etiqueta)throws PersistentException {
		try {
			instagualbdorm.Publicacion[] lEsta_ens = etiqueta.esta_en.toArray();
			for(int i = 0; i < lEsta_ens.length; i++) {
				lEsta_ens[i].setTiene(null);
			}
			return delete(etiqueta);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(instagualbdorm.Etiqueta etiqueta, org.orm.PersistentSession session)throws PersistentException {
		try {
			instagualbdorm.Publicacion[] lEsta_ens = etiqueta.esta_en.toArray();
			for(int i = 0; i < lEsta_ens.length; i++) {
				lEsta_ens[i].setTiene(null);
			}
			try {
				session.delete(etiqueta);
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
	
	public static boolean refresh(instagualbdorm.Etiqueta etiqueta) throws PersistentException {
		try {
			ProyectoInstagualPersistentManager.instance().getSession().refresh(etiqueta);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(instagualbdorm.Etiqueta etiqueta) throws PersistentException {
		try {
			ProyectoInstagualPersistentManager.instance().getSession().evict(etiqueta);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Etiqueta loadEtiquetaByCriteria(EtiquetaCriteria etiquetaCriteria) {
		Etiqueta[] etiquetas = listEtiquetaByCriteria(etiquetaCriteria);
		if(etiquetas == null || etiquetas.length == 0) {
			return null;
		}
		return etiquetas[0];
	}
	
	public static Etiqueta[] listEtiquetaByCriteria(EtiquetaCriteria etiquetaCriteria) {
		return etiquetaCriteria.listEtiqueta();
	}
}
