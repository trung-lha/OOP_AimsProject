import java.util.Scanner;
public class addTwoMatricesSameSize {
	public static void main(String[] args) {
		int col,row;
		Scanner input = new Scanner(System.in);
		System.out.printf("Enter number of columns: ");
		col = input.nextInt();
		System.out.printf("Enter number of rows: ");
		row = input.nextInt();
		int matric1[][] = new int[col][row];
		int matric2[][] = new int[col][row];
		System.out.println("Enter value for matric 1");
		for(int i=0;i < col;i++)
			for(int j=0;j<row;j++)
				matric1[i][j] = input.nextInt();
		System.out.println("Enter value for matric 2");
		for(int i=0;i < col;i++)
			for(int j=0;j<row;j++)
				matric2[i][j] = input.nextInt();
		//add two matrices
		int sumMatrices[][] = new int[col][row];
		for (int i=0;i<col;i++)
			for (int j=0;j<row;j++)
				sumMatrices[i][j] = matric1[i][j] + matric2[i][j];
		
		System.out.println("Matric 1:");
		for (int i=0;i<col;i++) {
			for (int j=0;j<row;j++) {
				System.out.printf("%d  ",matric1[i][j]);
			}
			System.out.println();
		}
		
		System.out.println("Matric 2:");
		for (int i=0;i<col;i++) {
			for (int j=0;j<row;j++) {
				System.out.printf("%d  ",matric2[i][j]);
			}
			System.out.println();
		}
		
		System.out.println("Sum two matrices:");
		for (int i=0;i<col;i++) {
			for (int j=0;j<row;j++) {
				System.out.printf("%d  ",sumMatrices[i][j]);
			}
			System.out.println();
		}
	}
}