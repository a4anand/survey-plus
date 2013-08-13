package com.controllers;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.form.LoginForm;
import com.form.QuestionForm;

@Controller
public class QuestionConroller {
	@RequestMapping(value={"question.html"} , method = RequestMethod.GET)
	public String showQuestionForm(Map model) {
		QuestionForm questionForm = new QuestionForm();
		//model.put("loginForm", loginForm);
		return "loginform";
	}
}
