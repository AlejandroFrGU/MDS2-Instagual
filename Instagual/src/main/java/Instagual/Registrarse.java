package Instagual;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import com.vaadin.navigator.View;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;

import instagualbdorm.Administrador;
import instagualbdorm.AdministradorDAO;
import instagualbdorm.BD_Principal;
import instagualbdorm.ProyectoInstagualPersistentManager;
import instagualbdorm.UsuarioDAO;
import instagualbdorm.Usuario_Registrado;
import instagualbdorm.Usuario_RegistradoDAO;
import ual.mds2.Instagual.Registrarse_ventana;
import ual.mds2.app.MyUI;

public class Registrarse extends Registrarse_ventana implements View{
	//private Button _registrarseB;
	public Usuario_no_registrado_movil _usuario_no_registrado_movil;
	public Registrado_con_exitoELIMINAR _registrado_con_exito;//sobra?
	public Correo_electronico _correo_electronico;

	
	public Registrarse() {
		botonRegistarse.addClickListener(
				event ->Registrar()
		);
		//////////////
		botonCancelar.addClickListener(
				event ->((MyUI)UI.getCurrent()).getNavigator1().navigateTo("IniciarSesion")	
		);
	}

	public void Registrar() {
		
		String correo = this.tFCorreo.getValue();
		String password = this.tFPassword.getValue();
		
		if(correo.isEmpty() || password.isEmpty()) {
			Notification.show("Debe completar todos los campos.", Notification.Type.WARNING_MESSAGE);
		}else if(!correo.contains("@")) {
			Notification.show("No es un correo valido.", Notification.Type.WARNING_MESSAGE);
		}else if(!comprobarContrasenia(password) || password.length() < 8) {
			Notification.show("La contraseña debe contener una minuscula, mayuscula y un numero y ser mayor o igual a 8 caracteres.", Notification.Type.WARNING_MESSAGE);
		}else if(!correo.isEmpty() && !password.isEmpty()) {
			boolean bo = ((MyUI)UI.getCurrent()).getiNoRegistradoMovil().Registrar(correo, password);//usuario
//			boolean bo = ((MyUI)UI.getCurrent()).getiAdmin().Registrar_Admin(correo, password);//admin
			if(!bo) {
				Notification.show("Ya existe un usuario con ese correo.", Notification.Type.WARNING_MESSAGE);
			}else {
				
				Notification.show("Registrado con exito.", Notification.Type.WARNING_MESSAGE);
			}
			
		}
	}

	
	private boolean comprobarContrasenia(String pass){
		boolean hayNumero = false, hayMayuscula = false, hayMinuscula = false;

		for (int i = 0; i < pass.length(); i++) {
			String passValue = String.valueOf(pass.charAt(i));
			if (passValue.matches("[A-Z]+") && !hayMayuscula) {
				hayMayuscula = true;
			} else if (passValue.matches("[a-z]+") && !hayMinuscula) {
				hayMinuscula = true;
			} else if (passValue.matches("[0-9]+") && !hayNumero) {
				hayNumero = true;
			}
		}

		return (hayMayuscula && hayMinuscula && hayNumero);
	}
	
	
}