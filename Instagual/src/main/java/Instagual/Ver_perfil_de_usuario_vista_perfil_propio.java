package Instagual;

import com.vaadin.navigator.View;
import com.vaadin.server.ExternalResource;
import com.vaadin.server.Sizeable.Unit;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import instagualbdorm.Usuario_Registrado;
import ual.mds2.app.MyUI;

public class Ver_perfil_de_usuario_vista_perfil_propio extends Ver_perfil_de_usuario_vista_no_registrado_publica  implements View{
	public Menu_inferior _menu_inferior;
	public Ver_lista_de_mis_publicaciones _ver_lista_de_mis_publicaciones;
	public Configuracion _configuracion;
	public Ver_lista_de_mis_actividades _ver_lista_de_mis_actividades;
	public Editar_perfil _editar_perfil;
	Usuario_Registrado userP = null;
	
	public Ver_perfil_de_usuario_vista_perfil_propio(){
		if(((MyUI)UI.getCurrent()).getUserType() == 1) {
			userP = ((MyUI)UI.getCurrent()).getUsuario();
			buttonEliminarPerfil.setVisible(false);
			//nombreUsuario
			labelNombreDeUsuario.setValue(userP.getNombreUsuario());
			//Imagen
			imagePerfil.setSource(new ExternalResource(userP.getFotoPerfil()));
			
			//Seguidores
			labelSeguidores.setValue("Seguidores " + userP.seguido_por.size());
			//Seguidos
			labelSeguidos.setValue("Seguidos " + userP.sigue_a.size());
			
			//Botones invisibles
			buttonSeguir.setVisible(false);
			buttonBloquear.setVisible(false);
			
			//Botones utiles
			buttonEditarPerfil.addClickListener(
					event->verEditPerfil()
					);
			buttonConfiguracionVerPerfil.addClickListener(
					event -> config()
					);
			menuPublicaciones.addClickListener(
					event -> VerPublicaciones()
					);
			menuEtiquetadas.addClickListener(
					event -> VerPublicacionesEtiquetadas()
					);
			menuActividades.addClickListener(
					event -> cargarActividades()
					);
			cargarActividades();
		}
		
	}
	
	public void config() {
		((MyUI)UI.getCurrent()).getNavigator2().navigateTo("Configuracion");
	}
	
	public void verEditPerfil() {
		((MyUI)UI.getCurrent()).getNavigator2().navigateTo("EditarPerfil");
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
	public void cargarActividades() {
		verticalLayoutLista.removeAllComponents();
		for(instagualbdorm.Notificacion notification: userP.notificaciones_de.toArray("IDNotificacion",false)) {
			if(!notification.getRecibida()) {
				Mi_actividad miAc = new Mi_actividad(notification.getFecha(), notification.getDescripcion());

				if(userP.getConfigura().getNotificacionesTodas()) {
					if(userP.getConfigura().getNotificacionesComentarios()) {
						if(notification.getTipo().equals("Comentario")) {
							verticalLayoutLista.addComponent(miAc);
						}
					}
					if(userP.getConfigura().getNotificacionesMeGusta()) {
						if(notification.getTipo().equals("MeGusta")) {
							verticalLayoutLista.addComponent(miAc);
						}
					}
					if(userP.getConfigura().getNotificacionesSeguir()) {
						if(notification.getTipo().equals("Seguir")) {
							verticalLayoutLista.addComponent(miAc);
						}
					}
				}	
			}
		}
	}
}