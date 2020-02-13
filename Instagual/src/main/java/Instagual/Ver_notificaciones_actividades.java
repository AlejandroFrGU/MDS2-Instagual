package Instagual;

import com.vaadin.navigator.View;
import com.vaadin.server.Sizeable.Unit;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import instagualbdorm.Usuario_Registrado;
import ual.mds2.Instagual.Ver_notificaciones_actividades_ventana;
import ual.mds2.app.MyUI;

public class Ver_notificaciones_actividades extends Ver_notificaciones_actividades_ventana implements View{
	public Menu_inferior _menu_inferior;
	public Ver_lista_de_actividades _ver_lista_de_actividades;
	public Ver_lista_de_notificaciones _ver_lista_de_notificaciones;
	Usuario_Registrado userP = null;
	
	public Ver_notificaciones_actividades() {
		userP = ((MyUI)UI.getCurrent()).getUsuario();
		cargarActividadesAjenas();
	}
	
	public void cargarActividadesAjenas() {
		vlAcNoti.removeAllComponents();
		for(instagualbdorm.Notificacion notification: userP.notificaciones_de.toArray("IDNotificacion",false)) {
			if(notification.getRecibida() && notification.getDescripcion().indexOf(userP.getNombreUsuario()) == -1) {
				Notificacion notifi = new Notificacion(notification.getFecha(), notification.getDescripcion());
				vlAcNoti.addComponent(notifi);
				
				if(userP.getConfigura().getNotificacionesTodas()) {
					if(userP.getConfigura().getNotificacionesComentarios()) {
						if(notification.getTipo().equals("Comentario")) {
							vlAcNoti.addComponent(notifi);
						}
					}
					if(userP.getConfigura().getNotificacionesMeGusta()) {
						if(notification.getTipo().equals("MeGusta")) {
							vlAcNoti.addComponent(notifi);
						}
					}
					if(userP.getConfigura().getNotificacionesSeguir()) {
						if(notification.getTipo().equals("Seguir")) {
							vlAcNoti.addComponent(notifi);
						}
					}
				}
			}
		}
	}
}