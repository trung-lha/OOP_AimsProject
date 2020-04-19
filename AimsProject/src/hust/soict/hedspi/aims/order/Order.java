package hust.soict.hedspi.aims.order;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import hust.soict.hedspi.aims.media.Media;

public class Order {
	private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
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
	public Order() {
		this.setDateOrdered();
	}
	public boolean checkIdMedia(Media media) {
		for(Media md : itemsOrdered) {
			if(md.getId() == media.getId())
				return true;
		}
		return false;
	}
	public void addMedia(Media media) {
		if(checkIdMedia(media)) {
			System.err.println("The media name "+media.getTitle()+" is exist");
			return;
		}
		else {
			itemsOrdered.add(media);
		}
	}
	public void removeMedia(Media media) {
		if(!checkIdMedia(media)) {
			System.err.println("The disc name "+media.getTitle()+" is not exist");
			return;
		}
		else {
			itemsOrdered.remove(media);
			System.out.println("The disc name "+media.getTitle()+" has removed");
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
		if(itemsOrdered.size() == 0) {
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