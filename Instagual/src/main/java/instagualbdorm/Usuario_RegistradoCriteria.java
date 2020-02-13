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

public class Usuario_RegistradoCriteria extends AbstractORMCriteria {
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
	
	public Usuario_RegistradoCriteria(Criteria criteria) {
		super(criteria);
		IDUsuario = new IntegerExpression("IDUsuario", this);
		correo = new StringExpression("correo", this);
		password = new StringExpression("password", this);
		nombre = new StringExpression("nombre", this);
		apellido = new StringExpression("apellido", this);
		nombreUsuario = new StringExpression("nombreUsuario", this);
		Activo = new BooleanExpression("Activo", this);
		FotoPerfil = new StringExpression("FotoPerfil", this);
		Codigo = new StringExpression("Codigo", this);
		esAdmin = new BooleanExpression("esAdmin", this);
		bloquedo_por = new CollectionExpression("ORM_bloquedo_por", this);
		sigue_a = new CollectionExpression("ORM_sigue_a", this);
		configuraId = new IntegerExpression("configura.", this);
		configura = new AssociationExpression("configura", this);
		bloquea_a = new CollectionExpression("ORM_bloquea_a", this);
		seguido_por = new CollectionExpression("ORM_seguido_por", this);
		gusta = new CollectionExpression("ORM_gusta", this);
		comenta = new CollectionExpression("ORM_comenta", this);
		sube = new CollectionExpression("ORM_sube", this);
		mencionado_en = new CollectionExpression("ORM_mencionado_en", this);
		le_gusta = new CollectionExpression("ORM_le_gusta", this);
		notificaciones_de = new CollectionExpression("ORM_notificaciones_de", this);
	}
	
	public Usuario_RegistradoCriteria(PersistentSession session) {
		this(session.createCriteria(Usuario_Registrado.class));
	}
	
	public Usuario_RegistradoCriteria() throws PersistentException {
		this(ProyectoInstagualPersistentManager.instance().getSession());
	}
	
	public Usuario_RegistradoCriteria createBloquedo_porCriteria() {
		return new Usuario_RegistradoCriteria(createCriteria("ORM_bloquedo_por"));
	}
	
	public Usuario_RegistradoCriteria createSigue_aCriteria() {
		return new Usuario_RegistradoCriteria(createCriteria("ORM_sigue_a"));
	}
	
	public ConfiguracionCriteria createConfiguraCriteria() {
		return new ConfiguracionCriteria(createCriteria("configura"));
	}
	
	public Usuario_RegistradoCriteria createBloquea_aCriteria() {
		return new Usuario_RegistradoCriteria(createCriteria("ORM_bloquea_a"));
	}
	
	public Usuario_RegistradoCriteria createSeguido_porCriteria() {
		return new Usuario_RegistradoCriteria(createCriteria("ORM_seguido_por"));
	}
	
	public ComentarioCriteria createGustaCriteria() {
		return new ComentarioCriteria(createCriteria("ORM_gusta"));
	}
	
	public ComentarioCriteria createComentaCriteria() {
		return new ComentarioCriteria(createCriteria("ORM_comenta"));
	}
	
	public PublicacionCriteria createSubeCriteria() {
		return new PublicacionCriteria(createCriteria("ORM_sube"));
	}
	
	public PublicacionCriteria createMencionado_enCriteria() {
		return new PublicacionCriteria(createCriteria("ORM_mencionado_en"));
	}
	
	public PublicacionCriteria createLe_gustaCriteria() {
		return new PublicacionCriteria(createCriteria("ORM_le_gusta"));
	}
	
	public NotificacionCriteria createNotificaciones_deCriteria() {
		return new NotificacionCriteria(createCriteria("ORM_notificaciones_de"));
	}
	
	public Usuario_Registrado uniqueUsuario_Registrado() {
		return (Usuario_Registrado) super.uniqueResult();
	}
	
	public Usuario_Registrado[] listUsuario_Registrado() {
		java.util.List list = super.list();
		return (Usuario_Registrado[]) list.toArray(new Usuario_Registrado[list.size()]);
	}
}

