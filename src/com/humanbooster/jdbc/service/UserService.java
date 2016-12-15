package com.humanbooster.jdbc.service;

import com.humanbooster.jdbc.objects.User;

public interface UserService {
	
	public boolean deleteAllEntries();
	public boolean createUser(User u);
	public boolean createUserDirty(User u);
	public User getUser(String login);
	public User getUserDirty(String login);
	public boolean updateUser(String login, String password);
	public boolean updateUserDirty(String login, String password);
	public boolean deleteUser(String login);
	public boolean deleteUserDirty(String login);

}
