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

public class ComentarioCriteria extends AbstractORMCriteria {
	public final IntegerExpression IDComentario;
	public final IntegerExpression contenido_enId;
	public final AssociationExpression contenido_en;
	public final CollectionExpression gustado_por;
	public final StringExpression comentario;
	public final StringExpression nombreUsuario;
	public final IntegerExpression propiedad_deId;
	public final AssociationExpression propiedad_de;
	
	public ComentarioCriteria(Criteria criteria) {
		super(criteria);
		IDComentario = new IntegerExpression("IDComentario", this);
		contenido_enId = new IntegerExpression("contenido_en.IDpublicacion", this);
		contenido_en = new AssociationExpression("contenido_en", this);
		gustado_por = new CollectionExpression("ORM_gustado_por", this);
		comentario = new StringExpression("comentario", this);
		nombreUsuario = new StringExpression("nombreUsuario", this);
		propiedad_deId = new IntegerExpression("propiedad_de.", this);
		propiedad_de = new AssociationExpression("propiedad_de", this);
	}
	
	public ComentarioCriteria(PersistentSession session) {
		this(session.createCriteria(Comentario.class));
	}
	
	public ComentarioCriteria() throws PersistentException {
		this(ProyectoInstagualPersistentManager.instance().getSession());
	}
	
	public PublicacionCriteria createContenido_enCriteria() {
		return new PublicacionCriteria(createCriteria("contenido_en"));
	}
	
	public Usuario_RegistradoCriteria createGustado_porCriteria() {
		return new Usuario_RegistradoCriteria(createCriteria("ORM_gustado_por"));
	}
	
	public Usuario_RegistradoCriteria createPropiedad_deCriteria() {
		return new Usuario_RegistradoCriteria(createCriteria("propiedad_de"));
	}
	
	public Comentario uniqueComentario() {
		return (Comentario) super.uniqueResult();
	}
	
	public Comentario[] listComentario() {
		java.util.List list = super.list();
		return (Comentario[]) list.toArray(new Comentario[list.size()]);
	}
}

