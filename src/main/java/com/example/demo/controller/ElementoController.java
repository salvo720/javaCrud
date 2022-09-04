package com.example.demo.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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

		System.out.println("elemento : " + elemento);
		ArrayList<Elemento> saveElemento = new ArrayList<Elemento>();
		saveElemento.add(0, new Elemento(elemento.getNome(), elemento.getSerialeprodotto(), elemento.getQuantita()));
		serviceElemento.NewElement(saveElemento);
		String successNewElemento = "Elemento inserito correttamente";
		model.addAttribute("successMessage", successNewElemento);
//		i dati si passano attraverso il model attribute 
		return "newElementoView";
	}

	@RequestMapping(value = "/updateElemento", method = RequestMethod.GET)
	public String updateElemento() {
		return "elementiView";
	}

	@RequestMapping(value = "/deleteElemento", method = RequestMethod.GET)
	public String DeleteElemento() {
		return "elementiView";
	}

}
