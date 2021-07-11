package com.adityapandey.thillio;

import com.adityapandey.thillio.constants.KidFriendlyStatus;
import com.adityapandey.thillio.constants.UserType;
import com.adityapandey.thillio.controllers.BookmarkController;
import com.adityapandey.thrillio.entities.Bookmark;
import com.adityapandey.thrillio.entities.User;
import com.adityapandey.thrillio.partner.Shareable;

public class View {

	public static void browse(User user, Bookmark[][] bookmarks) {
		System.out.println("\n" + user.getEmail() + " is browsing items..");
		int bookmarkCount = 0;

		for (Bookmark[] bookmarkList : bookmarks) {
			for (Bookmark bookmark : bookmarkList) {
				if (bookmarkCount < DataStore.USER_BOOKMARK_LIMIT) {
					boolean isBookmarked = getBookmarkDecision(bookmark);
					if (isBookmarked) {
						bookmarkCount++;

						BookmarkController.getInstace().saveUserBookmark(user, bookmark);
						System.out.println("New item bookmarked -- " + bookmark);
					}
				}
				if (user.getUserType().equals(UserType.EDITOR) || user.getUserType().equals(UserType.CHIEF_EDITOR)) {
					// Mark kid friendly status
					if (bookmark.isKidFriendlyEligible()
							&& bookmark.getKidFriendlyStatus().equals(KidFriendlyStatus.UNKNOWN)) {
						String kidFriendlyStatus = getKidFriendlyStatusDecision(bookmark);
						if (!kidFriendlyStatus.equals(KidFriendlyStatus.UNKNOWN)) {
							BookmarkController.getInstace().setKidFriendlyStatus(user, kidFriendlyStatus, bookmark);
						}
					}

					// Sharing
					if (bookmark.getKidFriendlyStatus().equals(KidFriendlyStatus.APPROVED)
							&& bookmark instanceof Shareable) {
						boolean isShared = getShareDecision();
						if(isShared) {
							BookmarkController.getInstace().share(user, bookmark);
						}
					}
				}
			}
		}

	}
	
	//TODO: Below methods simulate user input.

	private static String getKidFriendlyStatusDecision(Bookmark bookmark) {
		return Math.random() < 0.4 ? KidFriendlyStatus.APPROVED
				: (Math.random() >= 0.5 && Math.random() < 0.8) ? KidFriendlyStatus.REJECTED
						: KidFriendlyStatus.UNKNOWN;
	}

	private static boolean getBookmarkDecision(Bookmark bookmark) {
		return Math.random() < 0.5 ? true : false;
	}

	private static boolean getShareDecision() {
		return Math.random() < 0.5 ? true : false;
	}
}
