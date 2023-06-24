package com.spring.practise.repository.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.spring.practise.repository.PractiseRepository;

@Repository
public class PractiseRepositoryImpl implements PractiseRepository{
	
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	public String getUserNameForId(int id) {
		String userName = null;
		String query = "SELECT * FROM account_auth where id = :id";
		Map<String, Integer> data = new HashMap<>();
		data.put("id", id);
		List<Map<String, Object>> output = namedParameterJdbcTemplate.queryForList(query, data);
		if(!output.isEmpty()) {
			userName = output.get(0).get("username").toString();
			System.out.println(userName);
		}
		return userName;
	}

}
