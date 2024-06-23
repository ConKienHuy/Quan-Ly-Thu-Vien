package com.sgu.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sgu.spring.commonValue.Constants;
import com.sgu.spring.model.Book;
import com.sgu.spring.model.Category;
import com.sgu.spring.model.Issue;
import com.sgu.spring.service.BookService;
import com.sgu.spring.service.CategoryService;
import com.sgu.spring.service.IssueService;

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
	private CategoryService categoryService;
	
	@Autowired
	private BookService bookService;
	
	@ModelAttribute(name = "memberTypes")
	public List<String> memberTypes() {
		return Constants.MEMBER_TYPES;
	}
	
	@ModelAttribute(name = "categories")
	public List<Category> getCategories() {
		return categoryService.getAllBySort();
	}
	
	@ModelAttribute(name = "books")
	public List<Book> getBooksFromCategory(){
		return bookService.getByCategory(null);
	}
}
