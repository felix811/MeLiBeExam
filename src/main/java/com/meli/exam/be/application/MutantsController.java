package com.meli.exam.be.application;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.meli.exam.be.domain.services.IDnaService;

@RestController
@RequestMapping("/mutant")
public class MutantsController {

	@Autowired
	IDnaService mutantService;
	
	@RequestMapping("/")
	@PostMapping
	@JsonProperty("dna")
	public
	HttpStatus isMutant(@RequestBody DnaRequest dna) {
		
		if(mutantService.isMutant(dna.getDna()))
			return HttpStatus.OK;
//		else {
//			throw new ResponseStatusException(
//					  HttpStatus.FORBIDDEN
//					);
	    //}
		return HttpStatus.FORBIDDEN;
		
	}
}
