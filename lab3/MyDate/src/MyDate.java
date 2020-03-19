import java.util.Calendar;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


public class MyDate {
	private int day;
	private int month;
	private int year;
	
	//setter and getter methods
	public void setDay(int day) {
		if(checkLeapYear(year)) {
			if(month == 2) {
				if(day <=0 || day >29) {
					System.out.println("Valude of day is invalid");
					return;
				}
				else {
					this.day = day;
				}
			}
			else if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
				if(day < 1 || day > 31) {
					System.out.println("Valude of day is invalid");
					return;
				}
				else {
					this.day = day;
				}
			}
			else {
				if(day <1 || day > 30) {
					System.out.println("Value of day is invalid");
					return;
				}
				else {
					this.day = day;
				}
			}
		}
		else {
			if(month == 2) {
				if(day <=0 || day > 28) {
					System.out.println("Valude of day is invalid");
					return;
				}
				else {
					this.day = day;
				}
			}
			else if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
				if(day < 1 || day > 31) {
					System.out.println("Valude of day is invalid");
					return;
				}
				else {
					this.day = day;
				}
			}
			else {
				if(day <1 || day > 30) {
					System.out.println("Value of day is invalid");
					return;
				}
				else {
					this.day = day;
				}
			}					
		}
	}
	public void setMonth(int month) {
		if(month <=0 || month > 12) {
			System.out.println("Value of month is invalid");
			return;
		}
		this.month = month;
	}
	public void setYear(int year) {
		if(year < 0 ) {
			System.out.println("Value of year is invalid");
			return;			
		}
		this.year = year;
	}
	public static boolean checkLeapYear(int year) {
		if(year%4 == 0) {
			if(year%100 == 0 && year%400 != 0) {
				return false;
			}
			return true;
		}
		return false;
	}
	public int getDay() {
		return this.day;
	}
	public int getMonth() {
		return this.month;
	}
	public int getYear() {
		return this.year;
	}
	//Construct 3 parameter
	public MyDate(int day, int month, int year) {
		super();
		setYear(year);
		setMonth(month);
		setDay(day);
	}
	//Construct no parameter
	public MyDate() {
		Calendar c = Calendar.getInstance();
		this.year = c.get(Calendar.YEAR);
		this.month = c.get(Calendar.MONTH) + 1;
		this.day = c.get(Calendar.DATE);
	}
	public String accept() {
		Scanner sc = new Scanner(System.in);
		System.out.printf("Enter date (EX:'February 18 2019'): ");
		String strDate = sc.nextLine();
		return strDate;
	}
	public MyDate(String strDate) {
		if(strDate == "") {
			strDate = accept();
		}
		SimpleDateFormat formatter = new SimpleDateFormat("MMM dd yyyy");
        try {
            Date date = formatter.parse(strDate);
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
    		this.year = cal.get(Calendar.YEAR);
    		this.month = cal.get(Calendar.MONTH) + 1;
    		this.day = cal.get(Calendar.DATE);           
        } catch (ParseException e) {
            e.printStackTrace();
        }
	}
	public void print() {
		if (this.day == 0 || month == 0 || year == 0) {
			System.out.println("Date is not created");
		} else {
			System.out.println("Day: " +this.day+ " ---Month: " + this.month + " ---Year: " + this.year);
		}
	}
	
	
	
}
