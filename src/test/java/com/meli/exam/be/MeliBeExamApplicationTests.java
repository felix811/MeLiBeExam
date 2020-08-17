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
		
		HttpStatus ret = controller.isMutant(new DnaRequest(DnaCases.getInvalidN6Dna()));
		
		assertThat(ret).isEqualTo(HttpStatus.FORBIDDEN);
	 }
	
	@Test
	public void invalidN3DnaTest() {
		HttpStatus ret = controller.isMutant(new DnaRequest(DnaCases.getInvalidN3Dna()));
		
		assertThat(ret).isEqualTo(HttpStatus.FORBIDDEN);
	}
	
	@Test
	public void invalid4x6DnaTest() {
		HttpStatus ret = controller.isMutant(new DnaRequest(DnaCases.getInvalid4x6Dna()));
		
		assertThat(ret).isEqualTo(HttpStatus.FORBIDDEN);
		
	}
	
	@Test
	public void invalidNotSquareDnaTest() {
		HttpStatus ret = controller.isMutant(new DnaRequest(DnaCases.getInvalidNotSquareDna()));
		
		assertThat(ret).isEqualTo(HttpStatus.FORBIDDEN);
		
	}
	
	@Test
	 public void validHumanDnaTest() {
		
		HttpStatus ret = controller.isMutant(new DnaRequest(DnaCases.getValidHumanN6Dna()));
		
		assertThat(ret).isEqualTo(HttpStatus.FORBIDDEN);
	 }
	
	//ValidMutant Dna
	@Test
	 public void validExistingMutantDnaTest() {
		
		HttpStatus ret = controller.isMutant(new DnaRequest(DnaCases.getvalidExistingMutantN6Dna()));
		
		assertThat(ret).isEqualTo(HttpStatus.OK);
	 }
	
	@Test
	 public void validMutantDnaRowTest() {
		
		HttpStatus ret = controller.isMutant(new DnaRequest(DnaCases.getValidMutantN6RowDna()));
		
		assertThat(ret).isEqualTo(HttpStatus.OK);
	 }
	
	@Test
	 public void validMutantDnaColumnTest() {
		
		HttpStatus ret = controller.isMutant(new DnaRequest(DnaCases.getValidMutantN6ColumnDna()));
		
		assertThat(ret).isEqualTo(HttpStatus.OK);
	 }
	
	@Test
	 public void validMutantDnaDiagonalTest() {
		
		HttpStatus ret = controller.isMutant(new DnaRequest(DnaCases.getValidMutantN6DiagonalDna()));
		
		assertThat(ret).isEqualTo(HttpStatus.OK);
	 }
	
	@Test
	 public void validMutantDnaRowAndDiagonalTest() {
		
		HttpStatus ret = controller.isMutant(new DnaRequest(DnaCases.getValidMutantN6RowAndDiagonalDna()));
		
		assertThat(ret).isEqualTo(HttpStatus.OK);
	 }
	
	@Test
	 public void validMutantDnaRowAndColumnTest() {
		
		HttpStatus ret = controller.isMutant(new DnaRequest(DnaCases.getValidMutantN6RowAndColumnDna()));
		
		assertThat(ret).isEqualTo(HttpStatus.OK);
	 }
	
	@Test
	 public void validMutantDnaColumnAndDiagonalTest() {
		
		HttpStatus ret = controller.isMutant(new DnaRequest(DnaCases.getValidMutantN6ColumnAndDiagonalDna()));
		
		assertThat(ret).isEqualTo(HttpStatus.OK);
	 }
	
	@Test
	 public void validMutantDnaN4RowAndDiagonalTest() {
		
		HttpStatus ret = controller.isMutant(new DnaRequest(DnaCases.getValidMutantN4RowAndDiagonalDna()));
		
		assertThat(ret).isEqualTo(HttpStatus.OK);
	 }
	
	@Test
	 public void validMutantDnaN10RowAndDiagonalTest() {
		
		HttpStatus ret = controller.isMutant(new DnaRequest(DnaCases.getValidMutantN10RowDiagonalDna()));
		
		assertThat(ret).isEqualTo(HttpStatus.OK);
	 }
	
	@Test
	 public void validMutantDnaN10DualRowTest() {
		
		HttpStatus ret = controller.isMutant(new DnaRequest(DnaCases.getValidMutantN10DualRowDna()));
		
		assertThat(ret).isEqualTo(HttpStatus.OK);
	 }
}
