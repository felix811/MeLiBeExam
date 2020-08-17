package com.meli.exam.be.domain.services;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.meli.exam.be.domain.Dna;
import com.meli.exam.be.repository.IDnaRepository;

@Service
public class DnaServiceImpl implements IDnaService {

	private final String MUTANT_TYPE = "MUTANT";
	private final String HUMAN_TYPE = "HUMAN";
	private final String VALID_DNA = "ATCG";
	private final String[] MUTANT_SEQUENCES = {"AAAA","TTTT","CCCC","GGGG"};
	private final short MIN_OCURRENCES = 2;
	
	
	@Autowired
	IDnaRepository dnaRepository;
	
	@Override
	public boolean isMutant(String[] dnaString) {

		if(!this.isValidDna(dnaString))
			return false;
		
		
		Dna dna = dnaRepository.get(dnaString);
		
		if (dna != null)
			return dna.getDnaType().equals(MUTANT_TYPE);
		
		boolean isMutant = false;
		
		//this.mutantSequences = dnaRepository.getDnaSequencesByType(MUTANT_TYPE);

		dna = new Dna();
		dna.setDnaString(dnaString);
		dna.setDnaType(HUMAN_TYPE);
		
		short dnaMatches = 0;
		
		dnaMatches += this.analizeRows(dnaString);
		
		if(dnaMatches >= MIN_OCURRENCES)
			isMutant = true;
		else {
			dnaMatches += this.analizeColumns(dnaString);
			if(dnaMatches >= MIN_OCURRENCES)
				isMutant = true;
			else {
				dnaMatches += this.analizeDiagonals(dnaString);
				if(dnaMatches >= MIN_OCURRENCES)
					isMutant = true;
			}
		}
			
		if(isMutant)
			dna.setDnaType(MUTANT_TYPE);
		
		//Save the adn request
		dnaRepository.save(dna);
	    
		
		return isMutant;
	}

	private boolean isValidDna(String[] dnaString) {
		
		
		short dimension = (short)dnaString[0].length();
		boolean validDimensions = true;
		
		short minDimension = (short) MUTANT_SEQUENCES[0].length();
		
		if(minDimension > dimension)
			return false;
		
		short i = 0;
		
		while(i < dnaString.length) {
			if(dnaString[i].length() != dimension) {
				validDimensions = false;
				break;
			}
			i++;
		}
		
		if(!validDimensions || i != dimension)
			return false;
		
		Pattern pattern = Pattern.compile("[^"+ VALID_DNA +"]");
        Matcher matcher = null; 

		for (String row : dnaString) {
			matcher = pattern.matcher(row);
			if(matcher.find())
				return false;	
		}
        
		return true;
		
	}

	private short analizeRows(String[] dnaString) {
		
		return this.containsMutantSequence(dnaString);
		
	}

	private short analizeColumns(String[] dnaString) {
		
		short sequenceLenght = (short)dnaString[0].length();
		
		String[] rows = new String[sequenceLenght];
		Arrays.fill(rows, "");

		
		for (String dnaRow : dnaString) {
			for (int i = 0; i < dnaRow.length(); i++) {
				rows[i] += dnaRow.charAt(i);
			}
		}
		
		return this.containsMutantSequence(rows);
		
	}
	
	private short analizeDiagonals(String[] dnaString) {

		short sequenceLenght = (short)MUTANT_SEQUENCES[0].length();
		short dimension = (short)dnaString[0].length();
		
		short iterations = (short)(dimension - sequenceLenght);
		
		String[] rows = new String[iterations*4 + 2];
		Arrays.fill(rows, "");

		short row = 0;
		short column =0;
		short i = 0;
		for(short j = 1; j-1 < iterations; j++) {
			
			row = j; 
			column = 0;
			while(dimension - row> 0) {
				rows[i] += dnaString[row].charAt(column);
				rows[i+1]+= dnaString[column].charAt(row);
				rows[i+2] += dnaString[dimension-row-1].charAt(column);
				rows[i+3] += dnaString[dimension-column-1].charAt(row);
				
				row++;
				column++;
			}
			i += 4;
		}
		
		for(int j = 0; j < dimension; j++) {
			rows[i] += dnaString[j].charAt(j);
			rows[i + 1] += dnaString[dimension-j-1].charAt(j);
		}
		
		
		return this.containsMutantSequence(rows);
		
	}
	
	private short containsMutantSequence(String[] rows) {
	
		short sequencesCount = 0;
		
		for (String row : rows) {
			for (String sequence : MUTANT_SEQUENCES) {
				sequencesCount += StringUtils.countOccurrencesOf(row, sequence);
			} 
			if(sequencesCount >= MIN_OCURRENCES)
				break;
		}
		return sequencesCount;
	}



}
