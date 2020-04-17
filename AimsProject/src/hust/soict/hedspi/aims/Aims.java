package hust.soict.hedspi.aims;
import java.util.ArrayList;
import java.util.Scanner;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.order.Order;

public class Aims {
	public static void main(String[] args){
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
				createNewOrder(listOrder);
				break;
			case 2:
				int optionNumber = 0;
				while(optionNumber != 3) {
					System.out.print("1. Add Book\n2. Add DVD\n3. Exit feature 2\nSelect number of option: ");
					optionNumber = sc.nextInt();
					sc.nextLine();
					switch(optionNumber) {
					case 1:
						System.out.print("Enter the id of book: ");
						int idBook = sc.nextInt();
						sc.nextLine();
						System.out.print("Enter the title of book: ");
						String titleBook = sc.nextLine();
						System.out.print("Enter the category of book: ");
						String categoryBook = sc.nextLine();
						System.out.print("Enter the cost of book: ");
						float costBook = sc.nextFloat();
						sc.nextLine();
						Book book = new Book(idBook,titleBook,categoryBook,costBook);
						System.out.print("Enter the list of authors (like:'lehoang trandan'):");
						String strAuthors = sc.nextLine();
						String[] arrayAuthors = strAuthors.split("\\s");
						for(String author : arrayAuthors) {
							book.addAuthor(author);
						}
						listOrder.get(0).addMedia(book);
						break;
					case 2:
						System.out.print("Enter the id of DVD: ");
						int idDVD = sc.nextInt();
						sc.nextLine();
						System.out.print("Enter the title of DVD: ");
						String titleDVD = sc.nextLine();
						System.out.print("Enter the category of DVD: ");
						String categoryDVD = sc.nextLine();
						System.out.print("Enter the director of DVD: ");
						String directorDVD = sc.nextLine();
						System.out.print("Enter the length of DVD: ");
						int lengthDVD = sc.nextInt();
						sc.nextLine();
						System.out.print("Enter the cost of DVD: ");
						float costDVD = sc.nextFloat();
						sc.nextLine();
						DigitalVideoDisc dvd = new DigitalVideoDisc(idDVD,titleDVD,categoryDVD,directorDVD,lengthDVD,costDVD);
						listOrder.get(0).addMedia(dvd);
						break;
					case 3:
						break;
					default:
						System.err.println("The option number of feature 2 is wrong. please enter again");
						break;
					}
				}
				break;
			case 3:
				Scanner sc_case3 = new Scanner(System.in);
				System.out.printf("Enter item id to remove: ");
				int idRemove = sc_case3.nextInt();
				listOrder.get(0).removeMedia(idRemove);
				break;
			case 4:
				displayItemList(listOrder, sc);
				break;
			default:
				System.out.printf("The number selected is not valid. Please enter again ");
				break;
			}
		}
	}
	private static void displayItemList(ArrayList<Order> listOrder, Scanner sc) {
		listOrder.get(0).printOrdered();
	}
	private static void createNewOrder(ArrayList<Order> listOrder) {
		Order new_order = new Order();
		listOrder.add(new_order);
	}
	
}
