import hust.soict.globalict.aims.disc.DigitalVideoDisc.DigitalVideoDisc;

public class Aims {
	public static void main(String[] args){
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("disk 1","anhtru","nahar",12,29f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("disk 2");
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("disk 4");
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("disk 3");
		DigitalVideoDisc listdvd[] = {dvd1,dvd2,dvd3,dvd4};
		Order order1 = new Order();
		Order order2 = new Order();
		Order order3 = new Order();
		Order order4 = new Order();
		
		order2.addDigitalVideoDisc(listdvd);
	
		order2.removeDigitalVideoDisc(dvd4);
		System.out.print(order2.qtyOrder);
		DigitalVideoDisc dvd6 = new DigitalVideoDisc("disk 6");
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("disk 5");
		order2.addDigitalVideoDisc(dvd5, dvd6);
		
		order2.printOrdered();
		
		MyDate md1 = new MyDate("");
		md1.print();
//		String input = "anh TrungA andwue ahhqu";
//		input = input.toLowerCase().replaceAll(" and", " ");
//        String[] splittedParts = input.trim().split("\\s",3);
//        System.out.println(input);
//        for(String w : splittedParts) {
//        	System.out.println(w);
//        }
//        String a = "anh";
//        String[] b = {"anh","em"};
//        if(a == b[0]) System.out.print("11");
//        if(a.equalsIgnoreCase(b[0]))
//        	System.out.print("11");
	}
}
