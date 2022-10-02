package com.example.demo.controller;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.Utente;
import com.example.demo.service.ServiceUtente;

@Controller
public class UtenteController {

	@Autowired
	private ServiceUtente serviceUtente;
	
//	Default per spring security login 
	@RequestMapping(value="/default2",method=RequestMethod.GET)
	public String defaultMethod(String[] args  ,HttpServletRequest request)	{
		if (request.isUserInRole("ADMIN")) {
			return "redirect:/elementiView/";
			}
		return "redirect:/";
	}


//	/ e login portano allo stesso link  
//	per poter prendere i dati del login dobbiamo creare un oggetto con i dati del for che mandiamo 
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(HttpServletRequest request, Model model) {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		model.addAttribute("utente", new Utente(email, password));
		return "/login";
	}

//	/ e login coincidono 
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String undefinePage() {
		return "redirect:/login";

	}

	@RequestMapping(value = "/loginCheck", method = RequestMethod.POST)
	public String loginCheck(@ModelAttribute("utente") Utente utente, Model model) throws Exception {

		Utente UtenteAuth = serviceUtente.loginAuth(utente.getEmail(), utente.getPassword());
		System.out.println("UtenteAuth :" + UtenteAuth);
		System.out.println("Utente.getUsername() :" + utente.getEmail());
//		guard condition 
		if ( Objects.isNull(UtenteAuth) ) {
//		TODO: Mostrare l'errore nella pagina html 
			String errorMessage = "user not register in db";
			model.addAttribute("errorMessage", errorMessage);
			System.out.println("error");
			return "redirect:/login";
		}

		return "redirect:/elementiView";

	}

	@RequestMapping(value = "/login2", method = RequestMethod.GET)
	public String login2(HttpServletRequest request, Model model) {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		model.addAttribute("utente", new Utente(email, password));
		return "login2";

	}

	@RequestMapping(value = "/login2Check", method = RequestMethod.POST)
	public String login2Check(@ModelAttribute("utente") Utente utente, Model model) {

		Utente utentedb = serviceUtente.loginAuth(utente.getEmail(), utente.getPassword());
//		System.out.println("utentedb :" + utentedb.getEmail() + utentedb.getPassword());
		
		if ( utentedb == null ) {
			model.addAttribute("errorMessage", "email or password invalid ");
			return "login2";
		}

		if ( !Objects.isNull(utentedb) ) {
//			System.out.println(utentedb.getId() + utentedb.getUsername() + utentedb.getPassword());

			return "dashboard";
		}

		return "login2";

	}

// Varie can be deleted after 25-09-2022 ------------------------------------------------------------------------------------------------

	@RequestMapping(value = "/ciao", method = RequestMethod.GET)
	@ResponseBody
	public ArrayList ciao() {

		int objectSize = 100;
		ArrayList ObjectElement = new ArrayList();

		for (int i = 0; i <= objectSize; i++) {
			if ( (i % 3 == 0) && (i % 5 == 0) ) ObjectElement.add(i, "dip 3 5");
			else if ( (i % 3 == 0) || (i % 5 == 0) ) {
				if ( i % 3 == 0 ) ObjectElement.add(i, "dip 3");
				if ( i % 5 == 0 ) ObjectElement.add(i, "dip 5");
			} else {
				ObjectElement.add(i, i);
			}
		}

		for (int y = 0; y <= objectSize; y++) {
//			ObjectElement.get(i);
			System.out.println(" y : " + y + " , " + ObjectElement.get(y));
		}
//		System.out.println(ObjectElement);

		return ObjectElement;

	}

}