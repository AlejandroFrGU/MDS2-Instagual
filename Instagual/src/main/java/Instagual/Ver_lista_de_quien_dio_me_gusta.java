package Instagual;

import com.vaadin.navigator.View;
import com.vaadin.ui.UI;

import instagualbdorm.Usuario_Registrado;
import ual.mds2.Instagual.Ver_lista_de_quien_dio_me_gusta_ventana;
import ual.mds2.app.MyUI;

public class Ver_lista_de_quien_dio_me_gusta extends Ver_lista_de_quien_dio_me_gusta_ventana implements View{
	public Ver_detalles_de_publicacion _ver_detalles_de_publicacion;
	public Usuario_que_dio_me_gusta _usuario_que_dio__me_gusta_;
	Usuario_Registrado userP = null;
	instagualbdorm.Publicacion publi = null;
	
	public Ver_lista_de_quien_dio_me_gusta() {
		publi = ((MyUI)UI.getCurrent()).getPublicacionVer();
		userP = publi.getPropiedad_de();
		
		ListarUsuariosPublicacionMeGusta();

		bAtras.addClickListener(
				event->((MyUI)UI.getCurrent()).getNavigator2().navigateTo("DetallePubli")
				);
	}
	
	
	public void ListarUsuariosPublicacionMeGusta() {
		for(Usuario_Registrado user: publi.gustada_por.toArray()) {
			Usuario use1 = new Usuario(user);
			verticalLayoutListaMeGusta.addComponent(use1);
		}
		
	}
}