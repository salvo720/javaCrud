package com.example.demo.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.ServiceElemento;

@RestController
public class ElementoControllerRest {

	@Autowired
	private ServiceElemento serviceElemento;

	@RequestMapping(value = "/api/elementiJson", method = RequestMethod.GET)

	public List ElementiJson() {
		return serviceElemento.ElementiJson();
	}

}
