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
@Table(name="Usuario")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorValue("Usuario")
public class Usuario implements Serializable {
	public Usuario() {
	}
	
	@Column(name="IDUsuario", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="INSTAGUALBDORM_USUARIO_IDUSUARIO_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="INSTAGUALBDORM_USUARIO_IDUSUARIO_GENERATOR", strategy="native")	
	private int IDUsuario;
	
	@Column(name="Correo", nullable=true, length=255)	
	private String correo;
	
	@Column(name="Password", nullable=true, length=255)	
	private String password;
	
	@Column(name="Nombre", nullable=true, length=255)	
	private String nombre;
	
	@Column(name="Apellido", nullable=true, length=255)	
	private String apellido;
	
	@Column(name="NombreUsuario", nullable=true, length=255)	
	private String nombreUsuario;
	
	private void setIDUsuario(int value) {
		this.IDUsuario = value;
	}
	
	public int getIDUsuario() {
		return IDUsuario;
	}
	
	public int getORMID() {
		return getIDUsuario();
	}
	
	public void setCorreo(String value) {
		this.correo = value;
	}
	
	public String getCorreo() {
		return correo;
	}
	
	public void setPassword(String value) {
		this.password = value;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setNombre(String value) {
		this.nombre = value;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setApellido(String value) {
		this.apellido = value;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	public void setNombreUsuario(String value) {
		this.nombreUsuario = value;
	}
	
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	
	public String toString() {
		return String.valueOf(getIDUsuario());
	}
	
}
