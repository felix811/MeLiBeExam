package com.meli.exam.be.repository.mappers;

import com.meli.exam.be.domain.Dna;
import com.meli.exam.be.repository.daos.DnaDao;

public class DnaMapper {
	
	public static String mapDnaString(String[] dnaString) {
		String dbString = "";
		
		for (String dnaRow : dnaString) {
			dbString+=dnaRow.concat(";");
		}
				
		return dbString;
	}
	
	public static String[] mapDnaString(String dnaDb) {
		
		return dnaDb.split(";");
		
	}
	
	public static Dna mapDna(DnaDao dnaDao) {
	
		Dna dna = new Dna();
		
		dna.setDnaString(mapDnaString(dnaDao.getDna_string()));
		dna.setDnaType(dnaDao.getDna_type());
		
		return dna;
	
	}
}
