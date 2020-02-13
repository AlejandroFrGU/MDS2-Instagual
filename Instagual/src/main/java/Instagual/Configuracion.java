package Instagual;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.navigator.View;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.Notification.Type;

import instagualbdorm.BD_Principal;
import ual.mds2.Instagual.Configuracion_ventana;
import ual.mds2.app.MyUI;

public class Configuracion extends Configuracion_ventana implements View{
	public Ver_perfil_de_usuario_vista_perfil_propio _ver_perfil_de_usuario_vista_perfil_propio;
	public Darse_de_baja _darse_de_baja;
	public Ajustes_de_notificaciones _ajustes_de_notificaciones;
	public Privacidad _privacidad;
	public Ver_lista_de_usuarios_bloqueados _ver_lista_de_usuarios_bloqueados;
	iUsuario_registrado iRegistrado = new BD_Principal();
	instagualbdorm.Usuario_Registrado userP = null;
	instagualbdorm.Configuracion config = null;
	
	
	public Configuracion() {
		((MyUI)UI.getCurrent()).updateUser();
		userP = ((MyUI)UI.getCurrent()).getUsuario();
		config = userP.getConfigura();
		
		todas.setValue(config.getNotificacionesTodas());
		megusta.setValue(config.getNotificacionesMeGusta());
		comentarios.setValue(config.getNotificacionesComentarios());
		seguir.setValue(config.getNotificacionesSeguir());
		privada.setValue(config.getPerfilPrivado());
		ocultarss.setValue(config.getOcultosSeguidoresSeguidos());
		
		buttonCerrarSesion.addClickListener(
				event-> cerrarSesion()
				);
		buttonDarseDeBaja.addClickListener(
				event-> darseBaja()
				);
		guardarConfig.addClickListener(
				event-> CambiarConfiguracion()
				);
		buttonListaDeBloqueados.addClickListener(
				event-> ((MyUI)UI.getCurrent()).getNavigator2().navigateTo("Bloqueados")
				);
	}
	
	
	private void CambiarConfiguracion() {
		boolean[] aListaAjustes = new boolean[6];
		aListaAjustes[0] = todas.getValue();
		aListaAjustes[1] = megusta.getValue();
		aListaAjustes[2] = comentarios.getValue();
		aListaAjustes[3] = seguir.getValue();
		aListaAjustes[4] = privada.getValue();
		aListaAjustes[5] = ocultarss.getValue();
		if(iRegistrado.Cambiar_Configuracion(userP.getORMID(),aListaAjustes))Notification.show("Configuracion cambiada.",Type.WARNING_MESSAGE);
		((MyUI)UI.getCurrent()).updateUser();
	}


	public void cerrarSesion() {
		((MyUI)UI.getCurrent()).reset();
		((MyUI)UI.getCurrent()).getNavigator1().navigateTo("IniciarSesion");
	}
	
	public void darseBaja() {
		Darse_de_baja ddb = new Darse_de_baja();
		UI.getCurrent().addWindow(ddb.getWDarseBaja());
	}
}