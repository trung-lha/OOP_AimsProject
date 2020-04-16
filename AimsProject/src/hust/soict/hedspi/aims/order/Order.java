package hust.soict.hedspi.aims.order;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;

public class Order {
	private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
	private static int nbOrders = 0;
	public static final int MAX_LIMITED_ORDERS= 3;
	int luckyNumber = -1;
	private String format_date;
	public void setDateOrdered() {
		LocalDateTime myDateObj = LocalDateTime.now();
	    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

	    this.format_date = myDateObj.format(myFormatObj);
	}
	public String getDateOrdered() {
		return this.format_date;
	}
	private Order(int n) {
		this.nbOrders += n;
		this.setDateOrdered();
	}
	public Order() {
		this(1);
		if(nbOrders > MAX_LIMITED_ORDERS) {
			System.out.println("Order was full");
			return;
		}
	}
	public void addMedia(DigitalVideoDisc[] disc) {
//		itemsOrdered = Arrays.asList(disc);
		for(int i=0; i < disc.length ; i++) {
			itemsOrdered.add(disc[i]);
		}
		System.out.println("The disc list has been added");
	}
	public void addMedia(Book[] book) {
		for(int i=0; i < book.length ; i++) {
			itemsOrdered.add(book[i]);
		}
		System.out.println("The book list has been added");
	}
	public void removeMedia(DigitalVideoDisc disc) {
		if(!itemsOrdered.contains(disc)) {
			System.out.println("The disc name "+disc.getTitle()+" is not exist");
			return;
		}
		else {
			itemsOrdered.remove(disc);
			System.out.println("The disc name "+disc.getTitle()+" has removed");
		}
	}
	public void removeMedia(int id) {
		int check_exist = 0;
		int target = 0;
		for(Media media: itemsOrdered) {
			if(media.getId() == id) {
				check_exist = 1;
				break;
			}
			target++;
		}
		if(check_exist == 0) {
			System.out.println("Id of item is not exist");
			return;
		}
		else {
			itemsOrdered.remove(target);
			System.out.printf("The item has id %d has been Deleted\n",id);
		}
	}
	public void removeMedia(Book book) {
		if(!itemsOrdered.contains(book)) {
			System.out.println("The book name "+book.getTitle()+" is not exist");
			return;
		}
		else {
			itemsOrdered.remove(book);
			System.out.println("The book name "+book.getTitle()+" has removed");
		}
	}
	public float totalCost(){
		int i;
		float total = 0,cost;
		for(i = 0; i< itemsOrdered.size();i++) {
			cost = itemsOrdered.get(i).getCost();
			total = total+cost;
		}
		if(luckyNumber != -1) {
			return total - itemsOrdered.get(luckyNumber).getCost();
		}
		else {
			return total;
		}
	}
	public void printOrdered() {
		float total=0;
		if(nbOrders == 0) {
			System.out.println("itemsOrder is empty");
			return;
		}
		else {
		System.out.println("******************** ORDER *********************");
		System.out.printf("Date: %s\nOrder Items:\n", this.getDateOrdered());
		for (int i=0;i<itemsOrdered.size();i++) {
			System.out.printf("%d. %s-%s-%.2f\n",itemsOrdered.get(i).getId(),itemsOrdered.get(i).getTitle(),
					itemsOrdered.get(i).getCategory(),itemsOrdered.get(i).getCost());
		}
		if(luckyNumber != -1) {
			System.out.printf("The title of disk free is: %d.%s\n",
					luckyNumber+1,itemsOrdered.get(luckyNumber).getTitle());
		}
		else {
			System.out.println("Lucky Number has not been selected");
		}
		total = this.totalCost();
		System.out.printf("Total cost: %.2f\n",total);
		System.out.println("************************************************");
		}
	}
	
	public Media getALuckyItem() {
		luckyNumber = 0 + (int)(Math.random()*(itemsOrdered.size()-1));
		return itemsOrdered.get(luckyNumber);
	}
}