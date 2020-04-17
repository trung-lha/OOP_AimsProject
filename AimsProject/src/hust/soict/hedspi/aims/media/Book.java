package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media{
	private List<String> authors = new ArrayList<String>();
	
	public Book(String title,String category,float cost) {
		super(title,category,cost);
	}
	public Book(int id,String title,String category,float cost) {
		super(title,category,cost);
		this.setId(id);
	}
	public Book(String title,String category,List<String> authors) {
		super(title,category);
		this.authors = authors;
	}
	public Book(String title, String category,float cost, List<String> authors) {
		super(title,category,cost);
		this.authors = authors;
	}
	public void addAuthor(String authorName) {
		if(authors.contains(authorName)) {
			System.out.println("The "+authorName+" is already exists in list");
			System.exit(0);
		}
		else {
			authors.add(authorName);
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
