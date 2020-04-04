//Example 4: ShowTwoNumber.java
package hust.soict.hedspi.lab1;
import javax.swing.JOptionPane;
public class ShowTwoNumber{
    public static void main(String[] args){
        String strNum1,strNum2;
        String Notification = "You've just entered: ";

        strNum1 = JOptionPane.showInputDialog(null, "Please input the first number: ","Input the first number",
        JOptionPane.INFORMATION_MESSAGE);
        Notification += strNum1 + " and ";
        strNum2 = JOptionPane.showInputDialog(null,"Please input the second number: ","Input the second number",
        JOptionPane.INFORMATION_MESSAGE);
        Notification += strNum2;
        JOptionPane.showInternalMessageDialog(null, Notification, "show two number", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}
