package com.slyak.activation.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.slyak.activation.service.ActivationService;

@Controller
public class AdminController {

	@Autowired
	private ActivationService activationService;
	
	@RequestMapping("/admin")
	public String index(){
		return "admin.index";
	}
	
}
