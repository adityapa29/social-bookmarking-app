package com.adityapandey.thrillio.entities;

import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;

import com.adityapandey.thillio.constants.BookGenre;
import com.adityapandey.thrillio.partner.Shareable;

public class Book extends Bookmark implements Shareable {
	private int publicationYear;
	private String publishers;
	private String[] authors;
	private String genre;
	private double amazonRating;

	public int getPublicationYear() {
		return publicationYear;
	}

	public void setPublicationYear(int publicationYear) {
		this.publicationYear = publicationYear;
	}

	public String getPublishers() {
		return publishers;
	}

	public void setPublishers(String publishers) {
		this.publishers = publishers;
	}

	public String[] getAuthors() {
		return authors;
	}

	public void setAuthors(String[] authors) {
		this.authors = authors;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public double getAmazonRating() {
		return amazonRating;
	}

	public void setAmazonRating(double amazonRating) {
		this.amazonRating = amazonRating;
	}

	@Override
	public String toString() {
		return "Book [publicationYear=" + publicationYear + ", publishers=" + publishers + ", authors="
				+ Arrays.toString(authors) + ", genre=" + genre + ", amazonRating=" + amazonRating + "]";
	}

	@Override
	public boolean isKidFriendlyEligible() {
		if (genre.equals(BookGenre.PHILOSOPHY) || genre.equals(BookGenre.SELF_HELP)) {
			return false;
		}
		return true;
	}

	@Override
	public String getItemData() {
		StringBuilder builder = new StringBuilder();
		builder.append("<item>");
		builder.append("<type>Book</type>");
		builder.append("<title>").append(getTitle()).append("</title>");
		builder.append("<authors>").append(StringUtils.join(authors, ",")).append("</authors>");
		builder.append("<publishers>").append(publishers).append("</publishers>");
		builder.append("<publicationYear>").append(publicationYear).append("</publicationYear>");
		builder.append("<genre>").append(genre).append("</genre>");
		builder.append("<amazonRating>").append(amazonRating).append("</amazonRating>");
		builder.append("</item>");
		return builder.toString();
	}

}
