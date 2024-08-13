package com.sgu.spring.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgu.spring.commonValue.Constants;
import com.sgu.spring.entity.Member;
import com.sgu.spring.repository.MemberRepository;

@Service
public class MemberService {
	
	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	private IssueService issueService;
	
	// *** CRUD - Create Read Update Delete - ****//
	
	public List<Member> readAll(){
		return (List<Member>) memberRepository.findAllByOrderByFirstNameAscMiddleNameAscLastNameAsc();
	}
	
	public Member createMember(Member member) {
		member.setJoiningDate(new Date());
		return memberRepository.save(member);
	}
	
	public Member updateMember(Member member) {
		return memberRepository.save(member);
	}
	
	public void deleteMember(Member member) {
		memberRepository.delete(member);
	}
	
	public Member findByID(Long id) {
		return memberRepository.findById(id).get();
	}
	
	//  Kiểm tra khóa ngoại
	public boolean hasForeignKey(Member member) {
		return issueService.countByMember(member) > 0;
	}

	public Long getTotalCount() {
		return memberRepository.count();
	}

	public Long getStudentsCount() {
		return memberRepository.countByType(Constants.MEMBER_STUDENT);
	}

	public Long getParentsCount() {
		return memberRepository.countByType(Constants.MEMBER_PARENT);
	}
}
