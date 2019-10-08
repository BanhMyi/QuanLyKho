package com.quanlykho.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("/")
	public String home() {
		 return "/home";
	}

//	@GetMapping("/login")
//	public String login(Model mode) {
//
//		return "loginPage.html";
//	}

    @GetMapping("/403")
    public String error403() {
        return "/error/403";
    }
}
