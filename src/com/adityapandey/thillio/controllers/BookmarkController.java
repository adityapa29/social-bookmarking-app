package com.adityapandey.thillio.controllers;

import com.adityapandey.thillio.manager.BookmarkManager;
import com.adityapandey.thrillio.entities.Bookmark;
import com.adityapandey.thrillio.entities.User;

public class BookmarkController {
	private static BookmarkController instance = new BookmarkController();

	private BookmarkController() {
	}

	public static BookmarkController getInstace() {
		return instance;
	}

	public void saveUserBookmark(User user, Bookmark bookmark) {
		BookmarkManager.getInstance().saveUserBookmark(user,bookmark);
		
	}

	public void setKidFriendlyStatus(User user, String kidFriendlyStatus, Bookmark bookmark) {
		BookmarkManager.getInstance().setKidFriendlyStatus(user,kidFriendlyStatus,bookmark);
		
	}

	public void share(User user, Bookmark bookmark) {
		BookmarkManager.getInstance().share(user,bookmark);
		
	}
}
