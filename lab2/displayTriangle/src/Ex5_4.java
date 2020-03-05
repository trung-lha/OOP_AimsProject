import java.util.Scanner;
public class Ex5_4 {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter height of triangle: ");
		int tHeight = keyboard.nextInt();
		for(int i=0;i<tHeight;i++) {
			
			for(int j = 0;j <= tHeight - i;j++) {
				System.out.print(" ");
			}
			
			for(int j=0;j<2*i+1;j++) {
				System.out.print("*");
			}
			
			System.out.println();
		}
	}
}
