package com.meli.exam.be;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import com.meli.exam.be.application.StatsController;
import com.meli.exam.be.application.dtos.MutantStatsDto;
import com.meli.exam.be.domain.Dna;
import com.meli.exam.be.repository.IDnaRepository;



@SpringBootTest
@ActiveProfiles("test")
@Sql({ "schema.sql","data.sql"})
class MeliBeExamStatsTests {

	@Autowired
	private StatsController statsController;
	
	@Autowired
	private IDnaRepository dnaRepo;
	
	@Test
	void contextLoads() {
	}

	@Test
	public void statsTest() {
		
		boolean ret1 = false, ret2 = false, ret3 = false, ret4 = false;
		
		ret1 = initialStatsTest();
		 
		dnaRepo.save(new Dna(DnaCases.getValidHumanN6Dna(),"HUMAN"));
		dnaRepo.save(new Dna(DnaCases.getValidHumanN6Dna2(),"HUMAN"));
		dnaRepo.save(new Dna(DnaCases.getValidMutantN6ColumnAndDiagonalDna(),"MUTANT"));
		
		ret2 = ratioLowerThan1Test();
		
		dnaRepo.save(new Dna(DnaCases.getValidMutantN6ColumnDna(),"MUTANT"));
		
		ret3 = ratioEquals1Test();
		
		dnaRepo.save(new Dna(DnaCases.getValidMutantN6RowDna(),"MUTANT"));
		
		ret4 = ratioGreaterThan1Test();
		
		assertThat(ret1 && ret2 && ret3 && ret4).isEqualTo(true);
		
	}
	

	private boolean initialStatsTest() {
		MutantStatsDto referenceStat = new MutantStatsDto();
		referenceStat.setCount_human_dna(0);
		referenceStat.setCount_mutant_dna(0);
		referenceStat.setRatio(1);
		
		ResponseEntity<MutantStatsDto> statResponse = statsController.getMutanRatioStats();
		
		return referenceStat.equals(statResponse.getBody());
		
		//assertEquals(referenceStat, statResponse.getBody());
	}
	
	
	private boolean ratioLowerThan1Test() {
		MutantStatsDto referenceStat = new MutantStatsDto();
		referenceStat.setCount_human_dna(2);
		referenceStat.setCount_mutant_dna(1);
		referenceStat.setRatio(0.5f);
				
		return referenceStat.equals(statsController.getMutanRatioStats().getBody());

	}
	

	private boolean ratioEquals1Test() {

		MutantStatsDto referenceStat = new MutantStatsDto();
		referenceStat.setCount_human_dna(2);
		referenceStat.setCount_mutant_dna(2);
		referenceStat.setRatio(1);
		return referenceStat.equals(statsController.getMutanRatioStats().getBody());
	}
	

	private boolean ratioGreaterThan1Test() {
		MutantStatsDto referenceStat = new MutantStatsDto();
		referenceStat.setCount_human_dna(2);
		referenceStat.setCount_mutant_dna(3);
		referenceStat.setRatio(1.5f);
		
		return referenceStat.equals(statsController.getMutanRatioStats().getBody());
	}
	
	
	
	
}
