package com.meli.exam.be;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import com.meli.exam.be.application.DnaRequest;
import com.meli.exam.be.application.MutantsController;

@SpringBootTest//(classes = {RepositoryTestConfig.class})
@ActiveProfiles("test")
@Sql({ "schema.sql", "data.sql" })
class MeliBeExamApplicationTests {


	@Autowired
	 private MutantsController controller;
	
	@Test
	void contextLoads() {
	}
	
	@Test 
	 public void invalidDnaTest() {
		
		assertThat(controller.isMutant(new DnaRequest(DnaCases.getInvalidN6Dna())).getStatusCode())
			.isEqualTo(HttpStatus.FORBIDDEN);
	 }
	
	@Test
	public void invalidN3DnaTest() {
		
		assertThat(controller.isMutant(new DnaRequest(DnaCases.getInvalidN3Dna())).getStatusCode())
			.isEqualTo(HttpStatus.FORBIDDEN);
	}
	
	@Test
	public void invalid4x6DnaTest() {
		
		assertThat(controller.isMutant(new DnaRequest(DnaCases.getInvalid4x6Dna())).getStatusCode())
			.isEqualTo(HttpStatus.FORBIDDEN);
	}
	
	@Test
	public void invalidNotSquareDnaTest() {

		assertThat(controller.isMutant(new DnaRequest(DnaCases.getInvalidNotSquareDna())).getStatusCode())
			.isEqualTo(HttpStatus.FORBIDDEN);
	}
	
	@Test
	 public void validHumanDnaTest() {
		
		assertThat(controller.isMutant(new DnaRequest(DnaCases.getValidHumanN6Dna())).getStatusCode())
			.isEqualTo(HttpStatus.FORBIDDEN);
	 }
	
	//ValidMutant Dna
	@Test
	 public void validExistingMutantDnaTest() {
		
		assertThat(controller.isMutant(new DnaRequest(DnaCases.getvalidExistingMutantN6Dna())).getStatusCode())
			.isEqualTo(HttpStatus.OK);
	 }
	
	@Test
	 public void validMutantDnaRowTest() {

		assertThat(controller.isMutant(new DnaRequest(DnaCases.getValidMutantN6RowDna())).getStatusCode())
			.isEqualTo(HttpStatus.OK);
	 }
	
	@Test
	 public void validMutantDnaColumnTest() {
		
		assertThat(controller.isMutant(new DnaRequest(DnaCases.getValidMutantN6ColumnDna())).getStatusCode())
			.isEqualTo(HttpStatus.OK);
	 }
	
	@Test
	 public void validMutantDnaDiagonalTest() {
		
		assertThat(controller.isMutant(new DnaRequest(DnaCases.getValidMutantN6DiagonalDna())).getStatusCode())
			.isEqualTo(HttpStatus.OK);
	 }
	
	@Test
	 public void validMutantDnaRowAndDiagonalTest() {
		
		assertThat(controller.isMutant(new DnaRequest(DnaCases.getValidMutantN6RowAndDiagonalDna())).getStatusCode())
			.isEqualTo(HttpStatus.OK);
	 }
	
	@Test
	 public void validMutantDnaRowAndColumnTest() {
		
		assertThat(controller.isMutant(new DnaRequest(DnaCases.getValidMutantN6RowAndColumnDna())).getStatusCode())
			.isEqualTo(HttpStatus.OK);
	 }
	
	@Test
	 public void validMutantDnaColumnAndDiagonalTest() {
		
		assertThat(controller.isMutant(new DnaRequest(DnaCases.getValidMutantN6ColumnAndDiagonalDna())).getStatusCode())
			.isEqualTo(HttpStatus.OK);
	 }
	
	@Test
	 public void validMutantDnaN4RowAndDiagonalTest() {
		
		assertThat(controller.isMutant(new DnaRequest(DnaCases.getValidMutantN4RowAndDiagonalDna())).getStatusCode())
			.isEqualTo(HttpStatus.OK);
	 }
	
	@Test
	 public void validMutantDnaN10RowAndDiagonalTest() {
		
		assertThat(controller.isMutant(new DnaRequest(DnaCases.getValidMutantN10RowDiagonalDna())).getStatusCode())
			.isEqualTo(HttpStatus.OK);
	 }
	
	@Test
	 public void validMutantDnaN10DualRowTest() {
		
		assertThat(controller.isMutant(new DnaRequest(DnaCases.getValidMutantN10DualRowDna())).getStatusCode())
			.isEqualTo(HttpStatus.OK);
	 }
}
