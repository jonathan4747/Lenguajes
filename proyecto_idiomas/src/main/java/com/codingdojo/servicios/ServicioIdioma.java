package com.codingdojo.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.modelos.Idioma;
import com.codingdojo.repositorios.RepositorioIdioma;

@Service
public class ServicioIdioma {
	
	@Autowired
	private RepositorioIdioma repositorioIdioma;
	
	//leer todos los lenguajes
		public List<Idioma> SelectAllIdioma(){
			return repositorioIdioma.findAll();
		}
	//crear un gasto
		public Idioma CreateIdioma(Idioma nuevoIdioma) {
			return repositorioIdioma.save(nuevoIdioma);
		}
	//Encontrar el id para la edicion y para verlo
		public Idioma EncontrarId(Long id) {
			Optional<Idioma> opotionalIdioma=repositorioIdioma.findById(id); 
			if(opotionalIdioma.isPresent()) {
				return opotionalIdioma.get(); 
			} 
			else {
				return null;
			}
		}
		//Eliminar
		public Long deleteFromId( long id ) {
			return repositorioIdioma.deleteById(id);
		}
		
		//Editar
		public void updateIdioma( Idioma editarIdioma ) {
			
			repositorioIdioma.actualizaidioma( editarIdioma.getNombre(), 
											 editarIdioma.getCreador(), 
											 editarIdioma.getVersion(), 
											 editarIdioma.getId()
											  ); 								   
		}
}
