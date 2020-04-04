package hust.soict.hedspi.lab2;
import javax.swing.JOptionPane;
public class ChoosingOption {
	public static void main(String[] args) {
		int option = JOptionPane.showConfirmDialog(null,
				"Do you want to change to first class ticket?","Choosing Option",0);
		JOptionPane.showMessageDialog(null,"You've chosen:"
				+(option==JOptionPane.YES_OPTION?"YES":"NO"));
		System.exit(0);
	}
}
