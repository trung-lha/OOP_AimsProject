package hust.soict.hedspi.garbage;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class NoGarbage {
	public static void main(String[] args) throws IOException{
		StringBuffer strNoGarbage = new StringBuffer();
		Scanner sc = new Scanner(Paths.get("TestGarbage.txt"));
		while(sc.hasNextLine()) {
			strNoGarbage.append(sc.nextLine());
			strNoGarbage.append("\n");
		}
		System.out.println(strNoGarbage); 
		System.out.println("Done!");
	}
}
