package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Utente;
import com.example.demo.repository.UtenteRepository;

@Service
public class ServiceUtente {

	@Autowired
	private UtenteRepository repo;

	public Utente loginAuth(String username, String password) {

		Utente UtenteLogin = repo.findByUsernameAndPassword(username, password);
		return UtenteLogin;
	}

}
