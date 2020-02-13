package Instagual;

import ual.mds2.app.MyUI;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

import com.vaadin.navigator.View;
import com.vaadin.server.ExternalResource;
import com.vaadin.server.Resource;
import com.vaadin.server.Sizeable.Unit;
import com.vaadin.ui.Component;
import com.vaadin.ui.Image;
import com.vaadin.ui.Notification;
import com.vaadin.ui.ProgressBar;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.Upload;
import com.vaadin.ui.Upload.Receiver;

import instagualbdorm.BD_Principal;
import ual.mds2.Instagual.Editar_perfil_ventana;

public class Editar_perfil extends Editar_perfil_ventana implements View{
	//private Button _guardarCambiosB;
	public Ver_perfil_de_usuario_vista_perfil_propio _ver_perfil_de_usuario_vista_perfil_propio;
	public Registrado_con_exitoELIMINAR _registrado_con_exito;
	instagualbdorm.Usuario_Registrado userP = null;
	iUsuario_registrado iRegistrado = new BD_Principal();
	
	public Editar_perfil() {
		if(((MyUI)UI.getCurrent()).getUserType() == 0) {//NO ESTA CONTENIDA
			this.setWidth(400,Unit.PIXELS);
			this.setHeight(720,Unit.PIXELS);
		}
		
		textFieldNombre.setMaxLength(9);
		textFieldApellido.setMaxLength(9);
		textFieldNombreUsuario.setMaxLength(9);
		
		userP = ((MyUI)UI.getCurrent()).getUsuario();
		textFieldImagen.setValue(userP.getFotoPerfil());
		imagenPerfil.setSource(new ExternalResource(userP.getFotoPerfil()));
		
		if(userP.getNombre() == null & userP.getApellido()== null) {
			textFieldNombre.setValue("");
			textFieldApellido.setValue("");
		}else {
			textFieldNombre.setValue(userP.getNombre());
			textFieldApellido.setValue(userP.getApellido());
		}
		
		if(((MyUI)UI.getCurrent()).getUsuario().getActivo()) 
			textFieldCodigo.setVisible(false);
		if(userP.getNombreUsuario()==null) {
			textFieldNombreUsuario.setValue("");
		}else {
			textFieldNombreUsuario.setValue(userP.getNombreUsuario());
		}
		
		buttonGuardarCambios.addClickListener(
				event-> EditarPerfil()
				);
	}

	
	public void EditarPerfil() {

		
		String[] datos = new String[5];
		
		datos[0] = textFieldImagen.getValue();
		datos[1] = textFieldNombre.getValue();; 
		datos[2] = textFieldApellido.getValue();
		datos[3] = textFieldNombreUsuario.getValue();
		datos[4] = textFieldCodigo.getValue();
		

		//NO ESTA ACTIVO
		if(!((MyUI)UI.getCurrent()).getUsuario().getActivo()) {
			//ACTIVACION
			if(datos[1] .equals("") || datos[2].equals("")|| datos[3].equals("")||datos[4].equals("")) {//FALTAN CAMPOS POR RELLENAR
				Notification.show("Faltan campos importantes por rellenar.\n Importantes: Nombre, apellido, nombreUsuario, codigo", Notification.Type.WARNING_MESSAGE);
			}else {
				if(!textFieldImagen.getValue().equals("") ) {//IMAGEN CORRECTA?
					if(textFieldImagen.getValue().contains(".jpg") || textFieldImagen.getValue().contains(".png")||textFieldImagen.getValue().contains(".gif")) {
					//si
						if(((MyUI)UI.getCurrent()).getUsuario().getCodigo().equals(textFieldCodigo.getValue())) {
							if(iRegistrado.Editar_perfil(userP.getORMID(), datos, true)){//PERFIL EDITADO CON EXITO
								Notification.show("Código correcto y perfil actualizado!", Notification.Type.WARNING_MESSAGE);
							}
						}else {//ERROR AL EDITAR PERFIL
							Notification.show("Código incorrecto.", Notification.Type.WARNING_MESSAGE);
						}
					}
				}else {//no
					Notification.show("El formato de imagen no es correcto!", Notification.Type.WARNING_MESSAGE);//no
				}	
				((MyUI) UI.getCurrent()).setUsuario(null);
				((MyUI) UI.getCurrent()).setUserType(0);
				((MyUI)UI.getCurrent()).getNavigator1().navigateTo("IniciarSesion");
				
			}
		}//ESTA ACTIVO E INICIADO
		else if(((MyUI)UI.getCurrent()).getUsuario().getActivo()){
			//FALTAN CAMPOS POR RELLENAR
			if(datos[1] .equals("") || datos[2].equals("")|| datos[3].equals("")) {
				Notification.show("Faltan campos importantes por rellenar.\n Importantes: Nombre, apellido, nombreUsuario, codigo", Notification.Type.WARNING_MESSAGE);
				//((MyUI)UI.getCurrent()).getNavigator1().navigateTo("Entrar");
			}//TODOS LOS CAMPOS RELLENOS
			else {
				if(!textFieldImagen.getValue().equals("") ) {//IMAGEN CORRECTA?
					if(textFieldImagen.getValue().contains(".jpg") || textFieldImagen.getValue().contains(".png")||textFieldImagen.getValue().contains(".gif")) {
					//si
						if(iRegistrado.Editar_perfil(userP.getORMID(), datos, true)){//PERFIL EDITADO CON EXITO
							Notification.show("Información actualizada", Notification.Type.WARNING_MESSAGE);
							((MyUI)UI.getCurrent()).updateUser();
							((MyUI)UI.getCurrent()).getNavigator2().navigateTo("VerPerfilPropio");
						}else {//ERROR AL EDITAR PERFIL
							Notification.show("Hubo un error y no se actualizo la información.\nEs posible que ya exista un usuario con ese nombre.", Notification.Type.WARNING_MESSAGE);
						}
						
					}
				}else {//no
					Notification.show("El formato de imagen no es correcto!", Notification.Type.WARNING_MESSAGE);//no
				}	
			}
		}
		
		
	}

}