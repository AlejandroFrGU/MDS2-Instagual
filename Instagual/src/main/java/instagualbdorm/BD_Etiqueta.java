package instagualbdorm;

import java.util.Vector;

import org.orm.PersistentException;

import instagualbdorm.Etiqueta;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BD_Etiqueta {
	public BD_Principal _bD_Principal_Etiqueta;
	public Vector<Etiqueta> _contiene_etiqueta = new Vector<Etiqueta>();

	public List Buscar_Publicaciones(String aEtiqueta) throws PersistentException {
		
		/*Lista solo por etiqueta especifica
		Etiqueta etiquete = EtiquetaDAO.loadEtiquetaByQuery("nombre = '" + aEtiqueta + "' ", null);
		int idet = etiquete.getIDEtiqueta();
		List<instagualbdorm.Publicacion> publicaciones2 = new ArrayList<instagualbdorm.Publicacion>(etiquete.esta_en.getCollection());
		*/
		
		//lista por etiquetas parecidas
		List<instagualbdorm.Publicacion> publicaciones = new ArrayList<instagualbdorm.Publicacion>();
		List<instagualbdorm.Etiqueta> etiquetas = new ArrayList<instagualbdorm.Etiqueta>();
		Iterator<instagualbdorm.Publicacion> ite = PublicacionDAO.queryPublicacion(null, "IDPublicacion DESC").iterator();
		
		//etiquetas que contienen el string
		while(ite.hasNext()) {
			Etiqueta eti = ite.next().getTiene();
			if(eti.getNombre().indexOf(aEtiqueta) != -1) {//esta publicacion tiene parte de la etiqueta?
				etiquetas.add(eti);
			}
		}
		
		for(Etiqueta etiquete: etiquetas) {//añado las publicaciones obtenidas en el bucle anterior a la lista para mostrar
			for(Publicacion publicacionEtiquetada:etiquete.esta_en.toArray("IDpublicacion",false)) {
				if(!publicaciones.contains(publicacionEtiquetada)) {
					publicaciones.add(publicacionEtiquetada);
				}
				
			}
		}
		return publicaciones;
	}
}