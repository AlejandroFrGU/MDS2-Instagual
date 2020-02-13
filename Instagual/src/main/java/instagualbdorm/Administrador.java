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
@Table(name="Administrador")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorValue("Administrador")
@PrimaryKeyJoinColumn(name="UsuarioIDUsuario", referencedColumnName="IDUsuario")
public class Administrador extends instagualbdorm.Usuario implements Serializable {
	public Administrador() {
	}
	
	public String toString() {
		return super.toString();
	}
	
}
