package com.sgu.spring.service;

import java.util.HashMap;
import java.util.Map;

import com.sgu.spring.service.bookservice.BookService;
import com.sgu.spring.service.categoryservice.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomeService {
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private CategoryServiceImpl categoryServiceImpl;
	
	@Autowired
	private BookService bookService;
	
	public Map<String, Long> getTopTilesMap() {
		Map<String, Long> map = new HashMap<String, Long>();
		map.put("totalMembers", memberService.getTotalCount());
		map.put("totalStudents", memberService.getStudentsCount());
		map.put("totalParents", memberService.getParentsCount());
		map.put("totalCategories", categoryServiceImpl.getTotalCount());
		map.put("totalBooks", bookService.getTotalCount());
		map.put("totalIssuedBooks", bookService.getTotalIssuedBooks());
		return map;
	}
}
