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
@Table(name="Publicacion")
public class Publicacion implements Serializable {
	public Publicacion() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == ORMConstants.KEY_PUBLICACION_CONTIENE_A) {
			return ORM_contiene_a;
		}
		else if (key == ORMConstants.KEY_PUBLICACION_MENCIONA_A) {
			return ORM_menciona_a;
		}
		else if (key == ORMConstants.KEY_PUBLICACION_GUSTADA_POR) {
			return ORM_gustada_por;
		}
		else if (key == ORMConstants.KEY_PUBLICACION_CONTIENE) {
			return ORM_contiene;
		}
		
		return null;
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == ORMConstants.KEY_PUBLICACION_TIENE) {
			this.tiene = (instagualbdorm.Etiqueta) owner;
		}
		
		else if (key == ORMConstants.KEY_PUBLICACION_PROPIEDAD_DE) {
			this.propiedad_de = (instagualbdorm.Usuario_Registrado) owner;
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
	
	@Column(name="IDpublicacion", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="INSTAGUALBDORM_PUBLICACION_IDPUBLICACION_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="INSTAGUALBDORM_PUBLICACION_IDPUBLICACION_GENERATOR", strategy="native")	
	private int IDpublicacion;
	
	@ManyToOne(targetEntity=instagualbdorm.Usuario_Registrado.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="Usuario_RegistradoUsuarioIDUsuario", referencedColumnName="UsuarioIDUsuario", nullable=false) })	
	@org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)	
	private instagualbdorm.Usuario_Registrado propiedad_de;
	
	@ManyToOne(targetEntity=instagualbdorm.Etiqueta.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="EtiquetaIDEtiqueta", referencedColumnName="IDEtiqueta", nullable=false) })	
	@org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)	
	private instagualbdorm.Etiqueta tiene;
	
	@Column(name="Descripcion", nullable=true, length=255)	
	private String descripcion;
	
	@Column(name="ImagenPreview", nullable=true, length=255)	
	private String imagenPreview;
	
	@OneToMany(mappedBy="contenido_en", targetEntity=instagualbdorm.Comentario.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_contiene_a = new java.util.HashSet();
	
	@ManyToMany(targetEntity=instagualbdorm.Usuario_Registrado.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@JoinTable(name="Usuario_Registrado_Publicacion", joinColumns={ @JoinColumn(name="PublicacionIDpublicacion") }, inverseJoinColumns={ @JoinColumn(name="Usuario_RegistradoUsuarioIDUsuario") })	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_menciona_a = new java.util.HashSet();
	
	@ManyToMany(targetEntity=instagualbdorm.Usuario_Registrado.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@JoinTable(name="Usuario_Registrado_Publicacion2", joinColumns={ @JoinColumn(name="PublicacionIDpublicacion") }, inverseJoinColumns={ @JoinColumn(name="Usuario_RegistradoUsuarioIDUsuario") })	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_gustada_por = new java.util.HashSet();
	
	@OneToMany(mappedBy="contenido_en", targetEntity=instagualbdorm.Elemento.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_contiene = new java.util.HashSet();
	
	private void setIDpublicacion(int value) {
		this.IDpublicacion = value;
	}
	
	public int getIDpublicacion() {
		return IDpublicacion;
	}
	
	public int getORMID() {
		return getIDpublicacion();
	}
	
	public void setDescripcion(String value) {
		this.descripcion = value;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setImagenPreview(String value) {
		this.imagenPreview = value;
	}
	
	public String getImagenPreview() {
		return imagenPreview;
	}
	
	public void setTiene(instagualbdorm.Etiqueta value) {
		if (tiene != null) {
			tiene.esta_en.remove(this);
		}
		if (value != null) {
			value.esta_en.add(this);
		}
	}
	
	public instagualbdorm.Etiqueta getTiene() {
		return tiene;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Tiene(instagualbdorm.Etiqueta value) {
		this.tiene = value;
	}
	
	private instagualbdorm.Etiqueta getORM_Tiene() {
		return tiene;
	}
	
	private void setORM_Contiene_a(java.util.Set value) {
		this.ORM_contiene_a = value;
	}
	
	private java.util.Set getORM_Contiene_a() {
		return ORM_contiene_a;
	}
	
	@Transient	
	public final instagualbdorm.ComentarioSetCollection contiene_a = new instagualbdorm.ComentarioSetCollection(this, _ormAdapter, ORMConstants.KEY_PUBLICACION_CONTIENE_A, ORMConstants.KEY_COMENTARIO_CONTENIDO_EN, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public void setPropiedad_de(instagualbdorm.Usuario_Registrado value) {
		if (propiedad_de != null) {
			propiedad_de.sube.remove(this);
		}
		if (value != null) {
			value.sube.add(this);
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
	
	private void setORM_Menciona_a(java.util.Set value) {
		this.ORM_menciona_a = value;
	}
	
	private java.util.Set getORM_Menciona_a() {
		return ORM_menciona_a;
	}
	
	@Transient	
	public final instagualbdorm.Usuario_RegistradoSetCollection menciona_a = new instagualbdorm.Usuario_RegistradoSetCollection(this, _ormAdapter, ORMConstants.KEY_PUBLICACION_MENCIONA_A, ORMConstants.KEY_USUARIO_REGISTRADO_MENCIONADO_EN, ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	private void setORM_Gustada_por(java.util.Set value) {
		this.ORM_gustada_por = value;
	}
	
	private java.util.Set getORM_Gustada_por() {
		return ORM_gustada_por;
	}
	
	@Transient	
	public final instagualbdorm.Usuario_RegistradoSetCollection gustada_por = new instagualbdorm.Usuario_RegistradoSetCollection(this, _ormAdapter, ORMConstants.KEY_PUBLICACION_GUSTADA_POR, ORMConstants.KEY_USUARIO_REGISTRADO_LE_GUSTA, ORMConstants.KEY_MUL_MANY_TO_MANY);
	
	private void setORM_Contiene(java.util.Set value) {
		this.ORM_contiene = value;
	}
	
	private java.util.Set getORM_Contiene() {
		return ORM_contiene;
	}
	
	@Transient	
	public final instagualbdorm.ElementoSetCollection contiene = new instagualbdorm.ElementoSetCollection(this, _ormAdapter, ORMConstants.KEY_PUBLICACION_CONTIENE, ORMConstants.KEY_ELEMENTO_CONTENIDO_EN, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getIDpublicacion());
	}
	
}
