package com.meli.exam.be.application.dtos;

public class MutantStatsDto {

	private int count_mutant_dna;
	
	private int count_human_dna;
	
	private float ratio;

	public MutantStatsDto(){
		this.count_mutant_dna = 0;
		this.count_human_dna = 0;
		this.ratio = 0;
	}
	
	@Override
	public boolean equals(Object o) {
		
		MutantStatsDto m = (MutantStatsDto)o;
	
		return m.getCount_human_dna() == this.count_human_dna &&
				m.getCount_mutant_dna() == this.count_mutant_dna &&
				m.getRatio() == this.ratio;
				
	}
	
	public int getCount_mutant_dna() {
		return count_mutant_dna;
	}

	public void setCount_mutant_dna(int count_mutant_dna) {
		this.count_mutant_dna = count_mutant_dna;
	}

	public int getCount_human_dna() {
		return count_human_dna;
	}

	public void setCount_human_dna(int count_human_dna) {
		this.count_human_dna = count_human_dna;
	}

	public float getRatio() {
		return ratio;
	}

	public void setRatio(float ratio) {
		this.ratio = ratio;
	}
}
