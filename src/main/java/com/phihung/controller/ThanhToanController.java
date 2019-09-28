package com.phihung.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ThanhToanController {

	@RequestMapping(value="/payment")
	public String Default() {
		return "payment";
		
	}
}
