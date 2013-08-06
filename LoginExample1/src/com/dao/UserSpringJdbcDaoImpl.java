package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.beans.User;
@Repository
public class UserSpringJdbcDaoImpl implements UserSpringJdbcDao {
	
	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void insertUser(User user) {
		String query = "insert into User (user_id,password)"
				+ " VALUES (?,?)";
		jdbcTemplate.update(query,
				new Object[] { user.getUser_id(), user.getPassword()
				 });

	}

	@Override
	public List<User> listUsers() {
		String query = "Select * from Users";
		RowMapper<User> mapper = new RowMapper<User>() {
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User user = new User();
				user.setUser_id(rs.getString("user_id"));
				user.setPassword(rs.getString("password"));
				return (user);
			}
		};
		return (List<User>) jdbcTemplate.query(query, mapper);
	}

	@Override
	public User getUser(Long id) {
		String query = "Select * from User where Userid = ?";
		RowMapper<User> mapper = new RowMapper<User>() {
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User user = new User();
				user.setUser_id(rs.getString("user_id"));
				user.setPassword(rs.getString("password"));
				return (user);
			}
		};

		User user = (User) jdbcTemplate.queryForObject(query,
				new Object[] { id }, mapper);
		return user;
	}

	@Override
	public void updateUser(User user) {
		String query = "update User set user_id = ? , password = ?  where user_id = ?";
		jdbcTemplate.update(query,
				new Object[] { user.getUser_id(), user.getPassword() });
	}

	@Override
	public void deleteUser(Long userId) {
		String query = "delete from User where user_id = ?";
		jdbcTemplate.update(query, new Object[] { userId });
	}
}
