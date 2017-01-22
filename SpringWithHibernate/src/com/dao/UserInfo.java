package com.dao;

import com.model.User;

public interface UserInfo {
	
	void save(User user);
	void checkUser(User user);

}
