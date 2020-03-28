
public class Aims {
	public static void main(String[] args){
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("disk 1","anhtru","nahar",12,29f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("disk 2");
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("disk 4");
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("disk 3");
		DigitalVideoDisc listdvd[] = {dvd1,dvd2,dvd3,dvd4};
		Order order2 = new Order();
		
		order2.addDigitalVideoDisc(listdvd);
	
//		order2.removeDigitalVideoDisc(dvd4);
//		System.out.print(order2.qtyOrder);
		DigitalVideoDisc dvd6 = new DigitalVideoDisc("disk 6");
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("disk 5");
		order2.addDigitalVideoDisc(dvd5, dvd6);
		
		System.out.print(order2.qtyOrder);
	}
}
