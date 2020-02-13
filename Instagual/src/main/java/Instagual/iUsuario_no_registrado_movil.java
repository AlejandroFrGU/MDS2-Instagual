package Instagual;

import java.util.List;

import instagualbdorm.Usuario_Registrado;

public interface iUsuario_no_registrado_movil extends iUsuario_no_registrado_web {

	public Usuario_Registrado Iniciar_Sesion(String aCorreo, String aPassword);

	public List Buscar_Publicaciones(String aEtiqueta);

	public List Buscar_Usuarios(String aNombreUsuario);

	public boolean Rcuperar_Cuenta(String aCorreo);

	public boolean Recuperar_Password(String aCorreo);

	public boolean Registrar(String aCorreo, String aPassword);
}