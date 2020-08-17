package com.meli.exam.be.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.meli.exam.be.domain.Dna;
import com.meli.exam.be.repository.daos.DnaDao;
import com.meli.exam.be.repository.mappers.DnaMapper;

@Repository
public class DnaRepositoryImpl implements IDnaRepository{

	
	@Autowired  
	private JdbcTemplate jdbc;
	
	@Override
	public void save(Dna dna) {
		
		String idDnaType = jdbc.queryForObject(
                "select id from dna_types where description = ?",
                new Object[]{dna.getDnaType()},
                String.class
        );
		
		jdbc.update(
                "insert into dna (dna_string, dna_type) values(?,?)",
                DnaMapper.mapDnaString(dna.getDnaString()), idDnaType);
		
	}

	@Override
	public Dna get(String[] dnaString) {
		
		Dna dna = null;
		DnaDao dnaDao = null;
		
		String sql = "";
		sql += "SELECT dna_string, description";
		sql += " FROM dna, dna_types";
		sql += " WHERE dna_type = id";
		sql += " AND dna_string = ?";
		
		try {
			
			dnaDao = jdbc.queryForObject(
	                sql,
	                new Object[]{DnaMapper.mapDnaString(dnaString)},
	                (rs, rowNum) -> new DnaDao(rs.getString("dna_string"),
	                						   rs.getString("description"))
	        );
//			String parameter =DnaMapper.mapDnaString(dnaString);
//			dnaDao = (DnaDao) jdbc.query(
//					sql,
//					new Object[]{parameter},
//					new ResultSetExtractor<DnaDao>(){  
//					    @Override  
//					     public DnaDao extractData(ResultSet rs) throws SQLException,  
//					            DataAccessException {  
//					      
//					        DnaDao dna = new DnaDao();
//					        while(rs.next()){  
//					        	dna.setDna_string(rs.getString(1));
//					        	dna.setDna_type(rs.getString(2));
//					        }  
//					        return dna;  
//					       }  
//					    }
//    );
			dna = DnaMapper.mapDna(dnaDao);
		}
		catch(EmptyResultDataAccessException ex) {
			return null;
		}
		
		return dna;
	}

//	@Override
//	public String[] getDnaSequencesByType(String dnaType) {
//		
//		String sql = "";
//		
//		sql += "SELECT dna_sequence";
//		sql += " FROM dna_sequences, dna_types";
//		sql += " WHERE dna_type = id";
//		sql += " AND description = ?";
//		
//		
//		return (String[]) jdbc.query(
//                sql,
//                new Object[]{dnaType},
//                (rs, rowNum) ->
//                	rs.getLong("dna_sequence")
//                 
//        ).toArray();
//
//	}

}
