package Instagual;

import java.awt.Image;

import com.vaadin.navigator.View;
import com.vaadin.server.ExternalResource;
import com.vaadin.ui.UI;

import ual.mds2.Instagual.Usuario_ventana;
import ual.mds2.app.MyUI;

public class Usuario extends Usuario_ventana {
	private Image _imagenUsuarioI;
	public Buscar_por_usuario _lista_de_usuarios_de_busqueda;
	public Ver_perfil_de_usuario_vista_no_registrado_publica _ver_perfil_de_usuario_vista_no_registrado_publica;
	instagualbdorm.Usuario_Registrado userP =null;
	
	
	public Usuario(instagualbdorm.Usuario_Registrado user) {
		userP = user;
		imagePerfil.setSource(new ExternalResource(userP.getFotoPerfil()));
		nativeButtonNombreUsuario.setCaption(userP.getNombreUsuario());
		imagePerfil.addClickListener(
				event-> verPerfilUsuario()
				);
		nativeButtonNombreUsuario.addClickListener(
				event-> verPerfilUsuario()
				);
	}
	
	public void verPerfilUsuario() {
		if(((MyUI)UI.getCurrent()).getUserType() == 1) {
			if(userP.getORMID() == ((MyUI)UI.getCurrent()).getUsuario().getORMID() ) {//yo
				((MyUI)UI.getCurrent()).getNavigator2().navigateTo("VerPerfilPropio");
			}else {
				((MyUI)UI.getCurrent()).setUserVer(userP);
				((MyUI)UI.getCurrent()).getNavigator2().navigateTo("VerPerfil");
			}
		}else {
			((MyUI)UI.getCurrent()).setUserVer(userP);
			((MyUI)UI.getCurrent()).getNavigator2().navigateTo("VerPerfil");
		}

		
	}
}