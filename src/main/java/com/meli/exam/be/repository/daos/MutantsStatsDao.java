package com.meli.exam.be.repository.daos;

public class MutantsStatsDao {
	
	private int mutantCount;
	
	private int humanCount;

	public MutantsStatsDao(int mutantCount, int humanCount) {
		
		this.mutantCount = mutantCount;
		this.humanCount = humanCount;
		
	}
	
	public int getMutantCount() {
		return mutantCount;
	}

	public void setMutantCount(int mutantCount) {
		this.mutantCount = mutantCount;
	}

	public int getHumanCount() {
		return humanCount;
	}

	public void setHumanCount(int humanCount) {
		this.humanCount = humanCount;
	}
	
	
}
