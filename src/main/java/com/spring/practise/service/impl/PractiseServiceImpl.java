package com.spring.practise.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.practise.repository.PractiseRepository;
import com.spring.practise.service.PractiseService;

@Service
public class PractiseServiceImpl implements PractiseService{
	
	@Autowired
	PractiseRepository practiseRepository;
	
	public String getUserNameForId(int id) {
		return practiseRepository.getUserNameForId(id);
	}

}
