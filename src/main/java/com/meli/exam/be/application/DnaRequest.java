package com.meli.exam.be.application;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DnaRequest {

	@JsonProperty("dna")
    private String[] dna;

	public DnaRequest() {
		
	}
	
	public DnaRequest(String[] dna) {
		this.dna = dna;
	}
	
	
	public String[] getDna() {
		return dna;
	}

	public void setDna(String[] dna) {
		this.dna = dna;
	}
	
	
	
}
