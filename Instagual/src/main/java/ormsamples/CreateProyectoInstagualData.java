/**
 * Licensee: Alejandro(University of Almeria)
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class CreateProyectoInstagualData {
	public void createTestData() throws PersistentException {
		PersistentTransaction t = instagualbdorm.ProyectoInstagualPersistentManager.instance().getSession().beginTransaction();
		try {
			instagualbdorm.Usuario linstagualbdormUsuario = instagualbdorm.UsuarioDAO.createUsuario();
			// Initialize the properties of the persistent object here
			instagualbdorm.UsuarioDAO.save(linstagualbdormUsuario);
			instagualbdorm.Usuario_Registrado linstagualbdormUsuario_Registrado = instagualbdorm.Usuario_RegistradoDAO.createUsuario_Registrado();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : notificaciones_de, le_gusta, mencionado_en, sube, comenta, gusta, seguido_por, bloquea_a, configura, sigue_a, bloquedo_por, esAdmin, Activo
			instagualbdorm.Usuario_RegistradoDAO.save(linstagualbdormUsuario_Registrado);
			instagualbdorm.Etiqueta linstagualbdormEtiqueta = instagualbdorm.EtiquetaDAO.createEtiqueta();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : esta_en
			instagualbdorm.EtiquetaDAO.save(linstagualbdormEtiqueta);
			instagualbdorm.Administrador linstagualbdormAdministrador = instagualbdorm.AdministradorDAO.createAdministrador();
			// Initialize the properties of the persistent object here
			instagualbdorm.AdministradorDAO.save(linstagualbdormAdministrador);
			instagualbdorm.Elemento linstagualbdormElemento = instagualbdorm.ElementoDAO.createElemento();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : contenido_en
			instagualbdorm.ElementoDAO.save(linstagualbdormElemento);
			instagualbdorm.Comentario linstagualbdormComentario = instagualbdorm.ComentarioDAO.createComentario();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : propiedad_de, gustado_por, contenido_en
			instagualbdorm.ComentarioDAO.save(linstagualbdormComentario);
			instagualbdorm.Configuracion linstagualbdormConfiguracion = instagualbdorm.ConfiguracionDAO.createConfiguracion();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : notificacionesEliminacionPublicacion, notificacionesSeguir, notificacionesComentarios, notificacionesMeGusta, notificacionesTodas, OcultosSeguidoresSeguidos, perfilPrivado, configurado_por
			instagualbdorm.ConfiguracionDAO.save(linstagualbdormConfiguracion);
			instagualbdorm.Publicacion linstagualbdormPublicacion = instagualbdorm.PublicacionDAO.createPublicacion();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : contiene, gustada_por, menciona_a, contiene_a, tiene, propiedad_de
			instagualbdorm.PublicacionDAO.save(linstagualbdormPublicacion);
			instagualbdorm.Notificacion linstagualbdormNotificacion = instagualbdorm.NotificacionDAO.createNotificacion();
			// TODO Initialize the properties of the persistent object here, the following properties must be initialized before saving : recibida, contiene_notificaciones
			instagualbdorm.NotificacionDAO.save(linstagualbdormNotificacion);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			CreateProyectoInstagualData createProyectoInstagualData = new CreateProyectoInstagualData();
			try {
				createProyectoInstagualData.createTestData();
			}
			finally {
				instagualbdorm.ProyectoInstagualPersistentManager.instance().disposePersistentManager();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
