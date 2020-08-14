package com.meli.exam.be.application;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.meli.exam.be.domain.services.IMutantService;

@RestController
@RequestMapping("/mutant")
public class MutantsController {

	@Autowired
	IMutantService mutantService;
	
	@RequestMapping("/")
	HttpStatus isMutant(String[] dna) {
		
		if(mutantService.isMutant(dna))
			return HttpStatus.OK;
		
		return HttpStatus.FORBIDDEN;
		
	}
}
