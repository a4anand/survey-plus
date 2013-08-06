package com.dao;

import java.util.List;

import com.beans.User;

public interface UserSpringJdbcDao {
	public void insertUser(User user);

	public List<User> listUsers();

	public User getUser(Long id);

	public void updateUser(User user);

	public void deleteUser(Long userId);
	
	
}
