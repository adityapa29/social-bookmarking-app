package com.adityapandey.thrillio.entities;

import static org.junit.Assert.assertFalse;

import org.junit.jupiter.api.Test;

import com.adityapandey.thillio.constants.MovieGenre;
import com.adityapandey.thillio.manager.BookmarkManager;

class MovieTest {

	@Test
	public void testIsKidFriendlyEligible() {
		// Test1
		Movie movie = BookmarkManager.getInstance().createMovie(3000, "Citizen Kane", "", 1941,
				new String[] { "Orson Welles", "Joseph Cotten" }, new String[] { "Orson Welles" }, MovieGenre.HORROR,
				8.5);

		boolean isKidFriendlyEligible = movie.isKidFriendlyEligible();

		assertFalse("For Horror in Genre - isKidFriendlyEligible() should return false", isKidFriendlyEligible);

		// Test2
		movie = BookmarkManager.getInstance().createMovie(3000, "Citizen Kane", "", 1941,
				new String[] { "Orson Welles", "Joseph Cotten" }, new String[] { "Orson Welles" }, MovieGenre.THRILLERS,
				8.5);

		isKidFriendlyEligible = movie.isKidFriendlyEligible();

		assertFalse("For Thrillers in Genre - isKidFriendlyEligible() should return false", isKidFriendlyEligible);
	}

}
