package Instagual;

import java.util.List;

public interface iUsuario_administrador {

	public boolean Eliminar_Usuario(int aIDUsuario);
	
	public boolean Registrar_Admin(String correo,String password);
	
	public boolean Eliminar_PublicacionAdmin(int aIDPublicacion);
	
	public boolean Eliminar_ComentarioAdmin(int aIDComentario);
	
	public List Buscar_PublicacionesAdmin(String aEtiqueta);

	public List Buscar_UsuariosAdmin(String aNombreUsuario);
}