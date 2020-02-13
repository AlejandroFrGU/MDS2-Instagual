package Instagual;

import com.vaadin.server.ExternalResource;
import com.vaadin.server.Sizeable.Unit;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.Notification.Type;

import instagualbdorm.Usuario_Registrado;
import ual.mds2.app.MyUI;

public class Ver_perfil_de_usuario_vista_usuario_registrado extends Ver_perfil_de_usuario_vista_usuario_bloqueado {
	//private Button _seguirDejarDeSeguirB;
	public Publicacion_Pagina_Principal _publicacion;
	public Ver_detalles_de_publicacion_vista_usuario_registrado _ver_detalles_de_publicacion_vista_usuario_registrado;
	public Ver_detalles_de_publicacion_vista_actividad__publicacion_y_mi_actividad _ver_detalles_de_publicacion_vista_actividad__publicacion_y_mi_actividad;
	public Ver_lista_de_publicaciones_del_usuario_registrado _ver_lista_de_publicaciones_del_usuario_registrado;
	public Ver_lista_de_publicaciones_en_las_que_esta_etiquetado_registrado _ver_lista_de_publicaciones_en_las_que_esta_etiquetado_registrado;
	Usuario_Registrado userP = null;
	Usuario_Registrado userYo = null;
	boolean correctas = false;
	boolean leSigo = false;
	
	public Ver_perfil_de_usuario_vista_usuario_registrado() {
		
		if(((MyUI)UI.getCurrent()).getUserType() == 1) {
			userP = ((MyUI)UI.getCurrent()).getUserVer();
			userYo = ((MyUI)UI.getCurrent()).getUsuario();
			//nombreUsuario
			labelNombreDeUsuario.setValue(userP.getNombreUsuario());
			//Imagen
			imagePerfil.setSource(new ExternalResource(userP.getFotoPerfil()));
			menuActividades.setVisible(false);
			
			//Perfil privado
			if(userP.getConfigura().getPerfilPrivado() && !userYo.sigue_a.contains(userP)) {
				verticalLayoutOpcionesMenu.setVisible(false);
			}
			
			//le sigo?
			//si
			if(userYo.sigue_a.contains(userP)) {
				buttonSeguir.setCaption("No seguir");
				leSigo = true;
			}
			
			
			//le bloqueo?
			//si
			if(userYo.bloquea_a.contains(userP)) {
				buttonBloquear.setCaption("Desbloquear");
			}
			
			//me bloquea?
			//si
			if(userP.bloquea_a.contains(userYo)) {
				verticalLayoutOpcionesMenu.setVisible(false);
			}
			
			//Registrado -- Botones perfil otros
			buttonConfiguracionVerPerfil.setVisible(false);
			buttonEditarPerfil.setVisible(false);
			buttonEliminarPerfil.setVisible(false);
			
			
			//COMUN NO REGISTRADO Y REGISTRADO -- OCULTAR SEGUIDORES/SEGUIDOS
			if(userP.getConfigura().getOcultosSeguidoresSeguidos()){
				labelSeguidores.setVisible(false);
				labelSeguidos.setVisible(false);
			}else {
				//Seguidores
				labelSeguidores.setValue("Seguidores " + userP.seguido_por.size());
				//Seguidos
				labelSeguidos.setValue("Seguidos " + userP.sigue_a.size());
			} //SEGUIR END
			
			
			buttonSeguir.addClickListener(
					event->SeguirDejarSeguir()
					);
			buttonBloquear.addClickListener(
					event->BloquearUsuario()
					);
			menuPublicaciones.addClickListener(
					event -> VerPublicaciones()
					);
			menuEtiquetadas.addClickListener(
					event -> VerPublicacionesEtiquetadas()
					);
		}	
	}
	
			
	
	public void BloquearUsuario() {
		if(((MyUI)UI.getCurrent()).getiRegistrado().Bloquear_Usuario(((MyUI)UI.getCurrent()).getUsuario().getORMID(), userP.getORMID())) {
			((MyUI)UI.getCurrent()).updateUser();
			if(buttonBloquear.getCaption().equals("Bloquear")) {
				buttonBloquear.setCaption("Desbloquear");
			}else {
				buttonBloquear.setCaption("Bloquear");
			}
		}else {
			Notification.show("Hubo un error.",Type.WARNING_MESSAGE);
		}
	}

	public void SeguirDejarSeguir() {
		if(this.iRegistrado.Seguir_DejarSeguir(((MyUI)UI.getCurrent()).getUsuario().getORMID(), userP.getORMID())) {
			((MyUI)UI.getCurrent()).updateUser();
			if(buttonSeguir.getCaption().equals("Seguir")) {//NO LO SIGUES 
				leSigo = true;
				crearNotificacionSeguir();//CREAT NOTIFICACIONES
				if(correctas)Notification.show("Notificaciones creadas con exito.",Type.WARNING_MESSAGE);
				else Notification.show("Las notificaciones no se crearon.",Type.WARNING_MESSAGE);
				buttonSeguir.setCaption("No seguir");//CAMBIA EL CONTENIDO DEL BOTON
				//ES PRIVADO Y NO ME BLOQUEA PERO AHORA LE SIGO, ASI QUE VEO SUS COSAS
				if(userP.getConfigura().getPerfilPrivado() && !userP.bloquea_a.contains(userYo)) {
					verticalLayoutOpcionesMenu.setVisible(true);
				}
				labelSeguidores.setValue("Seguidores " + (userP.seguido_por.size()));//CAMBIO EL NUMERO DE SEGUIDORES
			}else {//LO SIGUES
				leSigo = false;
				crearNotificacionSeguir();//CREAT NOTIFICACIONES
				if(correctas)Notification.show("Notificaciones creadas con exito.",Type.WARNING_MESSAGE);
				else Notification.show("Las notificaciones no se crearon.",Type.WARNING_MESSAGE);
				buttonSeguir.setCaption("Seguir");//CAMBIA EL CONTENIDO DEL BOTON
				if(userP.getConfigura().getPerfilPrivado()) {//ES PRIVADO Y YA NO LE SIGO, ASI QUE NO VEO SUS COSAS
					verticalLayoutOpcionesMenu.setVisible(false);
				}
				labelSeguidores.setValue("Seguidores " + (userP.seguido_por.size()));//CAMBIO EL NUMERO DE SEGUIDORES
			}
		}
	}
	public void VerPublicaciones() {
		verticalLayoutLista.removeAllComponents();
		for(instagualbdorm.Publicacion pub: userP.sube.toArray("IDpublicacion", false)) {
			Publicacion_propia publicPropia = new Publicacion_propia(pub);
			verticalLayoutLista.addComponent(publicPropia);
		}
	}
	public void VerPublicacionesEtiquetadas() {
		verticalLayoutLista.removeAllComponents();
		for(instagualbdorm.Publicacion pub: userP.mencionado_en.toArray("IDpublicacion", false)) {
			Publicacion_en_las_que_esta_etiquetado publiEti = new Publicacion_en_las_que_esta_etiquetado(pub);
			verticalLayoutLista.addComponent(publiEti);
		}
	}
	
	
	public void crearNotificacionSeguir() {
		correctas = false;
		if(leSigo) {
			if(((MyUI)UI.getCurrent()).getiRegistrado().crearNotificacion(((MyUI)UI.getCurrent()).getUsuario().getORMID(), 
					"Has empezado a seguir a: \n" + userP.getNombreUsuario(),false,"Seguir")) {
				correctas = true;
			}
			if(((MyUI)UI.getCurrent()).getiRegistrado().crearNotificacion(((MyUI)UI.getCurrent()).getUsuario().getORMID(), 
					"Tu seguido "+ ((MyUI)UI.getCurrent()).getUsuario().getNombreUsuario() + " ahora sigue a: \n" + 
					userP.getNombreUsuario(),true,"Seguir")) {
				correctas = true;
			}else {
				correctas = false;
			}
		}else {
			if(((MyUI)UI.getCurrent()).getiRegistrado().crearNotificacion(((MyUI)UI.getCurrent()).getUsuario().getORMID(), 
					"Has dejado de seguir a: \n" + userP.getNombreUsuario(),false,"Seguir")) {
				correctas = true;
			}
			if(((MyUI)UI.getCurrent()).getiRegistrado().crearNotificacion(((MyUI)UI.getCurrent()).getUsuario().getORMID(), 
					"Tu seguido "+ ((MyUI)UI.getCurrent()).getUsuario().getNombreUsuario() + " dejo de seguir a: \n" + 
					userP.getNombreUsuario(),true,"Seguir")) {
				correctas = true;
			}else {
				correctas = false;
			}
		}

	}

}