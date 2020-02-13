package Instagual;

import java.util.List;

import com.vaadin.navigator.View;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Notification.Type;

import instagualbdorm.BD_Principal;
import instagualbdorm.Publicacion;
import ual.mds2.Instagual.Ver_pagina_principal_ventana;
import ual.mds2.app.MyUI;

public class Ver_pagina_principal  extends Ver_pagina_principal_ventana implements View{
	public Menu_inferior _menu_inferior;
	public Publicacion_Pagina_Principal _publicacion;

	public Ver_pagina_principal() {
		ListarPublicacionesPaginaPrincipal();
		
	}
	
	public void ListarPublicacionesPaginaPrincipal() {
			List<instagualbdorm.Publicacion> lista = ((MyUI)UI.getCurrent()).getiRegistrado().ListarPublicacionesPagina_Principal();
			for(instagualbdorm.Publicacion pub: lista) {
				if(pub.getPropiedad_de().getActivo()) {
					if(pub.getPropiedad_de().getORMID() != ((MyUI)UI.getCurrent()).getUsuario().getORMID()) {
						Publicacion_Pagina_Principal publiPP = new Publicacion_Pagina_Principal(pub);
						verticalLayoutListaPublicacionesPaginaPrincipal.addComponent(publiPP);
					}
				}
			}
	}
}