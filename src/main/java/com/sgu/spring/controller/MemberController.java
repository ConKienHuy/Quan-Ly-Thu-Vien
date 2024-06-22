package com.sgu.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sgu.spring.commonValue.Constants;
import com.sgu.spring.model.Member;
import com.sgu.spring.service.MemberService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/list")
	public String showMemberPage(Model model) {
		// Lấy danh sách member
		List<Member> members = memberService.readAll();
		// Đưa danh sách vào model để hiển thị lên view
		model.addAttribute("members", members);
		// Tìm kiếm /member/list để hiển thị view
		return "member/list";
	}
	
	@GetMapping("/add")
	public String showMemberAddForm(Model model) {
		// ID member == null
		// Người dùng sẽ nhập đầy đủ thông tin trừ ID
		model.addAttribute("member", new Member());
		return "member/form";
	}
	
	@GetMapping("/edit/{id}")
	public String showMemberEditForm(Model model, @PathVariable("id") Long id) {
		Member member = memberService.findByID(id);
		if(member != null){
			// ID member != null
			// Đưa member với thông tin vào chỉnh sửa
			model.addAttribute("member", member);
			return "member/form";
		}
		 else 
			return "redirect:/member/add";
	}
	
	@RequestMapping(value = {"/save"},method = RequestMethod.POST)
	public String saveMember(@Valid Member member, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		if(bindingResult.hasErrors()) {
			return "member/form";
		}
		
		// ID member không tồn tại
		// Người dùng đã nhập đầy đủ thông tin trong form trừ ID
		if(member.getId() == null) {
			memberService.createMember(member);
			redirectAttributes.addFlashAttribute("successMsg", "Thêm Member " +member.getFirstName()+ " thành công!");
			return "redirect:/member/add";
		}
		else {
			memberService.updateMember(member);
			redirectAttributes.addFlashAttribute("successMsg", "Cập nhật Member " +member.getFirstName()+ " thành công!");
			return "redirect:/member/list";
		}
	}
	
	@GetMapping("/remove/{id}")
	public String deleteMember(@PathVariable("id") Long id, Model model) {
		Member member = memberService.findByID(id);
		
		if(member != null) {
			// Có khóa ngoại: Member đang mượn sách
			if(memberService.hasForeignKey(member)) {
				model.addAttribute("memberInUse", true);
				return showMemberPage(model);
			}
			else {
				memberService.deleteMember(member);
			}
		}
		return "redirect:/member/list";
	}
	
	@ModelAttribute("memberTypes")
	public List<String> showMemberTypes(){
		return Constants.MEMBER_TYPES;
	}
}
