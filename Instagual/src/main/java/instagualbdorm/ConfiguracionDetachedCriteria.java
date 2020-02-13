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

public class ConfiguracionDetachedCriteria extends AbstractORMDetachedCriteria {
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
	
	public ConfiguracionDetachedCriteria() {
		super(instagualbdorm.Configuracion.class, instagualbdorm.ConfiguracionCriteria.class);
		IDConfiguracion = new IntegerExpression("IDConfiguracion", this.getDetachedCriteria());
		configurado_porId = new IntegerExpression("configurado_por.", this.getDetachedCriteria());
		configurado_por = new AssociationExpression("configurado_por", this.getDetachedCriteria());
		perfilPrivado = new BooleanExpression("perfilPrivado", this.getDetachedCriteria());
		OcultosSeguidoresSeguidos = new BooleanExpression("OcultosSeguidoresSeguidos", this.getDetachedCriteria());
		notificacionesTodas = new BooleanExpression("notificacionesTodas", this.getDetachedCriteria());
		notificacionesMeGusta = new BooleanExpression("notificacionesMeGusta", this.getDetachedCriteria());
		notificacionesComentarios = new BooleanExpression("notificacionesComentarios", this.getDetachedCriteria());
		notificacionesSeguir = new BooleanExpression("notificacionesSeguir", this.getDetachedCriteria());
		notificacionesEliminacionPublicacion = new BooleanExpression("notificacionesEliminacionPublicacion", this.getDetachedCriteria());
	}
	
	public ConfiguracionDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, instagualbdorm.ConfiguracionCriteria.class);
		IDConfiguracion = new IntegerExpression("IDConfiguracion", this.getDetachedCriteria());
		configurado_porId = new IntegerExpression("configurado_por.", this.getDetachedCriteria());
		configurado_por = new AssociationExpression("configurado_por", this.getDetachedCriteria());
		perfilPrivado = new BooleanExpression("perfilPrivado", this.getDetachedCriteria());
		OcultosSeguidoresSeguidos = new BooleanExpression("OcultosSeguidoresSeguidos", this.getDetachedCriteria());
		notificacionesTodas = new BooleanExpression("notificacionesTodas", this.getDetachedCriteria());
		notificacionesMeGusta = new BooleanExpression("notificacionesMeGusta", this.getDetachedCriteria());
		notificacionesComentarios = new BooleanExpression("notificacionesComentarios", this.getDetachedCriteria());
		notificacionesSeguir = new BooleanExpression("notificacionesSeguir", this.getDetachedCriteria());
		notificacionesEliminacionPublicacion = new BooleanExpression("notificacionesEliminacionPublicacion", this.getDetachedCriteria());
	}
	
	public Usuario_RegistradoDetachedCriteria createConfigurado_porCriteria() {
		return new Usuario_RegistradoDetachedCriteria(createCriteria("configurado_por"));
	}
	
	public Configuracion uniqueConfiguracion(PersistentSession session) {
		return (Configuracion) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Configuracion[] listConfiguracion(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Configuracion[]) list.toArray(new Configuracion[list.size()]);
	}
}

