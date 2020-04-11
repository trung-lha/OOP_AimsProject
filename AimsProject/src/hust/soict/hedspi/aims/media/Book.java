package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Book extends Media{
	private List<String> authors = new ArrayList<String>();
	public Book() {
		authors = null;
	}
	public Book(String[] listAuthors) {
		authors = Arrays.asList(listAuthors);
	}
	public void addAuthor(String authorName) {
		if(authors.contains(authorName)) {
			System.out.println("The "+authorName+" is already exists in list");
			System.exit(0);
		}
		else {
			authors.add(authorName);
			System.out.println("The author has added");
		}
	}
	
	public void removeAuthor(String authorName) {
		if(authors.contains(authorName)) {
			System.out.println("The "+authorName+" is not already exists in List");
			System.exit(0);
		}
		else {
			authors.remove(authorName);
			System.out.println("The Author has removed");
		}
	} 

}
