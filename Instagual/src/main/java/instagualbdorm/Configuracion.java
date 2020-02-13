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

import java.io.Serializable;
import javax.persistence.*;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="Configuracion")
public class Configuracion implements Serializable {
	public Configuracion() {
	}
	
	@Column(name="IDConfiguracion", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="INSTAGUALBDORM_CONFIGURACION_IDCONFIGURACION_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="INSTAGUALBDORM_CONFIGURACION_IDCONFIGURACION_GENERATOR", strategy="native")	
	private int IDConfiguracion;
	
	@OneToOne(optional=false, targetEntity=instagualbdorm.Usuario_Registrado.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="Usuario_RegistradoUsuarioIDUsuario", referencedColumnName="UsuarioIDUsuario", nullable=false) })	
	@org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)	
	private instagualbdorm.Usuario_Registrado configurado_por;
	
	@Column(name="PerfilPrivado", nullable=false, length=1)	
	private boolean perfilPrivado;
	
	@Column(name="OcultosSeguidoresSeguidos", nullable=false, length=1)	
	private boolean OcultosSeguidoresSeguidos;
	
	@Column(name="NotificacionesTodas", nullable=false, length=1)	
	private boolean notificacionesTodas;
	
	@Column(name="NotificacionesMeGusta", nullable=false, length=1)	
	private boolean notificacionesMeGusta;
	
	@Column(name="NotificacionesComentarios", nullable=false, length=1)	
	private boolean notificacionesComentarios;
	
	@Column(name="NotificacionesSeguir", nullable=false, length=1)	
	private boolean notificacionesSeguir;
	
	@Column(name="NotificacionesEliminacionPublicacion", nullable=false, length=1)	
	private boolean notificacionesEliminacionPublicacion;
	
	private void setIDConfiguracion(int value) {
		this.IDConfiguracion = value;
	}
	
	public int getIDConfiguracion() {
		return IDConfiguracion;
	}
	
	public int getORMID() {
		return getIDConfiguracion();
	}
	
	public void setPerfilPrivado(boolean value) {
		this.perfilPrivado = value;
	}
	
	public boolean getPerfilPrivado() {
		return perfilPrivado;
	}
	
	public void setOcultosSeguidoresSeguidos(boolean value) {
		this.OcultosSeguidoresSeguidos = value;
	}
	
	public boolean getOcultosSeguidoresSeguidos() {
		return OcultosSeguidoresSeguidos;
	}
	
	public void setNotificacionesTodas(boolean value) {
		this.notificacionesTodas = value;
	}
	
	public boolean getNotificacionesTodas() {
		return notificacionesTodas;
	}
	
	public void setNotificacionesMeGusta(boolean value) {
		this.notificacionesMeGusta = value;
	}
	
	public boolean getNotificacionesMeGusta() {
		return notificacionesMeGusta;
	}
	
	public void setNotificacionesComentarios(boolean value) {
		this.notificacionesComentarios = value;
	}
	
	public boolean getNotificacionesComentarios() {
		return notificacionesComentarios;
	}
	
	public void setNotificacionesSeguir(boolean value) {
		this.notificacionesSeguir = value;
	}
	
	public boolean getNotificacionesSeguir() {
		return notificacionesSeguir;
	}
	
	public void setNotificacionesEliminacionPublicacion(boolean value) {
		this.notificacionesEliminacionPublicacion = value;
	}
	
	public boolean getNotificacionesEliminacionPublicacion() {
		return notificacionesEliminacionPublicacion;
	}
	
	public void setConfigurado_por(instagualbdorm.Usuario_Registrado value) {
		if (this.configurado_por != value) {
			instagualbdorm.Usuario_Registrado lconfigurado_por = this.configurado_por;
			this.configurado_por = value;
			if (value != null) {
				configurado_por.setConfigura(this);
			}
			if (lconfigurado_por != null && lconfigurado_por.getConfigura() == this) {
				lconfigurado_por.setConfigura(null);
			}
		}
	}
	
	public instagualbdorm.Usuario_Registrado getConfigurado_por() {
		return configurado_por;
	}
	
	public String toString() {
		return String.valueOf(getIDConfiguracion());
	}
	
}
