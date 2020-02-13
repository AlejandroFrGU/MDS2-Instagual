/**
 * Licensee: Alejandro(University of Almeria)
 * License Type: Academic
 */
package ormsamples;

import org.orm.*;
public class ListProyectoInstagualData {
	private static final int ROW_COUNT = 100;
	
	public void listTestData() throws PersistentException {
		System.out.println("Listing Usuario...");
		instagualbdorm.Usuario[] instagualbdormUsuarios = instagualbdorm.UsuarioDAO.listUsuarioByQuery(null, null);
		int length = Math.min(instagualbdormUsuarios.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(instagualbdormUsuarios[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Usuario_Registrado...");
		instagualbdorm.Usuario_Registrado[] instagualbdormUsuario_Registrados = instagualbdorm.Usuario_RegistradoDAO.listUsuario_RegistradoByQuery(null, null);
		length = Math.min(instagualbdormUsuario_Registrados.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(instagualbdormUsuario_Registrados[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Etiqueta...");
		instagualbdorm.Etiqueta[] instagualbdormEtiquetas = instagualbdorm.EtiquetaDAO.listEtiquetaByQuery(null, null);
		length = Math.min(instagualbdormEtiquetas.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(instagualbdormEtiquetas[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Administrador...");
		instagualbdorm.Administrador[] instagualbdormAdministradors = instagualbdorm.AdministradorDAO.listAdministradorByQuery(null, null);
		length = Math.min(instagualbdormAdministradors.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(instagualbdormAdministradors[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Elemento...");
		instagualbdorm.Elemento[] instagualbdormElementos = instagualbdorm.ElementoDAO.listElementoByQuery(null, null);
		length = Math.min(instagualbdormElementos.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(instagualbdormElementos[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Comentario...");
		instagualbdorm.Comentario[] instagualbdormComentarios = instagualbdorm.ComentarioDAO.listComentarioByQuery(null, null);
		length = Math.min(instagualbdormComentarios.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(instagualbdormComentarios[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Configuracion...");
		instagualbdorm.Configuracion[] instagualbdormConfiguracions = instagualbdorm.ConfiguracionDAO.listConfiguracionByQuery(null, null);
		length = Math.min(instagualbdormConfiguracions.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(instagualbdormConfiguracions[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Publicacion...");
		instagualbdorm.Publicacion[] instagualbdormPublicacions = instagualbdorm.PublicacionDAO.listPublicacionByQuery(null, null);
		length = Math.min(instagualbdormPublicacions.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(instagualbdormPublicacions[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
		System.out.println("Listing Notificacion...");
		instagualbdorm.Notificacion[] instagualbdormNotificacions = instagualbdorm.NotificacionDAO.listNotificacionByQuery(null, null);
		length = Math.min(instagualbdormNotificacions.length, ROW_COUNT);
		for (int i = 0; i < length; i++) {
			System.out.println(instagualbdormNotificacions[i]);
		}
		System.out.println(length + " record(s) retrieved.");
		
	}
	
	public void listByCriteria() throws PersistentException {
		System.out.println("Listing Usuario by Criteria...");
		instagualbdorm.UsuarioCriteria linstagualbdormUsuarioCriteria = new instagualbdorm.UsuarioCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//linstagualbdormUsuarioCriteria.IDUsuario.eq();
		linstagualbdormUsuarioCriteria.setMaxResults(ROW_COUNT);
		instagualbdorm.Usuario[] instagualbdormUsuarios = linstagualbdormUsuarioCriteria.listUsuario();
		int length =instagualbdormUsuarios== null ? 0 : Math.min(instagualbdormUsuarios.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(instagualbdormUsuarios[i]);
		}
		System.out.println(length + " Usuario record(s) retrieved."); 
		
		System.out.println("Listing Usuario_Registrado by Criteria...");
		instagualbdorm.Usuario_RegistradoCriteria linstagualbdormUsuario_RegistradoCriteria = new instagualbdorm.Usuario_RegistradoCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//linstagualbdormUsuario_RegistradoCriteria.IDUsuario.eq();
		linstagualbdormUsuario_RegistradoCriteria.setMaxResults(ROW_COUNT);
		instagualbdorm.Usuario_Registrado[] instagualbdormUsuario_Registrados = linstagualbdormUsuario_RegistradoCriteria.listUsuario_Registrado();
		length =instagualbdormUsuario_Registrados== null ? 0 : Math.min(instagualbdormUsuario_Registrados.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(instagualbdormUsuario_Registrados[i]);
		}
		System.out.println(length + " Usuario_Registrado record(s) retrieved."); 
		
		System.out.println("Listing Etiqueta by Criteria...");
		instagualbdorm.EtiquetaCriteria linstagualbdormEtiquetaCriteria = new instagualbdorm.EtiquetaCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//linstagualbdormEtiquetaCriteria.IDEtiqueta.eq();
		linstagualbdormEtiquetaCriteria.setMaxResults(ROW_COUNT);
		instagualbdorm.Etiqueta[] instagualbdormEtiquetas = linstagualbdormEtiquetaCriteria.listEtiqueta();
		length =instagualbdormEtiquetas== null ? 0 : Math.min(instagualbdormEtiquetas.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(instagualbdormEtiquetas[i]);
		}
		System.out.println(length + " Etiqueta record(s) retrieved."); 
		
		System.out.println("Listing Administrador by Criteria...");
		instagualbdorm.AdministradorCriteria linstagualbdormAdministradorCriteria = new instagualbdorm.AdministradorCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//linstagualbdormAdministradorCriteria.IDUsuario.eq();
		linstagualbdormAdministradorCriteria.setMaxResults(ROW_COUNT);
		instagualbdorm.Administrador[] instagualbdormAdministradors = linstagualbdormAdministradorCriteria.listAdministrador();
		length =instagualbdormAdministradors== null ? 0 : Math.min(instagualbdormAdministradors.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(instagualbdormAdministradors[i]);
		}
		System.out.println(length + " Administrador record(s) retrieved."); 
		
		System.out.println("Listing Elemento by Criteria...");
		instagualbdorm.ElementoCriteria linstagualbdormElementoCriteria = new instagualbdorm.ElementoCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//linstagualbdormElementoCriteria.IDElemento.eq();
		linstagualbdormElementoCriteria.setMaxResults(ROW_COUNT);
		instagualbdorm.Elemento[] instagualbdormElementos = linstagualbdormElementoCriteria.listElemento();
		length =instagualbdormElementos== null ? 0 : Math.min(instagualbdormElementos.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(instagualbdormElementos[i]);
		}
		System.out.println(length + " Elemento record(s) retrieved."); 
		
		System.out.println("Listing Comentario by Criteria...");
		instagualbdorm.ComentarioCriteria linstagualbdormComentarioCriteria = new instagualbdorm.ComentarioCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//linstagualbdormComentarioCriteria.IDComentario.eq();
		linstagualbdormComentarioCriteria.setMaxResults(ROW_COUNT);
		instagualbdorm.Comentario[] instagualbdormComentarios = linstagualbdormComentarioCriteria.listComentario();
		length =instagualbdormComentarios== null ? 0 : Math.min(instagualbdormComentarios.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(instagualbdormComentarios[i]);
		}
		System.out.println(length + " Comentario record(s) retrieved."); 
		
		System.out.println("Listing Configuracion by Criteria...");
		instagualbdorm.ConfiguracionCriteria linstagualbdormConfiguracionCriteria = new instagualbdorm.ConfiguracionCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//linstagualbdormConfiguracionCriteria.IDConfiguracion.eq();
		linstagualbdormConfiguracionCriteria.setMaxResults(ROW_COUNT);
		instagualbdorm.Configuracion[] instagualbdormConfiguracions = linstagualbdormConfiguracionCriteria.listConfiguracion();
		length =instagualbdormConfiguracions== null ? 0 : Math.min(instagualbdormConfiguracions.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(instagualbdormConfiguracions[i]);
		}
		System.out.println(length + " Configuracion record(s) retrieved."); 
		
		System.out.println("Listing Publicacion by Criteria...");
		instagualbdorm.PublicacionCriteria linstagualbdormPublicacionCriteria = new instagualbdorm.PublicacionCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//linstagualbdormPublicacionCriteria.IDpublicacion.eq();
		linstagualbdormPublicacionCriteria.setMaxResults(ROW_COUNT);
		instagualbdorm.Publicacion[] instagualbdormPublicacions = linstagualbdormPublicacionCriteria.listPublicacion();
		length =instagualbdormPublicacions== null ? 0 : Math.min(instagualbdormPublicacions.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(instagualbdormPublicacions[i]);
		}
		System.out.println(length + " Publicacion record(s) retrieved."); 
		
		System.out.println("Listing Notificacion by Criteria...");
		instagualbdorm.NotificacionCriteria linstagualbdormNotificacionCriteria = new instagualbdorm.NotificacionCriteria();
		// Please uncomment the follow line and fill in parameter(s) 
		//linstagualbdormNotificacionCriteria.IDNotificacion.eq();
		linstagualbdormNotificacionCriteria.setMaxResults(ROW_COUNT);
		instagualbdorm.Notificacion[] instagualbdormNotificacions = linstagualbdormNotificacionCriteria.listNotificacion();
		length =instagualbdormNotificacions== null ? 0 : Math.min(instagualbdormNotificacions.length, ROW_COUNT); 
		for (int i = 0; i < length; i++) {
			 System.out.println(instagualbdormNotificacions[i]);
		}
		System.out.println(length + " Notificacion record(s) retrieved."); 
		
	}
	
	public static void main(String[] args) {
		try {
			ListProyectoInstagualData listProyectoInstagualData = new ListProyectoInstagualData();
			try {
				listProyectoInstagualData.listTestData();
				//listProyectoInstagualData.listByCriteria();
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
