package com.sgu.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sgu.spring.entity.User;
import com.sgu.spring.service.HomeService;
import com.sgu.spring.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {
	
	@Autowired
	private HomeService homeService;
	
	@Autowired 
	private UserService userService;
	
	@Autowired
	private HttpSession httpSession;
	
	@GetMapping("/")
	public String showHomePage(Model model) {
		model.addAttribute("topTiles", homeService.getTopTilesMap());
		return "/home";
	}
	
	@GetMapping({"/login","/logout"})
	public String showLoginPage() {
		return "login";
	}
	
	@PostMapping("/login")
	public String auth(@RequestParam("username") String username, @RequestParam("password") String password, Model model ) {
		User user = userService.authorize(username, password);
		
		if(user != null) {
			httpSession.setAttribute("loggedInUserName", username);
			return showHomePage(model);
		}
		else {
			return "/login";
		}
	}
	
}
