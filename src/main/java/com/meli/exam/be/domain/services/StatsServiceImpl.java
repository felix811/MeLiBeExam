package com.meli.exam.be.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meli.exam.be.domain.MutantRatioStat;
import com.meli.exam.be.repository.IStatsRepository;

@Service
public class StatsServiceImpl implements IStatsService{

	@Autowired
	private IStatsRepository statsRepsoitory;
	
	
	@Override
	public MutantRatioStat getMutantRatioStat() {
		
		return statsRepsoitory.getMutantRatioStat();
	}

}
