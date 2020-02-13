package instagualbdorm;

import java.util.Vector;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import instagualbdorm.Administrador;

public class BD_Administrador {
	public BD_Principal _bD_Principal_Administrador;
	public Vector<Administrador> _contiene_administrador = new Vector<Administrador>();

	public instagualbdorm.Administrador IniciarSesion_Web(String aCorreo, String aPassword) throws PersistentException {
		instagualbdorm.Administrador user = null;
		user = AdministradorDAO.loadAdministradorByQuery("Correo = '" + aCorreo + "' ", null);
		if(user==null) {//Existe?
			return null;//no
		}
			
		if(!user.getPassword().equals(aPassword)){//es esta su pass?
			return null;//no
		}
		return user;
	}
	/////////////////////////////////////////////////
	public boolean Registrar(String aCorreo, String aPassword) throws PersistentException {
		PersistentTransaction t = ProyectoInstagualPersistentManager.instance().getSession().beginTransaction();
		instagualbdorm.Administrador admin = null;
		try {
			
			admin = AdministradorDAO.createAdministrador();
			admin.setCorreo(aCorreo);
			admin.setPassword(aPassword);
			AdministradorDAO.save(admin);
			t.commit();
			return true;
		}catch(Exception e) {
			t.rollback();
		}
		return false;
	}
	///////////////////
}