package Instagual;

import com.vaadin.navigator.View;
import com.vaadin.navigator.Navigator;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.Button.ClickEvent;

import instagualbdorm.BD_Principal;
import ual.mds2.Instagual.Iniciar_sesion_ventana;
import ual.mds2.app.MyUI;

public class Iniciar_sesion extends Iniciar_sesion_ventana implements View  {
	public Usuario_no_registrado_web _usuario_no_registrado_web;
	public Datos_incorrectos _datos_incorrectos;

	//iUsuario_no_registrado_movil iNoRegistrado = new BD_Principal();
	public Iniciar_sesion() {
		botonIniciarSesion.addClickListener(
				event ->IniciarSesion()
		);
		
		botonEntrarInvitado.addClickListener(
				event ->((MyUI)UI.getCurrent()).getNavigator1().navigateTo("Entrar")
		);
		botonRegistrarse.addClickListener(
				event ->((MyUI)UI.getCurrent()).getNavigator1().navigateTo("Registrarse")	
		);
		botonRecuperarCuenta.addClickListener(
				event ->((MyUI)UI.getCurrent()).getNavigator1().navigateTo("RecuperarCuenta")	
		);
		botonRecuperarPassword.addClickListener(
				event ->((MyUI)UI.getCurrent()).getNavigator1().navigateTo("RecuperarPassword")	
		);

	}
	
	public void IniciarSesion() {
		String correo = datosCorreo.getValue();
		String password = datosPassword.getValue();
		
		instagualbdorm.Usuario_Registrado user = ((MyUI)UI.getCurrent()).getiNoRegistradoMovil().Iniciar_Sesion(correo, password);
		instagualbdorm.Administrador admin = ((MyUI)UI.getCurrent()).getiNoRegistradoWeb().IniciarSesion_Web(correo, password);
		
		if(admin != null) {
			((MyUI) UI.getCurrent()).setAdmin(((MyUI)UI.getCurrent()).getiNoRegistradoWeb().IniciarSesion_Web(correo, password));
			((MyUI) UI.getCurrent()).setUserType(2);
			((MyUI) UI.getCurrent()).getNavigator1().navigateTo("Entrar");
		}
		
		if(user !=null) {
			//NO ESTA ACTIVO
			if(!user.getActivo()) {
				if(user.getCodigo().equals("")) {//ESTA DADA DE BAJA
					Notification.show("Cuenta desactivada.", Notification.Type.WARNING_MESSAGE);
				}else {//PRIMER INICIO
					((MyUI) UI.getCurrent()).setUsuario(((MyUI)UI.getCurrent()).getiNoRegistradoMovil().Iniciar_Sesion(correo, password));
					((MyUI)UI.getCurrent()).getNavigator1().navigateTo("EditarPerfil");
				}
			}else {//INICIO NORMAL
				((MyUI) UI.getCurrent()).setUsuario(((MyUI)UI.getCurrent()).getiNoRegistradoMovil().Iniciar_Sesion(correo, password));
				((MyUI) UI.getCurrent()).setUserType(1);
				((MyUI) UI.getCurrent()).setCorreo(correo);
				((MyUI) UI.getCurrent()).setPassword(password);
				((MyUI) UI.getCurrent()).getNavigator1().navigateTo("Entrar");
			}
		
		}else if (user == null && admin == null){
			Notification.show("La combinación de Usuario y contraseña no es correcta \n o no existe ese usuario.", Notification.Type.WARNING_MESSAGE);
		}
		
	}
	
}