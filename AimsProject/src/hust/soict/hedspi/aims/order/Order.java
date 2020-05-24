package hust.soict.hedspi.aims.order;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.book.Book;
import hust.soict.hedspi.aims.media.disc.CompactDisc;
import hust.soict.hedspi.aims.media.disc.DigitalVideoDisc;

public class Order {
	private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
	int luckyNumber = -1;
	private String format_date;
	private float total = 0;

	public void setDateOrdered() {
		LocalDateTime myDateObj = LocalDateTime.now();
	    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

	    this.format_date = myDateObj.format(myFormatObj);
	}
	public String getDateOrdered() {
		return this.format_date;
	}
	public Order() {
		this.setDateOrdered();
	}
	
	public List<Media> getItemsOrdered(){
		return this.itemsOrdered;
	}
	public void setTotalCost() {
		this.total = this.getTotalCost();
	}
	public float getTotalCost() {
		return this.total;
	}
	public int addMedia(Media media) {
		if(itemsOrdered.contains(media)) {
			System.err.println("The media has ID is "+media.getId()+" is exist");
			return 0;
		}
		else {
			itemsOrdered.add(media);
			java.util.Collections.sort(itemsOrdered);
			return 1;
		}
	}
	public void removeMedia(Media media) {
		if(!itemsOrdered.contains(media)) {
			System.err.println("The media has ID is "+media.getId()+" is not exist");
			return;
		}
		else {
			itemsOrdered.remove(media);
			java.util.Collections.sort(itemsOrdered);
			System.out.println("The media has ID is "+media.getId()+" is exist");
		}
	}
	public int removeMedia(int id) {
		int check_exist = 0;
		int target = 0;
		for(Media media: itemsOrdered) {
			if(id == media.getId()) {
				check_exist = 1;
				break;
			}
			target++;
		}
		if(check_exist == 0) {
			System.err.println("Id of item is not exist");
			return 0;
		}
		else {
			itemsOrdered.remove(target);
			java.util.Collections.sort(itemsOrdered);
//			System.out.printf("The item has id %d has been Deleted\n",id);
			return 1;
		}
	}
	
	public float totalCost(){
		int i;
		float sum = 0,cost;
		for(i = 0; i< itemsOrdered.size();i++) {
			cost = itemsOrdered.get(i).getCost();
			sum = sum + cost;
		}
		if(luckyNumber != -1) {
			return sum - itemsOrdered.get(luckyNumber).getCost();
		}
		else {
			return sum;
		}
	}
	public void printOrdered() {
		float total=0;
//		java.util.Collections.sort(itemsOrdered);
		if(itemsOrdered.size() == 0) {
			System.out.println("itemsOrder is empty");
			return;
		}
		else {
		System.out.println("******************** ORDER *********************");
		System.out.printf("Date: %s\nOrder Items:\n", this.getDateOrdered());
		for(Media md : itemsOrdered) {
			if(md instanceof DigitalVideoDisc) {
				System.out.print(md.getId()+".");
				((DigitalVideoDisc)md).play();
			}
			else if (md instanceof CompactDisc) {
				System.out.print(md.getId()+".");
				((CompactDisc)md).play();
			}
			else{
				System.out.print(md.getId()+".");
				((Book)md).play();
			}
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
	public void sortItemsOrder() {
		
	}
	public boolean isEmpty() {
		if(itemsOrdered.size() == 0)
			return true;
		else return false;
	}
	public Media getALuckyItem() {
		luckyNumber = 0 + (int)(Math.random()*(itemsOrdered.size()-1));
		return itemsOrdered.get(luckyNumber);
	}
}