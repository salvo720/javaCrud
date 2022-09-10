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

	public void NewElement(Iterable<Elemento> elementoSave) {
		elementoRepository.saveAll(elementoSave);
	}

	public void UpdateElemento(Elemento elementoUpdate) throws Exception {
//		elementoRepository.save(elementoUpdate);
		Optional<Elemento> Elemento = elementoRepository.findById(elementoUpdate.getId());
		if (Elemento.isEmpty()) {
			throw new Exception("Errore elemento non trovato");
		}

		Elemento Elementodb = Elemento.get();

		Elementodb.setNome(elementoUpdate.getNome());
		Elementodb.setSerialeprodotto(elementoUpdate.getSerialeprodotto());
		Elementodb.setQuantita(elementoUpdate.getQuantita());
		elementoRepository.save(Elementodb);
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
