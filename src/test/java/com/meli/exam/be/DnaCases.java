package com.meli.exam.be;

public abstract class DnaCases {


	//Invalid Dna
	//Invalid character: "U", 4th string
	private static String[] invalidN6Dna = {"ATGCGA","CAGTGC","TTATGT","AUAATG","CCCCTA","TCACTG"};
	
	private static String[] invalidN3Dna = {"CTG","CAG","TTA"};
	
	private static String[] invalid4x6Dna = {"ATGC","AAGT","ATAT","AGAA","CCTC","TCAC"};
	
	private static String[] invalidNotSquareDna = {"ATGC","AAT","ATAT","AGAA"};
	



	//Valid human Dna
	private static String[] validHumanN6Dna = {"CTGCGA","CAGTGC","TTATGT","AGAATG","CCTCTA","TCACTG"};
	
	private static String[] validHumanN6Dna2 = {"TTGCGA","CAGTGC","TTATGT","AGAGTG","CCTCTA","TCGCTG"};
 		
	
	//Valid cases
	private static String[] validExistingMutantN6Dna = {"ATGCGA","CAGTGC","TTATGT","AGAATG","CCCCTA","TCACTG"};
	
	private static String[] validMutantN6RowDna = {"CTAAAA","CACCCC","TTATGT","AGAATG","CCTCTA","TCACTG"};
	
	private static String[] validMutantN6ColumnDna = {"CTGCGA","CAGTGC","CTATGT","CGAAGG","CCTCTA","TCACTG"};
	
	private static String[] validMutantN6DiagonalDna = {"CTGCGA","CAGTGC","TCATGT","AGCATG","CCGTAA","TCTCTG"};
	
	private static String[] validMutantN6RowAndDiagonalDna = {"CTGGGG","CATTGC","TTATGT","AGAGTG","CCGCTT","TCACTG"}; 
	
	private static String[] validMutantN6RowAndColumnDna = {"CTGTGA","CATTGC","TTATGT","AGATTG","CCTCTA","TCCCCG"};
	
	private static String[] validMutantN6ColumnAndDiagonalDna = {"ATGCGA","AAGTGC","ATATGT","AGAATG","CCTCAA","TCACTG"};
	
	private static String[] validMutantN4RowAndDiagonalDna = {"ATGA","TGAT","AAAA","AGAT"};
	
	private static String[] validMutantN10RowDiagonalDna = {"CTGCGACGAT","CAGTGCATAT","TTATGTGCTA","AGAATGGGGA","CCTCTATACC","TCACTGCAGT","GACTTGACTG","CCATAACTTC","GTACGATAGA","ATGGATCGTA"};
	
	private static String[] validMutantN10DualRowDna = {"CTGCGACGAT","CAGTGCATAT","TTATGTGCTA","GGGGGGGGAT","CCTCTATACC","TCACTGCAGT","GACTTGACTG","CCATAACTTC","GTACGATAGA","ATGGATCGTA"};

	 
	//Getters
	public static  String[] getValidMutantN6RowDna() {
		return validMutantN6RowDna;
	}
	
	public static  String[] getInvalidN6Dna() {
		return invalidN6Dna;
	}

	public static  String[] getInvalidNotSquareDna() {
		return invalidNotSquareDna;
	}
	
	public static String[] getValidHumanN6Dna() {
		return validHumanN6Dna;
	}
	
	public static String[] getValidHumanN6Dna2() {
		return validHumanN6Dna2;
	}

	public static String[] getInvalid4x6Dna() {
		return invalid4x6Dna;
	}


	public static String[] getvalidExistingMutantN6Dna() {
		return validExistingMutantN6Dna;
	}

	public static String[] getInvalidN3Dna() {
		return invalidN3Dna;
	}

	public static String[] getValidExistingMutantN6Dna() {
		return validExistingMutantN6Dna;
	}

	public static String[] getValidMutantN6ColumnDna() {
		return validMutantN6ColumnDna;
	}

	public static String[] getValidMutantN6DiagonalDna() {
		return validMutantN6DiagonalDna;
	}

	public static String[] getValidMutantN6RowAndDiagonalDna() {
		return validMutantN6RowAndDiagonalDna;
	}

	public static String[] getValidMutantN6RowAndColumnDna() {
		return validMutantN6RowAndColumnDna;
	}

	public static String[] getValidMutantN6ColumnAndDiagonalDna() {
		return validMutantN6ColumnAndDiagonalDna;
	}
	
	public static String[] getValidMutantN4RowAndDiagonalDna() {
		return validMutantN4RowAndDiagonalDna;
	}

	public static String[] getValidMutantN10RowDiagonalDna() {
		return validMutantN10RowDiagonalDna;
	}

	public static String[] getValidMutantN10DualRowDna() {
		return validMutantN10DualRowDna;
	}

	
	
	
}
