package ual.mds2.app;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import Instagual.Editar_perfil;
import Instagual.Iniciar_sesion;
import Instagual.Menu_inferior;
import Instagual.Recuperar_cuenta;
import Instagual.Recuperar_password;
import Instagual.Registrarse;
import Instagual.iUsuario_administrador;
import Instagual.iUsuario_no_registrado_movil;
import Instagual.iUsuario_no_registrado_web;
import Instagual.iUsuario_registrado;
import instagualbdorm.BD_Principal;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of an HTML page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {

	Navigator navigator1;
	Navigator navigator2;
	int userType = 0;
	iUsuario_no_registrado_movil dp = new BD_Principal();
	iUsuario_no_registrado_web iNoRegistradoWeb = new BD_Principal();

	iUsuario_registrado iRegistrado = new BD_Principal();
	iUsuario_administrador iAdmin = new BD_Principal();

	instagualbdorm.Usuario_Registrado user = null;
	instagualbdorm.Usuario_Registrado userVer = null;
	instagualbdorm.Administrador admin = null;
	instagualbdorm.Publicacion publicacionVer = null;
	
	String correo = "";
	String password = "";
	
    @Override
    protected void init(VaadinRequest vaadinRequest) {
    	navigator1 = new Navigator(this,this);
    	getPage().setTitle("Instagual");
    	navigator1.addView("IniciarSesion", Iniciar_sesion.class);
    	navigator1.addView("Registrarse", Registrarse.class);
    	navigator1.addView("RecuperarCuenta", Recuperar_cuenta.class);
    	navigator1.addView("RecuperarPassword", Recuperar_password.class);
    	navigator1.addView("Entrar", Menu_inferior.class);
    	navigator1.addView("EditarPerfil", Editar_perfil.class);
    	navigator1.navigateTo("IniciarSesion");
    }

    
    
    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
    
    
    public Navigator getNavigator1() {
    	return navigator1;
    }
    
    
    public Navigator getNavigator2() {
    	return navigator2;
    }
    
    public void setNavigator2(Navigator nav) {
    	navigator2 = nav;
    }
    
    
    public int getUserType() {
    	return userType;
    }
    
    public void setUserType(int usert) {
    	userType = usert;
    }
    
    public void setUsuario(instagualbdorm.Usuario_Registrado user2) {
    	user = user2;
    }
    
    public instagualbdorm.Usuario_Registrado getUsuario(){
    	return user;
    }
	public instagualbdorm.Usuario_Registrado getUserVer() {
		return userVer;
	}


	public void setUserVer(instagualbdorm.Usuario_Registrado userVer) {
		this.userVer = userVer;
	}


	public instagualbdorm.Publicacion getPublicacionVer() {
		return publicacionVer;
	}


	public void setPublicacionVer(instagualbdorm.Publicacion publicacionVer) {
		this.publicacionVer = publicacionVer;
	}
	
	public iUsuario_registrado getiRegistrado() {
		return iRegistrado;
	}
	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public iUsuario_no_registrado_movil getiNoRegistradoMovil() {
		return dp;
	}

	public void setDp(iUsuario_no_registrado_movil dp) {
		this.dp = dp;
	}

	public void updateUser() {
		user = this.dp.Iniciar_Sesion(correo, password);
	}

	public instagualbdorm.Administrador getAdmin() {
		return admin;
	}


	public void setAdmin(instagualbdorm.Administrador admin) {
		this.admin = admin;
	}
	public iUsuario_administrador getiAdmin() {
		return iAdmin;
	}


	public void setiAdmin(iUsuario_administrador iAdmin) {
		this.iAdmin = iAdmin;
	}

	public void reset() {
		userType = 0;
		user = null;
		userVer = null;
		publicacionVer = null;
		admin = null;
		correo = "";
		password = "";
	}
	public iUsuario_no_registrado_web getiNoRegistradoWeb() {
		return iNoRegistradoWeb;
	}


	public void setiNoRegistradoWeb(iUsuario_no_registrado_web iNoRegistradoWeb) {
		this.iNoRegistradoWeb = iNoRegistradoWeb;
	}


}
