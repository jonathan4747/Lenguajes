package com.codingdojo.controladores;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.modelos.Idioma;
import com.codingdojo.servicios.ServicioIdioma;

@Controller
public class ControladorIdioma {
	
	@Autowired
	private ServicioIdioma servicioIdioma;
	
	@RequestMapping( value = "/languages", method = RequestMethod.GET )
	public String PaginaPrincipal(@ModelAttribute("idioma") Idioma nuevoIdioma,Model model) {
		List<Idioma> listaIdiomas =  servicioIdioma.SelectAllIdioma();
		model.addAttribute("listaIdiomas", listaIdiomas);
		return "index.jsp";
	}
	
	@RequestMapping( value = "/languages", method = RequestMethod.POST )
	public String PaginaPrincipal(@Valid @ModelAttribute("idioma") Idioma nuevoIdioma,BindingResult result,Model model) {
		if(result.hasErrors()) {
			List<Idioma> listaIdiomas =  servicioIdioma.SelectAllIdioma();
			model.addAttribute("listaIdiomas", listaIdiomas);
			return "index.jsp";
		}
		else {
			servicioIdioma.CreateIdioma(nuevoIdioma);
			
			return "redirect:/languages";
		}
	}
	
	@RequestMapping( value = "/languages/{id}", method = RequestMethod.GET )
	public String Ver(@PathVariable("id") Long id,HttpSession session) {
		Idioma idioma = servicioIdioma.EncontrarId(id);
		session.setAttribute("id", idioma.getId());
		session.setAttribute("nombre", idioma.getNombre() );
		session.setAttribute("creador",idioma.getCreador());
		session.setAttribute("version", idioma.getVersion());
		return "vista.jsp";
	}
	@RequestMapping( value = "/logout", method = RequestMethod.GET )
	public String logout( HttpSession session ) {
		session.removeAttribute( "id" );
		session.removeAttribute( "nombre" );
		session.removeAttribute( "creador" );
		session.removeAttribute( "version" );	
		return "redirect:/languages";
	}
	
	@RequestMapping( value = "/languages/eliminar/{id}", method = RequestMethod.DELETE )
	public String eliminarIdioma( @PathVariable("id") long id ) {
		servicioIdioma.deleteFromId(id);
		return "redirect:/languages";
	}
	
	@RequestMapping( value = "/languages/edit/{id}", method = RequestMethod.GET )
	public String edit(@PathVariable("id") Long id,@ModelAttribute("idioma") Idioma editarIdioma,HttpSession session) {
		editarIdioma = servicioIdioma.EncontrarId(id);
		session.setAttribute("id", editarIdioma.getId());
		session.setAttribute("nombre", editarIdioma.getNombre() );
		session.setAttribute("creador",editarIdioma.getCreador());
		session.setAttribute("version", editarIdioma.getVersion());
		return"edit.jsp";
	}
	
	@RequestMapping( value = "/languages/edit/{id}", method = RequestMethod.PUT )
	public String editarIdioma( @Valid @ModelAttribute("idioma") Idioma editarIdioma, BindingResult result,
								 HttpSession session) {
		if ( result.hasErrors() ) {
			return "edit.jsp";
		}
		else {
			session.setAttribute("nombre", editarIdioma.getNombre());
			session.setAttribute("creador",editarIdioma.getCreador());
			session.setAttribute("version", editarIdioma.getVersion());
			servicioIdioma.updateIdioma(editarIdioma);
			return "redirect:/languages";
		}
	}

}
