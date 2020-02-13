package Instagual;

import java.util.List;

public interface iUsuario_registrado {

	public boolean Editar_perfil(int aIDUsuario, String[] aDatos, boolean aActivada);

	public List Buscar_PublicacionesRegistrado(String aEtiqueta);

	public List Buscar_UsuariosRegistrado(String aNombreUsuario);

	public boolean Cambiar_Configuracion(int aIDUsuario, boolean[] aListaOpciones);

	public void DarseDe_Baja(int aIDUsuario);

	public boolean DarMeGusta_Comentario(int aIDUsuario, int aIDComentario);

	public boolean DarMeGusta_Publicacion(int aIDUsuario, int aIDPublicacion);

	public boolean Publicar_Publicacion(String aDescripcion, int aIDUsuario, String[] aListaFotos, String aEtiqueta,String[] menciones);

	public boolean Publicar_Comentario(int aIDPublicacion, int aIDUsuario, String aComentario);

	public boolean Bloquear_Usuario(int aIDUsuario, int aIDUsuarioBloqueado);

	public boolean Seguir_DejarSeguir(int aIDUsuario, int aIDUsuarioSeguido);

	public boolean Eliminar_Publicacion(int aIDPublicacion);

	public boolean Eliminar_Comentario(int aIDComentario);

	public List ListarPublicacionesPagina_Principal();

	public boolean Eliminar_Mencion(int aIDUsuario, int aIDPublicacion);
	
	public boolean crearNotificacion(int  aIDUsuario,String descripcion,boolean recibida,String tipo);
}