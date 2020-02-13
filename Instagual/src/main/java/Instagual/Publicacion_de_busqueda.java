package Instagual;

import com.vaadin.server.ExternalResource;
import com.vaadin.server.Sizeable.Unit;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.Image;
import com.vaadin.ui.UI;
import com.vaadin.ui.Video;

import ual.mds2.Instagual.Publicacion_de_busqueda_ventana;
import ual.mds2.app.MyUI;

public class Publicacion_de_busqueda extends Publicacion_de_busqueda_ventana{
	public Buscar_por_etiqueta _buscar_por_etiqueta;
	public Ver_detalles_de_publicacion _ver_detalles_de_publicacion;
	instagualbdorm.Publicacion publi = null;
	
	public Publicacion_de_busqueda(instagualbdorm.Publicacion pub) {
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