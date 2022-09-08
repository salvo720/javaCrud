package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.model.Elemento;
import com.example.demo.service.ServiceElemento;

@Controller
public class ElementoController {

	@Autowired
	private ServiceElemento serviceElemento;

	@RequestMapping(value = "/elementiView", method = RequestMethod.GET)
	public String elementiView() {
		return "elementiView";
	}

	@RequestMapping(value = "/newElementoView", method = RequestMethod.GET)
	public String newElementoView(Model model) {
		model.addAttribute("Elemento", new Elemento());
		return "newElementoView";
	}

	@RequestMapping(value = "/newElemento", method = RequestMethod.POST)
//	@ResponseBody
//	response body indica che non torneremo una pagina di view del tempklate engine  ma un stringa 
	public String newElemento(@ModelAttribute("Elemento") Elemento elemento, Model model) {
//		inizialize
		model.addAttribute("successMessage", "");
		System.out.println("elemento : " + elemento);

		ArrayList<Elemento> saveElemento = new ArrayList<Elemento>();
		saveElemento.add(0, new Elemento(elemento.getNome(), elemento.getSerialeprodotto(), elemento.getQuantita()));
		serviceElemento.NewElement(saveElemento);
		String successNewElemento = "Elemento inserito correttamente";
		model.addAttribute("successMessage", successNewElemento);
//		i dati si passano attraverso il model attribute 
		return "newElementoView";
	}

	@RequestMapping(value = "/updateElementoView/{id}", method = RequestMethod.GET)
	public String updateElementoView(@PathVariable(value = "id") int id, Model model) throws Exception {
		Optional<Elemento> elementoFound = serviceElemento.findById(id);
		model.addAttribute("Elemento", new Elemento(elementoFound.get()));
		return "updateElemento";
	}

	@RequestMapping(value = "/updateElemento", method = RequestMethod.POST)
	public String updateElemento(@PathVariable(value = "Elemento") Elemento elemento) throws Exception {
		serviceElemento.UpdateElemento(elemento);
		return "updateElemento";
	}

	@RequestMapping(value = "/deleteElemento/{id}", method = RequestMethod.GET)
	public String DeleteElemento(@PathVariable(value = "id") int id, Model model) throws Exception {
		serviceElemento.DeleteElement(id);
		String successMessage = String.format("id : %s e stato eliminato con successo", id);
		model.addAttribute("successMessage", successMessage);
		return "redirect:/elementiView";
	}

}
