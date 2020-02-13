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

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class NotificacionDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression IDNotificacion;
	public final IntegerExpression contiene_notificacionesId;
	public final AssociationExpression contiene_notificaciones;
	public final StringExpression descripcion;
	public final StringExpression tipo;
	public final StringExpression fecha;
	public final BooleanExpression recibida;
	
	public NotificacionDetachedCriteria() {
		super(instagualbdorm.Notificacion.class, instagualbdorm.NotificacionCriteria.class);
		IDNotificacion = new IntegerExpression("IDNotificacion", this.getDetachedCriteria());
		contiene_notificacionesId = new IntegerExpression("contiene_notificaciones.", this.getDetachedCriteria());
		contiene_notificaciones = new AssociationExpression("contiene_notificaciones", this.getDetachedCriteria());
		descripcion = new StringExpression("descripcion", this.getDetachedCriteria());
		tipo = new StringExpression("tipo", this.getDetachedCriteria());
		fecha = new StringExpression("fecha", this.getDetachedCriteria());
		recibida = new BooleanExpression("recibida", this.getDetachedCriteria());
	}
	
	public NotificacionDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, instagualbdorm.NotificacionCriteria.class);
		IDNotificacion = new IntegerExpression("IDNotificacion", this.getDetachedCriteria());
		contiene_notificacionesId = new IntegerExpression("contiene_notificaciones.", this.getDetachedCriteria());
		contiene_notificaciones = new AssociationExpression("contiene_notificaciones", this.getDetachedCriteria());
		descripcion = new StringExpression("descripcion", this.getDetachedCriteria());
		tipo = new StringExpression("tipo", this.getDetachedCriteria());
		fecha = new StringExpression("fecha", this.getDetachedCriteria());
		recibida = new BooleanExpression("recibida", this.getDetachedCriteria());
	}
	
	public Usuario_RegistradoDetachedCriteria createContiene_notificacionesCriteria() {
		return new Usuario_RegistradoDetachedCriteria(createCriteria("contiene_notificaciones"));
	}
	
	public Notificacion uniqueNotificacion(PersistentSession session) {
		return (Notificacion) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Notificacion[] listNotificacion(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Notificacion[]) list.toArray(new Notificacion[list.size()]);
	}
}

