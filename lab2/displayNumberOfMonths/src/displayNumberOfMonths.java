import javax.swing.JOptionPane;
import java.util.Scanner;
public class displayNumberOfMonths {
	public static void main(String[] args) {
		String strMonth;
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a month: ");
		strMonth = input.next();
		String[] months = {"Jannury","February","March","April","May","June","July",
				"August","October","November","September","December"};
		switch(strMonth) {
		case "Jannuary":
			System.out.println("Number of days of this month is: "+ 31);
			break;
		case "February":
			System.out.println("Number of days of this month is: "+ 28);
		}
	}
}
