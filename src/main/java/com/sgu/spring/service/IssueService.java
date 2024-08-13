package com.sgu.spring.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgu.spring.entity.Issue;
import com.sgu.spring.entity.Member;
import com.sgu.spring.repository.IssueRepository;

import com.sgu.spring.commonValue.Constants;

@Service
public class IssueService {
	
	@Autowired
	private IssueRepository issueRepository;
	
	public List<Issue> readAll(){
		return (List<Issue>) issueRepository.findAll();
	}
	
	public Issue createIssue(Issue issue) {
		issue.setIssueDate(new Date());
		issue.setReturned(Constants.BOOK_NOT_RETURNED);
		return issueRepository.save(issue);
	}
	
	public Issue updateIssue(Issue issue) {
		return issueRepository.save(issue);
	}
	
	public void deleteIssue(Issue issue) {
		issueRepository.delete(issue);
	}
	
	public Issue findById(Long id) {
		return issueRepository.findById(id).get();
	}
	
	public List<Issue> finAllUnreturned(){
		return issueRepository.findByReturned(Constants.BOOK_NOT_RETURNED);
	}
	
	public Long countByMember(Member member) {
		return issueRepository.countByMemberAndReturned(member, Constants.BOOK_NOT_RETURNED);
	}
}
