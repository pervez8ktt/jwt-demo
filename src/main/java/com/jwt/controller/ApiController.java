package com.jwt.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
@Secured(value="ROLE_USER")
public class ApiController {

	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(){
		return "into login";
	}
	
	@RequestMapping(value="/secured", method=RequestMethod.GET)
	public String secured(){
		return "into secured";
	}
	
}
