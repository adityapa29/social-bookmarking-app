package com.adityapandey.thrillio.dao;

import com.adityapandey.thrillio.DataStore;
import com.adityapandey.thrillio.entities.User;

public class UserDao {

	public User[] getUsers() {
		return DataStore.getUsers();
	}

}
