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

public class UsuarioCriteria extends AbstractORMCriteria {
	public final IntegerExpression IDUsuario;
	public final StringExpression correo;
	public final StringExpression password;
	public final StringExpression nombre;
	public final StringExpression apellido;
	public final StringExpression nombreUsuario;
	
	public UsuarioCriteria(Criteria criteria) {
		super(criteria);
		IDUsuario = new IntegerExpression("IDUsuario", this);
		correo = new StringExpression("correo", this);
		password = new StringExpression("password", this);
		nombre = new StringExpression("nombre", this);
		apellido = new StringExpression("apellido", this);
		nombreUsuario = new StringExpression("nombreUsuario", this);
	}
	
	public UsuarioCriteria(PersistentSession session) {
		this(session.createCriteria(Usuario.class));
	}
	
	public UsuarioCriteria() throws PersistentException {
		this(ProyectoInstagualPersistentManager.instance().getSession());
	}
	
	public Usuario uniqueUsuario() {
		return (Usuario) super.uniqueResult();
	}
	
	public Usuario[] listUsuario() {
		java.util.List list = super.list();
		return (Usuario[]) list.toArray(new Usuario[list.size()]);
	}
}

