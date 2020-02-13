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

public class PublicacionDetachedCriteria extends AbstractORMDetachedCriteria {
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
	
	public PublicacionDetachedCriteria() {
		super(instagualbdorm.Publicacion.class, instagualbdorm.PublicacionCriteria.class);
		IDpublicacion = new IntegerExpression("IDpublicacion", this.getDetachedCriteria());
		propiedad_deId = new IntegerExpression("propiedad_de.", this.getDetachedCriteria());
		propiedad_de = new AssociationExpression("propiedad_de", this.getDetachedCriteria());
		tieneId = new IntegerExpression("tiene.IDEtiqueta", this.getDetachedCriteria());
		tiene = new AssociationExpression("tiene", this.getDetachedCriteria());
		descripcion = new StringExpression("descripcion", this.getDetachedCriteria());
		imagenPreview = new StringExpression("imagenPreview", this.getDetachedCriteria());
		contiene_a = new CollectionExpression("ORM_contiene_a", this.getDetachedCriteria());
		menciona_a = new CollectionExpression("ORM_menciona_a", this.getDetachedCriteria());
		gustada_por = new CollectionExpression("ORM_gustada_por", this.getDetachedCriteria());
		contiene = new CollectionExpression("ORM_contiene", this.getDetachedCriteria());
	}
	
	public PublicacionDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, instagualbdorm.PublicacionCriteria.class);
		IDpublicacion = new IntegerExpression("IDpublicacion", this.getDetachedCriteria());
		propiedad_deId = new IntegerExpression("propiedad_de.", this.getDetachedCriteria());
		propiedad_de = new AssociationExpression("propiedad_de", this.getDetachedCriteria());
		tieneId = new IntegerExpression("tiene.IDEtiqueta", this.getDetachedCriteria());
		tiene = new AssociationExpression("tiene", this.getDetachedCriteria());
		descripcion = new StringExpression("descripcion", this.getDetachedCriteria());
		imagenPreview = new StringExpression("imagenPreview", this.getDetachedCriteria());
		contiene_a = new CollectionExpression("ORM_contiene_a", this.getDetachedCriteria());
		menciona_a = new CollectionExpression("ORM_menciona_a", this.getDetachedCriteria());
		gustada_por = new CollectionExpression("ORM_gustada_por", this.getDetachedCriteria());
		contiene = new CollectionExpression("ORM_contiene", this.getDetachedCriteria());
	}
	
	public Usuario_RegistradoDetachedCriteria createPropiedad_deCriteria() {
		return new Usuario_RegistradoDetachedCriteria(createCriteria("propiedad_de"));
	}
	
	public EtiquetaDetachedCriteria createTieneCriteria() {
		return new EtiquetaDetachedCriteria(createCriteria("tiene"));
	}
	
	public ComentarioDetachedCriteria createContiene_aCriteria() {
		return new ComentarioDetachedCriteria(createCriteria("ORM_contiene_a"));
	}
	
	public Usuario_RegistradoDetachedCriteria createMenciona_aCriteria() {
		return new Usuario_RegistradoDetachedCriteria(createCriteria("ORM_menciona_a"));
	}
	
	public Usuario_RegistradoDetachedCriteria createGustada_porCriteria() {
		return new Usuario_RegistradoDetachedCriteria(createCriteria("ORM_gustada_por"));
	}
	
	public ElementoDetachedCriteria createContieneCriteria() {
		return new ElementoDetachedCriteria(createCriteria("ORM_contiene"));
	}
	
	public Publicacion uniquePublicacion(PersistentSession session) {
		return (Publicacion) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Publicacion[] listPublicacion(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Publicacion[]) list.toArray(new Publicacion[list.size()]);
	}
}

