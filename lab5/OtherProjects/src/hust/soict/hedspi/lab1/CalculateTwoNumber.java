//Example 5: Calculate Two Number

package hust.soict.hedspi.lab1;
import javax.swing.JOptionPane;
public class CalculateTwoNumber{
    public static void main(String[] args){
        String strNum1,strNum2;
        strNum1 = JOptionPane.showInputDialog(null,"enter number 1", "Input first number", 
        JOptionPane.INFORMATION_MESSAGE);
        strNum2 = JOptionPane.showInputDialog(null,"enter number 2", "Input second number", 
        JOptionPane.INFORMATION_MESSAGE);
        Double num1 = Double.parseDouble(strNum1);
        Double num2 = Double.parseDouble(strNum2);
        //System.out.println("Sum = "+(num1+num2));
        JOptionPane.showMessageDialog(null,
        "Sum of "+num1+" and "+num2+" is: " +(num1+num2)+"\n"+
        "Diffence of "+num1+" and "+num2+" is: " +(num1-num2)+"\n"+
        "Product of "+num1+" and "+num2+" is: " +(num1*num2)+"\n"+
        "Quotient of "+num1+" and "+num2+" is: " +(num1/num2), "Result", 
        JOptionPane.INFORMATION_MESSAGE);
        
    }
}