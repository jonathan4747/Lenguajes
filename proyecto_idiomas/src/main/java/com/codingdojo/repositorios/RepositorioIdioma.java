package com.codingdojo.repositorios;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.codingdojo.modelos.Idioma;

@Repository
public interface RepositorioIdioma extends CrudRepository<Idioma , Long> {
	
	List<Idioma> findAll();
	
	@SuppressWarnings("unchecked")
	Idioma save( Idioma nuevoIdioma );
	
	//Econtrar el id
	Idioma findById(long id);
	
	@Transactional
	Long deleteById( long id );
	
	@Transactional
	@Modifying
	@Query(value="UPDATE idiomas "+ "SET nombre = :nombre, creador = :creador, version = :version " +
			"WHERE id = :id", nativeQuery = true )
	void actualizaidioma(@Param("nombre")String nombre,@Param("creador") String creador,@Param("version") double version,
			            @Param("id")long id);

}
