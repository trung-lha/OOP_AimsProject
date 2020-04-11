package hust.soict.hedspi.garbage;
import java.util.Scanner;
import java.nio.file.Paths;
import java.io.IOException;
public class GarbageCreator {
	public static void main(String[] args) throws IOException{
		String strGarbage = "";
		Scanner sc = new Scanner(Paths.get("TestGarbage.txt"));
		while(sc.hasNextLine()) {
			strGarbage += sc.nextLine();
			strGarbage += "\n";
		}
		System.out.println(strGarbage); 
		System.out.println("done!");
	}
}
