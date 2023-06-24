package com.spring.practise.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.POST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.practise.model.UserData;
import com.spring.practise.service.PractiseService;

@Controller
public class PractiseController {
	
	@Autowired
	PractiseService practiseService;
	
	@RequestMapping("/")
	public String invokeMainPage() {
		return "main";
	}
	
	@RequestMapping("/fromController")
	public ModelAndView fetDataFromController() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("welcome");
		List<String> model = Arrays.asList("abc", "def", "ghi");
		mv.addObject("data", model);
		return mv;
	}
	
	@POST
	@RequestMapping("/fromUI")
	public ModelAndView fromUIPage(UserData userData) {
		System.out.println(userData.getUsername());
		System.out.println(userData.getPassword());
		ModelAndView mv = new ModelAndView();
		String user = practiseService.getUserNameForId(userData.getId());
		if(userData.getPassword().equals("Password")) {
			mv.setViewName("success");
			mv.addObject("authentication", "Success");
		}else {
			mv.setViewName("failure");
			mv.addObject("authentication", "Failure");
		}
		mv.addObject("userName", "Dilipan");
		mv.addObject("name", user);
		
		return mv;
	}

}
