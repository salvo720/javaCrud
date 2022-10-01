package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Utente;
import com.example.demo.repository.UtenteRepository;

@Service
public class ServiceUtente {

	@Autowired
	private UtenteRepository repo;

	public Utente loginAuth(String email, String password) {

		Utente UtenteLogin = repo.findByEmailAndPassword(email, password);
		return UtenteLogin;
	}

}
