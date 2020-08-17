package com.meli.exam.be.repository.daos;

public class DnaDao {

	private String dna_string;
	
	private String dna_type;

	
	public DnaDao() {
		
	}
	
	public DnaDao(String dna_string, String dna_type) {
		
		this.dna_string = dna_string;
		this.dna_type = dna_type;
		
	}
	
	
	public String getDna_string() {
		return dna_string;
	}

	public void setDna_string(String dna_string) {
		this.dna_string = dna_string;
	}

	public String getDna_type() {
		return dna_type;
	}

	public void setDna_type(String dna_type) {
		this.dna_type = dna_type;
	}
	
	
}
