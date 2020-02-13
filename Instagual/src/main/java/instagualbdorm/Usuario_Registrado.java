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
@Table(name="Usuario_Registrado")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorValue("Usuario_Registrado")
@PrimaryKeyJoinColumn(name="UsuarioIDUsuario", referencedColumnName="IDUsuario")
public class Usuario_Registrado extends instagualbdorm.Usuario implements Serializable {
	public Usuario_Registrado() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == ORMConstants.KEY_USUARIO_REGISTRADO_BLOQUEDO_POR) {
			return ORM_bloquedo_por;
		}
		else if (key == ORMConstants.KEY_USUARIO_REGISTRADO_SIGUE_A) {
			return ORM_sigue_a;
		}
		else if (key == ORMConstants.KEY_USUARIO_REGISTRADO_BLOQUEA_A) {
			return ORM_bloquea_a;
		}
		else if (key == ORMConstants.KEY_USUARIO_REGISTRADO_SEGUIDO_POR) {
			return ORM_seguido_por;
		}
		else if (key == ORMConstants.KEY_USUARIO_REGISTRADO_GUSTA) {
			return ORM_gusta;
		}
		else if (key == ORMConstants.KEY_USUARIO_REGISTRADO_COMENTA) {
			return ORM_comenta;
		}
		else if (key == ORMConstants.KEY_USUARIO_REGISTRADO_SUBE) {
			return ORM_sube;
		}
		else if (key == ORMConstants.KEY_USUARIO_REGISTRADO_MENCIONADO_EN) {
			return ORM_mencionado_en;
		}
		else if (key == ORMConstants.KEY_USUARIO_REGISTRADO_LE_GUSTA) {
			return ORM_le_gusta;
		}
		else if (key == ORMConstants.KEY_USUARIO_REGISTRADO_NOTIFICACIONES_DE) {
			return ORM_notificaciones_de;
		}
		
		return null;
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == ORMConstants.KEY_USUARIO_REGISTRADO_CONFIGURA) {
			this.configura = (instagualbdorm.Configuracion) owner;
		}
	}
	
	@Transient	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	@Column(name="Activo", nullable=false, length=1)	
	private boolean Activo;
	
	@Column(name="FotoPerfil", nullable=true, length=255)	
	private String FotoPerfil;
	
	@Column(name="Codigo", nullable=true, length=255)	
	private String Codigo;
	
	@Column(name="EsAdmin", nullable=false, length=1)	
	private boolean esAdmin;
	
	@ManyToMany(targetEntity=instagualbdorm.Usuario_Registrado.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@JoinTable(name="Usuario_Registrado_Usuario_Registrado", joinColumns={ @JoinColumn(name="Usuario_RegistradoUsuarioIDUsuario2") }, inverseJoinColumns={ @JoinColumn(name="Usuario_RegistradoUsuarioIDUsuario") })	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_bloquedo_por = new java.util.HashSet();
	
	@ManyToMany(targetEntity=instagualbdorm.Usuario_Registrado.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@JoinTable(name="Usuario_Registrado_Usuario_Registrado2", joinColumns={ @JoinColumn(name="Usuario_RegistradoUsuarioIDUsuario2") }, inverseJoinColumns={ @JoinColumn(name="Usuario_RegistradoUsuarioIDUsuario") })	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_sigue_a = new java.util.HashSet();
	
	@OneToOne(mappedBy="configurado_por", targetEntity=instagualbdorm.Configuracion.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)	
	private instagualbdorm.Configuracion configura;
	
	@ManyToMany(mappedBy="ORM_bloquedo_por", targetEntity=instagualbdorm.Usuario_Registrado.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_bloquea_a = new java.util.HashSet();
	
	@ManyToMany(mappedBy="ORM_sigue_a", targetEntity=instagualbdorm.Usuario_Registrado.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_seguido_por = new java.util.HashSet();
	
	@ManyToMany(mappedBy="ORM_gustado_por", targetEntity=instagualbdorm.Comentario.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_gusta = new java.util.HashSet();
	
	@OneToMany(mappedBy="propiedad_de", targetEntity=instagualbdorm.Comentario.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_comenta = new java.util.HashSet();
	
	@OneToMany(mappedBy="propiedad_de", targetEntity=instagualbdorm.Publicacion.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_sube = new java.util.HashSet();
	
	@ManyToMany(mappedBy="ORM_menciona_a", targetEntity=instagualbdorm.Publicacion.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_mencionado_en = new java.util.HashSet();
	
	@ManyToMany(mappedBy="ORM_gustada_por", targetEntity=instagualbdorm.Publicacion.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_le_gusta = new java.util.HashSet();
	
	@OneToMany(mappedBy="contiene_notificaciones", targetEntity=instagualbdorm.Notificacion.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_notificaciones_de = new java.util.HashSet();
	
	public void setActivo(boolean value) {
		this.Activo = value;
	}
	
	public boolean getActivo() {
		return Activo;
	}
	
	public void setFotoPerfil(String value) {
		this.FotoPerfil = value;
	}
	
	public String getFotoPerfil() {
		return FotoPerfil;
	}
	
	public void setCodigo(String value) {
		this.Codigo = value;
	}
	
	public String getCodigo() {
		return Codigo;
	}
	
	public void setEsAdmin(boolean value) {
		this.esAdmin = value;
	}
	
	public boolean getEsAdmin() {
		return esAdmin;
	}
	
	private void setORM_Bloquedo_por(java.util.Set value) {
		this.ORM_bloquedo_por = value;
	}
	
	private java.util.Set getORM_Bloquedo_por() {
		return ORM_bloquedo_por;
	}
	
	@Transient	
	public final instagualbdorm.Usuario_RegistradoSetCollection bloquedo_por = new instagualbdorm.Usuario_RegistradoSetCollection(this, _ormAdapter, ORMConstants.KEY_USUARIO_REGISTRADO_BLOQUEDO_POR, ORMConstants.KEY_USUARIO_REGISTRADO_BLOQUEA_A, ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	private void setORM_Sigue_a(java.util.Set value) {
		this.ORM_sigue_a = value;
	}
	
	private java.util.Set getORM_Sigue_a() {
		return ORM_sigue_a;
	}
	
	@Transient	
	public final instagualbdorm.Usuario_RegistradoSetCollection sigue_a = new instagualbdorm.Usuario_RegistradoSetCollection(this, _ormAdapter, ORMConstants.KEY_USUARIO_REGISTRADO_SIGUE_A, ORMConstants.KEY_USUARIO_REGISTRADO_SEGUIDO_POR, ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	public void setConfigura(instagualbdorm.Configuracion value) {
		if (this.configura != value) {
			instagualbdorm.Configuracion lconfigura = this.configura;
			this.configura = value;
			if (value != null) {
				configura.setConfigurado_por(this);
			}
			if (lconfigura != null && lconfigura.getConfigurado_por() == this) {
				lconfigura.setConfigurado_por(null);
			}
		}
	}
	
	public instagualbdorm.Configuracion getConfigura() {
		return configura;
	}
	
	private void setORM_Bloquea_a(java.util.Set value) {
		this.ORM_bloquea_a = value;
	}
	
	private java.util.Set getORM_Bloquea_a() {
		return ORM_bloquea_a;
	}
	
	@Transient	
	public final instagualbdorm.Usuario_RegistradoSetCollection bloquea_a = new instagualbdorm.Usuario_RegistradoSetCollection(this, _ormAdapter, ORMConstants.KEY_USUARIO_REGISTRADO_BLOQUEA_A, ORMConstants.KEY_USUARIO_REGISTRADO_BLOQUEDO_POR, ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	private void setORM_Seguido_por(java.util.Set value) {
		this.ORM_seguido_por = value;
	}
	
	private java.util.Set getORM_Seguido_por() {
		return ORM_seguido_por;
	}
	
	@Transient	
	public final instagualbdorm.Usuario_RegistradoSetCollection seguido_por = new instagualbdorm.Usuario_RegistradoSetCollection(this, _ormAdapter, ORMConstants.KEY_USUARIO_REGISTRADO_SEGUIDO_POR, ORMConstants.KEY_USUARIO_REGISTRADO_SIGUE_A, ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	private void setORM_Gusta(java.util.Set value) {
		this.ORM_gusta = value;
	}
	
	private java.util.Set getORM_Gusta() {
		return ORM_gusta;
	}
	
	@Transient	
	public final instagualbdorm.ComentarioSetCollection gusta = new instagualbdorm.ComentarioSetCollection(this, _ormAdapter, ORMConstants.KEY_USUARIO_REGISTRADO_GUSTA, ORMConstants.KEY_COMENTARIO_GUSTADO_POR, ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	private void setORM_Comenta(java.util.Set value) {
		this.ORM_comenta = value;
	}
	
	private java.util.Set getORM_Comenta() {
		return ORM_comenta;
	}
	
	@Transient	
	public final instagualbdorm.ComentarioSetCollection comenta = new instagualbdorm.ComentarioSetCollection(this, _ormAdapter, ORMConstants.KEY_USUARIO_REGISTRADO_COMENTA, ORMConstants.KEY_COMENTARIO_PROPIEDAD_DE, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private void setORM_Sube(java.util.Set value) {
		this.ORM_sube = value;
	}
	
	private java.util.Set getORM_Sube() {
		return ORM_sube;
	}
	
	@Transient	
	public final instagualbdorm.PublicacionSetCollection sube = new instagualbdorm.PublicacionSetCollection(this, _ormAdapter, ORMConstants.KEY_USUARIO_REGISTRADO_SUBE, ORMConstants.KEY_PUBLICACION_PROPIEDAD_DE, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	private void setORM_Mencionado_en(java.util.Set value) {
		this.ORM_mencionado_en = value;
	}
	
	private java.util.Set getORM_Mencionado_en() {
		return ORM_mencionado_en;
	}
	
	@Transient	
	public final instagualbdorm.PublicacionSetCollection mencionado_en = new instagualbdorm.PublicacionSetCollection(this, _ormAdapter, ORMConstants.KEY_USUARIO_REGISTRADO_MENCIONADO_EN, ORMConstants.KEY_PUBLICACION_MENCIONA_A, ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	private void setORM_Le_gusta(java.util.Set value) {
		this.ORM_le_gusta = value;
	}
	
	private java.util.Set getORM_Le_gusta() {
		return ORM_le_gusta;
	}
	
	@Transient	
	public final instagualbdorm.PublicacionSetCollection le_gusta = new instagualbdorm.PublicacionSetCollection(this, _ormAdapter, ORMConstants.KEY_USUARIO_REGISTRADO_LE_GUSTA, ORMConstants.KEY_PUBLICACION_GUSTADA_POR, ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	private void setORM_Notificaciones_de(java.util.Set value) {
		this.ORM_notificaciones_de = value;
	}
	
	private java.util.Set getORM_Notificaciones_de() {
		return ORM_notificaciones_de;
	}
	
	@Transient	
	public final instagualbdorm.NotificacionSetCollection notificaciones_de = new instagualbdorm.NotificacionSetCollection(this, _ormAdapter, ORMConstants.KEY_USUARIO_REGISTRADO_NOTIFICACIONES_DE, ORMConstants.KEY_NOTIFICACION_CONTIENE_NOTIFICACIONES, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return super.toString();
	}
	
}
