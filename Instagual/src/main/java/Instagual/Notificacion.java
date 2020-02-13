package Instagual;

import com.vaadin.shared.ui.ContentMode;

import ual.mds2.Instagual.Notificacion_ventana;

public class Notificacion extends Notificacion_ventana{
	//private Button _verPerfilUsuarioB;
	//private Button _verDetallePublicacionB;
	public Ver_lista_de_notificaciones _ver_lista_de_notificaciones;
	//public Ver_perfil_de_usuario_vista_notificacion _ver_perfil_de_usuario_vista_notificacion;
	public Ver_detalles_de_publicacion_vista_publicacion_propia _ver_detalles_de_publicacion_vista_publicacion_propia;

	
	public Notificacion(String fecha,String message) {
		notificacionFecha.setValue(fecha);
		notificacionCuerpo.setContentMode(ContentMode.PREFORMATTED);
		notificacionCuerpo.setValue(message);
	}
}