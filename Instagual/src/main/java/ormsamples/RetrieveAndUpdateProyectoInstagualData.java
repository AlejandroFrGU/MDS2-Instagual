/**
 * Licensee: Alejandro(University of Almeria)
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class RetrieveAndUpdateProyectoInstagualData {
	public void retrieveAndUpdateTestData() throws PersistentException {
		PersistentTransaction t = instagualbdorm.ProyectoInstagualPersistentManager.instance().getSession().beginTransaction();
		try {
			instagualbdorm.Usuario linstagualbdormUsuario = instagualbdorm.UsuarioDAO.loadUsuarioByQuery(null, null);
			// Update the properties of the persistent object
			instagualbdorm.UsuarioDAO.save(linstagualbdormUsuario);
			instagualbdorm.Usuario_Registrado linstagualbdormUsuario_Registrado = instagualbdorm.Usuario_RegistradoDAO.loadUsuario_RegistradoByQuery(null, null);
			// Update the properties of the persistent object
			instagualbdorm.Usuario_RegistradoDAO.save(linstagualbdormUsuario_Registrado);
			instagualbdorm.Etiqueta linstagualbdormEtiqueta = instagualbdorm.EtiquetaDAO.loadEtiquetaByQuery(null, null);
			// Update the properties of the persistent object
			instagualbdorm.EtiquetaDAO.save(linstagualbdormEtiqueta);
			instagualbdorm.Administrador linstagualbdormAdministrador = instagualbdorm.AdministradorDAO.loadAdministradorByQuery(null, null);
			// Update the properties of the persistent object
			instagualbdorm.AdministradorDAO.save(linstagualbdormAdministrador);
			instagualbdorm.Elemento linstagualbdormElemento = instagualbdorm.ElementoDAO.loadElementoByQuery(null, null);
			// Update the properties of the persistent object
			instagualbdorm.ElementoDAO.save(linstagualbdormElemento);
			instagualbdorm.Comentario linstagualbdormComentario = instagualbdorm.ComentarioDAO.loadComentarioByQuery(null, null);
			// Update the properties of the persistent object
			instagualbdorm.ComentarioDAO.save(linstagualbdormComentario);
			instagualbdorm.Configuracion linstagualbdormConfiguracion = instagualbdorm.ConfiguracionDAO.loadConfiguracionByQuery(null, null);
			// Update the properties of the persistent object
			instagualbdorm.ConfiguracionDAO.save(linstagualbdormConfiguracion);
			instagualbdorm.Publicacion linstagualbdormPublicacion = instagualbdorm.PublicacionDAO.loadPublicacionByQuery(null, null);
			// Update the properties of the persistent object
			instagualbdorm.PublicacionDAO.save(linstagualbdormPublicacion);
			instagualbdorm.Notificacion linstagualbdormNotificacion = instagualbdorm.NotificacionDAO.loadNotificacionByQuery(null, null);
			// Update the properties of the persistent object
			instagualbdorm.NotificacionDAO.save(linstagualbdormNotificacion);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public void retrieveByCriteria() throws PersistentException {
		System.out.println("Retrieving Usuario by UsuarioCriteria");
		instagualbdorm.UsuarioCriteria linstagualbdormUsuarioCriteria = new instagualbdorm.UsuarioCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//linstagualbdormUsuarioCriteria.IDUsuario.eq();
		System.out.println(linstagualbdormUsuarioCriteria.uniqueUsuario());
		
		System.out.println("Retrieving Usuario_Registrado by Usuario_RegistradoCriteria");
		instagualbdorm.Usuario_RegistradoCriteria linstagualbdormUsuario_RegistradoCriteria = new instagualbdorm.Usuario_RegistradoCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//linstagualbdormUsuario_RegistradoCriteria.IDUsuario.eq();
		System.out.println(linstagualbdormUsuario_RegistradoCriteria.uniqueUsuario_Registrado());
		
		System.out.println("Retrieving Etiqueta by EtiquetaCriteria");
		instagualbdorm.EtiquetaCriteria linstagualbdormEtiquetaCriteria = new instagualbdorm.EtiquetaCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//linstagualbdormEtiquetaCriteria.IDEtiqueta.eq();
		System.out.println(linstagualbdormEtiquetaCriteria.uniqueEtiqueta());
		
		System.out.println("Retrieving Administrador by AdministradorCriteria");
		instagualbdorm.AdministradorCriteria linstagualbdormAdministradorCriteria = new instagualbdorm.AdministradorCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//linstagualbdormAdministradorCriteria.IDUsuario.eq();
		System.out.println(linstagualbdormAdministradorCriteria.uniqueAdministrador());
		
		System.out.println("Retrieving Elemento by ElementoCriteria");
		instagualbdorm.ElementoCriteria linstagualbdormElementoCriteria = new instagualbdorm.ElementoCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//linstagualbdormElementoCriteria.IDElemento.eq();
		System.out.println(linstagualbdormElementoCriteria.uniqueElemento());
		
		System.out.println("Retrieving Comentario by ComentarioCriteria");
		instagualbdorm.ComentarioCriteria linstagualbdormComentarioCriteria = new instagualbdorm.ComentarioCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//linstagualbdormComentarioCriteria.IDComentario.eq();
		System.out.println(linstagualbdormComentarioCriteria.uniqueComentario());
		
		System.out.println("Retrieving Configuracion by ConfiguracionCriteria");
		instagualbdorm.ConfiguracionCriteria linstagualbdormConfiguracionCriteria = new instagualbdorm.ConfiguracionCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//linstagualbdormConfiguracionCriteria.IDConfiguracion.eq();
		System.out.println(linstagualbdormConfiguracionCriteria.uniqueConfiguracion());
		
		System.out.println("Retrieving Publicacion by PublicacionCriteria");
		instagualbdorm.PublicacionCriteria linstagualbdormPublicacionCriteria = new instagualbdorm.PublicacionCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//linstagualbdormPublicacionCriteria.IDpublicacion.eq();
		System.out.println(linstagualbdormPublicacionCriteria.uniquePublicacion());
		
		System.out.println("Retrieving Notificacion by NotificacionCriteria");
		instagualbdorm.NotificacionCriteria linstagualbdormNotificacionCriteria = new instagualbdorm.NotificacionCriteria();
		// Please uncomment the follow line and fill in parameter(s)
		//linstagualbdormNotificacionCriteria.IDNotificacion.eq();
		System.out.println(linstagualbdormNotificacionCriteria.uniqueNotificacion());
		
	}
	
	
	public static void main(String[] args) {
		try {
			RetrieveAndUpdateProyectoInstagualData retrieveAndUpdateProyectoInstagualData = new RetrieveAndUpdateProyectoInstagualData();
			try {
				retrieveAndUpdateProyectoInstagualData.retrieveAndUpdateTestData();
				//retrieveAndUpdateProyectoInstagualData.retrieveByCriteria();
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
