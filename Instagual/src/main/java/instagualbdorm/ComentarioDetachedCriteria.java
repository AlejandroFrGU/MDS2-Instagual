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

public class ComentarioDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression IDComentario;
	public final IntegerExpression contenido_enId;
	public final AssociationExpression contenido_en;
	public final CollectionExpression gustado_por;
	public final StringExpression comentario;
	public final StringExpression nombreUsuario;
	public final IntegerExpression propiedad_deId;
	public final AssociationExpression propiedad_de;
	
	public ComentarioDetachedCriteria() {
		super(instagualbdorm.Comentario.class, instagualbdorm.ComentarioCriteria.class);
		IDComentario = new IntegerExpression("IDComentario", this.getDetachedCriteria());
		contenido_enId = new IntegerExpression("contenido_en.IDpublicacion", this.getDetachedCriteria());
		contenido_en = new AssociationExpression("contenido_en", this.getDetachedCriteria());
		gustado_por = new CollectionExpression("ORM_gustado_por", this.getDetachedCriteria());
		comentario = new StringExpression("comentario", this.getDetachedCriteria());
		nombreUsuario = new StringExpression("nombreUsuario", this.getDetachedCriteria());
		propiedad_deId = new IntegerExpression("propiedad_de.", this.getDetachedCriteria());
		propiedad_de = new AssociationExpression("propiedad_de", this.getDetachedCriteria());
	}
	
	public ComentarioDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, instagualbdorm.ComentarioCriteria.class);
		IDComentario = new IntegerExpression("IDComentario", this.getDetachedCriteria());
		contenido_enId = new IntegerExpression("contenido_en.IDpublicacion", this.getDetachedCriteria());
		contenido_en = new AssociationExpression("contenido_en", this.getDetachedCriteria());
		gustado_por = new CollectionExpression("ORM_gustado_por", this.getDetachedCriteria());
		comentario = new StringExpression("comentario", this.getDetachedCriteria());
		nombreUsuario = new StringExpression("nombreUsuario", this.getDetachedCriteria());
		propiedad_deId = new IntegerExpression("propiedad_de.", this.getDetachedCriteria());
		propiedad_de = new AssociationExpression("propiedad_de", this.getDetachedCriteria());
	}
	
	public PublicacionDetachedCriteria createContenido_enCriteria() {
		return new PublicacionDetachedCriteria(createCriteria("contenido_en"));
	}
	
	public Usuario_RegistradoDetachedCriteria createGustado_porCriteria() {
		return new Usuario_RegistradoDetachedCriteria(createCriteria("ORM_gustado_por"));
	}
	
	public Usuario_RegistradoDetachedCriteria createPropiedad_deCriteria() {
		return new Usuario_RegistradoDetachedCriteria(createCriteria("propiedad_de"));
	}
	
	public Comentario uniqueComentario(PersistentSession session) {
		return (Comentario) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Comentario[] listComentario(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Comentario[]) list.toArray(new Comentario[list.size()]);
	}
}

