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

public class EtiquetaDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression IDEtiqueta;
	public final StringExpression nombre;
	public final CollectionExpression esta_en;
	
	public EtiquetaDetachedCriteria() {
		super(instagualbdorm.Etiqueta.class, instagualbdorm.EtiquetaCriteria.class);
		IDEtiqueta = new IntegerExpression("IDEtiqueta", this.getDetachedCriteria());
		nombre = new StringExpression("nombre", this.getDetachedCriteria());
		esta_en = new CollectionExpression("ORM_esta_en", this.getDetachedCriteria());
	}
	
	public EtiquetaDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, instagualbdorm.EtiquetaCriteria.class);
		IDEtiqueta = new IntegerExpression("IDEtiqueta", this.getDetachedCriteria());
		nombre = new StringExpression("nombre", this.getDetachedCriteria());
		esta_en = new CollectionExpression("ORM_esta_en", this.getDetachedCriteria());
	}
	
	public PublicacionDetachedCriteria createEsta_enCriteria() {
		return new PublicacionDetachedCriteria(createCriteria("ORM_esta_en"));
	}
	
	public Etiqueta uniqueEtiqueta(PersistentSession session) {
		return (Etiqueta) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Etiqueta[] listEtiqueta(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Etiqueta[]) list.toArray(new Etiqueta[list.size()]);
	}
}

