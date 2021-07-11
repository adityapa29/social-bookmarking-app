package com.adityapandey.thrillio.entities;

import static org.junit.Assert.assertFalse;

import org.junit.jupiter.api.Test;

import com.adityapandey.thillio.constants.BookGenre;
import com.adityapandey.thillio.manager.BookmarkManager;

class BookTest {

	@Test
	void testIsKidFriendlyEligible() {
		// Test1
		Book book = BookmarkManager.getInstance().createBook(4000, "Walden", "", 1854, "Wilder Publications",
				new String[] { "Henry David Thoreau" }, BookGenre.PHILOSOPHY, 4.3);

		boolean isKidFriendlyEligible = book.isKidFriendlyEligible();

		assertFalse("For Book Genre Philosophy - isKidFriendlyEligible() should return false", isKidFriendlyEligible);

		// Test2
		book = BookmarkManager.getInstance().createBook(4000, "Walden", "", 1854, "Wilder Publications",
				new String[] { "Henry David Thoreau" }, BookGenre.SELF_HELP, 4.3);

		isKidFriendlyEligible = book.isKidFriendlyEligible();

		assertFalse("For Book Genre Self help - isKidFriendlyEligible() should return false", isKidFriendlyEligible);
	}

}
