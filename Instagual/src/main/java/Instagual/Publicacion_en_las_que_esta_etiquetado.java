package Instagual;

import com.vaadin.server.ExternalResource;
import com.vaadin.ui.UI;

import ual.mds2.Instagual.Publicacion_en_las_que_esta_etiquetado_ventana;
import ual.mds2.app.MyUI;

public class Publicacion_en_las_que_esta_etiquetado extends Publicacion_en_las_que_esta_etiquetado_ventana {
	public Ver_lista_de_publicaciones_en_las_que_esta_etiquetado _ver_lista_de_publicaciones_en_las_que_esta_etiquetado;
	public Ver_detalles_de_publicacion_vista_publicacion_etiquetado _ver_detalles_de_publicacion_vista_publicacion_etiquetado;
	instagualbdorm.Publicacion publi = null;
	instagualbdorm.Usuario_Registrado userP = null;
	
	public Publicacion_en_las_que_esta_etiquetado(instagualbdorm.Publicacion pub) {
		publi = pub;
		userP = publi.getPropiedad_de();
		nombreUsuario.setCaption(publi.getPropiedad_de().getNombreUsuario());
		imageUsuario.setSource(new ExternalResource(userP.getFotoPerfil()));
		imagePrueba.setSource(new ExternalResource(publi.getImagenPreview()));
		imagePrueba.addClickListener(
				event -> verDetallePublicacion()
				);
		nombreUsuario.addClickListener(
				event -> verUsuario()
				);
		imageUsuario.addClickListener(
				event -> verUsuario()
				);
		
	}
	
	public void verDetallePublicacion() {
		((MyUI)UI.getCurrent()).setPublicacionVer(publi);
		((MyUI)UI.getCurrent()).getNavigator2().navigateTo("DetallePubli");
	}
	public void verUsuario() {
		((MyUI)UI.getCurrent()).setUserVer(userP);
		if(((MyUI)UI.getCurrent()).getUserType() == 2) {//admin
			((MyUI)UI.getCurrent()).getNavigator2().navigateTo("VerPerfilPropio");
		}else if(((MyUI)UI.getCurrent()).getUserType() == 0){//invitado
			((MyUI)UI.getCurrent()).getNavigator2().navigateTo("VerPerfil");
		}else if(userP.getORMID() == ((MyUI)UI.getCurrent()).getUsuario().getORMID()) {//propietario
			((MyUI)UI.getCurrent()).getNavigator2().navigateTo("VerPerfilPropio");
		}else {//no propietario
			((MyUI)UI.getCurrent()).getNavigator2().navigateTo("VerPerfil");
		}
	}
}