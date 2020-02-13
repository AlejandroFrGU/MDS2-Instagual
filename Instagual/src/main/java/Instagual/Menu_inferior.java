package Instagual;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.ui.Button;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;

import ual.mds2.Instagual.Menu_inferior_ventana;
import ual.mds2.app.*;
public class Menu_inferior extends Menu_inferior_ventana implements View{
	//private Button _paginaPrincipalB;
	//private Button _buscarB;
	//private Button _publicarB;
	//private Button _verNotificacionesActividadesB;
	//private Button _verPerfilPropioB;
	public instagualbdorm.Usuario_Registrado _usuario_registrado;
	public Buscar_vista_registrado _buscar_vista_registrado;
	public Publicar _publicar;
	public Ver_perfil_de_usuario_vista_perfil_propio _ver_perfil_de_usuario_vista_perfil_propio;
	public Ver_notificaciones_actividades _ver_notificaciones_actividades;
	public Ver_pagina_principal _ver_pagina_principal;

	Navigator nav;
	
	public Menu_inferior() {
		nav =((MyUI)UI.getCurrent()).getNavigator2();
		//nav = UI.getCurrent().getNavigator();
		nav = new Navigator(UI.getCurrent(),verticalLayoutPantallaBase);
		((MyUI)UI.getCurrent()).setNavigator2(nav);
		
		
		
		if(((MyUI)UI.getCurrent()).getUserType()==0){
			////////ajuste botones//
			verticalLayoutBotonPublicar.setVisible(false);
			verticalLayoutBotonNotificacionesActividades.setVisible(false);
			verticalLayoutBotonMiPerfil.setVisible(false);
			
			
			//userYadmin
			labelBienvenido.setVisible(false);
			verticalLayoutPantallaBienvenida.setVisible(false);
			//
			//user only
			buttonUser.setVisible(false);
			buttonAcNoti.setVisible(false);
			buttonPublicar.setVisible(false);
			//
			//admin only
			buttonCerrarSesion.setVisible(false);
			verticalLayoutCerrarSesAd.setVisible(false);
			//
			
		}else if(((MyUI)UI.getCurrent()).getUserType()==1) {
			//admin only
			buttonCerrarSesion.setVisible(false);
			verticalLayoutCerrarSesAd.setVisible(false);
			//
		}else if(((MyUI)UI.getCurrent()).getUserType()==2){
			//////Ajuste de boton Buscar y quitar botones///////////
			
			//Ajuste
			verticalLayoutBotonPaginaPrincipal.setVisible(false);
			verticalLayoutBotonPublicar.setVisible(false);
			verticalLayoutBotonNotificacionesActividades.setVisible(false);
			verticalLayoutBotonMiPerfil.setVisible(false);
			
			//botones off
			buttonHome.setVisible(false);
			buttonUser.setVisible(false);
			buttonAcNoti.setVisible(false);
			buttonPublicar.setVisible(false);
			//////////////////////////////////
		}
		
		nav.addView("DetallePubli", Ver_detalles_de_publicacion.class);
		nav.addView("ListaComentarios", Ver_lista_de_comentarios.class);
		nav.addView("PubliUsuariosMeGusta",Ver_lista_de_quien_dio_me_gusta.class);
		
		if(((MyUI)UI.getCurrent()).getUserType()==0){
			nav.addView("Home", Iniciar_sesion.class);
			nav.addView("Buscar", Buscar_vista_no_registrado_.class);
			nav.addView("VerPerfil", Ver_perfil_de_usuario_vista_no_registrado_privada.class);
			
		}else if(((MyUI)UI.getCurrent()).getUserType()==1){
			nav.addView("Home", Ver_pagina_principal.class);
			nav.addView("Buscar", Buscar_vista_no_registrado_.class);
			nav.addView("Publicar", Publicar.class);
			nav.addView("VerPerfilPropio", Ver_perfil_de_usuario_vista_perfil_propio.class);
			nav.addView("VerPerfil", Ver_perfil_de_usuario_vista_usuario_registrado.class);
			nav.addView("NotificacionesActividades", Ver_notificaciones_actividades.class);
			nav.addView("Configuracion", Configuracion.class);
			nav.addView("EditarPerfil", Editar_perfil.class);
			nav.addView("Bloqueados", Ver_lista_de_usuarios_bloqueados.class);
			
		}else {
			nav.addView("Home", Iniciar_sesion.class);
			nav.addView("Buscar", Buscar_vista_no_registrado_.class);
			nav.addView("VerPerfil", Ver_perfil_de_usuario_vista_administrador.class);
		}
		
		
		
		
		buttonHome.addClickListener(
				event ->verPaginaPrincipal()
				);
		buttonSearch.addClickListener(
				event ->buscar()
				);
		buttonPublicar.addClickListener(
				event ->publicar()
				);
		buttonAcNoti.addClickListener(
				event ->verNotificacionesActividades()
				);
		buttonUser.addClickListener(
				event->verPerfilPropio()
				);
		buttonCerrarSesion.addClickListener(
				event ->verPaginaPrincipal()
				);

	}

	public void verPaginaPrincipal() {
		if(((MyUI)UI.getCurrent()).getUserType()!=1){
			((MyUI)UI.getCurrent()).reset();
			((MyUI)UI.getCurrent()).getNavigator1().navigateTo("IniciarSesion");
		}else {
			nav.navigateTo("Home");
		}

	}

	public void buscar() {
		((MyUI)UI.getCurrent()).updateUser();
		nav.navigateTo("Buscar");
	}

	public void publicar() {
		((MyUI)UI.getCurrent()).updateUser();
		nav.navigateTo("Publicar");
	}

	public void verNotificacionesActividades() {
		((MyUI)UI.getCurrent()).updateUser();
		nav.navigateTo("NotificacionesActividades");
	}

	public void verPerfilPropio() {
		((MyUI)UI.getCurrent()).updateUser();
		nav.navigateTo("VerPerfilPropio");
	}
	
}