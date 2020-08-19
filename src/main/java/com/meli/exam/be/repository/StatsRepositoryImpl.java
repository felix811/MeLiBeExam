package com.meli.exam.be.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import com.meli.exam.be.domain.MutantRatioStat;
import com.meli.exam.be.repository.daos.MutantsStatsDao;


@Repository
public class StatsRepositoryImpl implements IStatsRepository {

	
	
	@Autowired  
	private JdbcTemplate jdbc;
	
	@Override
	public MutantRatioStat getMutantRatioStat() {
				String sql = "";
		sql += "SELECT ";
		sql += " SUM(CASE WHEN dna_type = 'M' THEN 1 ELSE 0 END) AS mutant_count,";
		sql += " SUM(CASE WHEN dna_type = 'H' THEN 1 ELSE 0 END) AS human_count";
		sql += " FROM dna";
		
		MutantsStatsDao dao = null;
		MutantRatioStat mutantRatioStat= null;
		try {
			
			 dao = jdbc.queryForObject(
	                sql,
	                (rs, rowNum) -> new MutantsStatsDao(rs.getInt("mutant_count"),
	                						   rs.getInt("human_count"))
	        );
			 mutantRatioStat = new MutantRatioStat(dao.getMutantCount(), dao.getHumanCount());
		}
		catch(EmptyResultDataAccessException ex) {
			return null;
		}
		
		
		return mutantRatioStat;
	}

}
