package com.example.demo.controller;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

//	Must : 
//	1) per poter mappare i package spring devi seguire la nomeclatura usata da spring , segui il primo package e accoda il nome del tuo package per proseguire 

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.model.Utente;
import com.example.demo.service.ServiceUtente;

@Controller
public class UtenteController {

	@Autowired
	private ServiceUtente serviceUtente;

//	/ e login portano allo stesso link  
//	per poter prendere i dati del login dobbiamo creare un oggetto con i dati del for che mandiamo 
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(HttpServletRequest request, Model model) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		model.addAttribute("utente", new Utente(username, password));
		return "login";
	}

//	/ e login coincidono 
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String undefinePage() {
		return "redirect:login";

	}

	@RequestMapping(value = "/loginCheck", method = RequestMethod.POST)
	public String loginCheck(@ModelAttribute("utente") Utente utente, Model model) throws Exception {

		Utente UtenteAuth = serviceUtente.loginAuth(utente.getUsername(), utente.getPassword());
//		System.out.println("UtenteAuth :" + UtenteAuth);
//		System.out.println("Utente.getUsername() :" + utente.getUsername());
//		guard condition 
		if (Objects.isNull(UtenteAuth)) {
//		TODO: Mostrare l'eerore nella pagina html 
			String errorMessage = "user not register in db";
			model.addAttribute("errorMessage", errorMessage);
			return "redirect:/login";
		}

		return "redirect:/elementiView";

	}

}
