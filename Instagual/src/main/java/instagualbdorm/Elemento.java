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
@Table(name="Elemento")
public class Elemento implements Serializable {
	public Elemento() {
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == ORMConstants.KEY_ELEMENTO_CONTENIDO_EN) {
			this.contenido_en = (instagualbdorm.Publicacion) owner;
		}
	}
	
	@Transient	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	@Column(name="IDElemento", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="INSTAGUALBDORM_ELEMENTO_IDELEMENTO_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="INSTAGUALBDORM_ELEMENTO_IDELEMENTO_GENERATOR", strategy="native")	
	private int IDElemento;
	
	@ManyToOne(targetEntity=instagualbdorm.Publicacion.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="PublicacionIDpublicacion", referencedColumnName="IDpublicacion", nullable=false) })	
	@org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)	
	private instagualbdorm.Publicacion contenido_en;
	
	@Column(name="PathName", nullable=true, length=255)	
	private String pathName;
	
	private void setIDElemento(int value) {
		this.IDElemento = value;
	}
	
	public int getIDElemento() {
		return IDElemento;
	}
	
	public int getORMID() {
		return getIDElemento();
	}
	
	public void setPathName(String value) {
		this.pathName = value;
	}
	
	public String getPathName() {
		return pathName;
	}
	
	public void setContenido_en(instagualbdorm.Publicacion value) {
		if (contenido_en != null) {
			contenido_en.contiene.remove(this);
		}
		if (value != null) {
			value.contiene.add(this);
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
		return String.valueOf(getIDElemento());
	}
	
}
