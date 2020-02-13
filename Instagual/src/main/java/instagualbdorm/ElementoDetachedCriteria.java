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

public class ElementoDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression IDElemento;
	public final IntegerExpression contenido_enId;
	public final AssociationExpression contenido_en;
	public final StringExpression pathName;
	
	public ElementoDetachedCriteria() {
		super(instagualbdorm.Elemento.class, instagualbdorm.ElementoCriteria.class);
		IDElemento = new IntegerExpression("IDElemento", this.getDetachedCriteria());
		contenido_enId = new IntegerExpression("contenido_en.IDpublicacion", this.getDetachedCriteria());
		contenido_en = new AssociationExpression("contenido_en", this.getDetachedCriteria());
		pathName = new StringExpression("pathName", this.getDetachedCriteria());
	}
	
	public ElementoDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, instagualbdorm.ElementoCriteria.class);
		IDElemento = new IntegerExpression("IDElemento", this.getDetachedCriteria());
		contenido_enId = new IntegerExpression("contenido_en.IDpublicacion", this.getDetachedCriteria());
		contenido_en = new AssociationExpression("contenido_en", this.getDetachedCriteria());
		pathName = new StringExpression("pathName", this.getDetachedCriteria());
	}
	
	public PublicacionDetachedCriteria createContenido_enCriteria() {
		return new PublicacionDetachedCriteria(createCriteria("contenido_en"));
	}
	
	public Elemento uniqueElemento(PersistentSession session) {
		return (Elemento) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Elemento[] listElemento(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Elemento[]) list.toArray(new Elemento[list.size()]);
	}
}

