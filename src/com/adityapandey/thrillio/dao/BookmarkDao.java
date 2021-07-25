package com.adityapandey.thrillio.dao;

import com.adityapandey.thrillio.DataStore;
import com.adityapandey.thrillio.entities.Bookmark;
import com.adityapandey.thrillio.entities.UserBookmark;

public class BookmarkDao {
	
	public Bookmark[][] getBookmarks() {
		return DataStore.getBookmarks();
	}

	public void saveUserBookmark(UserBookmark userBookmark) {
		DataStore.add(userBookmark);
		
	}
	
}
