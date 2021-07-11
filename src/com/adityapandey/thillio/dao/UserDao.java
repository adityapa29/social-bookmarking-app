package com.adityapandey.thillio.dao;

import com.adityapandey.thillio.DataStore;
import com.adityapandey.thrillio.entities.User;

public class UserDao {

	public User[] getUsers() {
		return DataStore.getUsers();
	}

}
