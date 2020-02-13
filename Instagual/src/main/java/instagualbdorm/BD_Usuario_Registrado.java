package instagualbdorm;

import java.util.Vector;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import com.vaadin.ui.Notification;

import Instagual.Correo_electronico;
import instagualbdorm.Usuario_Registrado;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BD_Usuario_Registrado {
	public BD_Principal _bD_Principal_Usuario_Registrado;
	public Vector<Usuario_Registrado> _contiene_usuario_registrado = new Vector<Usuario_Registrado>();

	public boolean Bloquear_Usuario(int aIDUsuario, int aIDUsuarioDesbloqueado) throws PersistentException {
		instagualbdorm.Usuario_Registrado user = null;
		instagualbdorm.Usuario_Registrado  userBlo= null;
		PersistentTransaction t = ProyectoInstagualPersistentManager.instance().getSession().beginTransaction();

		try {
			user = Usuario_RegistradoDAO.getUsuario_RegistradoByORMID(aIDUsuario);
			userBlo = Usuario_RegistradoDAO.getUsuario_RegistradoByORMID(aIDUsuarioDesbloqueado);
			//¿ya esta bloqueado?
			//si
			if(user.bloquea_a.contains(userBlo)) {
				user.bloquea_a.remove(userBlo);
			}//no
			else {
				user.bloquea_a.add(userBlo);
			}
			//Se guardan los cambios a los usuarios
			Usuario_RegistradoDAO.save(user);
			Usuario_RegistradoDAO.save(userBlo);
			
			t.commit();
			return true;
		} catch (PersistentException e) {
			e.printStackTrace();
			t.rollback();
		}
		return false;
	}

	public List Buscar_Usuarios(String aNolmbreUsuario) throws PersistentException {
		/*viejo
		Usuario_Registrado user = Usuario_RegistradoDAO.loadUsuario_RegistradoByQuery("nombreUsuario = '" + aNolmbreUsuario + "' ", null);
		List<instagualbdorm.Usuario_Registrado> users = 
				  Usuario_RegistradoDAO.queryUsuario_Registrado("nombreUsuario = '" + aNolmbreUsuario + "' ","IDUsuario DESC");*/
		
		//lista por etiquetas parecidas
				List<instagualbdorm.Usuario_Registrado> users = new ArrayList<instagualbdorm.Usuario_Registrado>();
				Iterator<instagualbdorm.Usuario_Registrado> ite = Usuario_RegistradoDAO.queryUsuario_Registrado(null, "IDUsuario DESC").iterator();
				while(ite.hasNext()) {//iteramos los usuarios existentes
					Usuario_Registrado user = ite.next();
					if(user.getNombreUsuario().indexOf(aNolmbreUsuario)  != -1) {//el nombre del usuario contiene "aNolmbreUsuario se añade
						users.add(user);
					}
				}
		return users;
	}

	public void DarDe_Baja(int aIDUsuario) throws PersistentException {
		PersistentTransaction t = ProyectoInstagualPersistentManager.instance().getSession().beginTransaction();
		instagualbdorm.Usuario_Registrado user = null;
		
		try {
			user = Usuario_RegistradoDAO.getUsuario_RegistradoByORMID(aIDUsuario);
			user.setActivo(false);//Desactivo
			user.setCodigo("");//Indico que fue dada de baja
			Usuario_RegistradoDAO.save(user);
			t.commit();
		} catch (PersistentException e) {
			e.printStackTrace();
			t.rollback();
		}
	}

	public boolean Editar_Perfil(int aIDUsuario, String[] aDatos, boolean aActivada) throws PersistentException {
		PersistentTransaction t = ProyectoInstagualPersistentManager.instance().getSession().beginTransaction();
		instagualbdorm.Usuario_Registrado user = null;
		instagualbdorm.Usuario_Registrado user1 = null;
		instagualbdorm.Publicacion publiDelUser = null;
		
		
		try {
			user = Usuario_RegistradoDAO.getUsuario_RegistradoByORMID(aIDUsuario);
			user1 = Usuario_RegistradoDAO.loadUsuario_RegistradoByQuery("nombreUsuario = '" + aDatos[3] + "' ", null);
			
			if(user1 !=null && user.getORMID() != user1.getORMID()) {//No tienen el mismo Nombre de usuario
				return false;
			}
			//Se cambian los datos por los elegidos
			user.setFotoPerfil(aDatos[0]);
			user.setNombre(aDatos[1]); 
			user.setApellido(aDatos[2]);
			user.setNombreUsuario(aDatos[3]);
			user.setCodigo(aDatos[4]);
			user.setActivo(aActivada);
			Usuario_RegistradoDAO.save(user);
		
			t.commit();
			return true;
			
		} catch (PersistentException e) {
			e.printStackTrace();
			t.rollback();
		}
		return false;
	}

	public boolean Eliminar_Usuario(int aIDUsuario) throws PersistentException {
		PersistentTransaction t = ProyectoInstagualPersistentManager.instance().getSession().beginTransaction();
		instagualbdorm.Usuario_Registrado user = null;
		
		try {
			user = Usuario_RegistradoDAO.getUsuario_RegistradoByORMID(aIDUsuario);
			//Se eliminan sus pertenencias una a una
			
			//notificaciones
			for(Notificacion noti:user.notificaciones_de.toArray()) {
				user.notificaciones_de.remove(noti);
				NotificacionDAO.delete(noti);
			}
			
			//comentarios
			for(Comentario comment:user.comenta.toArray()) {
				comment.setContenido_en(null);
				user.comenta.remove(comment);
				ComentarioDAO.delete(comment);
			}
			
			//seguidos
			for(Usuario_Registrado userSeg:user.sigue_a.toArray()) {
				user.sigue_a.remove(userSeg);
			}
			//bloqueados
			for(Usuario_Registrado userBlo:user.bloquea_a.toArray()) {
				user.bloquea_a.remove(userBlo);
			}
			//megustacomment
			for(Comentario commentMG:user.gusta.toArray()) {
				user.gusta.remove(commentMG);
			}
			//elimino menciones
			for(Publicacion publiMC:user.mencionado_en.toArray()) {
				user.mencionado_en.remove(publiMC);
			}
			//publis me gustan
			for(Publicacion publiMG:user.le_gusta.toArray()) {
				user.le_gusta.remove(publiMG);
			}
			//elimino configuracion
			Configuracion config = user.getConfigura();
			user.setConfigura(null);
			ConfiguracionDAO.delete(config);
			Usuario_RegistradoDAO.delete(user);
			t.commit();
			return true;
		} catch (PersistentException e) {
			e.printStackTrace();
			t.rollback();
		}
		return false;
	}

	public Usuario_Registrado Iniciar_Sesion(String aCorreo, String aPassword) throws PersistentException {
		instagualbdorm.Usuario_Registrado user = null;
			user = Usuario_RegistradoDAO.loadUsuario_RegistradoByQuery("Correo = '" + aCorreo + "' ", null);	
			if(user==null) {//El usuario no existe
				return null;
			}
			if(!user.getPassword().equals(aPassword)){//El usuario existe pero esa no es su password
				return null;
			}
		return user;
	}

	public boolean Recuperar_Cuenta(Object aCorreo) throws PersistentException {
		PersistentTransaction t = ProyectoInstagualPersistentManager.instance().getSession().beginTransaction();
		instagualbdorm.Usuario_Registrado user = null;
		try {
			user = Usuario_RegistradoDAO.loadUsuario_RegistradoByQuery("Correo = '" + aCorreo + "' ", null);
			user.setActivo(true);
			Usuario_RegistradoDAO.save(user);
			t.commit();
			return true;
		}catch(Exception e) {
			t.rollback();
		}
		return false;
	}

	public boolean Recuperar_Password(String aCorreo) throws PersistentException {
		instagualbdorm.Usuario_Registrado user = null;
			user = Usuario_RegistradoDAO.loadUsuario_RegistradoByQuery("Correo = '" + aCorreo + "' ", null);
			if(user == null) {
				return false;
			}
			Correo_electronico correo = new Correo_electronico(aCorreo, "Recuperación de password Instagual", "Password: "+ user.getPassword());
			correo.mandarEmail();
			return true;
	}

	public boolean Registrar(String aCorreo, String aPassword) throws PersistentException {
		PersistentTransaction t = ProyectoInstagualPersistentManager.instance().getSession().beginTransaction();
		instagualbdorm.Usuario_Registrado user = null;
		
		try {
			user = Usuario_RegistradoDAO.loadUsuario_RegistradoByQuery("Correo = '" + aCorreo + "' ", null);
			if(user != null) {//Existe ya el usuario?
				return false;//si
			}
			
			String code = createCode();
			//CREACION DE USUARIO
			Usuario_Registrado user1 = Usuario_RegistradoDAO.createUsuario_Registrado();
			user1.setCorreo(aCorreo);
			user1.setPassword(aPassword);
			user1.setNombre("nombre");
			user1.setApellido("apellido");
			user1.setActivo(false);
			user1.setNombreUsuario("");
			user1.setCodigo(code);
			user1.setFotoPerfil("https://clenguas.ual.es/wp-content/uploads/2018/11/logo_UAL.jpg");

			//Manda el correo con el código de activacion
			Correo_electronico correo = new Correo_electronico(aCorreo, "Activar cuenta Instagual", "Código de activación de cuenta: "+ code);
			correo.mandarEmail();
			
			//Configuracion de usuario - Configuración predeterminada
			Configuracion config = ConfiguracionDAO.createConfiguracion();
			config.setNotificacionesTodas(true);
			config.setNotificacionesMeGusta(true);
			config.setNotificacionesComentarios(true);
			config.setNotificacionesSeguir(true);
			config.setPerfilPrivado(false);
			config.setOcultosSeguidoresSeguidos(false);
			config.setConfigurado_por(user1);
			
			Usuario_RegistradoDAO.save(user1);
			t.commit();
			return true;
		}catch(PersistentException e) {
			t.rollback();
			return false;
		}	
	}

	public boolean Seguir_DejarSeguir(int aIDUsuario, int aIDUsuarioAseguir) throws PersistentException {
		instagualbdorm.Usuario_Registrado user = null;
		instagualbdorm.Usuario_Registrado  userSeg= null;
		PersistentTransaction t = ProyectoInstagualPersistentManager.instance().getSession().beginTransaction();

			try {
				user = Usuario_RegistradoDAO.getUsuario_RegistradoByORMID(aIDUsuario);
				userSeg = Usuario_RegistradoDAO.getUsuario_RegistradoByORMID(aIDUsuarioAseguir);
				//¿ya lo sigue?
				//si
				if(user.sigue_a.contains(userSeg)) {
					user.sigue_a.remove(userSeg);
				}//no
				else {
					user.sigue_a.add(userSeg);
				}
				
				Usuario_RegistradoDAO.save(user);
				Usuario_RegistradoDAO.save(userSeg);
				t.commit();
				return true;
			} catch (PersistentException e) {
				e.printStackTrace();
				t.rollback();
			}
			return false;	
	}
	
	//////////////
	//CREADOR DE PASSWORD
	public String createCode(){
		char[] elementos={'0','1','2','3','4','5','6','7','8','9' ,'a',
				'b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t',
				'u','v','w','x','y','z'};

		char[] conjunto = new char[10];
		String pass;
		for(int i=0;i<conjunto.length;i++){
			int el = (int)(Math.random()*36);
			conjunto[i] = (char)elementos[el];
		}
		return pass = new String(conjunto);
		}
	//////////////
}