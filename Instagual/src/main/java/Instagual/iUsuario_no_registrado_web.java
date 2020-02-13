package Instagual;

import instagualbdorm.Administrador;

public interface iUsuario_no_registrado_web {

	public Administrador IniciarSesion_Web(String aCorreo, String aPassword);
}