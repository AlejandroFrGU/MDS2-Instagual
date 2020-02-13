package Instagual;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.ExternalResource;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.Notification.Type;

import instagualbdorm.Usuario_Registrado;
import ual.mds2.Instagual.Publicacion_Pagina_Principal_ventana;
import ual.mds2.app.MyUI;

public class Publicacion_Pagina_Principal extends Publicacion_Pagina_Principal_ventana{
	//private Button _darMeGustaPublicacionB;
	public Ver_pagina_principal _ver_pagina_principal;
	public Ver_detalles_de_publicacion_vista_publicacion_de_otros _ver_detalles_de_publicacion_vista_publicacion_de_otros;
	public Ver_perfil_de_usuario_vista_usuario_registrado _ver_perfil_de_usuario_vista_usuario_registrado;
	instagualbdorm.Publicacion publi = null;
	instagualbdorm.Usuario_Registrado userP = null;
	boolean correctas = false;
	boolean publiMeGusta = false;
	
	public Publicacion_Pagina_Principal(instagualbdorm.Publicacion publi2) {
		publi = publi2;
		userP = publi.getPropiedad_de();
		//Rellenado de componentes
		nombreUsuario.setCaption(userP.getNombreUsuario());
		imageUsuario.setSource(new ExternalResource(userP.getFotoPerfil()));
		imagePrimeraImagen.setSource(new ExternalResource(publi.getImagenPreview()));
		if(userP.getORMID() == ((MyUI)UI.getCurrent()).getUsuario().getORMID() || ((MyUI)UI.getCurrent()).getUserType() !=1) {
			meGusta.setVisible(false);
		}
		//si le gusta
		if(publi.gustada_por.contains(((MyUI)UI.getCurrent()).getUsuario())) {
			meGusta.setIcon(VaadinIcons.HEART);
		}//si no le gusta
		else {
			meGusta.setIcon(VaadinIcons.HEART_O);
		}
		//configura el numero de me gusta y los que le han dado
		cambiarMeGusta();
		
		//Movimientos
		//ver detalle de publicacion
		imagePrimeraImagen.addClickListener(
				event->VerPublicacion()
		);
		//ver perfil de usuario
		nombreUsuario.addClickListener(
				event->verUsuario()
		);
		//ver perfil de usuario
		imageUsuario.addClickListener(
				event->verUsuario()
		);
		
		meGusta.addClickListener(
				event->DarMeGustaPublicacionPaginaPrincipal()
		);
		
	}
	
	
	public void DarMeGustaPublicacionPaginaPrincipal() {
		if(((MyUI)UI.getCurrent()).getiRegistrado().DarMeGusta_Publicacion(((MyUI)UI.getCurrent()).getUsuario().getORMID(),publi.getORMID())) {
			((MyUI)UI.getCurrent()).updateUser();
			if(meGusta.getIcon() == VaadinIcons.HEART_O) {
				publiMeGusta = true;
				crearNotificacionMeGustaPPP();
				if(correctas)Notification.show("Notificaciones creadas con exito.",Type.WARNING_MESSAGE);
				else Notification.show("Las notificaciones no se crearon.",Type.WARNING_MESSAGE);
				meGusta.setIcon(VaadinIcons.HEART);
			}else {
				publiMeGusta = false;
				crearNotificacionMeGustaPPP();
				if(correctas)Notification.show("Notificaciones creadas con exito.",Type.WARNING_MESSAGE);
				else Notification.show("Las notificaciones no se crearon.",Type.WARNING_MESSAGE);
				meGusta.setIcon(VaadinIcons.HEART_O);
			}
			cambiarMeGusta();
		}
	
		
	}
	
	public void VerPublicacion() {
		((MyUI)UI.getCurrent()).setPublicacionVer(publi);
		((MyUI)UI.getCurrent()).getNavigator2().navigateTo("DetallePubli");
	}
	public void verUsuario() {
		((MyUI)UI.getCurrent()).setUserVer(userP);
		if(userP.getORMID() == ((MyUI)UI.getCurrent()).getUsuario().getORMID()) {
			((MyUI)UI.getCurrent()).getNavigator2().navigateTo("VerPerfilPropio");
		}else {//no es mio
			((MyUI)UI.getCurrent()).getNavigator2().navigateTo("VerPerfil");
		}
	}
	
	public void cambiarMeGusta() {
		labelNumeroMeGusta.setValue(publi.gustada_por.size() + "");
		String usuariosGusta ="Me gusta: ";

		int cont = 0;
		for(Usuario_Registrado user: publi.gustada_por.toArray()) {
			if(cont == 2) {
				break;
			}else {
				if(cont == 0) {
					if(publi.gustada_por.size() == 1) {
						usuariosGusta += user.getNombreUsuario() + "...";
					}else {
						usuariosGusta += user.getNombreUsuario() + ", ";
					}
				}else {
					usuariosGusta += user.getNombreUsuario() + "...";
				}				
			}
			cont++;
		}
		labelGenteMeGusta.setValue(usuariosGusta);
	}
	
	public void crearNotificacionMeGustaPPP() {
		correctas = false;
		if(publiMeGusta) {//me gusta
			if(((MyUI)UI.getCurrent()).getiRegistrado().crearNotificacion(((MyUI)UI.getCurrent()).getUsuario().getORMID(), 
					"Has dado me gusta a la publicacion\ncon la etiqueta:\n" + publi.getTiene().getNombre(),false,"MeGusta")) {
				correctas = true;
			}
			if(((MyUI)UI.getCurrent()).getiRegistrado().crearNotificacion(((MyUI)UI.getCurrent()).getUsuario().getORMID(), 
					"Tu seguido "+ ((MyUI)UI.getCurrent()).getUsuario().getNombreUsuario() + " ha dado me gusta \n a la publicacion con etiqueta: \n" + 
					publi.getTiene().getNombre(),true,"MeGusta")) {
				correctas = true;
			}else {
				correctas = false;
			}
		}else {//no me gusta
			if(((MyUI)UI.getCurrent()).getiRegistrado().crearNotificacion(((MyUI)UI.getCurrent()).getUsuario().getORMID(), 
					"Quitaste tu me gusta a la publicacion \ncon la etiqueta: \n" + publi.getTiene().getNombre(),false,"MeGusta")) {
				correctas = true;
			}
			if(((MyUI)UI.getCurrent()).getiRegistrado().crearNotificacion(((MyUI)UI.getCurrent()).getUsuario().getORMID(), 
					"Tu seguido "+ ((MyUI)UI.getCurrent()).getUsuario().getNombreUsuario() + " ha quitado su me gusta \n a la publicacion con etiqueta: \n" + 
					publi.getTiene().getNombre(),true,"MeGusta")) {
				correctas = true;
			}else {
				correctas = false;
			}
		}

	}

}