package hust.soict.hedspi.aims;
import hust.soict.hedspi.aims.disc.DigitalVideoDisc;
import hust.soict.hedspi.aims.order.Order;

public class Aims {
	public static void main(String[] args){
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("disk 1","anhtru","nahar",12,29f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("disk 2","Lion king","unknow",23,23f);
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("harry Potter JK","unknow","Unknow",43,90f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Harry JK Rowling","unknow","Unknow",35,80f);
		DigitalVideoDisc listdvd[] = {dvd1,dvd2,dvd3,dvd4};
		
		Order order1 = new Order();
		Order order2 = new Order();
		Order order3 = new Order();
		Order order4 = new Order();

		Order order5 = new Order(); //test limited orders
		
		order2.addDigitalVideoDisc(listdvd);
	
		order2.removeDigitalVideoDisc(dvd4);
		
		DigitalVideoDisc dvd6 = new DigitalVideoDisc("disk 6");
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("disk 5");
		order2.addDigitalVideoDisc(dvd5, dvd6);
	}
}
