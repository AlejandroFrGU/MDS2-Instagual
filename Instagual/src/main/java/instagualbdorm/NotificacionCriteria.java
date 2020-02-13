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

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class NotificacionCriteria extends AbstractORMCriteria {
	public final IntegerExpression IDNotificacion;
	public final IntegerExpression contiene_notificacionesId;
	public final AssociationExpression contiene_notificaciones;
	public final StringExpression descripcion;
	public final StringExpression tipo;
	public final StringExpression fecha;
	public final BooleanExpression recibida;
	
	public NotificacionCriteria(Criteria criteria) {
		super(criteria);
		IDNotificacion = new IntegerExpression("IDNotificacion", this);
		contiene_notificacionesId = new IntegerExpression("contiene_notificaciones.", this);
		contiene_notificaciones = new AssociationExpression("contiene_notificaciones", this);
		descripcion = new StringExpression("descripcion", this);
		tipo = new StringExpression("tipo", this);
		fecha = new StringExpression("fecha", this);
		recibida = new BooleanExpression("recibida", this);
	}
	
	public NotificacionCriteria(PersistentSession session) {
		this(session.createCriteria(Notificacion.class));
	}
	
	public NotificacionCriteria() throws PersistentException {
		this(ProyectoInstagualPersistentManager.instance().getSession());
	}
	
	public Usuario_RegistradoCriteria createContiene_notificacionesCriteria() {
		return new Usuario_RegistradoCriteria(createCriteria("contiene_notificaciones"));
	}
	
	public Notificacion uniqueNotificacion() {
		return (Notificacion) super.uniqueResult();
	}
	
	public Notificacion[] listNotificacion() {
		java.util.List list = super.list();
		return (Notificacion[]) list.toArray(new Notificacion[list.size()]);
	}
}

