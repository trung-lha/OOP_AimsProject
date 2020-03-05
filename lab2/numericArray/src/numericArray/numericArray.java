package numericArray;

import java.util.*;

public class numericArray {
	public static void main(String[] args) {
		int arr[] = {1789,2035,1899,1456,2013};
		Arrays.sort(arr);
		System.out.printf("Day so sap xep tang dan: %s\n",Arrays.toString(arr));
		Scanner input = new Scanner(System.in);
		System.out.println("Nhap vao so phan tu cua mang: ");
		int elements = input.nextInt();
		int arr2[] = new int[elements];
		for(int i=0;i<elements;i++) {
			System.out.printf("Nhap phan tu thu %d cua mang: ",i+1);
			arr2[i] = input.nextInt();
		}
		Arrays.sort(arr2);
		System.out.printf("Day so sap xep tang dan: %s\n",Arrays.toString(arr2));
	}
}
