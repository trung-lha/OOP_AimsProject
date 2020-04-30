package hust.soict.hedspi.aims;
import java.util.ArrayList;
import java.util.Scanner;

import hust.soict.hedspi.aims.media.disc.Book;
import hust.soict.hedspi.aims.media.disc.CompactDisc;
import hust.soict.hedspi.aims.media.disc.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.disc.Track;
import hust.soict.hedspi.aims.order.Order;

public class Aims {
	public static void main(String[] args){
		ArrayList<Order> orders = new ArrayList<Order>();
		showMenu(orders);
//		MemoryDaemon md = new MemoryDaemon();
//		Thread t = new Thread(md);
//		t.setDaemon(true);
//		t.start();
//		t.run();
//		System.out.println(md.getMemoryUsed());
	}
	public static void showMenu(ArrayList<Order> listOrder) {
		int number =-1;
		System.out.println("Order Management Application: ");
		System.out.println("--------------------------------");
		System.out.println("1. Create new order");
		System.out.println("2. Add item to the order");
		System.out.println("3. Delete item by id");
		System.out.println("4. Display the items list of order");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");
		while(number != 0) {
			System.out.print("Enter a number of feature: ");
			Scanner sc = new Scanner(System.in);
			number = sc.nextInt();
			switch(number) {
			case 0:
				System.out.println("Exit.");
				break;
			case 1:
				createNewOrder(listOrder);
				break;
			case 2:
				int optionNumber = 0;
				while(optionNumber != 4) {
					System.out.print("1. Add Book\n2. Add DVD\n3. Add CompactDisc\n4. Exit feature 2\nSelect number of option: ");
					optionNumber = sc.nextInt();
					sc.nextLine();
					switch(optionNumber) {
					case 1:
						addBook(listOrder, sc);
						break;
					case 2:
						addDVD(listOrder, sc);
						break;
					case 3:
						addCD(listOrder, sc);
						break;
					case 4:
						break;
					default:
						System.err.println("The option number of feature 2 is wrong. please enter again");
						break;
					}
				}
				break;
			case 3:
				removeItem(listOrder);
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
	private static void addCD(ArrayList<Order> listOrder, Scanner sc) {
		System.out.print("Enter the id of CD: ");
		int idCD = sc.nextInt();
		sc.nextLine();
		System.out.print("Enter the title of CD: ");
		String titleCD = sc.nextLine();
		System.out.print("Enter the category of CD: ");
		String categoryCD = sc.nextLine();
		System.out.print("Enter the director of CD: ");
		String directorCD = sc.nextLine();
		int lengthCD = 0;
		System.out.print("Enter the cost of CD: ");
		float costCD = sc.nextFloat();
		sc.nextLine();
		System.out.print("Enter the artist of CD: ");
		String artistCD = sc.nextLine();
		CompactDisc cd = new CompactDisc(idCD,titleCD,categoryCD,costCD,lengthCD,directorCD,artistCD);
		System.out.print("Enter the track's number of CD: ");
		int numberTrack = sc.nextInt();
		sc.nextLine();
		int i = 0;
		while(i<numberTrack) {
			System.out.print("Enter title of track: ");
			String title = sc.nextLine();
			System.out.print("Enter length of track: ");
			int length = sc.nextInt();
			sc.nextLine();
			Track track = new Track(title,length);
			cd.addTrack(track);
			i++;
		}
		int check = listOrder.get(0).addMedia(cd);
		if(check == 1) {
			System.out.println("Imformation about CD just has added\n--------------------------------");
			cd.play();
		}
	}
	private static void removeItem(ArrayList<Order> listOrder) {
		Scanner sc_case3 = new Scanner(System.in);
		System.out.printf("Enter item id to remove: ");
		int idRemove = sc_case3.nextInt();
		listOrder.get(0).removeMedia(idRemove);
	}
	private static void addDVD(ArrayList<Order> listOrder, Scanner sc) {
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
		DigitalVideoDisc dvd = new DigitalVideoDisc(idDVD,titleDVD,categoryDVD,costDVD,lengthDVD,directorDVD);
		int check = listOrder.get(0).addMedia(dvd);
		if(check == 1) {
			System.out.println("Imformation about DVD just has added\n--------------------------------");
			dvd.play();
		}
	}
	private static void addBook(ArrayList<Order> listOrder, Scanner sc) {
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
	}
	private static void displayItemList(ArrayList<Order> listOrder, Scanner sc) {
		listOrder.get(0).printOrdered();
	}
	private static void createNewOrder(ArrayList<Order> listOrder) {
		Order new_order = new Order();
		listOrder.add(new_order);
	}
	
}
