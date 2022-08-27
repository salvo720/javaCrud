package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//	Must : 
//	1) onltre @Entity , prima della classe , devi inserire il @id per indicare quale campo sara l'id sul db 

@Entity
@Table(name = "elemento")
public class Elemento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	indica che si tratta di una chaive primaria e che e autoincrement , lato server del database
	private int id;
	private String nome;
	private String codiceIpt;
	private String quantita;

//	getter and setter 

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodiceIpt() {
		return codiceIpt;
	}

	public void setCodiceIpt(String codiceIpt) {
		this.codiceIpt = codiceIpt;
	}

	public String getQuantita() {
		return quantita;
	}

	public void setQuantita(String quantita) {
		this.quantita = quantita;
	}
}
