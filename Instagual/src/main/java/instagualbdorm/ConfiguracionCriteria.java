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

public class ConfiguracionCriteria extends AbstractORMCriteria {
	public final IntegerExpression IDConfiguracion;
	public final IntegerExpression configurado_porId;
	public final AssociationExpression configurado_por;
	public final BooleanExpression perfilPrivado;
	public final BooleanExpression OcultosSeguidoresSeguidos;
	public final BooleanExpression notificacionesTodas;
	public final BooleanExpression notificacionesMeGusta;
	public final BooleanExpression notificacionesComentarios;
	public final BooleanExpression notificacionesSeguir;
	public final BooleanExpression notificacionesEliminacionPublicacion;
	
	public ConfiguracionCriteria(Criteria criteria) {
		super(criteria);
		IDConfiguracion = new IntegerExpression("IDConfiguracion", this);
		configurado_porId = new IntegerExpression("configurado_por.", this);
		configurado_por = new AssociationExpression("configurado_por", this);
		perfilPrivado = new BooleanExpression("perfilPrivado", this);
		OcultosSeguidoresSeguidos = new BooleanExpression("OcultosSeguidoresSeguidos", this);
		notificacionesTodas = new BooleanExpression("notificacionesTodas", this);
		notificacionesMeGusta = new BooleanExpression("notificacionesMeGusta", this);
		notificacionesComentarios = new BooleanExpression("notificacionesComentarios", this);
		notificacionesSeguir = new BooleanExpression("notificacionesSeguir", this);
		notificacionesEliminacionPublicacion = new BooleanExpression("notificacionesEliminacionPublicacion", this);
	}
	
	public ConfiguracionCriteria(PersistentSession session) {
		this(session.createCriteria(Configuracion.class));
	}
	
	public ConfiguracionCriteria() throws PersistentException {
		this(ProyectoInstagualPersistentManager.instance().getSession());
	}
	
	public Usuario_RegistradoCriteria createConfigurado_porCriteria() {
		return new Usuario_RegistradoCriteria(createCriteria("configurado_por"));
	}
	
	public Configuracion uniqueConfiguracion() {
		return (Configuracion) super.uniqueResult();
	}
	
	public Configuracion[] listConfiguracion() {
		java.util.List list = super.list();
		return (Configuracion[]) list.toArray(new Configuracion[list.size()]);
	}
}

