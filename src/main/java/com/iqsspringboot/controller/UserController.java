package com.iqsspringboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@GetMapping("/rajat")
	public String demo(){		
		return "asd";
	}
}