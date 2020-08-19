package com.meli.exam.be.domain;

public class MutantRatioStat {

	private int mutantsCount;
	
	private int humansCount;
	
	private float ratio;

	public MutantRatioStat(int mutantsCount, int humansCount) {
		this.mutantsCount = mutantsCount;
		this.humansCount = humansCount;
		
		if(humansCount != 0)
			this.ratio = mutantsCount / humansCount;
		else
			this.ratio = 1;
			
	}
	
	
	public int getMutantsCount() {
		return mutantsCount;
	}

	public void setMutantsCount(int mutantsCount) {
		this.mutantsCount = mutantsCount;
	}

	public int getHumansCount() {
		return humansCount;
	}

	public void setHumansCount(int humansCount) {
		this.humansCount = humansCount;
	}

	public float getRatio() {
		return ratio;
	}

}
