//Ex6:First-Degree
import javax.swing.JOptionPane;
public class FirstDegree{
    public static void main(String[] args){
        String str1,str2;
        double a,b;
        str1 = JOptionPane.showInputDialog(null,"a = ","Nhap vao he so a",JOptionPane.INFORMATION_MESSAGE);
        a = Double.parseDouble(str1);
        while(a == 0){
            str1 = JOptionPane.showInputDialog(null,"a = ","Nhap lai he so a sao cho a != 0",
            JOptionPane.WARNING_MESSAGE);
            a = Double.parseDouble(str1);
        }
        str2 = JOptionPane.showInputDialog(null,"b = ","Nhập hệ số b",JOptionPane.INFORMATION_MESSAGE);
        b = Double.parseDouble(str2);
        JOptionPane.showInternalMessageDialog(null, "Phương trình có nghiệm là: "+(-b/a),
        "Kết quả",JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}