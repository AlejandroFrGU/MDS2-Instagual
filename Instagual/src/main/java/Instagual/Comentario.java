package Instagual;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.ExternalResource;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.UI;

import ual.mds2.Instagual.Comentario_ventana;
import ual.mds2.app.MyUI;

public class Comentario extends Comentario_ventana{
	public Ver_lista_de_comentarios _ver_lista_de_comentarios;
	//public Ver_perfil_de_usuario_Vista_de_no_registrado_comentario _ver_perfil_de_usuario_Vista_de_no_registrado_comentario;
	instagualbdorm.Usuario_Registrado userC = null;
	instagualbdorm.Comentario comment = null;
	instagualbdorm.Publicacion publi = null;
	boolean correctas = false;
	
	public Comentario(instagualbdorm.Comentario comm) {
		publi = ((MyUI)UI.getCurrent()).getPublicacionVer();//publicacion del comentario
		comment = comm;
		userC = comm.getPropiedad_de();//A quien pertenece el comentario
		
		if(((MyUI)UI.getCurrent()).getUserType() == 0) {//es invitado no puede dar me gusta ni eliminar
			buttonDarMeGustaComentario.setVisible(false);
			buttonEliminar.setVisible(false);
		}
		if(((MyUI)UI.getCurrent()).getUserType() == 2) {//es admin no puede dar me gusta
			buttonDarMeGustaComentario.setVisible(false);
		}
		
		if(((MyUI)UI.getCurrent()).getUserType() == 1) {//es registrado y puede:
			//No es mi comentario ni mi publicacion
			if(userC.getORMID() != ((MyUI)UI.getCurrent()).getUsuario().getORMID() && publi.getPropiedad_de().getORMID() != ((MyUI)UI.getCurrent()).getUsuario().getORMID()) {
				buttonEliminar.setVisible(false);
			}
			//Es mi comentario, no puedo darle me gusta
			if(userC.getORMID() == ((MyUI)UI.getCurrent()).getUsuario().getORMID()) {
				buttonDarMeGustaComentario.setVisible(false);
			}
			//Actualizacion del icono de me gusta
			if(((MyUI)UI.getCurrent()).getUsuario().gusta.contains(comment)) {
				buttonDarMeGustaComentario.setIcon(VaadinIcons.HEART);
			}else {
				buttonDarMeGustaComentario.setIcon(VaadinIcons.HEART_O);
			}
		}
		numMegusta.setValue(comm.gustado_por.size() + "");
		
		//imagen user
		imageNombreUsuario.setSource(new ExternalResource(userC.getFotoPerfil()));
		//nombreuser
		nativeButtonUsuario.setCaption(userC.getNombreUsuario());
		//comentario
		labelDescripPublicacion12.setValue(comm.getComentario());
		//botones
		buttonDarMeGustaComentario.addClickListener(
				event->DarMeGustaComentario());
		buttonEliminar.addClickListener(
				event->EliminarComentario());
		nativeButtonUsuario.addClickListener(
				event->verUsuario());
		imageNombreUsuario.addClickListener(
				event->verUsuario());
		
	}
	
	public void DarMeGustaComentario() {	
			if(((MyUI)UI.getCurrent()).getiRegistrado().DarMeGusta_Comentario(((MyUI)UI.getCurrent()).getUsuario().getORMID(),comment.getORMID())) {
				((MyUI)UI.getCurrent()).updateUser();
				//no me gusta
				if(buttonDarMeGustaComentario.getIcon() == VaadinIcons.HEART_O) {
					buttonDarMeGustaComentario.setIcon(VaadinIcons.HEART);
					numMegusta.setValue(comment.gustado_por.size() + "");
				}else {//me gusta
					buttonDarMeGustaComentario.setIcon(VaadinIcons.HEART_O);
					numMegusta.setValue(comment.gustado_por.size() + "");
				}
				
			}
	}
	public void EliminarComentario() {
		if(((MyUI)UI.getCurrent()).getUserType() == 1) {//ES USUARIO REGISTRADO
			if(((MyUI)UI.getCurrent()).getiRegistrado().Eliminar_Comentario(comment.getORMID())) {
				crearNotificacionEliminarComentario();
				if(correctas)Notification.show("Comentario eliminado y notificaciones creadas con exito.",Type.WARNING_MESSAGE);
				else Notification.show("Comentario eliminado pero las notificaciones no se crearon.",Type.WARNING_MESSAGE);
				((MyUI)UI.getCurrent()).updateUser();
				((MyUI)UI.getCurrent()).getNavigator2().navigateTo("ListaComentarios");//RECARGA PAGINA
			}else {
				Notification.show("No se pudo eliminar.",Type.WARNING_MESSAGE);
			}
		}else {//ES ADMIN
			if(((MyUI)UI.getCurrent()).getiAdmin().Eliminar_ComentarioAdmin(comment.getORMID())) {
				Notification.show("Mensaje eliminado con éxito",Type.WARNING_MESSAGE);
				((MyUI)UI.getCurrent()).getNavigator2().navigateTo("ListaComentarios");//RECARGA PAGINA
			}else {
				Notification.show("No se pudo eliminar.",Type.WARNING_MESSAGE);
			}
		}
	}
	
	public void verUsuario() {
		((MyUI)UI.getCurrent()).setUserVer(userC);
		//es mi comentario
		if(((MyUI)UI.getCurrent()).getUserType() !=1) {
			((MyUI)UI.getCurrent()).getNavigator2().navigateTo("VerPerfil");
		}else {
			if(userC.getORMID() == ((MyUI)UI.getCurrent()).getUsuario().getORMID()) {
				((MyUI)UI.getCurrent()).getNavigator2().navigateTo("VerPerfilPropio");
			}else {//no es mio
				((MyUI)UI.getCurrent()).getNavigator2().navigateTo("VerPerfil");
			}
		}
	}
	
	public void crearNotificacionEliminarComentario() {
		correctas = false;
			if(((MyUI)UI.getCurrent()).getiRegistrado().crearNotificacion(((MyUI)UI.getCurrent()).getUsuario().getORMID(), 
					"Has eliminado el comentario: \n" + comment.getComentario() + " \nEn la publicacion con etiqueta: \n" + publi.getTiene().getNombre(),false,"Comentario")) {
				correctas = true;
			}
			if(((MyUI)UI.getCurrent()).getiRegistrado().crearNotificacion(((MyUI)UI.getCurrent()).getUsuario().getORMID(), 
					"Tu seguido "+ ((MyUI)UI.getCurrent()).getUsuario().getNombreUsuario() + " ha eliminado su comentario: \n"+comment.getComentario() +"\nEn la publicacion con etiqueta: \n" + 
					publi.getTiene().getNombre(),true,"Comentario")) {
				correctas = true;
			}else {
				correctas = false;
			}
	}
}