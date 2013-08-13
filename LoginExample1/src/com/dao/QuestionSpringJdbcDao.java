package com.dao;

import com.beans.Question;

public interface QuestionSpringJdbcDao {
   public Question getQuestion(int que_Id,String surveyType);
}
