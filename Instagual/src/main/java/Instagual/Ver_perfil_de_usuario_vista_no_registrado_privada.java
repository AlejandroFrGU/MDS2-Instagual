package Instagual;

import java.util.Iterator;

import com.vaadin.navigator.View;
import com.vaadin.server.ExternalResource;
import com.vaadin.server.Sizeable.Unit;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import instagualbdorm.BD_Principal;
import instagualbdorm.Usuario_Registrado;
import ual.mds2.Instagual.Ver_perfil_de_usuario_vista_no_registrado_privada_ventana;
import ual.mds2.app.MyUI;

public class Ver_perfil_de_usuario_vista_no_registrado_privada extends Ver_perfil_de_usuario_vista_no_registrado_privada_ventana implements View{
	instagualbdorm.Usuario_Registrado userP = null;
	iUsuario_registrado iRegistrado = ((MyUI)UI.getCurrent()).getiRegistrado();
	
	public Ver_perfil_de_usuario_vista_no_registrado_privada() {

		if(((MyUI)UI.getCurrent()).getUserType() == 0) {
			userP = ((MyUI)UI.getCurrent()).getUserVer();
			
			menuActividades.setVisible(false);
			//nombreUsuario
			labelNombreDeUsuario.setValue(userP.getNombreUsuario());
			//Imagen
			imagePerfil.setSource(new ExternalResource(userP.getFotoPerfil()));
					
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
			
			
			//COMUN PRIVADO 
			//si
			if(userP.getConfigura().getPerfilPrivado()) {
					verticalLayoutOpcionesMenu.setVisible(false);
			}
			
			//botones off
			buttonConfiguracionVerPerfil.setVisible(false);
			buttonEditarPerfil.setVisible(false);
			buttonEliminarPerfil.setVisible(false);
			buttonSeguir.setVisible(false);
			buttonBloquear.setVisible(false);
			//
			menuPublicaciones.addClickListener(
					event -> VerPublicaciones()
					);
			menuEtiquetadas.addClickListener(
					event -> VerPublicacionesEtiquetadas()
					);
		}	
		
		
	}
	
	

	public void BloquearUsuario() {
		if(buttonBloquear.getCaption().equals("Bloquear")) {
			buttonBloquear.setCaption("Desbloquear");
		}else {
			buttonBloquear.setCaption("Bloquear");
		}
		this.iRegistrado.Bloquear_Usuario(((MyUI)UI.getCurrent()).getUsuario().getORMID(), userP.getORMID());
		((MyUI)UI.getCurrent()).getNavigator2().navigateTo("VerPerfilPropio");
	}

	public void SeguirDejarSeguir() {
		if(buttonSeguir.getCaption().equals("Seguir")) {
			buttonSeguir.setCaption("No seguir");
		}else {
			buttonSeguir.setCaption("Seguir");
		}
		this.iRegistrado.Seguir_DejarSeguir(((MyUI)UI.getCurrent()).getUsuario().getORMID(), userP.getORMID());
		((MyUI)UI.getCurrent()).getNavigator2().navigateTo("VerPerfilPropio");
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
}