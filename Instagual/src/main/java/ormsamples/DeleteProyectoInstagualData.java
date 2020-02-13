/**
 * Licensee: Alejandro(University of Almeria)
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class DeleteProyectoInstagualData {
	public void deleteTestData() throws PersistentException {
		PersistentTransaction t = instagualbdorm.ProyectoInstagualPersistentManager.instance().getSession().beginTransaction();
		try {
			instagualbdorm.Usuario linstagualbdormUsuario = instagualbdorm.UsuarioDAO.loadUsuarioByQuery(null, null);
			// Delete the persistent object
			instagualbdorm.UsuarioDAO.delete(linstagualbdormUsuario);
			instagualbdorm.Usuario_Registrado linstagualbdormUsuario_Registrado = instagualbdorm.Usuario_RegistradoDAO.loadUsuario_RegistradoByQuery(null, null);
			// Delete the persistent object
			instagualbdorm.Usuario_RegistradoDAO.delete(linstagualbdormUsuario_Registrado);
			instagualbdorm.Etiqueta linstagualbdormEtiqueta = instagualbdorm.EtiquetaDAO.loadEtiquetaByQuery(null, null);
			// Delete the persistent object
			instagualbdorm.EtiquetaDAO.delete(linstagualbdormEtiqueta);
			instagualbdorm.Administrador linstagualbdormAdministrador = instagualbdorm.AdministradorDAO.loadAdministradorByQuery(null, null);
			// Delete the persistent object
			instagualbdorm.AdministradorDAO.delete(linstagualbdormAdministrador);
			instagualbdorm.Elemento linstagualbdormElemento = instagualbdorm.ElementoDAO.loadElementoByQuery(null, null);
			// Delete the persistent object
			instagualbdorm.ElementoDAO.delete(linstagualbdormElemento);
			instagualbdorm.Comentario linstagualbdormComentario = instagualbdorm.ComentarioDAO.loadComentarioByQuery(null, null);
			// Delete the persistent object
			instagualbdorm.ComentarioDAO.delete(linstagualbdormComentario);
			instagualbdorm.Configuracion linstagualbdormConfiguracion = instagualbdorm.ConfiguracionDAO.loadConfiguracionByQuery(null, null);
			// Delete the persistent object
			instagualbdorm.ConfiguracionDAO.delete(linstagualbdormConfiguracion);
			instagualbdorm.Publicacion linstagualbdormPublicacion = instagualbdorm.PublicacionDAO.loadPublicacionByQuery(null, null);
			// Delete the persistent object
			instagualbdorm.PublicacionDAO.delete(linstagualbdormPublicacion);
			instagualbdorm.Notificacion linstagualbdormNotificacion = instagualbdorm.NotificacionDAO.loadNotificacionByQuery(null, null);
			// Delete the persistent object
			instagualbdorm.NotificacionDAO.delete(linstagualbdormNotificacion);
			t.commit();
		}
		catch (Exception e) {
			t.rollback();
		}
		
	}
	
	public static void main(String[] args) {
		try {
			DeleteProyectoInstagualData deleteProyectoInstagualData = new DeleteProyectoInstagualData();
			try {
				deleteProyectoInstagualData.deleteTestData();
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
