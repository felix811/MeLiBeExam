package com.meli.exam.be.repository;

import com.meli.exam.be.domain.Dna;

public interface IDnaRepository {
	
	void save(Dna dna);
	
	Dna get(String[] dnaString);

//	String[] getDnaSequencesByType(String string);
	
}
