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
@Table(name="Etiqueta")
public class Etiqueta implements Serializable {
	public Etiqueta() {
	}
	
	private java.util.Set this_getSet (int key) {
		if (key == ORMConstants.KEY_ETIQUETA_ESTA_EN) {
			return ORM_esta_en;
		}
		
		return null;
	}
	
	@Transient	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.Set getSet(int key) {
			return this_getSet(key);
		}
		
	};
	
	@Column(name="IDEtiqueta", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="INSTAGUALBDORM_ETIQUETA_IDETIQUETA_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="INSTAGUALBDORM_ETIQUETA_IDETIQUETA_GENERATOR", strategy="native")	
	private int IDEtiqueta;
	
	@Column(name="Nombre", nullable=true, length=255)	
	private String nombre;
	
	@OneToMany(mappedBy="tiene", targetEntity=instagualbdorm.Publicacion.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ORM_esta_en = new java.util.HashSet();
	
	private void setIDEtiqueta(int value) {
		this.IDEtiqueta = value;
	}
	
	public int getIDEtiqueta() {
		return IDEtiqueta;
	}
	
	public int getORMID() {
		return getIDEtiqueta();
	}
	
	public void setNombre(String value) {
		this.nombre = value;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	private void setORM_Esta_en(java.util.Set value) {
		this.ORM_esta_en = value;
	}
	
	private java.util.Set getORM_Esta_en() {
		return ORM_esta_en;
	}
	
	@Transient	
	public final instagualbdorm.PublicacionSetCollection esta_en = new instagualbdorm.PublicacionSetCollection(this, _ormAdapter, ORMConstants.KEY_ETIQUETA_ESTA_EN, ORMConstants.KEY_PUBLICACION_TIENE, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getIDEtiqueta());
	}
	
}
