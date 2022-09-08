package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Elemento;
import com.example.demo.repository.ElementoRepository;

@Service
public class ServiceElemento {

	@Autowired
	private ElementoRepository elementoRepository;

	public List<Elemento> ElementiJson() {
		List<Elemento> elementiJson = elementoRepository.findAll();
		return elementiJson;
	}

	public void NewElement(Iterable<Elemento> saveElemento) {
		elementoRepository.saveAll(saveElemento);
	}

	public void UpdateElemento(Elemento elemento) throws Exception {
//		Optional<Elemento> elementFound = elementoRepository.findById(elemento.getId());
//
//		if (elementFound.isEmpty()) {
//			throw new Exception("Errore elemento non trovato ");
//		}

		Optional<Elemento> elementFound = findById(elemento.getId());

		elementFound.get().setId(elemento.getId());
		elementFound.get().setNome(elemento.getNome());
		elementFound.get().setQuantita(elemento.getQuantita());
		elementFound.get().setSerialeprodotto(elemento.getSerialeprodotto());
	}

	public Optional<Elemento> findById(int id) throws Exception {
		Optional<Elemento> elementFound = elementoRepository.findById(id);

		if (elementFound.isEmpty()) {
			throw new Exception("Errore elemento non trovato ");
		}

		return Optional.of(elementFound.get());

	}

	public void DeleteElement(int id) throws Exception {
		Optional<Elemento> elementFound = elementoRepository.findById(id);

		if (elementFound.isEmpty()) {
			throw new Exception("Errore elemento non trovato ");
		}

		elementoRepository.deleteById(id);

	}

}
