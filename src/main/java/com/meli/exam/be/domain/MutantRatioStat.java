package com.meli.exam.be.domain;

public class MutantRatioStat {

	private int mutantsCount;
	
	private int humansCount;
	
	private float ratio;

	public MutantRatioStat(int mutantsCount, int humansCount) {
		this.mutantsCount = mutantsCount;
		this.humansCount = humansCount;
		
		if(humansCount != 0)
			this.ratio = ((float)mutantsCount / (float)humansCount);
		else
			this.ratio = 1;
	}
	
	
	public int getMutantsCount() {
		return mutantsCount;
	}


	public int getHumansCount() {
		return humansCount;
	}

	public float getRatio() {
		return ratio;
	}

}
