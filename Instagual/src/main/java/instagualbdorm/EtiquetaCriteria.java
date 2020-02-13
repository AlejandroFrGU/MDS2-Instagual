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

public class EtiquetaCriteria extends AbstractORMCriteria {
	public final IntegerExpression IDEtiqueta;
	public final StringExpression nombre;
	public final CollectionExpression esta_en;
	
	public EtiquetaCriteria(Criteria criteria) {
		super(criteria);
		IDEtiqueta = new IntegerExpression("IDEtiqueta", this);
		nombre = new StringExpression("nombre", this);
		esta_en = new CollectionExpression("ORM_esta_en", this);
	}
	
	public EtiquetaCriteria(PersistentSession session) {
		this(session.createCriteria(Etiqueta.class));
	}
	
	public EtiquetaCriteria() throws PersistentException {
		this(ProyectoInstagualPersistentManager.instance().getSession());
	}
	
	public PublicacionCriteria createEsta_enCriteria() {
		return new PublicacionCriteria(createCriteria("ORM_esta_en"));
	}
	
	public Etiqueta uniqueEtiqueta() {
		return (Etiqueta) super.uniqueResult();
	}
	
	public Etiqueta[] listEtiqueta() {
		java.util.List list = super.list();
		return (Etiqueta[]) list.toArray(new Etiqueta[list.size()]);
	}
}

