package hust.soict.hedspi.lab2;
import java.util.Scanner;
public class InputFromKeyboard {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("What's your name?");
		String strName = keyboard.nextLine();
		System.out.println("How are you?)");
		int iAge = keyboard.nextInt();
		System.out.println("How tall are you (m)?");
		double dHeight = keyboard.nextDouble();
		
		//similar to orther data types
		//nextByte(), nextShort(), nextLong()
		//nextFloat(), nextBoolean()
		System.out.println("Mr/Ms. " + strName + ", " + iAge + " Years old.\n"
				+ "Your height is " + dHeight + "(m).");
	}
}
