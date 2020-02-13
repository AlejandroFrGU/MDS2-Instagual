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

public class PublicacionCriteria extends AbstractORMCriteria {
	public final IntegerExpression IDpublicacion;
	public final IntegerExpression propiedad_deId;
	public final AssociationExpression propiedad_de;
	public final IntegerExpression tieneId;
	public final AssociationExpression tiene;
	public final StringExpression descripcion;
	public final StringExpression imagenPreview;
	public final CollectionExpression contiene_a;
	public final CollectionExpression menciona_a;
	public final CollectionExpression gustada_por;
	public final CollectionExpression contiene;
	
	public PublicacionCriteria(Criteria criteria) {
		super(criteria);
		IDpublicacion = new IntegerExpression("IDpublicacion", this);
		propiedad_deId = new IntegerExpression("propiedad_de.", this);
		propiedad_de = new AssociationExpression("propiedad_de", this);
		tieneId = new IntegerExpression("tiene.IDEtiqueta", this);
		tiene = new AssociationExpression("tiene", this);
		descripcion = new StringExpression("descripcion", this);
		imagenPreview = new StringExpression("imagenPreview", this);
		contiene_a = new CollectionExpression("ORM_contiene_a", this);
		menciona_a = new CollectionExpression("ORM_menciona_a", this);
		gustada_por = new CollectionExpression("ORM_gustada_por", this);
		contiene = new CollectionExpression("ORM_contiene", this);
	}
	
	public PublicacionCriteria(PersistentSession session) {
		this(session.createCriteria(Publicacion.class));
	}
	
	public PublicacionCriteria() throws PersistentException {
		this(ProyectoInstagualPersistentManager.instance().getSession());
	}
	
	public Usuario_RegistradoCriteria createPropiedad_deCriteria() {
		return new Usuario_RegistradoCriteria(createCriteria("propiedad_de"));
	}
	
	public EtiquetaCriteria createTieneCriteria() {
		return new EtiquetaCriteria(createCriteria("tiene"));
	}
	
	public ComentarioCriteria createContiene_aCriteria() {
		return new ComentarioCriteria(createCriteria("ORM_contiene_a"));
	}
	
	public Usuario_RegistradoCriteria createMenciona_aCriteria() {
		return new Usuario_RegistradoCriteria(createCriteria("ORM_menciona_a"));
	}
	
	public Usuario_RegistradoCriteria createGustada_porCriteria() {
		return new Usuario_RegistradoCriteria(createCriteria("ORM_gustada_por"));
	}
	
	public ElementoCriteria createContieneCriteria() {
		return new ElementoCriteria(createCriteria("ORM_contiene"));
	}
	
	public Publicacion uniquePublicacion() {
		return (Publicacion) super.uniqueResult();
	}
	
	public Publicacion[] listPublicacion() {
		java.util.List list = super.list();
		return (Publicacion[]) list.toArray(new Publicacion[list.size()]);
	}
}

