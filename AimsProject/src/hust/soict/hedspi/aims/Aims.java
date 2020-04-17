package hust.soict.hedspi.aims;
import java.util.ArrayList;
import java.util.Arrays;
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
			System.out.print("Enter a number of feature: ");
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
				Scanner scCase2 = new Scanner(System.in);
				System.out.print("Choose id of Order which want to add: ");
				int idForOrder = scCase2.nextInt();
				idForOrder = idForOrder - 1;
				if(idForOrder+1 > listOrder.size()) {
					System.out.printf("The Order has id: %d is not exist\n",idForOrder+1);
					break;
				}
				else {
					int option = 0;
					while(option != 3) {
					System.out.printf("1.Add book\n2. Add Video Disc\n3. Exit feature 2\n");
					System.out.printf("Enter the option of feature 2: ");
					option = scCase2.nextInt();
					switch(option) {
					case 1:
//					Scanner scOption1 = new Scanner(System.in);
						scCase2.nextLine();
						System.out.print("Enter the id of book: ");
						int idBook = scCase2.nextInt();
						scCase2.nextLine();
						System.out.print("Enter the title of book: ");
						String titleBook = scCase2.nextLine();
						System.out.print("Enter the category of book:");
						String categoryBook = scCase2.nextLine();
						System.out.print("Enter the cost of book:");
						float costBook = scCase2.nextFloat();
						scCase2.nextLine();
						System.out.print("Enter the list authors (like: HoangThiMai TranVanA): ");
						String strAuthors = scCase2.nextLine();
						Book book = new Book(idBook,titleBook,categoryBook,costBook);
						String[] listStrAuthors = strAuthors.split("\\s");
						for(String author : listStrAuthors) {
						book.addAuthor(author);
						}
						Book[] listBook = {book};
						listOrder.get(idForOrder).addMedia(listBook);
						break;
					case 2:
						scCase2.nextLine();
						System.out.print("Enter the id of Disc: ");
						int idDisc = scCase2.nextInt();
						scCase2.nextLine();
						System.out.printf("Enter the title of disc: ");
						String titleDisc = scCase2.nextLine();
						System.out.printf("Enter the category of disc:");
						String categoryDisc = scCase2.nextLine();
						System.out.printf("Enter the cost of disc:");
						float costDisc = scCase2.nextFloat();
						scCase2.nextLine();
						System.out.printf("Enter the Director of disc:");
						String director = scCase2.nextLine();
						System.out.printf("Enter the cost of length:");
						int length = scCase2.nextInt();
						DigitalVideoDisc addDisc = new DigitalVideoDisc(idDisc,titleDisc,categoryDisc,director,length,costDisc);
						DigitalVideoDisc[] listDisc = {addDisc};
						listOrder.get(idForOrder).addMedia(listDisc);
						break;
					case 3:
						break;
					default:
						System.out.println("Number of option is wrong. Enter Again!");
						break;
					}
				}
				}
				break;
			case 3:
				System.out.printf("Enter item id: ");
				Scanner sc_case2 = new Scanner(System.in);
				int id = sc_case2.nextInt();
				listOrder.get(0).removeMedia(id);
				break;
			case 4:
				sc.nextLine();
				System.out.print("choose number of Order");
				int numberOrder = sc.nextInt();
				sc.nextLine();
				listOrder.get(numberOrder).printOrdered();
				break;
			
			default:
				System.out.printf("The number selected is not valid. Please enter again ");
				break;
			}
		}
	}
}
