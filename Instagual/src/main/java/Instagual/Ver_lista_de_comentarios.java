package Instagual;

import java.util.Vector;

import com.vaadin.navigator.View;
import com.vaadin.server.ExternalResource;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;

import instagualbdorm.Comentario;
import instagualbdorm.Usuario_Registrado;
import ual.mds2.Instagual.Ver_lista_de_comentarios_ventana;
import ual.mds2.app.MyUI;

public class Ver_lista_de_comentarios extends Ver_lista_de_comentarios_ventana implements View{
//	private Button _publicarComentarioB;
	public Ver_detalles_de_publicacion _ver_detalles_de_publicacion;
	public Vector<Comentario> _comentario = new Vector<Comentario>();
	Usuario_Registrado userP = null;
	instagualbdorm.Publicacion publi = null;
	boolean correctas = false;
	
	public Ver_lista_de_comentarios() {
		textFieldComentario.setMaxLength(25);
		publi = ((MyUI)UI.getCurrent()).getPublicacionVer();
		userP = publi.getPropiedad_de();
		//Si no es un usuario registrado normal no puede comentar
		if(((MyUI)UI.getCurrent()).getUserType() != 1) {
			horizontalLayoutEscribirComentario.setVisible(false);
		}
		imageNombreUsuario.setSource(new ExternalResource(userP.getFotoPerfil()));//IMAGEN PERFIL
		nativeButtonUsuario.setCaption(userP.getNombreUsuario());//NOMBRE USUARIO
		
		if(publi.getPropiedad_de() != ((MyUI)UI.getCurrent()).getUsuario() && ((MyUI)UI.getCurrent()).getUserType() == 1) {
			nativeButtonUsuario.addClickListener(event-> ((MyUI)UI.getCurrent()).getNavigator2().navigateTo("VerPerfil")
					);
		}
		//descripcion de publicacion
		labelDescripPublicacion12.setValue(publi.getDescripcion());
		
		//lista de comentarios
		
		for(instagualbdorm.Comentario comm :publi.contiene_a.toArray("IDComentario",false)) {
			Instagual.Comentario comment = new Instagual.Comentario(comm);
			listaComentarios.addComponent(comment);
		}
		
		buttonPublicar.addClickListener(
				event->PublicarComentario()
				);
		nativeButtonUsuario.addClickListener(
				event->verUsuario()
				);
		imageNombreUsuario.addClickListener(
				event->verUsuario()
				);
		bAtras.addClickListener(
				event->((MyUI)UI.getCurrent()).getNavigator2().navigateTo("DetallePubli")
				);
		
	}
	

	public void PublicarComentario() {
		if(((MyUI)UI.getCurrent()).getiRegistrado()
				.Publicar_Comentario(publi.getORMID(),((MyUI)UI.getCurrent()).getUsuario().getORMID(),textFieldComentario.getValue())){
			crearNotificacionSubirComentario();
			if(correctas)Notification.show("Comentario y notificaciones agregados con éxito.");
			else Notification.show("Comentario agregado con éxito.\nLas notificaciones producieron error.");
			((MyUI)UI.getCurrent()).updateUser();
			((MyUI)UI.getCurrent()).getNavigator2().navigateTo("ListaComentarios");
		}else {
			Notification.show("Hubo un error y no se puedo agregar su comentario.");
		}
	}


	public void verUsuario() {
		((MyUI)UI.getCurrent()).setUserVer(userP);
		
		if(((MyUI)UI.getCurrent()).getUserType() !=1) {
			((MyUI)UI.getCurrent()).getNavigator2().navigateTo("VerPerfil");
		}else {
			if(userP.getORMID() == ((MyUI)UI.getCurrent()).getUsuario().getORMID()) {
				((MyUI)UI.getCurrent()).getNavigator2().navigateTo("VerPerfilPropio");
			}else {//no es mio
				((MyUI)UI.getCurrent()).getNavigator2().navigateTo("VerPerfil");
			}
		}
	}
	
	public void crearNotificacionSubirComentario() {
		correctas = false;
			if(((MyUI)UI.getCurrent()).getiRegistrado().crearNotificacion(((MyUI)UI.getCurrent()).getUsuario().getORMID(), 
					"Has comentado: \n"+ textFieldComentario.getValue()  +"\nEn la publicacion con etiqueta: \n" + publi.getTiene().getNombre(),false,"Comentario")) {
				correctas = true;
			}
			if(((MyUI)UI.getCurrent()).getiRegistrado().crearNotificacion(((MyUI)UI.getCurrent()).getUsuario().getORMID(), 
					"Tu seguido "+ ((MyUI)UI.getCurrent()).getUsuario().getNombreUsuario() + " ha comentado: \n"+ textFieldComentario.getValue() +"\nEn la publicacion con etiqueta: \n" + 
					publi.getTiene().getNombre(),true,"Comentario")) {
				correctas = true;
			}else {
				correctas = false;
			}
	}
}