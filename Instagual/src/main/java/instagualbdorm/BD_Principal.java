package instagualbdorm;

import Instagual.iUsuario_no_registrado_web;
import Instagual.iUsuario_no_registrado_movil;
import Instagual.iUsuario_registrado;
import Instagual.iUsuario_administrador;

import java.util.List;

import org.orm.PersistentException;

import com.vaadin.ui.Notification;

import Instagual.iCorreo_electronico;

public class BD_Principal implements iUsuario_no_registrado_web, iUsuario_no_registrado_movil, iUsuario_registrado, iUsuario_administrador, iCorreo_electronico {
	public BD_Configuracion _bD_Configuracion = new BD_Configuracion();
	public BD_Usuario_Registrado _bD_Usuario_Registrado = new BD_Usuario_Registrado();
	public BD_Administrador _bD_Administrador = new BD_Administrador();
	public BD_Etiqueta _bD_Etiqueta = new BD_Etiqueta();
	public BD_Comentario _bD_Comentario = new BD_Comentario();
	public BD_Publicacion _bD_Publicacion = new BD_Publicacion();
	public BD_Elemento _bD_Elemento = new BD_Elemento();
	public BD_Notificaciones _bD_Notificaciones = new BD_Notificaciones();

	public Usuario_Registrado Iniciar_Sesion(String aCorreo, String aPassword) {
		try {
			return this._bD_Usuario_Registrado.Iniciar_Sesion(aCorreo, aPassword);
		} catch (PersistentException e) {
			e.printStackTrace();
			return null;
		}
		
	}

	public Administrador IniciarSesion_Web(String aCorreo, String aPassword) {
		try {
			return this._bD_Administrador.IniciarSesion_Web(aCorreo, aPassword);
		} catch (PersistentException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public List Buscar_Publicaciones(String aEtiqueta) {
		List<instagualbdorm.Publicacion> lista;
		try {
			lista = this._bD_Etiqueta.Buscar_Publicaciones(aEtiqueta);
			return lista;
		} catch (PersistentException e) {
			e.printStackTrace();
			return null;
		}
		
	}

	public List Buscar_Usuarios(String aNombreUsuario) {
		List<instagualbdorm.Usuario_Registrado> lista;
		try {
			lista = this._bD_Usuario_Registrado.Buscar_Usuarios(aNombreUsuario);
			return lista;
		} catch (PersistentException e) {
			e.printStackTrace();
			return null;
		}
		
	}

	public boolean Rcuperar_Cuenta(String aCorreo) {
		try {
			return this._bD_Usuario_Registrado.Recuperar_Cuenta(aCorreo);
		} catch (PersistentException e) {
			e.printStackTrace();
			return false;
		}
		
	}

	public boolean Recuperar_Password(String aCorreo) {
		try {
			return this._bD_Usuario_Registrado.Recuperar_Password(aCorreo);
		} catch (PersistentException e) {
			e.printStackTrace();
			return false;
		}
		
	}

	public boolean Registrar(String aCorreo, String aPassword) {
		try {
			return this._bD_Usuario_Registrado.Registrar(aCorreo, aPassword);
		} catch (PersistentException e) {
			e.printStackTrace();
			return false;
		}
		
	}

	public boolean Editar_perfil(int aIDUsuario, String[] aDatos, boolean aActivada) {
		try {
			return this._bD_Usuario_Registrado.Editar_Perfil(aIDUsuario, aDatos,aActivada);
		} catch (PersistentException e) {
			e.printStackTrace();
			return false;
		}
		
	}

	public boolean Cambiar_Configuracion(int aIDUsuario, boolean[] aListaOpciones) {
		try {
			return this._bD_Configuracion.Cambiar_configuracion(aIDUsuario, aListaOpciones);
		} catch (PersistentException e) {
			e.printStackTrace();
			return false;
		}
		
	}

	public void DarseDe_Baja(int aIDUsuario) {
		try {
			this._bD_Usuario_Registrado.DarDe_Baja(aIDUsuario);
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}

	public boolean DarMeGusta_Comentario(int aIDUsuario, int aIDComentario) {
		try {
			return this._bD_Comentario.DarMeGusta_Comentario(aIDComentario,aIDUsuario);
		} catch (PersistentException e) {
			e.printStackTrace();
			return false;
		}
		
	}

	public boolean DarMeGusta_Publicacion(int aIDUsuario, int aIDPublicacion) {
		try {
			return this._bD_Publicacion.DarMeGusta_Publicacion(aIDUsuario,aIDPublicacion);
		} catch (PersistentException e) {
			e.printStackTrace();
			return false;
		}
		
	}

	public boolean Publicar_Publicacion(String aDescripcion, int aIDUsuario, String[] aListaFotos, String aEtiqueta,String[] menciones) {
		try {
			return this._bD_Publicacion.Publicar_Publicacion(aDescripcion, aIDUsuario, aListaFotos,aEtiqueta,menciones);
		} catch (PersistentException e) {
			e.printStackTrace();
			return false;
		}
		
	}

	public boolean Publicar_Comentario( int aIDPublicacion, int aIDUsuario,String aComentario) {
		try {
			return this._bD_Comentario.Publicar_Comentario(aIDPublicacion, aIDUsuario, aComentario);
		} catch (PersistentException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean Bloquear_Usuario(int aIDUsuario, int aIDUsuarioBloqueado) {
		try {
			return this._bD_Usuario_Registrado.Bloquear_Usuario(aIDUsuario, aIDUsuarioBloqueado);
		} catch (PersistentException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean Seguir_DejarSeguir(int aIDUsuario, int aIDUsuarioSeguido) {
		try {
			return this._bD_Usuario_Registrado.Seguir_DejarSeguir(aIDUsuario, aIDUsuarioSeguido);
		} catch (PersistentException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean Eliminar_Publicacion(int aIDPublicacion) {
		try {
			return this._bD_Publicacion.Eliminar_Publicacion(aIDPublicacion);
		} catch (PersistentException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean Eliminar_PublicacionAdmin(int aIDPublicacion) {
		try {
			return this._bD_Publicacion.Eliminar_Publicacion(aIDPublicacion);
		} catch (PersistentException e) {
			e.printStackTrace();
			return false;
		}
	}
	

	public List ListarPublicacionesPagina_Principal() {
		try {
			List<instagualbdorm.Publicacion> lista = this._bD_Publicacion.ListarPublicacionesPagina_Principal();
			return lista;
		} catch (PersistentException e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean Eliminar_Usuario(int aIDUsuario) {
		boolean allPublicationsGreen = true;
		try {
			for(Publicacion publi:Usuario_RegistradoDAO.getUsuario_RegistradoByORMID(aIDUsuario).sube.toArray()) {
				if(!Eliminar_Publicacion(publi.getORMID())) {
					allPublicationsGreen = false;
				}
			}
			if(allPublicationsGreen && _bD_Usuario_Registrado.Eliminar_Usuario(aIDUsuario)) {
				return true;
			}
	
		} catch (PersistentException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean Eliminar_Comentario(int aIDComentario) {
		try {
			return this._bD_Comentario.Eliminar_Comentario(aIDComentario);
		} catch (PersistentException e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean Eliminar_ComentarioAdmin(int aIDComentario) {
		try {
			return this._bD_Comentario.Eliminar_Comentario(aIDComentario);
		} catch (PersistentException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean Eliminar_Mencion(int aIDUsuario, int aIDPublicacion) {
		try {
			return this._bD_Publicacion.Eliminar_Mencion(aIDUsuario, aIDPublicacion);
		} catch (PersistentException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean Registrar_Admin(String correo, String password) {
		try {
			return this._bD_Administrador.Registrar(correo, password);
		} catch (PersistentException e) {
			e.printStackTrace();
			return false;
		}
		
	}

	public boolean crearNotificacion(int aIDUsuario,String descripcion,boolean recibida,String tipo) {
		try {
			return  this._bD_Notificaciones.crearNotificacion(aIDUsuario, descripcion, recibida, tipo);
		} catch (PersistentException e) {
			e.printStackTrace();
			return false;
		}
	}


	public List Buscar_PublicacionesAdmin(String aEtiqueta) {
		List<instagualbdorm.Publicacion> lista;
		try {
			lista = this._bD_Etiqueta.Buscar_Publicaciones(aEtiqueta);
			return lista;
		} catch (PersistentException e) {
			e.printStackTrace();
			return null;
		}
	}

	public List Buscar_UsuariosAdmin(String aNombreUsuario) {
		List<instagualbdorm.Usuario_Registrado> lista;
		try {
			lista = this._bD_Usuario_Registrado.Buscar_Usuarios(aNombreUsuario);
			return lista;
		} catch (PersistentException e) {
			e.printStackTrace();
			return null;
		}
	}

	public List Buscar_PublicacionesRegistrado(String aEtiqueta) {
		List<instagualbdorm.Publicacion> lista;
		try {
			lista = this._bD_Etiqueta.Buscar_Publicaciones(aEtiqueta);
			return lista;
		} catch (PersistentException e) {
			e.printStackTrace();
			return null;
		}
	}

	public List Buscar_UsuariosRegistrado(String aNombreUsuario) {
		List<instagualbdorm.Usuario_Registrado> lista;
		try {
			lista = this._bD_Usuario_Registrado.Buscar_Usuarios(aNombreUsuario);
			return lista;
		} catch (PersistentException e) {
			e.printStackTrace();
			return null;
		}
	}


}