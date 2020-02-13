package instagualbdorm;

import java.util.Vector;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import instagualbdorm.Comentario;

public class BD_Comentario {
	public BD_Principal _bD_Principal_comentario;
	public Vector<Comentario> _contiene_comentario = new Vector<Comentario>();

	public boolean Eliminar_Comentario(int aIDComentario) throws PersistentException {
		PersistentTransaction t = ProyectoInstagualPersistentManager.instance().getSession().beginTransaction();
		instagualbdorm.Comentario comment = null;
		try {
			comment = ComentarioDAO.getComentarioByORMID(aIDComentario);
			t.commit();
			return ComentarioDAO.deleteAndDissociate(comment);	
		}catch(Exception e) {
			t.rollback();
		}
		return false;
	}

	public boolean Publicar_Comentario(int aIDPublicacion, int aIDUsuario, String aComentario) throws PersistentException {
		PersistentTransaction t = ProyectoInstagualPersistentManager.instance().getSession().beginTransaction();
		instagualbdorm.Comentario comment = null;
		instagualbdorm.Usuario_Registrado user1 = null;
		instagualbdorm.Publicacion pub = null;
		try {
			//publicacion del comentario
			pub = PublicacionDAO.getPublicacionByORMID(aIDPublicacion);
			//propietario del comentario
			user1 = Usuario_RegistradoDAO.getUsuario_RegistradoByORMID(aIDUsuario);
			
			//creo comentario
			comment = ComentarioDAO.createComentario();
			comment.setComentario(aComentario);
			comment.setPropiedad_de(user1);
			comment.setContenido_en(pub);
			ComentarioDAO.save(comment);
			
			//lo añado a la publicacion
			pub.contiene_a.add(comment);
			PublicacionDAO.save(pub);
			//añado su dueño
			user1.comenta.add(comment);
			Usuario_RegistradoDAO.save(user1);
			
			t.commit();
			return true;
		}catch(Exception e) {
			t.rollback();
		}
		return false;
	}

	public boolean DarMeGusta_Comentario(int aIDComentario,int aIDUsuario) throws PersistentException {
		PersistentTransaction t = ProyectoInstagualPersistentManager.instance().getSession().beginTransaction();
		instagualbdorm.Comentario comment = null;
		instagualbdorm.Usuario_Registrado user1 = null;
		try {
			user1 = Usuario_RegistradoDAO.getUsuario_RegistradoByORMID(aIDUsuario);
			comment = ComentarioDAO.getComentarioByORMID(aIDComentario);
			//ya me gusta?
			//si
			if(comment.gustado_por.contains(user1)) {
				comment.gustado_por.remove(user1);
			}//no
			else {
				comment.gustado_por.add(user1);
			}
			
			ComentarioDAO.save(comment);
			Usuario_RegistradoDAO.save(user1);
			
			t.commit();
			return true;
		}catch(Exception e) {
			t.rollback();	
		}
		return false;
	}
}