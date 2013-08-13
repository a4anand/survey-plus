package com.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.beans.Question;
import com.beans.User;
import com.dao.QuestionSpringJdbcDao;
import com.dao.UserSpringJdbcDao;
import com.form.LoginForm;
import com.form.QuestionForm;
import com.form.SurveyType;

@Controller
public class LoginController {
	@Autowired
	QuestionSpringJdbcDao SpringQuestionJdbcDao;
	
	@Autowired
	UserSpringJdbcDao SpringJdbcDao;
	
	
	
	@RequestMapping(value={"loginform.html"} , method = RequestMethod.GET)
	public String showForm(Map model) {
		LoginForm loginForm = new LoginForm();
		model.put("loginForm", loginForm);
		return "loginform";
	}
	
	@RequestMapping(value={"surveytypecheck.html"} , method = RequestMethod.POST)
	public String processTypeSelection(SurveyType surveyType, BindingResult result,Map model) {
		//surveyType = (SurveyType) model.get("surveyType");
		//model.put("surveyType", surveyType);
		QuestionForm question = new QuestionForm();
		Question que = SpringQuestionJdbcDao.getQuestion(1, "1");
		question.setQuestion(que.getQuestion());
		//System.out.println("questtion  == "+que.getQuestion());
		model.put("questionForm", question);
		
		return "question";
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
				SurveyType surveyType=new SurveyType();
				model.put("surveyType", surveyType);
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
