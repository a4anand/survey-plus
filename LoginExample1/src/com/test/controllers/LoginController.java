package com.test.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import beans.User;

import com.test.form.LoginForm;

import dao.UserSpringJdbcDao;

@Controller
public class LoginController {
	
	@Autowired
	UserSpringJdbcDao SpringJdbcDao;

	@RequestMapping(value={"loginform.html"} , method = RequestMethod.GET)
	public String showForm(Map model) {
		LoginForm loginForm = new LoginForm();
		model.put("loginForm", loginForm);
		return "loginform";
	}
	
	@RequestMapping(value={"logincheck.html"}, method = RequestMethod.POST)
	public String processForm( LoginForm loginForm, BindingResult result,
			Map model) {
		if (result.hasErrors()) {
			return "loginform";

		}
		loginForm = (LoginForm) model.get("loginForm");
		List<User> listOfUsers = SpringJdbcDao.listUsers();  
		for (User user : listOfUsers) {
			if(user.getUser_id().equals(loginForm.getUserName()) && user.getPassword().equals(loginForm.getPassword())){
				model.put("loginForm", loginForm);
				return "loginsuccess";
			}
		}
		return "loginerror";
//		if (!loginForm.getUserName().equals(userName)
//				|| !loginForm.getPassword().equals(password)) {
//			return "loginerror";
//		}
//		model.put("loginForm", loginForm);
//		return "loginsuccess";
	}
	
}
