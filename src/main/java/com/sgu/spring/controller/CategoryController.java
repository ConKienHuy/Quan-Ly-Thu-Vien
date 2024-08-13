package com.sgu.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sgu.spring.entity.Category;
import com.sgu.spring.service.CategoryService;

import jakarta.validation.Valid;



@Controller
@RequestMapping(value = "/category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping(value={"","/list"})
	public String showCategoryPage(Model model) {
		// Lấy List category
		List<Category> categories = categoryService.getAllBySort();
		// Model chứa List để hiển thị lên view
		model.addAttribute("categories", categories);
		// Tìm kiếm trong templates/category/list và trả về view	 
		return "/category/list"; 				
	}
	
	@GetMapping("/add")
	public String showCategoryForm(Model model) {
		// Tạo một Object category mới để mà nhận dữ liệu nhập vào
		// ID category == null
		model.addAttribute("category", new Category());
		// Hiển thị view form
		return "/category/form";
		/**	Form này có 2 chức năng
		 *	Chức năng 1: Kiểm tra id == null thì sẽ thêm mới Category
		 *	Chức năng 2: Kiểm tra id != null thì sẽ cập nhật Category 		
		**/ 
	}
	
	@GetMapping("/edit/{id}")
	public String editCategory(@PathVariable("id") Long id, Model model) {
		Category category = categoryService.get(id);
		if(category != null){
			// ID category != null
			// Đưa category vào model, model đưa category lên view
			model.addAttribute("category", category);
			return "category/form";
		}
		 else 
			return "redirect:/category/add"; 
	}
	
	@PostMapping("/save")	
	public String saveCategory(@Valid Category category, BindingResult bindingResult, final RedirectAttributes redirectAttributes) {
		if(bindingResult.hasErrors()) {
			return "/category/form";
		}
		
		// Nếu id rỗng thì ta sẽ thêm Category mới 
		if(category.getId() == null) {
			categoryService.addNew(category);
			redirectAttributes.addFlashAttribute("sucessMsg", "Đã thêm category " +category.getName()+ " thành công!");
			return "redirect:/category/add"; // Tiếp tục thêm mới
		}
		
		//Nếu id tồn tại thì ta sẽ cập nhật thông tin Category
		else {
			categoryService.save(category);
			redirectAttributes.addFlashAttribute("successMsg", "Cập nhật thông tin " +category.getName()+ " thành công!");
			return "redirect:/category/list"; // Trở về danh sách
		}
	}
	
	@GetMapping("/remove/{id}")
	public String deleteCategory(@PathVariable("id") Long id, Model model) {
		// Lấy Category theo ID
		Category category = categoryService.get(id);
		// Kiểm tra khóa ngoại
		if(category != null) {
			if(categoryService.hasForeignkey(category) == true) {
				model.addAttribute("categoryInUse", true);
				return showCategoryPage(model);
			}
			 else categoryService.delete(category);
		}
		
		return "redirect:/category/list";
	}
}
	
