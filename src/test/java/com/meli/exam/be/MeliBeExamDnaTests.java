package com.meli.exam.be;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import com.meli.exam.be.application.DnaRequest;
import com.meli.exam.be.application.MutantsController;

@SpringBootTest//(classes = {RepositoryTestConfig.class})
@ActiveProfiles("test")
@Sql({ "schema.sql","data.sql"})
class MeliBeExamDnaTests {

 
	@Autowired
	 private MutantsController mutantsController;
	
	
	@Test
	void contextLoads() {
	}

	
	@Test 
	 public void invalidDnaTest() {
		
		assertThat(mutantsController.isMutant(new DnaRequest(DnaCases.getInvalidN6Dna())).getStatusCode())
			.isEqualTo(HttpStatus.FORBIDDEN);
	 }
	
	@Transactional
	@Test
	public void invalidN3DnaTest() {
		
		assertThat(mutantsController.isMutant(new DnaRequest(DnaCases.getInvalidN3Dna())).getStatusCode())
			.isEqualTo(HttpStatus.FORBIDDEN);
	}
	
	@Test
	public void invalid4x6DnaTest() {
		
		assertThat(mutantsController.isMutant(new DnaRequest(DnaCases.getInvalid4x6Dna())).getStatusCode())
			.isEqualTo(HttpStatus.FORBIDDEN);
	}
	
	@Test
	public void invalidNotSquareDnaTest() {

		assertThat(mutantsController.isMutant(new DnaRequest(DnaCases.getInvalidNotSquareDna())).getStatusCode())
			.isEqualTo(HttpStatus.FORBIDDEN);
	}

	@Test
	 public void validHumanDnaTest() {
		
		assertThat(mutantsController.isMutant(new DnaRequest(DnaCases.getValidHumanN6Dna())).getStatusCode())
			.isEqualTo(HttpStatus.FORBIDDEN);
	 }
	
	//ValidMutant Dna
	@Sql({"dataDnaInsert.sql"})
	@Test
	 public void validExistingMutantDnaTest() {
		
		assertThat(mutantsController.isMutant(new DnaRequest(DnaCases.getvalidExistingMutantN6Dna())).getStatusCode())
			.isEqualTo(HttpStatus.OK);
	 }
	
	@Test
	 public void validMutantDnaRowTest() {

		assertThat(mutantsController.isMutant(new DnaRequest(DnaCases.getValidMutantN6RowDna())).getStatusCode())
			.isEqualTo(HttpStatus.OK);
	 }
	
	@Test
	 public void validMutantDnaColumnTest() {
		
		assertThat(mutantsController.isMutant(new DnaRequest(DnaCases.getValidMutantN6ColumnDna())).getStatusCode())
			.isEqualTo(HttpStatus.OK);
	 }
	
	@Test
	 public void validMutantDnaDiagonalTest() {
		
		assertThat(mutantsController.isMutant(new DnaRequest(DnaCases.getValidMutantN6DiagonalDna())).getStatusCode())
			.isEqualTo(HttpStatus.OK);
	 }
	
	@Test
	 public void validMutantDnaRowAndDiagonalTest() {
		
		assertThat(mutantsController.isMutant(new DnaRequest(DnaCases.getValidMutantN6RowAndDiagonalDna())).getStatusCode())
			.isEqualTo(HttpStatus.OK);
	 }
	
	@Test
	 public void validMutantDnaRowAndColumnTest() {
		
		assertThat(mutantsController.isMutant(new DnaRequest(DnaCases.getValidMutantN6RowAndColumnDna())).getStatusCode())
			.isEqualTo(HttpStatus.OK);
	 }

	@Test
	 public void validMutantDnaColumnAndDiagonalTest() {
		
		assertThat(mutantsController.isMutant(new DnaRequest(DnaCases.getValidMutantN6ColumnAndDiagonalDna())).getStatusCode())
			.isEqualTo(HttpStatus.OK);
	 }
	
	@Test
	 public void validMutantDnaN4RowAndDiagonalTest() {
		
		assertThat(mutantsController.isMutant(new DnaRequest(DnaCases.getValidMutantN4RowAndDiagonalDna())).getStatusCode())
			.isEqualTo(HttpStatus.OK);
	 }
	
	@Test
	 public void validMutantDnaN10RowAndDiagonalTest() {
		
		assertThat(mutantsController.isMutant(new DnaRequest(DnaCases.getValidMutantN10RowDiagonalDna())).getStatusCode())
			.isEqualTo(HttpStatus.OK);
	 }
	
	@Test
	 public void validMutantDnaN10DualRowTest() {
		
		assertThat(mutantsController.isMutant(new DnaRequest(DnaCases.getValidMutantN10DualRowDna())).getStatusCode())
			.isEqualTo(HttpStatus.OK);
	 }
}
