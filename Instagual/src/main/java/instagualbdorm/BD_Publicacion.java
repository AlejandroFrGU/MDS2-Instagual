package instagualbdorm;

import java.util.Vector;

import org.orm.PersistentException;
import org.orm.PersistentTransaction;

import instagualbdorm.Publicacion;
import java.util.List;

public class BD_Publicacion {
	public BD_Principal _bD_Principal_Publicacion;
	public Vector<Publicacion> _contiene_publicacion = new Vector<Publicacion>();

	public boolean Eliminar_Mencion(int aIDUsuario, int aIDPublicacion) throws PersistentException {
		PersistentTransaction t = ProyectoInstagualPersistentManager.instance().getSession().beginTransaction();
		instagualbdorm.Publicacion publi = null;
		instagualbdorm.Usuario_Registrado user = null;
		try {
			publi = PublicacionDAO.getPublicacionByORMID(aIDPublicacion);
			user = Usuario_RegistradoDAO.getUsuario_RegistradoByORMID(aIDUsuario);

			//borro mencionados
			for(Usuario_Registrado usr: publi.menciona_a.toArray()) {
				if(usr.getORMID() == user.getORMID()) {
					publi.menciona_a.remove(usr);
				}
			}
			PublicacionDAO.save(publi);
			Usuario_RegistradoDAO.save(user);
	
			t.commit();
			return true;
		} catch (PersistentException e) {
			e.printStackTrace();
			t.rollback();
			return false;
		}
	}

	public boolean Eliminar_Publicacion(int aIDPublicacion) throws PersistentException {
		PersistentTransaction t = ProyectoInstagualPersistentManager.instance().getSession().beginTransaction();
		instagualbdorm.Publicacion publi = null;
		instagualbdorm.Usuario_Registrado user = null;
			try {
				publi = PublicacionDAO.getPublicacionByORMID(aIDPublicacion);
				user = Usuario_RegistradoDAO.getUsuario_RegistradoByORMID(publi.getPropiedad_de().getORMID());
				//Se eliminan sus componentes uno por uno
				//borro comentarios
				for(Comentario comment:publi.contiene_a.toArray()) {
					ComentarioDAO.deleteAndDissociate(comment);
				}
				//borro elementos de publicacion
				for(Elemento elem: publi.contiene.toArray()) {
					ElementoDAO.deleteAndDissociate(ElementoDAO.getElementoByORMID(elem.getORMID()));
				}
				//borro mencionados
				for(Usuario_Registrado usr: publi.menciona_a.toArray()) {
					publi.menciona_a.remove(usr);
				}
				//borrar gustados
				for(Usuario_Registrado usr:publi.gustada_por.toArray()) {
					publi.gustada_por.remove(usr);
				}
				
				//borro vinculo entre publi y etiqueta
				instagualbdorm.Etiqueta eti = publi.getTiene();
				eti.esta_en.remove(publi);
				
				user.sube.remove(publi);//elimino publicacion del que la sube
				PublicacionDAO.delete(publi);//Elimino la publicacion
				Usuario_RegistradoDAO.save(user);//guardo usuario
		
				t.commit();
				return true;
			} catch (PersistentException e) {
				e.printStackTrace();
				t.rollback();
			}
			return false;
	}

	public List ListarPublicacionesPagina_Principal() throws PersistentException {
		List<instagualbdorm.Publicacion> lista;
		//Se listan todas las publicaciones Por IDPublicacion Descenciente
		lista = PublicacionDAO.queryPublicacion(null, "IDPublicacion DESC");
		return lista;
	}

	public boolean DarMeGusta_Publicacion(int aIDUsuario, int aIDPublicacion) throws PersistentException {
		PersistentTransaction t = ProyectoInstagualPersistentManager.instance().getSession().beginTransaction();
		instagualbdorm.Publicacion publi = null;
		instagualbdorm.Usuario_Registrado user = null;
			try {
				publi = PublicacionDAO.getPublicacionByORMID(aIDPublicacion);
				user = Usuario_RegistradoDAO.getUsuario_RegistradoByORMID(aIDUsuario);
				
				//ya le gusta
				if(publi.gustada_por.contains(user)) {
					publi.gustada_por.remove(user);
				}//ya no le gusta
				else {
					publi.gustada_por.add(user);
				}
				
				PublicacionDAO.save(publi);
				Usuario_RegistradoDAO.save(user);
				t.commit();
				return true;
			} catch (PersistentException e) {
				e.printStackTrace();
				t.rollback();
			}
			return false;
	}

	public boolean Publicar_Publicacion(String aDescripcion, int aIDUsuario, String[] aListaFotos, String aEtiqueta, String[] aMenciones) throws PersistentException {
				PersistentTransaction t = ProyectoInstagualPersistentManager.instance().getSession().beginTransaction();
				instagualbdorm.Usuario_Registrado userPropietario = null;
				instagualbdorm.Usuario_Registrado userMencion1 = null;
				instagualbdorm.Usuario_Registrado userMencion2 = null;
				instagualbdorm.Publicacion pub = null;
				instagualbdorm.Etiqueta etiquete = null;
				
				try {
					etiquete = EtiquetaDAO.loadEtiquetaByQuery("nombre = '" + aEtiqueta + "' ", null);
					userPropietario = Usuario_RegistradoDAO.getUsuario_RegistradoByORMID(aIDUsuario);
					
					//crea etiqueta si no existe
					if(etiquete == null) {
						etiquete  = EtiquetaDAO.createEtiqueta();
						etiquete.setNombre(aEtiqueta);
					}
					EtiquetaDAO.save(etiquete);
					//crea publicacion
					pub = PublicacionDAO.createPublicacion();
					pub.setDescripcion(aDescripcion);
					
					//busca user propietario  y lo adjunta
					pub.setPropiedad_de(userPropietario);
					pub.setTiene(etiquete);
					PublicacionDAO.save(pub);//guarda publicacion
					etiquete.esta_en.add(pub);
					EtiquetaDAO.save(etiquete);
					//guarda etiqueta
					
					//Elementos de publicacion
					Elemento el;
					for(String pathnameF:aListaFotos) {
						if(pathnameF != null) {//Si hay URL se crea el elemento
							 el = ElementoDAO.createElemento();
							 el.setPathName(pathnameF);
							 el.setContenido_en(pub);
							 ElementoDAO.save(el);
						}
					}
					pub.setImagenPreview(aListaFotos[0]);//Se pone la primera imagen como preview
					
					if(!aMenciones[0].equals("")) {//El primer espacio tiene mencion?
						userMencion1 = Usuario_RegistradoDAO.loadUsuario_RegistradoByQuery("nombreUsuario = '" + aMenciones[0] + "' ", null);
						if(userMencion1 == null) {//El mencionado no existe
							return false;
						}
						pub.menciona_a.add(userMencion1);
						Usuario_RegistradoDAO.save(userMencion1);
					}
					
					if(!aMenciones[1].equals("")) {//El segundo espacio tiene mencion?
						userMencion2 = Usuario_RegistradoDAO.loadUsuario_RegistradoByQuery("nombreUsuario = '" + aMenciones[1] + "' ", null);
						if(userMencion2 == null) {//El mencionado no existe
							return false;
						}
						pub.menciona_a.add(userMencion2);
						Usuario_RegistradoDAO.save(userMencion2);
					}
					PublicacionDAO.save(pub);
					
					t.commit();
					return true;
				}catch(PersistentException e) {
					t.rollback();
				}
				return false;
	}
}