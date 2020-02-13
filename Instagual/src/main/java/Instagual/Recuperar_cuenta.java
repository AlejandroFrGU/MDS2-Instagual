package Instagual;

import com.vaadin.navigator.View;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.UI;

import ual.mds2.Instagual.Recuperar_cuenta_ventana;
import ual.mds2.app.MyUI;

public class Recuperar_cuenta extends Recuperar_cuenta_ventana implements View {
	//private Buton _recuperarCuentaB;
	public Usuario_no_registrado_movil _usuario_no_registrado_movil;
	public Correo_no_encontrado_cuenta _correo_no_encontrado_cuenta;
	public Correo_electronico _correo_electronico;

	
	public Recuperar_cuenta() {
		
		botonRecuperarCuenta.addClickListener(
				event ->RecuperarCuenta()
		);
		
		botonCancelar.addClickListener(
				event -> ((MyUI)UI.getCurrent()).getNavigator1().navigateTo("IniciarSesion")
		);
	}
	
	public void RecuperarCuenta() {
		if(((MyUI)UI.getCurrent()).getiNoRegistradoMovil().Rcuperar_Cuenta(tFCorreo.getValue())) {
			Notification.show("Recuperada con éxito", Type.WARNING_MESSAGE);
		}else {
			Notification.show("Hubo un error.\nEs posible que esa cuenta no exista.", Type.WARNING_MESSAGE);
		}
	}
}