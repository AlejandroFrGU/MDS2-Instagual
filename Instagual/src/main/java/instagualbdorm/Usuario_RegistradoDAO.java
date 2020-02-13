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

public class Usuario_RegistradoDAO {
	public static Usuario_Registrado loadUsuario_RegistradoByORMID(int IDUsuario) throws PersistentException {
		try {
			PersistentSession session = ProyectoInstagualPersistentManager.instance().getSession();
			return loadUsuario_RegistradoByORMID(session, IDUsuario);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Usuario_Registrado getUsuario_RegistradoByORMID(int IDUsuario) throws PersistentException {
		try {
			PersistentSession session = ProyectoInstagualPersistentManager.instance().getSession();
			return getUsuario_RegistradoByORMID(session, IDUsuario);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Usuario_Registrado loadUsuario_RegistradoByORMID(int IDUsuario, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = ProyectoInstagualPersistentManager.instance().getSession();
			return loadUsuario_RegistradoByORMID(session, IDUsuario, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Usuario_Registrado getUsuario_RegistradoByORMID(int IDUsuario, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = ProyectoInstagualPersistentManager.instance().getSession();
			return getUsuario_RegistradoByORMID(session, IDUsuario, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Usuario_Registrado loadUsuario_RegistradoByORMID(PersistentSession session, int IDUsuario) throws PersistentException {
		try {
			return (Usuario_Registrado) session.load(instagualbdorm.Usuario_Registrado.class, new Integer(IDUsuario));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Usuario_Registrado getUsuario_RegistradoByORMID(PersistentSession session, int IDUsuario) throws PersistentException {
		try {
			return (Usuario_Registrado) session.get(instagualbdorm.Usuario_Registrado.class, new Integer(IDUsuario));
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Usuario_Registrado loadUsuario_RegistradoByORMID(PersistentSession session, int IDUsuario, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Usuario_Registrado) session.load(instagualbdorm.Usuario_Registrado.class, new Integer(IDUsuario), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Usuario_Registrado getUsuario_RegistradoByORMID(PersistentSession session, int IDUsuario, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			return (Usuario_Registrado) session.get(instagualbdorm.Usuario_Registrado.class, new Integer(IDUsuario), lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryUsuario_Registrado(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = ProyectoInstagualPersistentManager.instance().getSession();
			return queryUsuario_Registrado(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryUsuario_Registrado(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = ProyectoInstagualPersistentManager.instance().getSession();
			return queryUsuario_Registrado(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Usuario_Registrado[] listUsuario_RegistradoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = ProyectoInstagualPersistentManager.instance().getSession();
			return listUsuario_RegistradoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Usuario_Registrado[] listUsuario_RegistradoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = ProyectoInstagualPersistentManager.instance().getSession();
			return listUsuario_RegistradoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static List queryUsuario_Registrado(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From instagualbdorm.Usuario_Registrado as Usuario_Registrado");
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
	
	public static List queryUsuario_Registrado(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From instagualbdorm.Usuario_Registrado as Usuario_Registrado");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Usuario_Registrado", lockMode);
			return query.list();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Usuario_Registrado[] listUsuario_RegistradoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		try {
			List list = queryUsuario_Registrado(session, condition, orderBy);
			return (Usuario_Registrado[]) list.toArray(new Usuario_Registrado[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Usuario_Registrado[] listUsuario_RegistradoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			List list = queryUsuario_Registrado(session, condition, orderBy, lockMode);
			return (Usuario_Registrado[]) list.toArray(new Usuario_Registrado[list.size()]);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Usuario_Registrado loadUsuario_RegistradoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = ProyectoInstagualPersistentManager.instance().getSession();
			return loadUsuario_RegistradoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Usuario_Registrado loadUsuario_RegistradoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = ProyectoInstagualPersistentManager.instance().getSession();
			return loadUsuario_RegistradoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Usuario_Registrado loadUsuario_RegistradoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		Usuario_Registrado[] usuario_Registrados = listUsuario_RegistradoByQuery(session, condition, orderBy);
		if (usuario_Registrados != null && usuario_Registrados.length > 0)
			return usuario_Registrados[0];
		else
			return null;
	}
	
	public static Usuario_Registrado loadUsuario_RegistradoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		Usuario_Registrado[] usuario_Registrados = listUsuario_RegistradoByQuery(session, condition, orderBy, lockMode);
		if (usuario_Registrados != null && usuario_Registrados.length > 0)
			return usuario_Registrados[0];
		else
			return null;
	}
	
	public static java.util.Iterator iterateUsuario_RegistradoByQuery(String condition, String orderBy) throws PersistentException {
		try {
			PersistentSession session = ProyectoInstagualPersistentManager.instance().getSession();
			return iterateUsuario_RegistradoByQuery(session, condition, orderBy);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateUsuario_RegistradoByQuery(String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		try {
			PersistentSession session = ProyectoInstagualPersistentManager.instance().getSession();
			return iterateUsuario_RegistradoByQuery(session, condition, orderBy, lockMode);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static java.util.Iterator iterateUsuario_RegistradoByQuery(PersistentSession session, String condition, String orderBy) throws PersistentException {
		StringBuffer sb = new StringBuffer("From instagualbdorm.Usuario_Registrado as Usuario_Registrado");
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
	
	public static java.util.Iterator iterateUsuario_RegistradoByQuery(PersistentSession session, String condition, String orderBy, org.hibernate.LockMode lockMode) throws PersistentException {
		StringBuffer sb = new StringBuffer("From instagualbdorm.Usuario_Registrado as Usuario_Registrado");
		if (condition != null)
			sb.append(" Where ").append(condition);
		if (orderBy != null)
			sb.append(" Order By ").append(orderBy);
		try {
			Query query = session.createQuery(sb.toString());
			query.setLockMode("Usuario_Registrado", lockMode);
			return query.iterate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Usuario_Registrado createUsuario_Registrado() {
		return new instagualbdorm.Usuario_Registrado();
	}
	
	public static boolean save(instagualbdorm.Usuario_Registrado usuario_Registrado) throws PersistentException {
		try {
			ProyectoInstagualPersistentManager.instance().saveObject(usuario_Registrado);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean delete(instagualbdorm.Usuario_Registrado usuario_Registrado) throws PersistentException {
		try {
			ProyectoInstagualPersistentManager.instance().deleteObject(usuario_Registrado);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(instagualbdorm.Usuario_Registrado usuario_Registrado)throws PersistentException {
		try {
			instagualbdorm.Usuario_Registrado[] lBloquedo_pors = usuario_Registrado.bloquedo_por.toArray();
			for(int i = 0; i < lBloquedo_pors.length; i++) {
				lBloquedo_pors[i].bloquea_a.remove(usuario_Registrado);
			}
			instagualbdorm.Usuario_Registrado[] lSigue_as = usuario_Registrado.sigue_a.toArray();
			for(int i = 0; i < lSigue_as.length; i++) {
				lSigue_as[i].seguido_por.remove(usuario_Registrado);
			}
			if (usuario_Registrado.getConfigura() != null) {
				usuario_Registrado.getConfigura().setConfigurado_por(null);
			}
			
			instagualbdorm.Usuario_Registrado[] lBloquea_as = usuario_Registrado.bloquea_a.toArray();
			for(int i = 0; i < lBloquea_as.length; i++) {
				lBloquea_as[i].bloquedo_por.remove(usuario_Registrado);
			}
			instagualbdorm.Usuario_Registrado[] lSeguido_pors = usuario_Registrado.seguido_por.toArray();
			for(int i = 0; i < lSeguido_pors.length; i++) {
				lSeguido_pors[i].sigue_a.remove(usuario_Registrado);
			}
			instagualbdorm.Comentario[] lGustas = usuario_Registrado.gusta.toArray();
			for(int i = 0; i < lGustas.length; i++) {
				lGustas[i].gustado_por.remove(usuario_Registrado);
			}
			instagualbdorm.Comentario[] lComentas = usuario_Registrado.comenta.toArray();
			for(int i = 0; i < lComentas.length; i++) {
				lComentas[i].setPropiedad_de(null);
			}
			instagualbdorm.Publicacion[] lSubes = usuario_Registrado.sube.toArray();
			for(int i = 0; i < lSubes.length; i++) {
				lSubes[i].setPropiedad_de(null);
			}
			instagualbdorm.Publicacion[] lMencionado_ens = usuario_Registrado.mencionado_en.toArray();
			for(int i = 0; i < lMencionado_ens.length; i++) {
				lMencionado_ens[i].menciona_a.remove(usuario_Registrado);
			}
			instagualbdorm.Publicacion[] lLe_gustas = usuario_Registrado.le_gusta.toArray();
			for(int i = 0; i < lLe_gustas.length; i++) {
				lLe_gustas[i].gustada_por.remove(usuario_Registrado);
			}
			instagualbdorm.Notificacion[] lNotificaciones_des = usuario_Registrado.notificaciones_de.toArray();
			for(int i = 0; i < lNotificaciones_des.length; i++) {
				lNotificaciones_des[i].setContiene_notificaciones(null);
			}
			return delete(usuario_Registrado);
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean deleteAndDissociate(instagualbdorm.Usuario_Registrado usuario_Registrado, org.orm.PersistentSession session)throws PersistentException {
		try {
			instagualbdorm.Usuario_Registrado[] lBloquedo_pors = usuario_Registrado.bloquedo_por.toArray();
			for(int i = 0; i < lBloquedo_pors.length; i++) {
				lBloquedo_pors[i].bloquea_a.remove(usuario_Registrado);
			}
			instagualbdorm.Usuario_Registrado[] lSigue_as = usuario_Registrado.sigue_a.toArray();
			for(int i = 0; i < lSigue_as.length; i++) {
				lSigue_as[i].seguido_por.remove(usuario_Registrado);
			}
			if (usuario_Registrado.getConfigura() != null) {
				usuario_Registrado.getConfigura().setConfigurado_por(null);
			}
			
			instagualbdorm.Usuario_Registrado[] lBloquea_as = usuario_Registrado.bloquea_a.toArray();
			for(int i = 0; i < lBloquea_as.length; i++) {
				lBloquea_as[i].bloquedo_por.remove(usuario_Registrado);
			}
			instagualbdorm.Usuario_Registrado[] lSeguido_pors = usuario_Registrado.seguido_por.toArray();
			for(int i = 0; i < lSeguido_pors.length; i++) {
				lSeguido_pors[i].sigue_a.remove(usuario_Registrado);
			}
			instagualbdorm.Comentario[] lGustas = usuario_Registrado.gusta.toArray();
			for(int i = 0; i < lGustas.length; i++) {
				lGustas[i].gustado_por.remove(usuario_Registrado);
			}
			instagualbdorm.Comentario[] lComentas = usuario_Registrado.comenta.toArray();
			for(int i = 0; i < lComentas.length; i++) {
				lComentas[i].setPropiedad_de(null);
			}
			instagualbdorm.Publicacion[] lSubes = usuario_Registrado.sube.toArray();
			for(int i = 0; i < lSubes.length; i++) {
				lSubes[i].setPropiedad_de(null);
			}
			instagualbdorm.Publicacion[] lMencionado_ens = usuario_Registrado.mencionado_en.toArray();
			for(int i = 0; i < lMencionado_ens.length; i++) {
				lMencionado_ens[i].menciona_a.remove(usuario_Registrado);
			}
			instagualbdorm.Publicacion[] lLe_gustas = usuario_Registrado.le_gusta.toArray();
			for(int i = 0; i < lLe_gustas.length; i++) {
				lLe_gustas[i].gustada_por.remove(usuario_Registrado);
			}
			instagualbdorm.Notificacion[] lNotificaciones_des = usuario_Registrado.notificaciones_de.toArray();
			for(int i = 0; i < lNotificaciones_des.length; i++) {
				lNotificaciones_des[i].setContiene_notificaciones(null);
			}
			try {
				session.delete(usuario_Registrado);
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
	
	public static boolean refresh(instagualbdorm.Usuario_Registrado usuario_Registrado) throws PersistentException {
		try {
			ProyectoInstagualPersistentManager.instance().getSession().refresh(usuario_Registrado);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static boolean evict(instagualbdorm.Usuario_Registrado usuario_Registrado) throws PersistentException {
		try {
			ProyectoInstagualPersistentManager.instance().getSession().evict(usuario_Registrado);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
	}
	
	public static Usuario_Registrado loadUsuario_RegistradoByCriteria(Usuario_RegistradoCriteria usuario_RegistradoCriteria) {
		Usuario_Registrado[] usuario_Registrados = listUsuario_RegistradoByCriteria(usuario_RegistradoCriteria);
		if(usuario_Registrados == null || usuario_Registrados.length == 0) {
			return null;
		}
		return usuario_Registrados[0];
	}
	
	public static Usuario_Registrado[] listUsuario_RegistradoByCriteria(Usuario_RegistradoCriteria usuario_RegistradoCriteria) {
		return usuario_RegistradoCriteria.listUsuario_Registrado();
	}
}
