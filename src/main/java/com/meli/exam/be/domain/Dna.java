package com.meli.exam.be.domain;


public class Dna {
	
	private String[] dnaString;
	
	private String dnaType;
	
	public Dna() {
		
	}
	public Dna(String[] dnaString, String dnaType) {
		this.dnaString = dnaString;
		this.dnaType = dnaType;
	}
	

	public String[] getDnaString() {
		return dnaString;
	}

	public void setDnaString(String[] dnaString) {
		this.dnaString = dnaString;
	}

	public String getDnaType() {
		return dnaType;
	}

	public void setDnaType(String dnaType) {
		this.dnaType = dnaType;
	}
}
