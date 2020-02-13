package instagualbdorm;

import java.util.Vector;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import instagualbdorm.Configuracion;

public class BD_Configuracion {
	public BD_Principal _bD_Principal_configuracion;
	public Vector<Configuracion> _contiene_configuracion = new Vector<Configuracion>();

	public boolean Cambiar_configuracion(int aIDUsuario, boolean[] aListaOpciones) throws PersistentException {
		PersistentTransaction t = ProyectoInstagualPersistentManager.instance().getSession().beginTransaction();
		
		instagualbdorm.Usuario_Registrado user = null;
		instagualbdorm.Configuracion config = null;
		try {
			user = Usuario_RegistradoDAO.loadUsuario_RegistradoByORMID(aIDUsuario);
			//Cambio la configuracion a la elegida
			config = user.getConfigura();
			config.setNotificacionesTodas(aListaOpciones[0]);
			config.setNotificacionesMeGusta(aListaOpciones[1]);
			config.setNotificacionesComentarios(aListaOpciones[2]);
			config.setNotificacionesSeguir(aListaOpciones[3]);
			config.setPerfilPrivado(aListaOpciones[4]);
			config.setOcultosSeguidoresSeguidos(aListaOpciones[5]);
			ConfiguracionDAO.save(config);

			t.commit();
			return true;
		}catch(PersistentException e) {
			t.rollback();
			return false;
		}
	}
}