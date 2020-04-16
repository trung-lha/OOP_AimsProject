package hust.soict.hedspi.aims;
import java.util.ArrayList;
import java.util.Scanner;

import java.util.List;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.order.Order;

public class Aims {
	public static void main(String[] args){
//		DigitalVideoDisc dvd1 = new DigitalVideoDisc("disk 1","anhtru","nahar",12,29f);
//		DigitalVideoDisc dvd2 = new DigitalVideoDisc("disk 2","Lion king","unknow",23,23f);
//		DigitalVideoDisc dvd4 = new DigitalVideoDisc("harry Potter JK","unknow","Unknow",43,90f);
//		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Harry JK Rowling","unknow","Unknow",35,80f);
//		DigitalVideoDisc listdvd[] = {dvd1,dvd2,dvd3,dvd4};
//		
//		Order order1 = new Order();
//		Order order2 = new Order();
//		Order order3 = new Order();
//		Order order4 = new Order();
//		Order order5 = new Order(); //test limited orders
//		
//		order2.addMedia(listdvd);
//		order2.removeMedia(dvd4);
//		order2.printOrdered();
//		
//		DigitalVideoDisc dvd6 = new DigitalVideoDisc("disk 6");
//		DigitalVideoDisc dvd5 = new DigitalVideoDisc("disk 5");
////		order2.addMedia(dvd5, dvd6);
		showMenu();
	}
	public static void showMenu() {
		System.out.println("Order Management Application: ");
		System.out.println("--------------------------------");
		System.out.println("1. Create new order");
		System.out.println("2. Add item to the order");
		System.out.println("3. Delete item by id");
		System.out.println("4. Display the items list of order");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");
		ArrayList<Order> listOrder = new ArrayList<Order>();
		
		while(true) {
			System.out.println("Enter a number");
			Scanner sc = new Scanner(System.in);
			int number = sc.nextInt();
			switch(number) {
			case 0:
				System.out.println("Exit.");
				System.exit(0);
			case 1:
				Order new_order = new Order();
				listOrder.add(new_order);
				break;
			case 2:
				DigitalVideoDisc dvd1 = new DigitalVideoDisc(1,"sieu nhan","thieu nhi","nhat ban",90,90f);
				List<String> authorsOfBook1 = new ArrayList<String>();
				authorsOfBook1.add("JK Rowling");
				Book book1 = new Book(2,"Harry Potter Part 1","Magic",120f,authorsOfBook1);
				Book book2 = new Book(3,"Harry Potter Part 2","Magic",140f,authorsOfBook1);
				DigitalVideoDisc[] dvd = {dvd1};
				Book[] book = {book1,book2};
				listOrder.get(0).addMedia(dvd);
				listOrder.get(0).addMedia(book);
				break;
			case 3:
				System.out.printf("Enter item id: ");
				Scanner sc_case2 = new Scanner(System.in);
				int id = sc_case2.nextInt();
				listOrder.get(0).removeMedia(id);
				break;
			case 4:
				listOrder.get(0).printOrdered();
				break;
			
			default:
				System.out.printf("The number selected is not valid. Please enter again ");
				break;
			}
		}
	}
}
