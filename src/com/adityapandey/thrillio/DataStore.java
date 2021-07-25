package com.adityapandey.thrillio;

import com.adityapandey.thrillio.constants.BookGenre;
import com.adityapandey.thrillio.constants.Gender;
import com.adityapandey.thrillio.constants.MovieGenre;
import com.adityapandey.thrillio.constants.UserType;
import com.adityapandey.thrillio.entities.Bookmark;
import com.adityapandey.thrillio.entities.User;
import com.adityapandey.thrillio.entities.UserBookmark;
import com.adityapandey.thrillio.manager.BookmarkManager;
import com.adityapandey.thrillio.manager.UserManager;
import com.adityapandey.thrillio.util.IOUtil;

public class DataStore {
	public static final int USER_BOOKMARK_LIMIT = 5;
	public static final int BOOKMARK_COUNT_PER_TYPE = 5;
	public static final int BOOKMARK_TYPES_COUNT = 3;
	public static final int TOTAL_USER_COUNT = 5;

	private static User[] users = new User[TOTAL_USER_COUNT];
	private static Bookmark[][] bookmarks = new Bookmark[BOOKMARK_TYPES_COUNT][BOOKMARK_COUNT_PER_TYPE];
	private static UserBookmark[] userBookmarks = new UserBookmark[TOTAL_USER_COUNT * USER_BOOKMARK_LIMIT];
	private static int bookmarkIndex;

	public static User[] getUsers() {
		return users;
	}

	public static Bookmark[][] getBookmarks() {
		return bookmarks;
	}

	public static void loadData() {
		loadUsers();
		loadWebLinks();
		loadMovies();
		loadBooks();
	}

	private static void loadUsers() {
		String[] data = new String[TOTAL_USER_COUNT];
		IOUtil.read(data, "User");
		int rowNum = 0;
		for (String row : data) {
			String[] values = row.split("\t");

			int gender = Gender.MALE;
			if (values[5].equals("f")) {
				gender = Gender.FEMALE;
			} else if (values[5].equals("t")) {
				gender = Gender.TRANSGENDER;
			}

			users[rowNum++] = UserManager.getInstance().createUser(Long.parseLong(values[0]), values[1], values[2],
					values[3], values[4], gender, values[6]);
		}
	}

	private static void loadWebLinks() {
		String[] data = new String[BOOKMARK_COUNT_PER_TYPE];
    	IOUtil.read(data, "WebLink");
    	int colNum = 0;
    	for (String row : data) {
    		String[] values = row.split("\t");
    		bookmarks[0][colNum++] = BookmarkManager.getInstance().createWebLink(Long.parseLong(values[0]), values[1],"",values[2], values[3]);
    	}

	}

	private static void loadMovies() {
		String[] data = new String[BOOKMARK_COUNT_PER_TYPE];
    	IOUtil.read(data, "Movie");
    	int colNum = 0;
    	for (String row : data) {
    		String[] values = row.split("\t");
    		String[] cast = values[3].split(",");
    		String[] directors = values[4].split(",");
    		bookmarks[1][colNum++] = BookmarkManager.getInstance().createMovie(Long.parseLong(values[0]), values[1], "", Integer.parseInt(values[2]), cast, directors, values[5], Double.parseDouble(values[6]));
    	}
	}

	private static void loadBooks() {
		String[] data = new String[BOOKMARK_COUNT_PER_TYPE];
    	IOUtil.read(data, "Book");
    	int colNum = 0;
    	for (String row : data) {
    		String[] values = row.split("\t");
    		String[] authors = values[4].split(",");
    		bookmarks[2][colNum++] = BookmarkManager.getInstance().createBook(Long.parseLong(values[0]), values[1],"", Integer.parseInt(values[2]), values[3], authors, values[5], Double.parseDouble(values[6]));
    	}

	}

	public static void add(UserBookmark userBookmark) {
		userBookmarks[bookmarkIndex] = userBookmark;
		bookmarkIndex++;
	}

}