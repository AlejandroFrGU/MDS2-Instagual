package instagualbdorm;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

public class BD_Notificaciones {
	public BD_Principal _bD_Principal;
	public Notificacion _contiene_notificacion;
	
	public boolean crearNotificacion(int aIDUsuario,String descripcion,boolean recibida,String tipo) throws PersistentException {	
		PersistentTransaction t = ProyectoInstagualPersistentManager.instance().getSession().beginTransaction();
		instagualbdorm.Publicacion publi = null;
		instagualbdorm.Usuario_Registrado user = null;//usuario de la notificacion
		try {
			user = Usuario_RegistradoDAO.getUsuario_RegistradoByORMID(aIDUsuario);
			Notificacion notification = NotificacionDAO.createNotificacion();
			notification.setDescripcion(descripcion);
			notification.setContiene_notificaciones(user);
			notification.setTipo(tipo);
			if(!recibida) {//No es recibida por lo que es para el
				user.notificaciones_de.add(notification);
				notification.setRecibida(false);
			}else {
				//es recibida por lo que es para sus seguidores
				notification.setRecibida(true);
				for(Usuario_Registrado userMeSigue: user.seguido_por.toArray()) {
					userMeSigue.notificaciones_de.add(notification);
					Usuario_RegistradoDAO.save(userMeSigue);
				}
			}
			//fecha
			SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");  
			Date date = new Date(System.currentTimeMillis());
			notification.setFecha(formatter.format(date));
			Usuario_RegistradoDAO.save(user);
			NotificacionDAO.save(notification);
			t.commit();
			return true;
		} catch (PersistentException e) {
			e.printStackTrace();
			t.rollback();
		}
		return false;
	}
}