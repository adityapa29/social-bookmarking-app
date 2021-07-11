package com.adityapandey.thillio.dao;

import com.adityapandey.thillio.DataStore;
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
