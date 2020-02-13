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

public class Usuario_RegistradoDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression IDUsuario;
	public final StringExpression correo;
	public final StringExpression password;
	public final StringExpression nombre;
	public final StringExpression apellido;
	public final StringExpression nombreUsuario;
	public final BooleanExpression Activo;
	public final StringExpression FotoPerfil;
	public final StringExpression Codigo;
	public final BooleanExpression esAdmin;
	public final CollectionExpression bloquedo_por;
	public final CollectionExpression sigue_a;
	public final IntegerExpression configuraId;
	public final AssociationExpression configura;
	public final CollectionExpression bloquea_a;
	public final CollectionExpression seguido_por;
	public final CollectionExpression gusta;
	public final CollectionExpression comenta;
	public final CollectionExpression sube;
	public final CollectionExpression mencionado_en;
	public final CollectionExpression le_gusta;
	public final CollectionExpression notificaciones_de;
	
	public Usuario_RegistradoDetachedCriteria() {
		super(instagualbdorm.Usuario_Registrado.class, instagualbdorm.Usuario_RegistradoCriteria.class);
		IDUsuario = new IntegerExpression("IDUsuario", this.getDetachedCriteria());
		correo = new StringExpression("correo", this.getDetachedCriteria());
		password = new StringExpression("password", this.getDetachedCriteria());
		nombre = new StringExpression("nombre", this.getDetachedCriteria());
		apellido = new StringExpression("apellido", this.getDetachedCriteria());
		nombreUsuario = new StringExpression("nombreUsuario", this.getDetachedCriteria());
		Activo = new BooleanExpression("Activo", this.getDetachedCriteria());
		FotoPerfil = new StringExpression("FotoPerfil", this.getDetachedCriteria());
		Codigo = new StringExpression("Codigo", this.getDetachedCriteria());
		esAdmin = new BooleanExpression("esAdmin", this.getDetachedCriteria());
		bloquedo_por = new CollectionExpression("ORM_bloquedo_por", this.getDetachedCriteria());
		sigue_a = new CollectionExpression("ORM_sigue_a", this.getDetachedCriteria());
		configuraId = new IntegerExpression("configura.", this.getDetachedCriteria());
		configura = new AssociationExpression("configura", this.getDetachedCriteria());
		bloquea_a = new CollectionExpression("ORM_bloquea_a", this.getDetachedCriteria());
		seguido_por = new CollectionExpression("ORM_seguido_por", this.getDetachedCriteria());
		gusta = new CollectionExpression("ORM_gusta", this.getDetachedCriteria());
		comenta = new CollectionExpression("ORM_comenta", this.getDetachedCriteria());
		sube = new CollectionExpression("ORM_sube", this.getDetachedCriteria());
		mencionado_en = new CollectionExpression("ORM_mencionado_en", this.getDetachedCriteria());
		le_gusta = new CollectionExpression("ORM_le_gusta", this.getDetachedCriteria());
		notificaciones_de = new CollectionExpression("ORM_notificaciones_de", this.getDetachedCriteria());
	}
	
	public Usuario_RegistradoDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, instagualbdorm.Usuario_RegistradoCriteria.class);
		IDUsuario = new IntegerExpression("IDUsuario", this.getDetachedCriteria());
		correo = new StringExpression("correo", this.getDetachedCriteria());
		password = new StringExpression("password", this.getDetachedCriteria());
		nombre = new StringExpression("nombre", this.getDetachedCriteria());
		apellido = new StringExpression("apellido", this.getDetachedCriteria());
		nombreUsuario = new StringExpression("nombreUsuario", this.getDetachedCriteria());
		Activo = new BooleanExpression("Activo", this.getDetachedCriteria());
		FotoPerfil = new StringExpression("FotoPerfil", this.getDetachedCriteria());
		Codigo = new StringExpression("Codigo", this.getDetachedCriteria());
		esAdmin = new BooleanExpression("esAdmin", this.getDetachedCriteria());
		bloquedo_por = new CollectionExpression("ORM_bloquedo_por", this.getDetachedCriteria());
		sigue_a = new CollectionExpression("ORM_sigue_a", this.getDetachedCriteria());
		configuraId = new IntegerExpression("configura.", this.getDetachedCriteria());
		configura = new AssociationExpression("configura", this.getDetachedCriteria());
		bloquea_a = new CollectionExpression("ORM_bloquea_a", this.getDetachedCriteria());
		seguido_por = new CollectionExpression("ORM_seguido_por", this.getDetachedCriteria());
		gusta = new CollectionExpression("ORM_gusta", this.getDetachedCriteria());
		comenta = new CollectionExpression("ORM_comenta", this.getDetachedCriteria());
		sube = new CollectionExpression("ORM_sube", this.getDetachedCriteria());
		mencionado_en = new CollectionExpression("ORM_mencionado_en", this.getDetachedCriteria());
		le_gusta = new CollectionExpression("ORM_le_gusta", this.getDetachedCriteria());
		notificaciones_de = new CollectionExpression("ORM_notificaciones_de", this.getDetachedCriteria());
	}
	
	public Usuario_RegistradoDetachedCriteria createBloquedo_porCriteria() {
		return new Usuario_RegistradoDetachedCriteria(createCriteria("ORM_bloquedo_por"));
	}
	
	public Usuario_RegistradoDetachedCriteria createSigue_aCriteria() {
		return new Usuario_RegistradoDetachedCriteria(createCriteria("ORM_sigue_a"));
	}
	
	public ConfiguracionDetachedCriteria createConfiguraCriteria() {
		return new ConfiguracionDetachedCriteria(createCriteria("configura"));
	}
	
	public Usuario_RegistradoDetachedCriteria createBloquea_aCriteria() {
		return new Usuario_RegistradoDetachedCriteria(createCriteria("ORM_bloquea_a"));
	}
	
	public Usuario_RegistradoDetachedCriteria createSeguido_porCriteria() {
		return new Usuario_RegistradoDetachedCriteria(createCriteria("ORM_seguido_por"));
	}
	
	public ComentarioDetachedCriteria createGustaCriteria() {
		return new ComentarioDetachedCriteria(createCriteria("ORM_gusta"));
	}
	
	public ComentarioDetachedCriteria createComentaCriteria() {
		return new ComentarioDetachedCriteria(createCriteria("ORM_comenta"));
	}
	
	public PublicacionDetachedCriteria createSubeCriteria() {
		return new PublicacionDetachedCriteria(createCriteria("ORM_sube"));
	}
	
	public PublicacionDetachedCriteria createMencionado_enCriteria() {
		return new PublicacionDetachedCriteria(createCriteria("ORM_mencionado_en"));
	}
	
	public PublicacionDetachedCriteria createLe_gustaCriteria() {
		return new PublicacionDetachedCriteria(createCriteria("ORM_le_gusta"));
	}
	
	public NotificacionDetachedCriteria createNotificaciones_deCriteria() {
		return new NotificacionDetachedCriteria(createCriteria("ORM_notificaciones_de"));
	}
	
	public Usuario_Registrado uniqueUsuario_Registrado(PersistentSession session) {
		return (Usuario_Registrado) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Usuario_Registrado[] listUsuario_Registrado(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Usuario_Registrado[]) list.toArray(new Usuario_Registrado[list.size()]);
	}
}

