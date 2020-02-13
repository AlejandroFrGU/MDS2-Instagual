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
@Table(name="Notificacion")
public class Notificacion implements Serializable {
	public Notificacion() {
	}
	
	private void this_setOwner(Object owner, int key) {
		if (key == ORMConstants.KEY_NOTIFICACION_CONTIENE_NOTIFICACIONES) {
			this.contiene_notificaciones = (instagualbdorm.Usuario_Registrado) owner;
		}
	}
	
	@Transient	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
		}
		
	};
	
	@Column(name="IDNotificacion", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="INSTAGUALBDORM_NOTIFICACION_IDNOTIFICACION_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="INSTAGUALBDORM_NOTIFICACION_IDNOTIFICACION_GENERATOR", strategy="native")	
	private int IDNotificacion;
	
	@ManyToOne(targetEntity=instagualbdorm.Usuario_Registrado.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns({ @JoinColumn(name="Usuario_RegistradoUsuarioIDUsuario", referencedColumnName="UsuarioIDUsuario", nullable=false) })	
	@org.hibernate.annotations.LazyToOne(value=org.hibernate.annotations.LazyToOneOption.NO_PROXY)	
	private instagualbdorm.Usuario_Registrado contiene_notificaciones;
	
	@Column(name="Descripcion", nullable=true, length=255)	
	private String descripcion;
	
	@Column(name="Tipo", nullable=true, length=255)	
	private String tipo;
	
	@Column(name="Fecha", nullable=true, length=255)	
	private String fecha;
	
	@Column(name="Recibida", nullable=false, length=1)	
	private boolean recibida;
	
	public void setDescripcion(String value) {
		this.descripcion = value;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setTipo(String value) {
		this.tipo = value;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public void setFecha(String value) {
		this.fecha = value;
	}
	
	public String getFecha() {
		return fecha;
	}
	
	private void setIDNotificacion(int value) {
		this.IDNotificacion = value;
	}
	
	public int getIDNotificacion() {
		return IDNotificacion;
	}
	
	public int getORMID() {
		return getIDNotificacion();
	}
	
	public void setRecibida(boolean value) {
		this.recibida = value;
	}
	
	public boolean getRecibida() {
		return recibida;
	}
	
	public void setContiene_notificaciones(instagualbdorm.Usuario_Registrado value) {
		if (contiene_notificaciones != null) {
			contiene_notificaciones.notificaciones_de.remove(this);
		}
		if (value != null) {
			value.notificaciones_de.add(this);
		}
	}
	
	public instagualbdorm.Usuario_Registrado getContiene_notificaciones() {
		return contiene_notificaciones;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Contiene_notificaciones(instagualbdorm.Usuario_Registrado value) {
		this.contiene_notificaciones = value;
	}
	
	private instagualbdorm.Usuario_Registrado getORM_Contiene_notificaciones() {
		return contiene_notificaciones;
	}
	
	public String toString() {
		return String.valueOf(getIDNotificacion());
	}
	
}
