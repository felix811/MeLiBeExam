package com.meli.exam.be.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meli.exam.be.application.dtos.MutantStatsDto;
import com.meli.exam.be.domain.MutantRatioStat;
import com.meli.exam.be.domain.services.IStatsService;

@RestController
@RequestMapping("/stats")
public class StatsController {
	
	@Autowired
	IStatsService statsService;
	
	@GetMapping
	public ResponseEntity<MutantStatsDto> getMutanRatioStats() {
		
		MutantStatsDto dto = new MutantStatsDto();
		try {
			MutantRatioStat mrstat= statsService.getMutantRatioStat();
			
			
			dto.setCount_human_dna(mrstat.getHumansCount());
			dto.setCount_mutant_dna(mrstat.getMutantsCount());
			dto.setRatio(mrstat.getRatio());
		}
		catch(Exception ex){
			return new ResponseEntity<MutantStatsDto>(dto,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<MutantStatsDto>(dto,HttpStatus.OK);
	}

}
