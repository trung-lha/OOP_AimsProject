//EX6: First-Degree Two Variables
package hust.soict.hedspi.lab1;
import javax.swing.JOptionPane;
public class FirstDegreeTwoVariables{
    public static void main(String[] args){
        String strA11,strA12,strA21,strA22,strB1,strB2;
        Double a11,a12,a21,a22,b1,b2;
        strA11 = JOptionPane.showInputDialog(null,"a11 = ","Nhap he so phuong trinh 1",JOptionPane.INFORMATION_MESSAGE);
        a11 = Double.parseDouble(strA11);
        strA12 = JOptionPane.showInputDialog(null,"a12 = ","Nhap he so phuong trinh 1",JOptionPane.INFORMATION_MESSAGE);
        a12 = Double.parseDouble(strA12);
        strB1 = JOptionPane.showInputDialog(null,"b1 = ","Nhap he so phuong trinh 1",JOptionPane.INFORMATION_MESSAGE);
        b1= Double.parseDouble(strB1);
        strA21 = JOptionPane.showInputDialog(null,"a21 = ","Nhap he so phuong trinh 2",JOptionPane.INFORMATION_MESSAGE);
        a21 = Double.parseDouble(strA21);
        strA22 = JOptionPane.showInputDialog(null,"a22 = ","Nhap he so phuong trinh 2",JOptionPane.INFORMATION_MESSAGE);
        a22 = Double.parseDouble(strA22);
        strB2 = JOptionPane.showInputDialog(null,"b2 = ","Nhap he so phuong trinh 2",JOptionPane.INFORMATION_MESSAGE);
        b2= Double.parseDouble(strB2);
        Double D,D1,D2;
        D = a11*a22 - a21*a12;
        D1 = b1*a22 - b2*a12;
        D2 = a11*b2 - b1*a21;
        
        if(D != 0)
            JOptionPane.showInternalMessageDialog(null,"He phuong trinh co nghiem duy nhat: (x1,x2) = ("+(D1/D)+","+(D2/D)+")","Ket qua",
            JOptionPane.INFORMATION_MESSAGE);
        else if(D == 0 && D2 == 0)
            JOptionPane.showInternalMessageDialog(null,"He phuong trinh co vo so nghiem","Ket qua",JOptionPane.INFORMATION_MESSAGE);
        else 
            JOptionPane.showInternalMessageDialog(null,"He phuong trinh vo nghiem","Ket qua",JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}