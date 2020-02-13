package Instagual;

import java.util.List;

import com.vaadin.navigator.View;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import instagualbdorm.BD_Principal;
import ual.mds2.Instagual.Buscar_ventana;
import ual.mds2.app.MyUI;

public class Buscar  extends Buscar_ventana implements View{
//	private Button _buscarB;
	public Buscar_por_usuario _buscar_por_usuario;
	public Buscar_por_etiqueta _buscar_por_etiqueta;
	public boolean users = true;
	iUsuario_registrado iRegistrado = ((MyUI)UI.getCurrent()).getiRegistrado();
	iUsuario_no_registrado_movil iNoRegistradoMovil = ((MyUI)UI.getCurrent()).getiNoRegistradoMovil();
	iUsuario_administrador iAdmin =((MyUI)UI.getCurrent()).getiAdmin();
	
	public Buscar() {
		verticalLayoutListaBusqueda.setVisible(false);
		buttonUsuarios.addClickListener(
				event->PorUsuarios()
				);
		buttonPublicaciones.addClickListener(
				event->PorPublicaciones()
				);
		buttonBuscar.addClickListener(
				event->Buscar()
				);
	}
	
	public void Buscar() {
		String valor = textFieldBuscar.getValue(); 
		List<instagualbdorm.Publicacion> listaPubli = null;
		List<instagualbdorm.Usuario_Registrado> listaUsers = null;
		
		if(((MyUI)UI.getCurrent()).getUserType() == 0) {
			if(!users) {
				listaPubli = iNoRegistradoMovil.Buscar_Publicaciones(valor);
			}else if(users) {
				listaUsers = iNoRegistradoMovil.Buscar_Usuarios(valor);				
			}
		}else if(((MyUI)UI.getCurrent()).getUserType() == 1) {
			if(!users) {
				listaPubli = iRegistrado.Buscar_PublicacionesRegistrado(valor);
			}else if(users) {
				listaUsers = iRegistrado.Buscar_UsuariosRegistrado(valor);
			}
		}else if(((MyUI)UI.getCurrent()).getUserType() == 2) {
			if(!users) {
				listaPubli = iAdmin.Buscar_PublicacionesAdmin(valor);
			}else if(users) {
				listaUsers = iAdmin.Buscar_UsuariosAdmin(valor);
			}
		}
		
		if(!users) {
			verticalLayoutListaBusqueda.setVisible(true);
			verticalLayoutListaBusqueda.removeAllComponents();
			
			for(instagualbdorm.Publicacion pub: listaPubli) {
				//si eres admin ves las publicaciones de los inactivos, sino no las ves
				if(!pub.getPropiedad_de().getActivo() && ((MyUI)UI.getCurrent()).getUserType() != 2)continue;
				Publicacion_de_busqueda publi = new Publicacion_de_busqueda(pub);
				verticalLayoutListaBusqueda.addComponent(publi);
			}
		}else if(users) {
			verticalLayoutListaBusqueda.setVisible(true);
			verticalLayoutListaBusqueda.removeAllComponents();	
			
			for(instagualbdorm.Usuario_Registrado user: listaUsers) {
				//si eres admin ves los usuarios inactivos, sino no se ven
				if(!user.getActivo() && ((MyUI)UI.getCurrent()).getUserType() != 2)continue;
				if(((MyUI)UI.getCurrent()).getUserType() == 1) {///no me veo en la lista de usuarios
					if(user.getORMID() == ((MyUI)UI.getCurrent()).getUsuario().getORMID())continue;
				}
				Usuario use1 = new Usuario(user);
				verticalLayoutListaBusqueda.addComponent(use1);					
			}
		}
	}
	
	public void PorUsuarios() {
		users = true;
	}
	
	public void PorPublicaciones() {
		users = false;
	}
}