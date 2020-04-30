package hust.soict.hedspi.aims.media.disc;

import java.util.ArrayList;
import java.util.List;

import hust.soict.hedspi.aims.media.Media;

public class Book extends Media{
	private List<String> authors = new ArrayList<String>();
	
	public Book(String title,String category,float cost) {
		super(title,category,cost);
	}
	public Book(int id,String title,String category,float cost) {
		super(title,category,cost);
		this.id = id;
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
	public void play() {
		System.out.println("Book title: " + this.getTitle());
		System.out.println("Book cost: "+ this.getCost());
//		System.out.println("--------------------------------");
	}
	// sap xep theo title cua Book
	public int compareTo(Media obj) {
		if((obj instanceof DigitalVideoDisc) || (obj instanceof CompactDisc))
			return -1;
		else {
			if(this.title.compareTo(((Book)obj).getTitle()) > 0)
					return 1;
			else if(this.title.compareTo(((Book)obj).getTitle()) < 0)
					return -1;
			else return 0;
		}
	}

}
