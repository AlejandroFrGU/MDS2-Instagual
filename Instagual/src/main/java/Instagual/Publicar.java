package Instagual;

import com.vaadin.navigator.View;
import com.vaadin.server.ExternalResource;
import com.vaadin.server.Sizeable.Unit;
import com.vaadin.ui.Image;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.UI;
import com.vaadin.ui.Video;

import instagualbdorm.BD_Principal;
import ual.mds2.Instagual.Publicar_ventana;
import ual.mds2.app.MyUI;

public class Publicar extends Publicar_ventana implements View{
	//private Button _publicarB;
	public Menu_inferior _menu_inferior;
	public Ver_lista_de_elementos_en_la_publicacion _ver_lista_de_elementos_en_la_publicacion;
	iUsuario_registrado iRegistrado = new BD_Principal();
	String[] fotos = new String[5];
	int i = 0;
	public Publicar() {
		tFEtiqueta.setMaxLength(9);
		tfDescripcion.setMaxLength(50);
		buttonPublicar.addClickListener(
				event->PublicarPublicacion()
				);
		buttonSubir.addClickListener(
				event->SumImage()
				);
		
	}
	
	
	private void SumImage() {
		if(uRLFoto.getValue().contains(".jpg") || uRLFoto.getValue().contains(".png")||uRLFoto.getValue().contains(".gif")) {
			if(i == 5) {
				Notification.show("Ya se incluyo el máximo de imagenes.", Notification.Type.WARNING_MESSAGE);
			}else {
				fotos[i] = uRLFoto.getValue();
				Image img = new Image();
				img.setSource(new ExternalResource(uRLFoto.getValue()));
				img.setWidth(100,Unit.PERCENTAGE);
				img.setHeight(100,Unit.PERCENTAGE);
				hlImagenesVideos.addComponent(img);
				i++;
				
			}
		}else {
			Notification.show("Vinculo de imagen erroneo.", Notification.Type.WARNING_MESSAGE);
		}

	
	}


	public void PublicarPublicacion() {
		String etiqueta = tFEtiqueta.getValue();
		String aDescripcion = tfDescripcion.getValue();
		String[] menciones = new String[2];
		
		menciones[0] = mencion1.getValue();
		menciones[1] = mencion2.getValue();
		//Notification.show("Menciones " + mencion1.getValue() + " mencion2 = "+ mencion2.getValue(), Notification.Type.WARNING_MESSAGE);
		
		
		//faltan campos por rellenar
		if(etiqueta == null | aDescripcion == null || fotos[0] == null) {
			Notification.show("Es necesario una: \n"
					+ "Etiqueta, descripcion y \n"
					+ "al menos una imagen", Notification.Type.WARNING_MESSAGE);
		}else {//campos necesarios relenos
			int aIDUsuario = ((MyUI)UI.getCurrent()).getUsuario().getORMID();
			boolean publicada = this.iRegistrado.Publicar_Publicacion(aDescripcion,aIDUsuario, fotos, etiqueta,menciones);
			if(publicada) {
				((MyUI)UI.getCurrent()).updateUser();
				Notification.show("Creado con exito.", Notification.Type.WARNING_MESSAGE);
				((MyUI)UI.getCurrent()).getNavigator2().navigateTo("Publicar");
			}else {
				((MyUI)UI.getCurrent()).updateUser();
				Notification.show("No se pudo crear.\n Posibles razones: \n"
						+ "Usuarios mencionados incorrectos.", Notification.Type.WARNING_MESSAGE);
				((MyUI)UI.getCurrent()).getNavigator2().navigateTo("VerPerfilPropio");
			}
		}
		
		
	}

}