package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.beans.Question;
@Repository
public class QuestionSpringJdbcDaoImpl  implements QuestionSpringJdbcDao{
	private JdbcTemplate jdbcTemplate;
	 @Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	@Override
	public Question getQuestion(int que_Id, String surveyType) {
		//que_Id =1;
		// TODO Auto-generated method stub
		String tableName ="que_education";
		String query = "Select * from "+tableName+" where que_id = ?";
		RowMapper<Question> mapper = new RowMapper<Question>() {
			public Question mapRow(ResultSet rs, int rowNum) throws SQLException {
				Question que = new Question();
				que.setQue_id(rs.getInt("que_id"));
				que.setQuestion(rs.getString("question"));
				que.setOpt1(rs.getString("opt1"));
				que.setOpt2(rs.getString("opt2"));
				que.setOpt3(rs.getString("opt3"));
				que.setOpt4(rs.getString("opt4"));
				return (que);
			}
		};

		Question que = (Question) jdbcTemplate.queryForObject(query,
				new Object[] { 1 }, mapper);
		return que;
	}
   
}
