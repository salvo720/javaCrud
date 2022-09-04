package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Elemento;

@Repository
public interface ElementoRepository extends JpaRepository<Elemento, Integer> {
	public List findAll();

	public List saveAll(Iterable saveElemento);
}