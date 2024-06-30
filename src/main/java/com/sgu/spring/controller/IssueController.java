package com.sgu.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sgu.spring.model.Book;
import com.sgu.spring.model.Issue;
import com.sgu.spring.model.Member;
import com.sgu.spring.service.BookService;
import com.sgu.spring.service.IssueService;
import com.sgu.spring.service.MemberService;

@Controller
@RequestMapping("/issue")
public class IssueController {
	
	@Autowired
	private IssueService issueService;
	
	@GetMapping("/list")
	public String showIssuePage(Model model) {
		List<Issue> issues = issueService.finAllUnreturned();
		model.addAttribute("isuses", issues  );
		return "/issue/list";
	}
	
	@GetMapping("/new")
	public String showIssueForm(Model model) {
		return "issue/form";
	}
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private BookService bookService;
	
	@ModelAttribute(name = "members")
	public List<Member> memberTypes() {
		return memberService.readAll();
	}
	
	@ModelAttribute(name = "books")
	public List<Book> getBooksFromCategory(Model model){
		return bookService.getAll();
	}
}
