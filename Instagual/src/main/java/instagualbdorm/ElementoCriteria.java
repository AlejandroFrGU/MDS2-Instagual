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

public class ElementoCriteria extends AbstractORMCriteria {
	public final IntegerExpression IDElemento;
	public final IntegerExpression contenido_enId;
	public final AssociationExpression contenido_en;
	public final StringExpression pathName;
	
	public ElementoCriteria(Criteria criteria) {
		super(criteria);
		IDElemento = new IntegerExpression("IDElemento", this);
		contenido_enId = new IntegerExpression("contenido_en.IDpublicacion", this);
		contenido_en = new AssociationExpression("contenido_en", this);
		pathName = new StringExpression("pathName", this);
	}
	
	public ElementoCriteria(PersistentSession session) {
		this(session.createCriteria(Elemento.class));
	}
	
	public ElementoCriteria() throws PersistentException {
		this(ProyectoInstagualPersistentManager.instance().getSession());
	}
	
	public PublicacionCriteria createContenido_enCriteria() {
		return new PublicacionCriteria(createCriteria("contenido_en"));
	}
	
	public Elemento uniqueElemento() {
		return (Elemento) super.uniqueResult();
	}
	
	public Elemento[] listElemento() {
		java.util.List list = super.list();
		return (Elemento[]) list.toArray(new Elemento[list.size()]);
	}
}

