package Instagual;

import com.vaadin.server.ExternalResource;
import com.vaadin.ui.UI;

import ual.mds2.Instagual.Publicacion_propia_ventana;
import ual.mds2.app.MyUI;

public class Publicacion_propia extends Publicacion_propia_ventana{
	public Ver_lista_de_mis_publicaciones _ver_lista_de_mis_publicaciones;
	public Ver_detalles_de_publicacion_vista_publicacion_propia _ver_detalles_de_publicacion_vista_publicacion_propia;
	instagualbdorm.Publicacion publi = null;
	
	public Publicacion_propia(instagualbdorm.Publicacion pub) {
		publi = pub;
		imagePrueba.setSource(new ExternalResource(publi.getImagenPreview()));
		imagePrueba.addClickListener(
				event -> verDetallePublicacion()
				);
		
	}
	
	public void verDetallePublicacion() {
		((MyUI)UI.getCurrent()).setPublicacionVer(publi);
		((MyUI)UI.getCurrent()).getNavigator2().navigateTo("DetallePubli");
	}
}