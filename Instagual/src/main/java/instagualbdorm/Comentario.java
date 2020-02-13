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
@Table(name="Comentario")
public class Comentario implements Serializable {
	public Comentario() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == ORMConstants.KEY_COMENTARIO_GUSTADO_POR) {
			return ORM_gustado_por;
		}
		
		return null;
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == ORMConstants.KEY_COMENTARIO_PROPIEDAD_DE) {
			this.propiedad_de = (instagualbdorm.Usuario_Registrado) owner;
		}
		
		else if (key == ORMConstants.KEY_COMENTARIO_CONTENIDO_EN) {
			this.contenido_en = (instagualbdorm.Publicacion) owner;
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
	
	@Column(name="IDComentario", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="INSTAGUALBDORM_COMENTARIO_IDCOMENTARIO_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="INSTAGUALBDORM_COMENTARIO_IDCOMENTARIO_GENERATOR", strategy="native")	
	private int IDComentario;
	
	@ManyToOne(targetEntity=instagualbdorm.Publicacion.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="PublicacionIDpublicacion", referencedColumnName="IDpublicacion", nullable=false) })	
	@org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)	
	private instagualbdorm.Publicacion contenido_en;
	
	@ManyToMany(targetEntity=instagualbdorm.Usuario_Registrado.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@JoinTable(name="Usuario_Registrado_Comentario", joinColumns={ @JoinColumn(name="ComentarioIDComentario") }, inverseJoinColumns={ @JoinColumn(name="Usuario_RegistradoUsuarioIDUsuario") })	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_gustado_por = new java.util.HashSet();
	
	@Column(name="Comentario", nullable=true, length=255)	
	private String comentario;
	
	@Column(name="NombreUsuario", nullable=true, length=255)	
	private String nombreUsuario;
	
	@ManyToOne(targetEntity=instagualbdorm.Usuario_Registrado.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="Usuario_RegistradoUsuarioIDUsuario", referencedColumnName="UsuarioIDUsuario", nullable=false) })	
	@org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)	
	private instagualbdorm.Usuario_Registrado propiedad_de;
	
	private void setIDComentario(int value) {
		this.IDComentario = value;
	}
	
	public int getIDComentario() {
		return IDComentario;
	}
	
	public int getORMID() {
		return getIDComentario();
	}
	
	public void setComentario(String value) {
		this.comentario = value;
	}
	
	public String getComentario() {
		return comentario;
	}
	
	public void setNombreUsuario(String value) {
		this.nombreUsuario = value;
	}
	
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	
	private void setORM_Gustado_por(java.util.Set value) {
		this.ORM_gustado_por = value;
	}
	
	private java.util.Set getORM_Gustado_por() {
		return ORM_gustado_por;
	}
	
	@Transient	
	public final instagualbdorm.Usuario_RegistradoSetCollection gustado_por = new instagualbdorm.Usuario_RegistradoSetCollection(this, _ormAdapter, ORMConstants.KEY_COMENTARIO_GUSTADO_POR, ORMConstants.KEY_USUARIO_REGISTRADO_GUSTA, ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	public void setPropiedad_de(instagualbdorm.Usuario_Registrado value) {
		if (propiedad_de != null) {
			propiedad_de.comenta.remove(this);
		}
		if (value != null) {
			value.comenta.add(this);
		}
	}
	
	public instagualbdorm.Usuario_Registrado getPropiedad_de() {
		return propiedad_de;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Propiedad_de(instagualbdorm.Usuario_Registrado value) {
		this.propiedad_de = value;
	}
	
	private instagualbdorm.Usuario_Registrado getORM_Propiedad_de() {
		return propiedad_de;
	}
	
	public void setContenido_en(instagualbdorm.Publicacion value) {
		if (contenido_en != null) {
			contenido_en.contiene_a.remove(this);
		}
		if (value != null) {
			value.contiene_a.add(this);
		}
	}
	
	public instagualbdorm.Publicacion getContenido_en() {
		return contenido_en;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Contenido_en(instagualbdorm.Publicacion value) {
		this.contenido_en = value;
	}
	
	private instagualbdorm.Publicacion getORM_Contenido_en() {
		return contenido_en;
	}
	
	public String toString() {
		return String.valueOf(getIDComentario());
	}
	
}
