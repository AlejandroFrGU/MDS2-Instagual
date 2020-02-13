package Instagual;

import com.vaadin.navigator.View;
import com.vaadin.ui.UI;

import instagualbdorm.Usuario_Registrado;
import ual.mds2.Instagual.Ver_lista_de_usuarios_bloqueados_ventana;
import ual.mds2.app.MyUI;

public class Ver_lista_de_usuarios_bloqueados extends Ver_lista_de_usuarios_bloqueados_ventana implements View{
	public Configuracion _configuracion;
	public Usuario_bloqueado _usuario_bloqueado;
	Usuario_Registrado usuarioActual = null;
	public Ver_lista_de_usuarios_bloqueados() {
		usuarioActual = ((MyUI)UI.getCurrent()).getUsuario();
		ListarUsuariosBloqueados();
	}

	public void ListarUsuariosBloqueados() {
		//verticalLayoutListaUsuarios
		for(Usuario_Registrado bloqueado: usuarioActual.bloquea_a.toArray()) {
			Usuario use1 = new Usuario(bloqueado);
			verticalLayoutListaUsuarios.addComponent(use1);
		}
	}
}