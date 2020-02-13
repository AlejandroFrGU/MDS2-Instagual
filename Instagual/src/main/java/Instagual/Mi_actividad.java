package Instagual;

import com.vaadin.shared.ui.ContentMode;

import ual.mds2.Instagual.Mi_actividad_ventana;

public class Mi_actividad extends Mi_actividad_ventana{
	public Ver_lista_de_mis_actividades _ver_lista_de_mis_actividades;
	public Ver_detalles_de_publicacion_vista_actividad__publicacion_y_mi_actividad _ver_detalles_de_publicacion_vista_actividad__publicacion_y_mi_actividad;
	public Ver_detalles_de_publicacion_vista_publicacion_propia _ver_detalles_de_publicacion_vista_publicacion_propia;

	public Mi_actividad(String fecha,String message) {
		notificacionFecha.setValue(fecha);
		notificacionCuerpo.setContentMode(ContentMode.PREFORMATTED);
		notificacionCuerpo.setValue(message);
	}
}