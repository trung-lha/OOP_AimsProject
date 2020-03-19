
public class DataTest {
	public static void main(String[] args) {
		//Test Constructor no parameter 
		MyDate test1 = new MyDate();
		test1.print();
		
		//Test Constructor 3 parameter
		MyDate test2 = new MyDate(30, 4, 2019);
		test2.print();
		//test constructor string
		MyDate test3 = new MyDate("August 10 1999");
		test3.print();
		//Test constructor enter string from keyboard
		MyDate test4 = new MyDate("");
		test4.print();
		
		System.exit(0);
	}
}
