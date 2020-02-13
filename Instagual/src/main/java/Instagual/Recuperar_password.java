package Instagual;

import com.vaadin.navigator.View;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.Notification.Type;

import ual.mds2.Instagual.Recuperar_password_ventana;
import ual.mds2.app.MyUI;

public class Recuperar_password extends Recuperar_password_ventana implements View {
	//private Button _recuperarPasswordB;
	public Usuario_no_registrado_movil _usuario_no_registrado_movil;
	public Correo_no_encontrado_password _correo_no_encontrado_password;

	public Recuperar_password() {
		botonRecuperarPassword.addClickListener(
				event ->RecuperarPassword()
		);
		
		botonCancelar.addClickListener(
				event -> ((MyUI)UI.getCurrent()).getNavigator1().navigateTo("IniciarSesion")
		);
	}
	
	public void RecuperarPassword() {
		if(((MyUI)UI.getCurrent()).getiNoRegistradoMovil().Recuperar_Password(tFCorreo.getValue())) {
			Notification.show("Recuperada con éxito", Type.WARNING_MESSAGE);
		}else {
			Notification.show("Hubo un error.", Type.WARNING_MESSAGE);
		}
	}
}