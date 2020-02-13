package Instagual;

import com.vaadin.server.ExternalResource;
import com.vaadin.server.Sizeable.Unit;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import instagualbdorm.Usuario_Registrado;
import ual.mds2.app.MyUI;

public class Ver_perfil_de_usuario_vista_administrador extends Ver_perfil_de_usuario_vista_no_registrado_publica {
	public Buscar_vista_admin _buscar_vista_admin;
	public Ver_lista_de_mis_actividades_admin _ver_lista_de_mis_actividades_admin;
	public Eliminar_usuario _eliminar_usuario;
	Usuario_Registrado userP = null;
	
	public Ver_perfil_de_usuario_vista_administrador() {
		if(((MyUI)UI.getCurrent()).getUserType() == 2) {
			userP = ((MyUI)UI.getCurrent()).getUserVer();
			
			//nombreUsuario
			labelNombreDeUsuario.setValue(userP.getNombreUsuario());
			//Imagen
			imagePerfil.setSource(new ExternalResource(userP.getFotoPerfil()));
					
			//Seguidores
			labelSeguidores.setValue("Seguidores " + userP.seguido_por.size());
			//Seguidos
			labelSeguidos.setValue("Seguidos " + userP.sigue_a.size());
			
			
			buttonConfiguracionVerPerfil.setVisible(false);
			buttonEditarPerfil.setVisible(false);
			buttonSeguir.setVisible(false);
			buttonBloquear.setVisible(false);
			
			menuPublicaciones.addClickListener(
					event -> VerPublicaciones()
					);
			buttonEliminarPerfil.addClickListener(
					event -> EliminarUsuario()
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
	

	public void EliminarUsuario() {
		if(((MyUI)UI.getCurrent()).getiAdmin().Eliminar_Usuario(userP.getORMID())) {
			Notification.show("Usuario eliminado.", Notification.Type.WARNING_MESSAGE);
			((MyUI)UI.getCurrent()).getNavigator2().navigateTo("Buscar");
		}else {
			Notification.show("Hubo un error.", Notification.Type.WARNING_MESSAGE);
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
	public void cargarActividades() {
		verticalLayoutLista.removeAllComponents();
		for(instagualbdorm.Notificacion notification: userP.notificaciones_de.toArray("IDNotificacion",false)) {
			if(!notification.getRecibida()) {
				Mi_actividad miAc = new Mi_actividad(notification.getFecha(), notification.getDescripcion());
				verticalLayoutLista.addComponent(miAc);
			}
		}
	}
	
}