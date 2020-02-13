package Instagual;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.View;
import com.vaadin.server.ExternalResource;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.server.Sizeable.Unit;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

import instagualbdorm.Elemento;
import instagualbdorm.Usuario_Registrado;
import ual.mds2.Instagual.Ver_detalles_de_publicacion_ventana;
import ual.mds2.app.MyUI;

public class Ver_detalles_de_publicacion extends Ver_detalles_de_publicacion_ventana implements View {
//	private Button _verListadoComentariosB;
//	private Button _verListadoUsuariosMeGustaB;
	public Publicacion_de_busqueda _publicacion_de_busqueda;
	public Ver_elementos_de_publicacion _ver_elementos_de_publicacion;
	public Ver_lista_de_comentarios _ver_lista_de_comentarios;
	public Ver_lista_de_quien_dio_me_gusta _ver_lista_de_quien_dio__me_gusta_;
	//public Ver_perfil_de_usuario_Vista_no_registrado_detalles_de_publicacion _ver_perfil_de_usuario_Vista_no_registrado_detalles_de_publicacion;
	instagualbdorm.Publicacion publi = null;
	instagualbdorm.Usuario_Registrado userP = null;
	boolean correctas = false;
	public Window wiCompartir;
	boolean publiMeGusta = false;
	
	public Ver_detalles_de_publicacion() {
		publi = ((MyUI)UI.getCurrent()).getPublicacionVer();//PUBLICACION
		userP = publi.getPropiedad_de();//PROPIETARIO DE PUBLICACION
		VerDetallesDePublicacion();
		buttonEliminarPublicacion.addClickListener(
				event->EliminarPublicacion()
		);
		verComentarios.addClickListener(
				event-> ((MyUI)UI.getCurrent()).getNavigator2().navigateTo("ListaComentarios")
				);
		nombreUsuario.addClickListener(
				event->verUsuario()
		);
		imagenPerfil.addClickListener(
				event->verUsuario()
		);
		meGusta.addClickListener(
				event->DarMeGustaPublicacion()
		);
		buttonEliminarMencion.addClickListener(
				event->EliminarMencion()
		);
		labelMegusta.addClickListener(
				event->usuariosMeGusta()
				);
		
		buttonCompartir.addClickListener(
				event->Compartir()
				);
	}
	
	public void Compartir() {
		wiCompartir = new Window("Compartir");
		//layouts
		VerticalLayout main = new VerticalLayout();
		VerticalLayout vl = new VerticalLayout();
		
		//label
		Label lbl = new Label();
		lbl.setContentMode(ContentMode.PREFORMATTED);
		lbl.setValue("Publicación del usuario:\n" + userP.getNombreUsuario() +"\nEtiqueta de publicacion:\n" + publi.getTiene().getNombre());
		lbl.setWidth(100,Unit.PERCENTAGE);
		lbl.setHeight(100,Unit.PERCENTAGE);

		vl.addComponent(lbl);
		
		//boton cancelar
		Button can = new Button();
		can.setCaption("Cancelar");
		can.addClickListener(event->wiCompartir.close());
		vl.addComponent(can);
		
		main.addComponent(vl);
		
		wiCompartir.setContent(main);
		wiCompartir.setModal(true);
		UI.getCurrent().addWindow(wiCompartir);
	}
	public void usuariosMeGusta() {
		((MyUI)UI.getCurrent()).getNavigator2().navigateTo("PubliUsuariosMeGusta");
	}
	
	public void VerDetallesDePublicacion() {
		buttonEliminarMencion.setVisible(false);
		//cargar datos de componentes
		
		//numero de me gusta y gente
		cambiarMeGusta();
		//cargar por perfil
		//es admin?
		if(((MyUI)UI.getCurrent()).getUserType() != 1) {
			buttonCompartir.setVisible(false);
			meGusta.setVisible(false);
			buttonEliminarMencion.setVisible(false);
			if(((MyUI)UI.getCurrent()).getUserType() == 0) {
				buttonEliminarPublicacion.setVisible(false);
			}
			
		}else if(((MyUI)UI.getCurrent()).getUserType() == 1){//USUARIOS REGISTRADOS
			//MI PUBLICACION
			if(publi.getPropiedad_de().getORMID() == (((MyUI)UI.getCurrent()).getUsuario().getORMID())) {
				buttonEliminarMencion.setVisible(false);
				meGusta.setVisible(false);
			}//NO ES MI PUBLICACION
			else  {
				buttonEliminarPublicacion.setVisible(false);
				if(((MyUI)UI.getCurrent()).getUsuario().le_gusta.contains(publi)) {
					meGusta.setIcon(VaadinIcons.HEART);
				}else {
					meGusta.setIcon(VaadinIcons.HEART_O);
				}

			}
		}
		labelDescripcionPublicacion.setValue(publi.getDescripcion());//DESCRIPCION PUBLICACION
		nombreUsuario.setCaption(userP.getNombreUsuario());//NOMBRE USUARIO
		imagenPerfil.setSource(new ExternalResource(userP.getFotoPerfil()));//IMAGEN PERFIL
		
		//LISTAR IMAGENES
		Image img;
		for(Elemento pub: publi.contiene.toArray()) {
			img = new Image();
			img.setSource(new ExternalResource(pub.getPathName()));
			img.setWidth(100,Unit.PERCENTAGE);
			img.setHeight(100,Unit.PERCENTAGE);
			horizontalLayoutListaElementos.addComponent(img);
		}

		cargarMenciones();
	}
	
	
	public void verUsuario() {
		//ver al usuario
		((MyUI)UI.getCurrent()).setUserVer(userP);
		if(((MyUI)UI.getCurrent()).getUserVer().equals(((MyUI)UI.getCurrent()).getUsuario())) {
			//mi perfil
			((MyUI)UI.getCurrent()).getNavigator2().navigateTo("VerPerfilPropio");
		}else {
			//no es mi perfil
			((MyUI)UI.getCurrent()).getNavigator2().navigateTo("VerPerfil");
		}
		
	}
	
	
	public void DarMeGustaPublicacion() {
		if(((MyUI)UI.getCurrent()).getiRegistrado().DarMeGusta_Publicacion(((MyUI)UI.getCurrent()).getUsuario().getORMID(),publi.getORMID())) {
			((MyUI)UI.getCurrent()).updateUser();
			//ya le gusta
			if(meGusta.getIcon() == VaadinIcons.HEART_O) {
				publiMeGusta = true;
				crearNotificacionMeGustaP();
				if(correctas)Notification.show("Notificaciones creadas con exito.",Type.WARNING_MESSAGE);
				else Notification.show("Las notificaciones no se crearon.",Type.WARNING_MESSAGE);
				meGusta.setIcon(VaadinIcons.HEART);
			}else {
				publiMeGusta = false;
				crearNotificacionMeGustaP();
				if(correctas)Notification.show("Notificaciones creadas con exito.",Type.WARNING_MESSAGE);
				else Notification.show("Las notificaciones no se crearon.",Type.WARNING_MESSAGE);
				meGusta.setIcon(VaadinIcons.HEART_O);
			}
			cambiarMeGusta();	
		}
	}
	
	//secondary
	public void cambiarMeGusta() {///metodo que se encarga de actualizar los numeros de me gusta y gente
		String meGusta = publi.gustada_por.size() + " Me gusta: ";
		int cont = 0;
		for(Usuario_Registrado user: publi.gustada_por.toArray()) {
			if(cont == 2) {
				break;
			}else {
				if(cont == 0) {
					if(publi.gustada_por.size() == 1) {
						meGusta += user.getNombreUsuario() + "...";
					}else {
						meGusta += user.getNombreUsuario() + ", ";
					}
				}else {
					meGusta += user.getNombreUsuario() + "...";
				}				
			}
			cont++;
		}
		labelMegusta.setCaption(meGusta);
	}
	
	public void EliminarPublicacion() {
		
		if(((MyUI)UI.getCurrent()).getUserType() == 1) {
			if(((MyUI)UI.getCurrent()).getiRegistrado().Eliminar_Publicacion(publi.getORMID())) {
				Notification.show("Publicacion eliminada con éxito.",Type.ERROR_MESSAGE);
				((MyUI)UI.getCurrent()).updateUser();
				((MyUI)UI.getCurrent()).getNavigator2().navigateTo("Buscar");
			}else {
				Notification.show("No se pudo eliminar.",Type.ERROR_MESSAGE);
			}
		}else if(((MyUI)UI.getCurrent()).getUserType() == 2) {
			if(((MyUI)UI.getCurrent()).getiAdmin().Eliminar_PublicacionAdmin(publi.getORMID())) {
				Notification.show("Publicacion eliminada con éxito.",Type.ERROR_MESSAGE);
				((MyUI)UI.getCurrent()).getNavigator2().navigateTo("Buscar");
			}else {
				Notification.show("No se pudo eliminar.",Type.ERROR_MESSAGE);
			}
		}	
	}
	//secondary
	public void cargarMenciones() {
		String menciones = "Mencionados: ";
		//listar mencionados
		for(Usuario_Registrado user: publi.menciona_a.toArray()) {
			menciones += "@" + user.getNombreUsuario() + "";
			if(((MyUI)UI.getCurrent()).getUserType() == 1) {
				if(user.getNombreUsuario().equals(((MyUI)UI.getCurrent()).getUsuario().getNombreUsuario())) {
					buttonEliminarMencion.setVisible(true);
				}
			}

		}
		mencionados.setValue(menciones);
		
	}
	
	public void EliminarMencion() {
		boolean desmencionado = ((MyUI)UI.getCurrent()).getiRegistrado().Eliminar_Mencion(((MyUI)UI.getCurrent()).getUsuario().getORMID(),publi.getORMID());
		if(desmencionado) {
			Notification.show("Ya no estás mencionado en esta publicacion.",Type.ERROR_MESSAGE);
			((MyUI)UI.getCurrent()).updateUser();
			cargarMenciones();
		}else {
			Notification.show("No se pudo eliminar la mencion.",Type.ERROR_MESSAGE);
		}
	}
	
	public void crearNotificacionMeGustaP() {
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