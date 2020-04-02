import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTest {
	public static void main(String[] args) {
		//Test Constructor no parameter 
		MyDate test1 = new MyDate();
		test1.print2();
		
		//Test Constructor 3 parameter
		MyDate test2 = new MyDate(30, 4, 2019);
		test2.print2();
		//test constructor string
		MyDate test3 = new MyDate("August 10 1999");
		test3.print2();
		//Test constructor enter string from keyboard
//		MyDate test4 = new MyDate("");
//		test4.print();
		
		String[] date = new String[]{"2020/10/04", "2021/04/24", "2020/05/10", "2015/06/20"};
		DateUtils.sortingDate(date);

        // After Sort
        System.out.println("After Sort: ");
        for (int i = 0; i < date.length; i++) {
            System.out.println(date[i]);
        }
		
		MyDate test5 = new MyDate("first","April","twenty twenty");
		test5.print();
		
		System.exit(0);
	}
}
