package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.ElementoRepository;

@Service
public class ServiceElemento {

	@Autowired
	private ElementoRepository elementoRepository;

	public List ElementiJson() {
		List elementiJson = elementoRepository.findAll();
		return elementiJson;
	}

}
