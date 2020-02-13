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

public class AdministradorDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression IDUsuario;
	public final StringExpression correo;
	public final StringExpression password;
	public final StringExpression nombre;
	public final StringExpression apellido;
	public final StringExpression nombreUsuario;
	
	public AdministradorDetachedCriteria() {
		super(instagualbdorm.Administrador.class, instagualbdorm.AdministradorCriteria.class);
		IDUsuario = new IntegerExpression("IDUsuario", this.getDetachedCriteria());
		correo = new StringExpression("correo", this.getDetachedCriteria());
		password = new StringExpression("password", this.getDetachedCriteria());
		nombre = new StringExpression("nombre", this.getDetachedCriteria());
		apellido = new StringExpression("apellido", this.getDetachedCriteria());
		nombreUsuario = new StringExpression("nombreUsuario", this.getDetachedCriteria());
	}
	
	public AdministradorDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, instagualbdorm.AdministradorCriteria.class);
		IDUsuario = new IntegerExpression("IDUsuario", this.getDetachedCriteria());
		correo = new StringExpression("correo", this.getDetachedCriteria());
		password = new StringExpression("password", this.getDetachedCriteria());
		nombre = new StringExpression("nombre", this.getDetachedCriteria());
		apellido = new StringExpression("apellido", this.getDetachedCriteria());
		nombreUsuario = new StringExpression("nombreUsuario", this.getDetachedCriteria());
	}
	
	public Administrador uniqueAdministrador(PersistentSession session) {
		return (Administrador) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Administrador[] listAdministrador(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Administrador[]) list.toArray(new Administrador[list.size()]);
	}
}

