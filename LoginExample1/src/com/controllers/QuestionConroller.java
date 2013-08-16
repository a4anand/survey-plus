package com.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.beans.Question;
import com.dao.QuestionSpringJdbcDao;
import com.form.LoginForm;
import com.form.QuestionForm;
 
@Controller
public class QuestionConroller {
	@Autowired
	QuestionSpringJdbcDao SpringQuestionJdbcDao;
	
	@RequestMapping(value={"redirect.html","question.html"} , method = RequestMethod.POST)
	public String showQuestionForm(Map model) {
		QuestionForm question = new QuestionForm();
		Question que = SpringQuestionJdbcDao.getQuestion(1, "1");
		question.setQuestion(que.getQuestion());
		question.setOpt1(que.getOpt1());
		question.setOpt2(que.getOpt2());
		question.setOpt3(que.getOpt3());
		question.setOpt4(que.getOpt4());
		model.put("questionForm", question);
		return "question";
	}

}
