
public class DataTest {
	public static void main(String[] args) {
		//Test Constructor no parameter 
		MyDate testDate = new MyDate();
		testDate.print();
		
		//Test Constructor 3 parameter
		MyDate testDate2 = new MyDate(30, 4, 2019);
		testDate2.print();
		
		//Test constructor enter string from keyboard
		MyDate testDate3 = new MyDate("");
		testDate3.print();
		
		System.exit(0);
	}
}
