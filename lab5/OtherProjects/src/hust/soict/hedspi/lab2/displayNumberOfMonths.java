package hust.soict.hedspi.lab2;
import java.util.Scanner;
public class displayNumberOfMonths {
	public static void main(String[] args) {
		String[] monthType1 = {"Jannury","February","March","April","May","June","July",
				"August","October","November","September","December"};
		String monthType2[] = {"Jan.","Feb.","Mar.","Apr.","May.","Jun.","Jul.",
				"Aug.","Sep.","Oct.","Nov.","Dec."};
		String monthType3[] = {"Jan","Feb","Mar","Apr","May","Jun","Jul",
				"Aug","Sep","Oct","Nov","Dec"};
		String monthType4[] = {"1","2","3","4","5","6","7","8","9","10","11","12"};
		int commonYear[] = {31,28,31,30,31,30,31,31,30,31,30,31};
		int leapYear[] = {31,29,31,30,31,30,31,31,30,31,30,31};
		String strMonth,strYear;
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a year: ");
		strYear = input.next();
		System.out.print("Enter a month of year: ");
		strMonth = input.next();
		
		//tim ra thang vua nhap vao
		int f1 = -1,f2 = -1,f3 = -1,f4 = -1;
		while(f1 == -1 && f2 == -1 && f3 ==-1 && f4==-1) {
			f1 = findMonth(monthType1,strMonth);
			f2 = findMonth(monthType2,strMonth);
			f3 = findMonth(monthType3,strMonth);
			f4 = findMonth(monthType4,strMonth);
		}
		if(f1 == -1 && f2 == -1 && f3 ==-1 && f4==-1)
			System.out.println("Enter month erorr");
		int f;
		if(f1 != -1)
			f = f1;
		else if (f2 != -1)
			f = f2;
		else if (f3 != -1)
			f = f3;
		else f = f4;
		int intYear = Integer.parseInt(strYear);
		if(intYear%4 == 0) {
			if(intYear%100 == 0 && intYear%400 != 0)
				System.out.printf("Number of %s of %d is: %d\n",strMonth,intYear,
						commonYear[f]);
			else System.out.printf("Number of %s of %d is: %d\n",strMonth,intYear,
					leapYear[f]);
		}
		else System.out.printf("Number of %s of %d is: %d\n",strMonth,intYear,
				commonYear[f]);
	}
	
	public static int findMonth(String months[],String strMonth) {
		for (int i=0; i<months.length; i++) {
			if(months[i].equalsIgnoreCase(strMonth))
				return i;
		}
		return -1;
	}
}

