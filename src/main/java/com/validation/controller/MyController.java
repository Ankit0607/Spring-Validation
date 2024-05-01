package com.validation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.validation.entities.LoginData;

import jakarta.validation.Valid;

@Controller
public class MyController {

	@GetMapping("/form")
	public String openForm(Model model) {
		model.addAttribute("LoginData", new LoginData());
		return "form";
	}

	@PostMapping("/process")
	public String processForm(@Valid @ModelAttribute("LoginData") LoginData LoginData, BindingResult res) {

		if (res.hasErrors()) {
			System.out.println(res);
			return "form";
		}
		System.out.println(LoginData);
		
		return "success";
	}
}
