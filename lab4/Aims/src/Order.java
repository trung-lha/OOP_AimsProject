import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import hust.soict.globalict.aims.disc.DigitalVideoDisc.DigitalVideoDisc;

public class Order {
	private static int nbOrders = 0;
	public static final int MAX_NUMBERS_ORDERED = 10;
	public static final int MAX_LIMITED_ORDERS= 4;
	int qtyOrder;
	private String format_date;
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	
	public void setDateOrdered() {
		LocalDateTime myDateObj = LocalDateTime.now();
	    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

	    this.format_date = myDateObj.format(myFormatObj);
	}
	public String getDateOrdered() {
		return this.format_date;
	}
	private Order(int u) {
		this.setDateOrdered();
		this.qtyOrder = u;
		this.nbOrders++;
	}

	public Order() {
		this(0);
		if(nbOrders > MAX_LIMITED_ORDERS) {
			System.out.println("Limited orders");
			System.exit(0);
		}
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if(qtyOrder < MAX_NUMBERS_ORDERED) {
			itemsOrdered[qtyOrder] = disc;
			qtyOrder++;
			System.out.println("The disc has been added");
		}
		else {
			System.out.println("The order is almost full");
			System.exit(0);
		}
	}
	public void addDigitalVideoDisc(DigitalVideoDisc[] disc) {
		int i = 0;
		if (qtyOrder+disc.length > MAX_NUMBERS_ORDERED) {
			System.out.println("list disc full");
			System.out.printf("only has %d slots\n",MAX_NUMBERS_ORDERED-qtyOrder);
		} else {
			while (qtyOrder < MAX_NUMBERS_ORDERED && i < disc.length ) {
				addDigitalVideoDisc(disc[i]);
				i++;
			}
		}
	}	
	public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		if(qtyOrder >= MAX_NUMBERS_ORDERED) {
			System.out.println("Could not add " + dvd1.getTitle() + " and " + dvd2.getTitle());
		}
		else if (qtyOrder + 1 == MAX_NUMBERS_ORDERED) {
			itemsOrdered[qtyOrder++] = dvd1;
			System.out.println("Could not add " +  dvd2.getTitle());
		}
		else {
			itemsOrdered[qtyOrder] = dvd1;
			qtyOrder++;
			itemsOrdered[qtyOrder] = dvd2;
			qtyOrder++;
			System.out.println("The disks has added");
		}
		
	}
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		int i=0;
		while (i<qtyOrder) {
			if(itemsOrdered[i] == disc) {
				if(i == qtyOrder -1){
					itemsOrdered[i] = null;
					qtyOrder--;
					System.out.println("The disc name "+ disc.getTitle()+ " has removed");
					return;
				}
				else {
					for(int j = i; j< qtyOrder-1; j++) {
						itemsOrdered[j] = itemsOrdered[j+1];
					}
					itemsOrdered[qtyOrder-1] = null;
					System.out.println("The disc name "+ disc.getTitle()+ " has removed");
					break;
				}
			}
			i++;
		}
		if(i == qtyOrder) {
			System.out.println("Cann't find the disc that you want to remove");
		}
		
	}
	public float totalCost(){
		int i=0;
		float total = 0,cost;
		for(i = 0; i< qtyOrder;i++) {
			cost = itemsOrdered[i].getCost();
			total = total+cost;
		}
		return total;
	}
	public void printOrdered() {
		float total=0;
		System.out.println("******************** ORDER *********************");
		System.out.printf("Date: %s\nOrder Items:\n", this.getDateOrdered());
		for (int i=0;i<qtyOrder;i++) {
			System.out.printf("%d. %s-%s-%s-%d-%.2f\n",i+1,itemsOrdered[i].getTitle(),itemsOrdered[i].getCategory()
					,itemsOrdered[i].getDirector(),itemsOrdered[i].getLength(),itemsOrdered[i].getCost());
		}
		total = this.totalCost();
		System.out.printf("Total cost: %.2f\n",total);
		System.out.println("************************************************");
	}
}
