//Example 3: HelloNameDialog.java
package hust.soict.hedspi.lab1;
import javax.swing.JOptionPane;
public class HelloNameDialog{
    public static void main(String[] args){
        String result;
        result = JOptionPane.showInputDialog("Please enter your name: ");
        JOptionPane.showMessageDialog(null, "Xin Chao " + result +"!");
        System.exit(0);
    }
}