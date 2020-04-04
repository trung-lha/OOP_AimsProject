//EX6: Second Degree
package hust.soict.hedspi.lab1;
import javax.swing.JOptionPane;
public class SecondDegree{
    public static void main(String[] args){
        String str1,str2,str3;
        str1 = JOptionPane.showInputDialog(null,"a =","Nhap vao he so bac 2",JOptionPane.INFORMATION_MESSAGE);
        str2 = JOptionPane.showInputDialog(null,"b =","Nhap vao he so bac 1",JOptionPane.INFORMATION_MESSAGE);
        str3 = JOptionPane.showInputDialog(null,"c =","Nhap vao he so tu do",JOptionPane.INFORMATION_MESSAGE);
        Double a = Double.parseDouble(str1);
        Double b = Double.parseDouble(str2);
        Double c = Double.parseDouble(str3);
        Double delta = b*b-4*a*c;
        if(delta == 0) JOptionPane.showInternalMessageDialog(null,"Phuong trinh co nghiem kep la: "+(-b/(2*a)),"Ket qua",
        JOptionPane.INFORMATION_MESSAGE);
        else if (delta > 0){
            double x1 = (-b-Math.sqrt(delta))/(2*a);
            double x2 = (-b+Math.sqrt(delta))/(2*a);
            JOptionPane.showInternalMessageDialog(null,"Phuong trinh co 2 nghiem phan biet la:"+x1+" va "+x2,"Ket qua",
            JOptionPane.INFORMATION_MESSAGE);
        }
        else JOptionPane.showInternalMessageDialog(null,"Phuong trinh vo nghiem","Ket qua",JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}