package com.sgu.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sgu.spring.service.HomeService;

@Controller
public class MainController {
	
	@Autowired
	private HomeService homeService;
	
	@GetMapping("/")
	public String showHomePage(Model model) {
		model.addAttribute("topTiles", homeService.getTopTilesMap());
		return "/home";
	}
}
